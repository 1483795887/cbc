package com.cheng.cbc.type;

import com.cheng.cbc.ast.Location;
import com.cheng.cbc.ast.Slot;

import java.util.List;

public class StructType extends CompositeType {
    public StructType(Location location, String name, List<Slot> members) {
        super(location, name, members);
    }

    @Override
    public String toString() {
        return "struct " + name;
    }
}
