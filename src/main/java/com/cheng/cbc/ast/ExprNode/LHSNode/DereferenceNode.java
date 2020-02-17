package com.cheng.cbc.ast.ExprNode.LHSNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class DereferenceNode extends LHSNode {
    private ExprNode node;

    public DereferenceNode(ExprNode node) {
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
