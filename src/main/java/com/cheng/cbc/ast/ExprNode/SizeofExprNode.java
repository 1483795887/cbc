package com.cheng.cbc.ast.ExprNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class SizeofExprNode extends ExprNode {
    private ExprNode node;

    public SizeofExprNode(ExprNode node) {
        this.node = node;
    }

    public ExprNode getNode() {
        return node;
    }

    @Override
    public Location getLocation() {
        return node.getLocation();
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
