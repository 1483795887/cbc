package com.cheng.cbc.ast.StmtNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class ForNode extends StmtNode {
    private ExprNode start;
    private ExprNode end;
    private ExprNode step;
    private StmtNode body;

    public ForNode(Location location, ExprNode start, ExprNode end, ExprNode step, StmtNode body) {
        this.location = location;
        this.start = start;
        this.end = end;
        this.step = step;
        this.body = body;
    }

    public ExprNode getStart() {
        return start;
    }

    public ExprNode getEnd() {
        return end;
    }

    public ExprNode getStep() {
        return step;
    }

    public StmtNode getBody() {
        return body;
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("start", start);
        dumper.printMember("end", end);
        dumper.printMember("step", step);
        dumper.printMember("body", body);
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
