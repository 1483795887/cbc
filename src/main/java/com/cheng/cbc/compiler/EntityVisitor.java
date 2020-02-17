package com.cheng.cbc.compiler;

import com.cheng.cbc.entity.DefinedFunction;
import com.cheng.cbc.entity.DefinedVariable;

public interface EntityVisitor<T> {
    T visit(DefinedVariable variable);

    T visit(DefinedFunction function);
}
