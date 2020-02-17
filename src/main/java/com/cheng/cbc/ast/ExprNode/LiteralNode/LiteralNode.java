package com.cheng.cbc.ast.ExprNode.LiteralNode;

import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.ast.TypeNode;
import com.cheng.cbc.type.TypeRef;

abstract public class LiteralNode extends ExprNode {
    protected TypeNode typeNode;

    public LiteralNode(Location location, TypeRef typeRef) {
        this.location = location;
        typeNode = new TypeNode(typeRef);
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    public TypeNode getTypeNode() {
        return typeNode;
    }
}
