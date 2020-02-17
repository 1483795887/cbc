package com.cheng.cbc.entity;

import com.cheng.cbc.ast.TypeNode;

abstract public class Function extends Entity {
    public Function(Boolean isPrivate, TypeNode typeNode, String name) {
        super(isPrivate, typeNode, name);
    }
}
