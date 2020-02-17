package com.cheng.cbc.ast.ExprNode;

import com.cheng.cbc.ast.Node;
import com.cheng.cbc.compiler.ASTVisitor;

abstract public class ExprNode extends Node {
    abstract public <S, E> E accept(ASTVisitor<S, E> visitor);

    public boolean isConstant() {
        return false;
    }
}
