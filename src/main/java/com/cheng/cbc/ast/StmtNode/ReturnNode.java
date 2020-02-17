package com.cheng.cbc.ast.StmtNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class ReturnNode extends StmtNode {
    private ExprNode result;

    public ReturnNode(Location location, ExprNode result) {
        this.location = location;
        this.result = result;
    }

    public ExprNode getResult() {
        return result;
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("result", result);
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
