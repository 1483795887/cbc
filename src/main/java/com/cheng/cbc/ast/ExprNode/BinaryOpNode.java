package com.cheng.cbc.ast.ExprNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class BinaryOpNode extends ExprNode {
    private ExprNode left;
    private String op;
    private ExprNode right;

    public BinaryOpNode(ExprNode left, String op, ExprNode right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public ExprNode getLeft() {
        return left;
    }

    public ExprNode getRight() {
        return right;
    }

    @Override
    public Location getLocation() {
        return left.getLocation();
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("left", left);
        dumper.printMember("op", op);
        dumper.printMember("right", right);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }

}
