package com.cheng.cbc.ast.ExprNode.AssignNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.compiler.ASTVisitor;

public class AssignNode extends AbstractAssignNode {
    public AssignNode(ExprNode left, ExprNode right) {
        super(left, right);
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("left", left);
        dumper.printMember("right", right);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
