package com.cheng.cbc.ast;

import com.cheng.cbc.type.TypeRef;

import java.util.List;

abstract public class CompositeTypeDefinition extends TypeDefinition {
    protected List<Slot> members;

    public CompositeTypeDefinition(Location location, String name, TypeRef typeRef, List<Slot> members) {
        super(location, name, typeRef);
        this.members = members;
    }

    public List<Slot> getMembers() {
        return members;
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("name", name);
        dumper.printMember("members", members);
    }
}
