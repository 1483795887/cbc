package com.cheng.cbc.type;

public class PointerType extends Type {
    private Type baseType;
    private long pointerType;

    public PointerType(Type baseType, long pointerType) {
        this.baseType = baseType;
        this.pointerType = pointerType;
    }

    @Override
    public Type baseType() {
        return baseType;
    }

    @Override
    public String toString() {
        return baseType.toString() + "*";
    }

    @Override
    public boolean isPointer() {
        return true;
    }
}
