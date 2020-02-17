package com.cheng.cbc.ast.ExprNode.LiteralNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;
import com.cheng.cbc.type.IntegerTypeRef;
import com.cheng.cbc.type.PointerTypeRef;
import com.cheng.cbc.type.TypeRef;
import com.cheng.cbc.utils.TextUtils;

public class StringLiteralNode extends LiteralNode {
    private String value;

    public StringLiteralNode(Location location, TypeRef typeRef, String value) {
        super(location, typeRef);
        this.value = value;
    }

    public static StringLiteralNode stringLiteralNode(Location location, String value) {
        return new StringLiteralNode(location,
                new PointerTypeRef(IntegerTypeRef.charRef(location)),
                value);
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("typeNode", typeNode);
        dumper.printMember("value", "\"" + TextUtils.getStringLiteral(value) + "\"");
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
