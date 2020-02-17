package com.cheng.cbc.entity;

import com.cheng.cbc.ast.Location;

import java.util.List;

abstract public class ParamSlot<T> {
    protected Location location;
    protected List<T> params;
    protected boolean vararg;

    public ParamSlot(Location location, List<T> params, boolean vararg) {
        this.location = location;
        this.params = params;
        this.vararg = vararg;
    }

    public List<T> getParams() {
        return params;
    }

    public void acceptVarargs() {
        this.vararg = true;
    }
}
