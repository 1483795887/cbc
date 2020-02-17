package com.cheng.cbc.ast.StmtNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;
import com.cheng.cbc.entity.DefinedVariable;
import com.cheng.cbc.entity.Scope;

import java.util.List;

public class BlockNode extends StmtNode {
    private List<DefinedVariable> vars;
    private List<StmtNode> stmts;
    private Scope scope;

    public BlockNode(Location location, List<DefinedVariable> vars, List<StmtNode> stmts) {
        this.location = location;
        this.vars = vars;
        this.stmts = stmts;
    }

    public List<DefinedVariable> getVars() {
        return vars;
    }

    public List<StmtNode> getStmts() {
        return stmts;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("vars", vars);
        dumper.printMember("stmts", stmts);
    }

    @Override
    public <S, E> S accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
