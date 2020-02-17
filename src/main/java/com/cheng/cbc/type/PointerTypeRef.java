package com.cheng.cbc.type;

public class PointerTypeRef extends TypeRef {
    private TypeRef typeRef;

    public PointerTypeRef(TypeRef typeRef) {
        super(typeRef.getLocation());
        this.typeRef = typeRef;
    }

    public TypeRef getTypeRef() {
        return typeRef;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PointerTypeRef)) return false;
        return typeRef.equals(((PointerTypeRef) obj).typeRef);
    }

    @Override
    public String toString() {
        return typeRef.toString() + "*";
    }
}
