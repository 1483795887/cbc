package com.cheng.cbc.type;

public class FunctionType extends Type {
    private Type retType;
    private ParamType paramType;

    public FunctionType(Type retType, ParamType paramType) {
        this.retType = retType;
        this.paramType = paramType;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(retType.toString());
        builder.append("(");
        String sep = "";
        for (Type type : paramType.getParams()) {
            builder.append(sep);
            builder.append(type.toString());
            sep = ",";
        }
        builder.append(")");
        return builder.toString();
    }
}
