package com.cheng.cbc.ast.ExprNode.AssignNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.Location;

abstract public class AbstractAssignNode extends ExprNode {
    protected ExprNode left;
    protected ExprNode right;

    public AbstractAssignNode(ExprNode left, ExprNode right) {
        this.left = left;
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

    }
}
