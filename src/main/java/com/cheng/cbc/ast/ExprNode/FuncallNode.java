package com.cheng.cbc.ast.ExprNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;

import java.util.List;

public class FuncallNode extends ExprNode {
    private ExprNode func;
    private List<ExprNode> args;

    public FuncallNode(ExprNode func, List<ExprNode> args) {
        this.func = func;
        this.args = args;
    }

    public ExprNode getFunc() {
        return func;
    }

    public List<ExprNode> getArgs() {
        return args;
    }

    @Override
    public Location getLocation() {
        return func.getLocation();
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("func", func);
        dumper.printMember("args", args);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
