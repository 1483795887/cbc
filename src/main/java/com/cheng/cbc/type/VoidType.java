package com.cheng.cbc.type;

public class VoidType extends Type {
    @Override
    public boolean isVoid() {
        return true;
    }

    @Override
    public String toString() {
        return "void";
    }
}
