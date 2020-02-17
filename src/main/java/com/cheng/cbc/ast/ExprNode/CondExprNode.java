package com.cheng.cbc.ast.ExprNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class CondExprNode extends ExprNode {
    private ExprNode cond;
    private ExprNode left;
    private ExprNode right;

    public CondExprNode(ExprNode cond, ExprNode left, ExprNode right) {
        this.cond = cond;
        this.left = left;
        this.right = right;
    }

    public ExprNode getCond() {
        return cond;
    }

    public ExprNode getLeft() {
        return left;
    }

    public ExprNode getRight() {
        return right;
    }

    @Override
    public Location getLocation() {
        return cond.getLocation();
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("cond", cond);
        dumper.printMember("left", left);
        dumper.printMember("right", right);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
