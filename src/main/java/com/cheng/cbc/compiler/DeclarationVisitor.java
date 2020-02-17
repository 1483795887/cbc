package com.cheng.cbc.compiler;

import com.cheng.cbc.ast.StructNode;
import com.cheng.cbc.ast.TypedefNode;

public interface DeclarationVisitor<T> {
    T visit(StructNode node);

    T visit(TypedefNode node);
}
