package com.cheng.cbc.ast.StmtNode;

import com.cheng.cbc.ast.Node;
import com.cheng.cbc.compiler.ASTVisitor;

abstract public class StmtNode extends Node {
    abstract public <S, E> S accept(ASTVisitor<S, E> visitor);
}
