package com.cheng.cbc.ast.StmtNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class BreakNode extends StmtNode {
    public BreakNode(Location location) {
        this.location = location;
    }

    @Override
    protected void _dump(Dumper dumper) {

    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
