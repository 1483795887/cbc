package com.cheng.cbc.ast;

abstract public class Node implements Dumpable {

    protected Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public void dump(Dumper dumper) {
        dumper.printClass(this, getLocation());
        _dump(dumper);
    }

    abstract protected void _dump(Dumper dumper);

}
