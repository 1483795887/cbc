package com.cheng.cbc.type;

public class IntegerType extends Type {
    private int size;
    private String name;
    private boolean isSigned;

    public IntegerType(int size, String name, boolean isSigned) {
        this.size = size;
        this.name = name;
        this.isSigned = isSigned;
    }

    @Override
    public String toString() {
        return name;
    }
}
