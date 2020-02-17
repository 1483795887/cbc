package com.cheng.cbc.type;

import com.cheng.cbc.ast.Location;
import com.cheng.cbc.ast.TypeNode;

public class UserType extends NamedType {
    private TypeNode realType;

    public UserType(Location location, String name, TypeNode realType) {
        super(location, name);
        this.realType = realType;
    }

    @Override
    public Type baseType() {
        return getRealType().baseType();
    }

    public Type getRealType() {
        return realType.getType();
    }

    @Override
    public String toString() {
        return name;
    }
}
