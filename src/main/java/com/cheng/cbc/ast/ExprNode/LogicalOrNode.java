package com.cheng.cbc.ast.ExprNode;

import com.cheng.cbc.compiler.ASTVisitor;

public class LogicalOrNode extends BinaryOpNode {
    public LogicalOrNode(ExprNode left, ExprNode right) {
        super(left, "||", right);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
