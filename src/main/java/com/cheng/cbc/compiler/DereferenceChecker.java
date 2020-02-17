package com.cheng.cbc.compiler;

import com.cheng.cbc.ast.AST;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.StmtNode.BlockNode;
import com.cheng.cbc.ast.StmtNode.StmtNode;
import com.cheng.cbc.entity.DefinedFunction;
import com.cheng.cbc.entity.DefinedVariable;
import com.cheng.cbc.exception.SemanticError;
import com.cheng.cbc.exception.SemanticException;
import com.cheng.cbc.type.TypeTable;
import com.cheng.cbc.utils.ErrorHandler;

public class DereferenceChecker extends Visitor {
    private final TypeTable typeTable;
    private final ErrorHandler errorHandler;

    public DereferenceChecker(TypeTable typeTable, ErrorHandler errorHandler) {
        this.typeTable = typeTable;
        this.errorHandler = errorHandler;
    }

    public void check(AST ast) throws SemanticException {
        for (DefinedVariable variable : ast.definedVariableList()) {
            checkTopLevelVariable(variable);
        }
        for (DefinedFunction function : ast.definedFunctionList()) {
            check(function.getBody());
        }
        if (errorHandler.errorOccured()) {
            throw new SemanticException("compile failed.");
        }
    }

    private void check(ExprNode node) {
        node.accept(this);
    }

    private void check(StmtNode node) {
        node.accept(this);
    }

    private void checkVariable(DefinedVariable variable) {
        if (variable.hasInitialize()) {
            try {
                check(variable.getInit());
            } catch (SemanticError e) {
                ;
            }
        }
    }

    private void checkConstant(ExprNode node) {
        if (!node.isConstant()) {
            errorHandler.error(node.getLocation(), "not a constant");
        }
    }

    private void checkTopLevelVariable(DefinedVariable variable) {
        checkVariable(variable);
        if (variable.hasInitialize())
            checkConstant(variable.getInit());
    }

    @Override
    public Void visit(BlockNode node) {
        for (DefinedVariable variable : node.getVars()) {
            checkVariable(variable);
        }
        for (StmtNode stmtNode : node.getStmts()) {
            try {
                check(stmtNode);
            } catch (SemanticError err) {
                ;
            }
        }
        return null;
    }
}
