package com.cheng.cbc.entity;

import com.cheng.cbc.ast.TypeNode;

abstract public class Variable extends Entity {
    public Variable(Boolean isPrivate, TypeNode typeNode, String name) {
        super(isPrivate, typeNode, name);
    }
}
