package com.cheng.cbc.entity;

import com.cheng.cbc.ast.Dumpable;
import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.ast.Location;
import com.cheng.cbc.type.ParamTypeRef;
import com.cheng.cbc.type.TypeRef;

import java.util.ArrayList;
import java.util.List;

public class Params extends ParamSlot<Parameter> implements Dumpable {
    public Params(Location location, List<Parameter> params) {
        super(location, params, false);
    }

    @Override
    public void dump(Dumper dumper) {
        dumper.printMember("params", params);
        dumper.printMember("acceptVarargs", vararg);
    }

    public ParamTypeRef getTypeRef() {
        List<TypeRef> typeRefs = new ArrayList<>();
        for (Parameter parameter : params) {
            typeRefs.add(parameter.getTypeNode().getTypeRef());
        }
        return new ParamTypeRef(location, typeRefs, vararg);
    }
}
