package com.cheng.cbc.type;

import com.cheng.cbc.ast.Location;

public class NamedType extends Type {
    protected Location location;
    protected String name;

    public NamedType(Location location, String name) {
        this.location = location;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }
}
