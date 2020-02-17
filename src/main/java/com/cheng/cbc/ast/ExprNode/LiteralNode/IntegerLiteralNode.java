package com.cheng.cbc.ast.ExprNode.LiteralNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;
import com.cheng.cbc.type.IntegerTypeRef;
import com.cheng.cbc.type.TypeRef;

public class IntegerLiteralNode extends LiteralNode {
    private long value;

    public IntegerLiteralNode(Location location, TypeRef typeRef, long value) {
        super(location, typeRef);
        this.value = value;
    }

    public static IntegerLiteralNode intLiteralNode(Location location, long value) {
        return new IntegerLiteralNode(location,
                IntegerTypeRef.intRef(location),
                value);
    }

    public static IntegerLiteralNode charLiteralNode(Location location, long value) {
        return new IntegerLiteralNode(location
                , IntegerTypeRef.charRef(location),
                value);
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("typeNode", typeNode);
        dumper.printMember("value", value);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
