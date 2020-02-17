package com.cheng.cbc.entity;

import com.cheng.cbc.exception.SemanticException;
import com.cheng.cbc.utils.ErrorHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopLevelScope extends Scope {
    protected Map<String, Entity> entityMap;
    protected List<DefinedVariable> definedVariableList;

    public TopLevelScope() {
        entityMap = new HashMap<>();
        definedVariableList = new ArrayList<>();
    }

    public void defineEntity(Entity entity) {
        Entity e = entityMap.get(entity.getName());
        if (e != null) {
            throw new RuntimeException("duplicated declaration:"
                    + entity.getName() + ": "
                    + entity.getLocation());
        }
        entityMap.put(entity.getName(), entity);
    }

    @Override
    public Entity get(String name) throws SemanticException {
        Entity entity = entityMap.get(name);
        if (entity == null) {
            throw new SemanticException("unresolved reference: " + name);
        }
        return entity;
    }

    @Override
    public void checkReference(ErrorHandler handler) {
        for (Entity entity : entityMap.values()) {
            if (entity.isDefined() && !entity.getReferred()) {
                handler.warn(entity.getLocation(), "unused variable: " + entity.getName());
            }
        }
        for (LocalScope scope : children) {
            scope.checkReference(handler);
        }
    }
}
