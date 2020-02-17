package com.cheng.cbc.type;

import com.cheng.cbc.ast.Location;
import com.cheng.cbc.entity.ParamSlot;

import java.util.List;

public class ParamType extends ParamSlot<Type> {
    public ParamType(Location location, List<Type> params, boolean vararg) {
        super(location, params, vararg);
    }


}
