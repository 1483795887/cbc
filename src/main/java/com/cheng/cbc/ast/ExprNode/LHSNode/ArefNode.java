package com.cheng.cbc.ast.ExprNode.LHSNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class ArefNode extends LHSNode {
    private ExprNode node;
    private ExprNode idx;

    public ArefNode(ExprNode node, ExprNode idx) {
        this.node = node;
        this.idx = idx;
    }

    public ExprNode getNode() {
        return node;
    }

    public ExprNode getIdx() {
        return idx;
    }

    @Override
    public Location getLocation() {
        return node.getLocation();
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("expr", node);
        dumper.printMember("idx", idx);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
