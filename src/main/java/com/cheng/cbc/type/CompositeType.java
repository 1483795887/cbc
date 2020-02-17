package com.cheng.cbc.type;

import com.cheng.cbc.ast.Location;
import com.cheng.cbc.ast.Slot;

import java.util.List;

public class CompositeType extends NamedType {
    protected List<Slot> members;

    public CompositeType(Location location, String name, List<Slot> members) {
        super(location, name);
        this.members = members;
    }

    public List<Slot> getMembers() {
        return members;
    }
}
