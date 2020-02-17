package com.cheng.cbc.ast.ExprNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.ast.TypeNode;
import com.cheng.cbc.compiler.ASTVisitor;

public class CastNode extends ExprNode {
    private TypeNode typeNode;
    private ExprNode exprNode;

    public CastNode(TypeNode typeNode, ExprNode exprNode) {
        this.typeNode = typeNode;
        this.exprNode = exprNode;
    }

    public ExprNode getExprNode() {
        return exprNode;
    }

    @Override
    public Location getLocation() {
        return exprNode.getLocation();
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("type", typeNode);
        dumper.printMember("expr", exprNode);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
