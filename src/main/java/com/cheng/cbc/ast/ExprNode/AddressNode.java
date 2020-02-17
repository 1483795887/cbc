package com.cheng.cbc.ast.ExprNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;
import com.cheng.cbc.type.Type;

public class AddressNode extends ExprNode {
    private ExprNode node;
    private Type type;

    public AddressNode(ExprNode node) {
        this.node = node;
    }

    @Override
    public Location getLocation() {
        return node.getLocation();
    }

    public ExprNode getNode() {
        return node;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("expr", node);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
