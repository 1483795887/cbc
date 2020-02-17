package com.cheng.cbc.ast.ExprNode.UnaryOpNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class UnaryOpNode extends ExprNode {
    protected String operator;
    protected ExprNode node;

    public UnaryOpNode(String operator, ExprNode node) {
        this.operator = operator;
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
        dumper.printMember("operator", operator);
        dumper.printMember("expr", node);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
