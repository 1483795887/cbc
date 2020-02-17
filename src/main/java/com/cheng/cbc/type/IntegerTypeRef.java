package com.cheng.cbc.type;

import com.cheng.cbc.ast.Location;

public class IntegerTypeRef extends TypeRef {
    private String name;

    public IntegerTypeRef(String name, Location location) {
        super(location);
        this.name = name;
    }

    public static IntegerTypeRef charRef(Location loc) {
        return new IntegerTypeRef("char", loc);
    }

    public static IntegerTypeRef shortRef(Location loc) {
        return new IntegerTypeRef("short", loc);
    }

    public static IntegerTypeRef intRef(Location loc) {
        return new IntegerTypeRef("int", loc);
    }

    public static IntegerTypeRef longRef(Location loc) {
        return new IntegerTypeRef("long", loc);
    }

    public static IntegerTypeRef ucharRef(Location loc) {
        return new IntegerTypeRef("unsigned char", loc);
    }

    public static IntegerTypeRef ushortRef(Location loc) {
        return new IntegerTypeRef("unsigned short", loc);
    }

    public static IntegerTypeRef uintRef(Location loc) {
        return new IntegerTypeRef("unsigned int", loc);
    }

    public static IntegerTypeRef ulongRef(Location loc) {
        return new IntegerTypeRef("unsigned long", loc);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IntegerTypeRef)) return false;
        return name.equals(((IntegerTypeRef) obj).name);
    }

    @Override
    public String toString() {
        return name;
    }
}
