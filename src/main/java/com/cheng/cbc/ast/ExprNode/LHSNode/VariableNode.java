package com.cheng.cbc.ast.ExprNode.LHSNode;

import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.compiler.ASTVisitor;
import com.cheng.cbc.entity.Entity;

public class VariableNode extends LHSNode {
    private String name;
    private Entity entity;

    public VariableNode(Location location, String name) {
        this.location = location;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("name", name);
    }

    @Override
    public <S, E> E accept(ASTVisitor<S, E> visitor) {
        return visitor.visit(this);
    }
}
