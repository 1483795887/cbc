package com.cheng.cbc.ast;

import com.cheng.cbc.entity.DefinedFunction;
import com.cheng.cbc.entity.DefinedVariable;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Declarations {

    private Set<DefinedVariable> defVars = new LinkedHashSet<>();
    private Set<DefinedFunction> defFuns = new LinkedHashSet<>();
    private Set<StructNode> defStructs = new LinkedHashSet<>();
    private Set<TypedefNode> defTypedefs = new LinkedHashSet<>();

    public void addDefVars(List<DefinedVariable> vars) {
        defVars.addAll(vars);
    }

    public void addDefFun(DefinedFunction function) {
        defFuns.add(function);
    }

    public void addDefStruct(StructNode structNode) {
        defStructs.add(structNode);
    }

    public void addDefTypedef(TypedefNode typedefNode) {
        defTypedefs.add(typedefNode);
    }

    public List<DefinedVariable> getDefVars() {
        return new ArrayList<>(defVars);
    }

    public List<DefinedFunction> getDefFuns() {
        return new ArrayList<>(defFuns);
    }

    public List<TypedefNode> getTypedefs() {
        return new ArrayList<>(defTypedefs);
    }

    public List<StructNode> getDefStructs() {
        return new ArrayList<>(defStructs);
    }
}
