package com.cheng.cbc.type;

import com.cheng.cbc.exception.SemanticError;

abstract public class Type {
    public boolean isVoid() {
        return false;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPointer() {
        return false;
    }

    public Type baseType() {
        throw new SemanticError("no base type");
    }

    public CompositeType getCompositeType() {
        return (CompositeType) this;
    }
}
