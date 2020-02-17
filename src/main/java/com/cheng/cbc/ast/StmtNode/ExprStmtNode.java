package com.cheng.cbc.ast.StmtNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class ExprStmtNode extends StmtNode {
    private ExprNode exprNode;

    public ExprStmtNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }

    @Override
    public Location getLocation() {
        return exprNode.getLocation();
    }

    public ExprNode getExprNode() {
        return exprNode;
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("expr", exprNode);
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
