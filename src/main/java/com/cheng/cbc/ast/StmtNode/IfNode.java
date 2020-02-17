package com.cheng.cbc.ast.StmtNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class IfNode extends StmtNode {
    private ExprNode cond;
    private StmtNode thenBody;
    private StmtNode elseBody;

    public IfNode(Location location, ExprNode cond, StmtNode thenBody, StmtNode elseBody) {
        this.location = location;
        this.cond = cond;
        this.thenBody = thenBody;
        this.elseBody = elseBody;
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("cond", cond);
        dumper.printMember("then", thenBody);
        dumper.printMember("else", elseBody);
    }

    public ExprNode getCond() {
        return cond;
    }

    public StmtNode getThenBody() {
        return thenBody;
    }

    public StmtNode getElseBody() {
        return elseBody;
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
