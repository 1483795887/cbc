package com.cheng.cbc.ast;

import com.cheng.cbc.compiler.DeclarationVisitor;
import com.cheng.cbc.type.StructType;
import com.cheng.cbc.type.StructTypeRef;
import com.cheng.cbc.type.Type;

import java.util.List;

public class StructNode extends CompositeTypeDefinition {
    public StructNode(Location location, String name, List<Slot> members) {
        super(location, name, new StructTypeRef(location, name), members);
    }

    @Override
    public Type definingType() {
        return new StructType(location, name, members);
    }

    @Override
    public <T> T accept(DeclarationVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
