package com.cheng.cbc.type;

import com.cheng.cbc.ast.Location;

public class VoidTypeRef extends TypeRef {
    public VoidTypeRef(Location location) {
        super(location);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VoidTypeRef)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "void";
    }
}
