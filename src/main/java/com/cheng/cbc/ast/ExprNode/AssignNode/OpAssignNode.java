package com.cheng.cbc.ast.ExprNode.AssignNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.compiler.ASTVisitor;

public class OpAssignNode extends AbstractAssignNode {
    private String op;

    public OpAssignNode(ExprNode left, String op, ExprNode right) {
        super(left, right);
        this.op = op;
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
