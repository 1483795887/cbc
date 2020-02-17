package com.cheng.cbc.type;

public class FunctionTypeRef extends TypeRef {
    private TypeRef retTypeRef;
    private ParamTypeRef paramTypeRef;

    public FunctionTypeRef(TypeRef retTypeRef, ParamTypeRef paramTypeRef) {
        super(retTypeRef.getLocation());
        this.retTypeRef = retTypeRef;
        this.paramTypeRef = paramTypeRef;
    }

    public TypeRef getRetTypeRef() {
        return retTypeRef;
    }

    public ParamTypeRef getParamTypeRef() {
        return paramTypeRef;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FunctionTypeRef)) return false;
        return retTypeRef.equals(((FunctionTypeRef) obj).retTypeRef)
                && paramTypeRef.equals(((FunctionTypeRef) obj).paramTypeRef);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(retTypeRef.toString());
        builder.append("(");
        String sep = "";
        for (TypeRef ref : paramTypeRef.getParams()) {
            builder.append(sep);
            builder.append(ref.toString());
            sep = ",";
        }
        builder.append(")");
        return builder.toString();
    }
}
