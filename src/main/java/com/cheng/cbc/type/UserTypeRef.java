package com.cheng.cbc.type;

import com.cheng.cbc.ast.Location;

public class UserTypeRef extends TypeRef {
    private String name;

    public UserTypeRef(Location location, String name) {
        super(location);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(obj.toString());
    }
}
