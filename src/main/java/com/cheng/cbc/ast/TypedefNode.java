package com.cheng.cbc.ast;

import com.cheng.cbc.compiler.DeclarationVisitor;
import com.cheng.cbc.type.Type;
import com.cheng.cbc.type.TypeRef;
import com.cheng.cbc.type.UserType;
import com.cheng.cbc.type.UserTypeRef;

public class TypedefNode extends TypeDefinition {
    private TypeNode realType;

    public TypedefNode(Location location, TypeRef realRef, String name) {
        super(location, name, new UserTypeRef(location, name));
        this.realType = new TypeNode(realRef);
    }


    public TypeNode getRealType() {
        return realType;
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("name", name);
        dumper.printMember("type", typeNode);
    }

    @Override
    public Type definingType() {
        return new UserType(location, name, realType);
    }

    @Override
    public <T> T accept(DeclarationVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
