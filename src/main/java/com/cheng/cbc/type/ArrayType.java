package com.cheng.cbc.type;

public class ArrayType extends Type {
    static final private long UNDEFINED = -1;
    private Type baseType;
    private long length;
    private long pointerSize;

    public ArrayType(Type baseType, long pointerSize) {
        this.baseType = baseType;
        this.length = UNDEFINED;
        this.pointerSize = pointerSize;
    }

    public ArrayType(Type baseType, long length, long pointerSize) {
        this.baseType = baseType;
        this.length = length;
        this.pointerSize = pointerSize;
    }

    @Override
    public Type baseType() {
        return baseType;
    }

    @Override
    public String toString() {
        return baseType.toString() + "[" + (length != UNDEFINED ? length : "") + "]";
    }
}
