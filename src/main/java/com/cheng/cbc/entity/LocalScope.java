package com.cheng.cbc.entity;

import com.cheng.cbc.exception.SemanticException;
import com.cheng.cbc.utils.ErrorHandler;

import java.util.HashMap;
import java.util.Map;

public class LocalScope extends Scope {
    protected Scope parent;
    protected Map<String, DefinedVariable> variableMap;

    public LocalScope(Scope scope) {
        this.parent = scope;
        parent.addChild(this);
        variableMap = new HashMap<>();
    }

    public boolean isDefinedLocally(String name) {
        return variableMap.get(name) != null;
    }

    public void defineVariable(DefinedVariable var) {
        variableMap.put(var.getName(), var);
    }

    public Entity get(String name) throws SemanticException {
        DefinedVariable variable = variableMap.get(name);
        if (variable != null) {
            return variable;
        } else {
            return parent.get(name);
        }
    }

    @Override
    public void checkReference(ErrorHandler handler) {
        for (Entity entity : variableMap.values()) {
            if (entity.isDefined() && !entity.getReferred()) {
                handler.warn(entity.getLocation(), "unused variable: " + entity.getName());
            }
        }
        for (LocalScope scope : children) {
            scope.checkReference(handler);
        }
    }
}
