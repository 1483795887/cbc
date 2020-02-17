package com.cheng.cbc.type;

import com.cheng.cbc.ast.Location;

public class StructTypeRef extends TypeRef {
    private String name;

    public StructTypeRef(Location location, String name) {
        super(location);
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StructTypeRef)) return false;
        return name.equals(((StructTypeRef) obj).name);
    }

    @Override
    public String toString() {
        return "struct " + name;
    }
}
