package com.cheng.cbc.ast;

import com.cheng.cbc.compiler.DeclarationVisitor;
import com.cheng.cbc.type.Type;
import com.cheng.cbc.type.TypeRef;

abstract public class TypeDefinition extends Node {
    protected String name;
    protected TypeNode typeNode;

    public TypeDefinition(Location location, String name, TypeRef typeRef) {
        this.location = location;
        this.name = name;
        this.typeNode = new TypeNode(typeRef);
    }

    public TypeNode getTypeNode() {
        return typeNode;
    }

    public Type getType() {
        return typeNode.getType();
    }

    public TypeRef getTypeRef() {
        return typeNode.getTypeRef();
    }

    public String getName() {
        return name;
    }

    abstract public Type definingType();

    abstract public <T> T accept(DeclarationVisitor<T> visitor);
}
