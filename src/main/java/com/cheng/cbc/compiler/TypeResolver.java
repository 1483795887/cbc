package com.cheng.cbc.compiler;

import com.cheng.cbc.ast.*;
import com.cheng.cbc.ast.ExprNode.LiteralNode.IntegerLiteralNode;
import com.cheng.cbc.ast.ExprNode.LiteralNode.StringLiteralNode;
import com.cheng.cbc.ast.StmtNode.BlockNode;
import com.cheng.cbc.entity.DefinedFunction;
import com.cheng.cbc.entity.DefinedVariable;
import com.cheng.cbc.entity.Entity;
import com.cheng.cbc.entity.Parameter;
import com.cheng.cbc.exception.SemanticException;
import com.cheng.cbc.type.CompositeType;
import com.cheng.cbc.type.TypeTable;
import com.cheng.cbc.utils.ErrorHandler;

import java.util.List;

public class TypeResolver extends Visitor implements
        DeclarationVisitor<Void>, EntityVisitor<Void> {
    private final TypeTable typeTable;
    private final ErrorHandler errorHandler;

    public TypeResolver(TypeTable typeTable, ErrorHandler errorHandler) {
        this.typeTable = typeTable;
        this.errorHandler = errorHandler;
    }

    public void resolve(AST ast) throws SemanticException {
        defineTypes(ast.getTypes());
        for (TypeDefinition t : ast.getTypes()) {
            t.accept(this);
        }
        for (Entity entity : ast.definitions()) {
            entity.accept(this);
        }

        if (errorHandler.errorOccured()) {
            throw new SemanticException("compile failed.");
        }
    }

    private void bindType(TypeNode node) {
        if (node.isResolved()) return;
        node.setType(typeTable.get(node.getTypeRef()));
    }

    private void resolveCompositeType(CompositeTypeDefinition definition) {
        CompositeType ct = (CompositeType) typeTable.get(definition.getTypeRef());
        if (ct == null) {
            throw new Error("cannot intern struct: " + definition.getName());
        }
        for (Slot slot : ct.getMembers()) {
            bindType(slot.getTypeNode());
        }
    }

    @Override
    public Void visit(StructNode node) {
        resolveCompositeType(node);
        return null;
    }

    @Override
    public Void visit(TypedefNode node) {
        bindType(node.getTypeNode());
        bindType(node.getRealType());
        return null;
    }

    @Override
    public Void visit(DefinedVariable variable) {
        bindType(variable.getTypeNode());
        if (variable.hasInitialize())
            visitExpr(variable.getInit());
        return null;
    }

    @Override
    public Void visit(IntegerLiteralNode node) {
        bindType(node.getTypeNode());
        return null;
    }

    @Override
    public Void visit(StringLiteralNode node) {
        bindType(node.getTypeNode());
        return null;
    }

    @Override
    public Void visit(DefinedFunction function) {
        bindType(function.getTypeNode());
        for (Parameter parameter : function.getParams()) {
            visit(parameter);
        }
        visitStmt(function.getBody());
        return null;
    }

    @Override
    public Void visit(BlockNode node) {
        for (DefinedVariable variable : node.getVars()) {
            visit(variable);
        }
        visitStmts(node.getStmts());
        return null;
    }

    private void defineTypes(List<TypeDefinition> types) {
        for (TypeDefinition definition : types) {
            if (typeTable.isDefined(definition.getTypeRef()))
                errorHandler.error(definition.getLocation(),
                        "duplicated type definition: " + definition.getTypeRef());
            else {
                typeTable.put(definition.getTypeRef(), definition.definingType());
            }
        }
    }
}
