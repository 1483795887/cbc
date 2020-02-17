package com.cheng.cbc.ast.StmtNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

public class WhileNode extends StmtNode {
    private ExprNode expr;
    private StmtNode body;

    public WhileNode(Location location, ExprNode expr, StmtNode body) {
        this.location = location;
        this.expr = expr;
        this.body = body;
    }

    public ExprNode getExpr() {
        return expr;
    }

    public StmtNode getBody() {
        return body;
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("expr", expr);
        dumper.printMember("body", body);
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
