package com.cheng.cbc.type;

import com.cheng.cbc.ast.Location;
import com.cheng.cbc.entity.ParamSlot;

import java.util.ArrayList;
import java.util.List;

public class ParamTypeRef extends ParamSlot<TypeRef> {
    public ParamTypeRef(Location location, List<TypeRef> params, boolean vararg) {
        super(location, params, vararg);
    }

    public ParamType internType(TypeTable typeTable) {
        List<Type> types = new ArrayList<>();
        for (TypeRef ref : params) {
            types.add(typeTable.get(ref));
        }
        return new ParamType(location, types, vararg);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof ParamTypeRef)
                && params.equals(((ParamTypeRef) obj).params);
    }
}
