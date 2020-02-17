package com.cheng.cbc.entity;

import com.cheng.cbc.ast.Dumpable;
import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.ast.TypeNode;
import com.cheng.cbc.compiler.EntityVisitor;

abstract public class Entity implements Dumpable {
    protected String name;
    protected TypeNode typeNode;
    protected Boolean isPrivate;
    protected int referred;

    public Entity(Boolean isPrivate, TypeNode typeNode, String name) {
        this.name = name;
        this.typeNode = typeNode;
        this.isPrivate = isPrivate;
    }

    public TypeNode getTypeNode() {
        return typeNode;
    }

    public Location getLocation() {
        return typeNode.getLocation();
    }

    public String getName() {
        return name;
    }

    public void referred() {
        this.referred++;
    }

    @Override
    public void dump(Dumper dumper) {
        dumper.printClass(this, getLocation());
        _dump(dumper);
    }

    public boolean getReferred() {
        return referred > 0;
    }

    abstract public void _dump(Dumper dumper);

    abstract public boolean isDefined();

    abstract public <T> T accept(EntityVisitor<T> visitor);
}
