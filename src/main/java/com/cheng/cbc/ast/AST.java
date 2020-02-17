package com.cheng.cbc.ast;

import com.cheng.cbc.entity.DefinedFunction;
import com.cheng.cbc.entity.DefinedVariable;
import com.cheng.cbc.entity.Entity;
import com.cheng.cbc.entity.Scope;

import java.util.ArrayList;
import java.util.List;

public class AST extends Node {
    private Declarations declarations;
    private Scope scope;

    public AST(Location location, Declarations declarations) {
        this.location = location;
        this.declarations = declarations;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public List<DefinedVariable> definedVariableList() {
        return declarations.getDefVars();
    }

    public List<DefinedFunction> definedFunctionList() {
        return declarations.getDefFuns();
    }

    public List<Entity> definitions() {
        List<Entity> entities = new ArrayList<>();
        entities.addAll(declarations.getDefVars());
        entities.addAll(declarations.getDefFuns());
        return entities;
    }

    public List<TypeDefinition> getTypes() {
        List<TypeDefinition> definitionList = new ArrayList<>();
        definitionList.addAll(declarations.getDefStructs());
        definitionList.addAll(declarations.getTypedefs());
        return definitionList;
    }

    @Override
    protected void _dump(Dumper dumper) {
        dumper.printMember("variables", definedVariableList());
        dumper.printMember("functions", definedFunctionList());
    }
}
