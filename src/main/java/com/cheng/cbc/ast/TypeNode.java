package com.cheng.cbc.ast;

import com.cheng.cbc.type.Type;
import com.cheng.cbc.type.TypeRef;

public class TypeNode extends Node {
    private Type type;
    private TypeRef typeRef;

    public TypeNode(TypeRef typeRef) {
        this.typeRef = typeRef;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        if (this.type != null) {
            throw new Error("TypeNode#setType called twice");
        }
        this.type = type;
    }

    public TypeRef getTypeRef() {
        return typeRef;
    }

    public boolean isResolved() {
        return type != null;
    }

    @Override
    public Location getLocation() {
        return typeRef.getLocation();
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("type", typeRef);
    }
}
