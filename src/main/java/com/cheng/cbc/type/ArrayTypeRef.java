package com.cheng.cbc.type;

public class ArrayTypeRef extends TypeRef {
    private static long UNDEFINED_LENGTH = -1;
    private long length;
    private TypeRef ref;

    public ArrayTypeRef(TypeRef ref, long length) {
        super(ref.getLocation());
        this.ref = ref;
        this.length = length;
    }

    public ArrayTypeRef(TypeRef ref) {
        super(ref.getLocation());
        this.ref = ref;
        this.length = UNDEFINED_LENGTH;
    }

    public long getLength() {
        return length;
    }

    public TypeRef getRef() {
        return ref;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ArrayTypeRef)) return false;
        return length == ((ArrayTypeRef) obj).length && ref.equals(((ArrayTypeRef) obj).ref);
    }

    @Override
    public String toString() {
        return ref + "[" + (length != UNDEFINED_LENGTH ? length : "") + "]";
    }
}
