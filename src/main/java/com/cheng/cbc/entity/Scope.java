package com.cheng.cbc.entity;

import com.cheng.cbc.exception.SemanticException;
import com.cheng.cbc.utils.ErrorHandler;

import java.util.ArrayList;
import java.util.List;

abstract public class Scope {
    protected List<LocalScope> children;

    public Scope() {
        children = new ArrayList<>();
    }

    public void addChild(LocalScope localScope) {
        children.add(localScope);
    }

    abstract public Entity get(String name) throws SemanticException;

    abstract public void checkReference(ErrorHandler handler);
}
