package com.cheng.cbc.ast.ExprNode.LHSNode;

import com.cheng.cbc.ast.ExprNode.ExprNode;
import com.cheng.cbc.type.Type;

abstract public class LHSNode extends ExprNode {
    protected Type type, originalType;

    public Type type() {
        return type != null ? type : originalType;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
