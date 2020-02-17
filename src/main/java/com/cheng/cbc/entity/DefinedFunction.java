package com.cheng.cbc.entity;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.StmtNode.BlockNode;
import com.cheng.cbc.ast.TypeNode;
import com.cheng.cbc.compiler.EntityVisitor;

import java.util.List;

public class DefinedFunction extends Function {
    private BlockNode body;
    private Params params;

    public DefinedFunction(Boolean isPrivate, TypeNode typeNode, String name, Params params, BlockNode body) {
        super(isPrivate, typeNode, name);
        this.params = params;
        this.body = body;
    }

    public List<Parameter> getParams() {
        return params.getParams();
    }

    public BlockNode getBody() {
        return body;
    }

    @Override
    public boolean isDefined() {
        return true;
    }

    @Override
    public void _dump(Dumper dumper) {
        dumper.printMember("private", isPrivate);
        dumper.printMember("retType", typeNode);
        dumper.printMember("name", name);
        dumper.printMember("params", params);
        dumper.printMember("body", body);
    }

    @Override
    public <T> T accept(EntityVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
