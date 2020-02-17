package com.cheng.cbc.entity;

import com.cheng.cbc.ast.TypeNode;

public class Parameter extends DefinedVariable {
    public Parameter(TypeNode typeNode, String name) {
        super(false, typeNode, name, null);
    }
}
