package com.cheng.cbc.compiler;

import com.cheng.cbc.ast.AST;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.ExprNode.LHSNode.VariableNode;
import com.cheng.cbc.ast.StmtNode.BlockNode;
import com.cheng.cbc.ast.StmtNode.StmtNode;
import com.cheng.cbc.entity.*;
import com.cheng.cbc.exception.SemanticException;
import com.cheng.cbc.utils.ErrorHandler;

import java.util.LinkedList;
import java.util.List;

public class LocalResolver extends Visitor {

    private final LinkedList<Scope> scopeStack;
    private ErrorHandler handler;

    public LocalResolver(ErrorHandler handler) {
        scopeStack = new LinkedList<>();
        this.handler = handler;
    }

    @Override
    public Void visit(BlockNode node) {
        pushScope(node.getVars());
        super.visit(node);
        node.setScope(popScope());
        return null;
    }

    @Override
    public Void visit(VariableNode node) {
        try {
            Entity entity = getCurrentScope().get(node.getName());
            entity.referred();
            node.setEntity(entity);
        } catch (SemanticException e) {
            handler.error(node.getLocation(), e.getMessage());
        }
        return null;
    }

    public void resolve(AST ast) throws SemanticException {
        TopLevelScope topLevel = new TopLevelScope();
        scopeStack.add(topLevel);

        for (Entity entity : ast.definitions()) {
            topLevel.defineEntity(entity);
        }

        resolveGlobalVariableInitialize(ast.definedVariableList());
        resolveFunctions(ast.definedFunctionList());

        topLevel.checkReference(handler);

        if (handler.errorOccured()) {
            throw new SemanticException("compile failed.");
        }

        ast.setScope(topLevel);
    }

    private void resolveGlobalVariableInitialize(List<DefinedVariable> variableList) {
        for (DefinedVariable variable : variableList) {
            if (variable.hasInitialize())
                resolve(variable.getInit());
        }
    }

    private void resolveFunctions(List<DefinedFunction> functionList) {
        for (DefinedFunction function : functionList) {
            pushScope(function.getParams());
            resolve(function.getBody());
            popScope();
        }
    }

    private void pushScope(List<? extends DefinedVariable> vars) {
        LocalScope scope = new LocalScope(getCurrentScope());
        for (DefinedVariable variable : vars) {
            if (scope.isDefinedLocally(variable.getName())) {
                throw new RuntimeException("duplicated variable in scope: " + variable.getName());
            } else {
                scope.defineVariable(variable);
            }
        }
        scopeStack.addLast(scope);
    }

    private LocalScope popScope() {
        return (LocalScope) scopeStack.removeLast();
    }

    private Scope getCurrentScope() {
        return scopeStack.getLast();
    }

    private void resolve(StmtNode n) {
        n.accept(this);
    }

    private void resolve(ExprNode n) {
        n.accept(this);
    }
}
