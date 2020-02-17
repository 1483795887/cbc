package com.cheng.cbc.entity;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.TypeNode;
import com.cheng.cbc.compiler.EntityVisitor;

public class Constant extends Entity {
    private ExprNode value;

    public Constant(TypeNode typeNode, String name, ExprNode value) {
        super(false, typeNode, name);
        this.value = value;
    }

    @Override
    public void _dump(Dumper dumper) {
        dumper.printMember("type", typeNode);
        dumper.printMember("name", name);
        dumper.printMember("value", value);
    }

    @Override
    public boolean isDefined() {
        return true;
    }

    @Override
    public <T> T accept(EntityVisitor<T> visitor) {
        return null;
    }
}
