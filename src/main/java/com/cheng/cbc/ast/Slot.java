package com.cheng.cbc.ast;

public class Slot extends Node {
    private TypeNode type;
    private String name;

    public Slot(TypeNode type, String name) {
        this.type = type;
        this.name = name;
    }

    public TypeNode getTypeNode() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public Location getLocation() {
        return type.getLocation();
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("type", type);
        dumper.printMember("name", name);
    }

    @Override
    public String toString() {
        return name;
    }
}
