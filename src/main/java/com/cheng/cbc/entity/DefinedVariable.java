package com.cheng.cbc.entity;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.TypeNode;
import com.cheng.cbc.compiler.EntityVisitor;

public class DefinedVariable extends Variable {
    private ExprNode init;

    public DefinedVariable(Boolean isPrivate, TypeNode typeNode, String name, ExprNode init) {
        super(isPrivate, typeNode, name);
        this.init = init;
    }

    public boolean hasInitialize() {
        return init != null;
    }

    public ExprNode getInit() {
        return init;
    }

    @Override
    public boolean isDefined() {
        return true;
    }

    @Override
    public void _dump(Dumper dumper) {
        dumper.printMember("name", name);
        dumper.printMember("type", typeNode);
        dumper.printMember("private", isPrivate);
        dumper.printMember("init", init);
    }

    @Override
    public <T> T accept(EntityVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
