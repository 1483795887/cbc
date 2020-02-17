package com.cheng.cbc.ast.ExprNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.ast.TypeNode;
import com.cheng.cbc.compiler.ASTVisitor;

public class SizeofTypeNode extends ExprNode {
    private TypeNode node;

    public SizeofTypeNode(TypeNode node) {
        this.node = node;
    }

    @Override
    public Location getLocation() {
        return node.getLocation();
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("type", node);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
