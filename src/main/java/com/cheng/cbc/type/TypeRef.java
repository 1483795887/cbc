package com.cheng.cbc.type;

import com.cheng.cbc.ast.Location;

abstract public class TypeRef {
    protected Location location;

    public TypeRef(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
