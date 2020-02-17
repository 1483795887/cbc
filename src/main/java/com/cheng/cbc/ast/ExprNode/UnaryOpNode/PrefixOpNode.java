package com.cheng.cbc.ast.ExprNode.UnaryOpNode;

import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.compiler.ASTVisitor;

public class PrefixOpNode extends UnaryArithmeticOpNode {
    public PrefixOpNode(String operator, ExprNode node) {
        super(operator, node);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
