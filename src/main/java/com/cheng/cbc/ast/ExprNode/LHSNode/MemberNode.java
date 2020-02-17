package com.cheng.cbc.ast.ExprNode.LHSNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class MemberNode extends LHSNode {
    private ExprNode node;
    private String member;

    public MemberNode(ExprNode node, String member) {
        this.node = node;
        this.member = member;
    }

    public ExprNode getNode() {
        return node;
    }

    @Override
    public Location getLocation() {
        return node.getLocation();
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("expr", node);
        dumper.printMember("member", member);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
