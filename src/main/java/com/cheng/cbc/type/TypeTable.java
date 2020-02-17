package com.cheng.cbc.type;

import com.cheng.cbc.ast.Slot;
import com.cheng.cbc.exception.SemanticException;
import com.cheng.cbc.utils.ErrorHandler;

import java.util.HashMap;
import java.util.Map;

public class TypeTable {
    private static final Object checking = new Object();
    private static final Object checked = new Object();
    private Map<TypeRef, Type> table;
    private int intSize;
    private int longSize;
    private int pointerSize;

    public TypeTable(int intSize, int longSize, int pointerSize) {
        this.intSize = intSize;
        this.longSize = longSize;
        this.pointerSize = pointerSize;
        table = new HashMap<>();
    }

    public static TypeTable ilp32() {
        return newTable(1, 2, 4, 4, 4);
    }

    private static TypeTable newTable(int chSize, int shortSize, int intSize, int longSize, int pointerSize) {
        TypeTable typeTable = new TypeTable(intSize, longSize, pointerSize);
        typeTable.put(new VoidTypeRef(null), new VoidType());
        typeTable.put(IntegerTypeRef.charRef(null),
                new IntegerType(chSize, "char", false));
        typeTable.put(IntegerTypeRef.shortRef(null),
                new IntegerType(shortSize, "short", false));
        typeTable.put(IntegerTypeRef.intRef(null),
                new IntegerType(intSize, "int", false));
        typeTable.put(IntegerTypeRef.longRef(null),
                new IntegerType(intSize, "long", false));

        typeTable.put(IntegerTypeRef.ucharRef(null),
                new IntegerType(chSize, "unsigned char", true));
        typeTable.put(IntegerTypeRef.ushortRef(null),
                new IntegerType(shortSize, "unsigned short", true));
        typeTable.put(IntegerTypeRef.uintRef(null),
                new IntegerType(intSize, "unsigned int", true));
        typeTable.put(IntegerTypeRef.ulongRef(null),
                new IntegerType(intSize, "unsigned long", true));

        return typeTable;
    }

    public boolean isDefined(TypeRef ref) {
        return table.containsKey(ref);
    }

    public void put(TypeRef ref, Type type) {
        table.put(ref, type);
    }

    public Type get(TypeRef ref) {
        Type type = table.get(ref);
        if (type == null) {
            if (ref instanceof ArrayTypeRef) {
                ArrayTypeRef typeRef = (ArrayTypeRef) ref;
                Type baseType = get(typeRef.getRef());
                Type arrayType = new ArrayType(baseType, typeRef.getLength(), pointerSize);
                table.put(ref, arrayType);
                return arrayType;
            } else if (ref instanceof PointerTypeRef) {
                PointerTypeRef pointerTypeRef = (PointerTypeRef) ref;
                Type baseType = get(pointerTypeRef.getTypeRef());
                Type pointerType = new PointerType(baseType, pointerSize);
                table.put(ref, pointerType);
                return pointerType;
            } else if (ref instanceof FunctionTypeRef) {
                FunctionTypeRef functionTypeRef = (FunctionTypeRef) ref;
                Type retType = get(functionTypeRef.getRetTypeRef());
                ParamType paramType = functionTypeRef.getParamTypeRef().internType(this);
                Type t = new FunctionType(retType, paramType);
                table.put(functionTypeRef, t);
                return t;
            }
            throw new Error("unregistered type: " + ref.toString());
        }
        return type;
    }

    private void checkVoidMember(CompositeType type, ErrorHandler errorHandler) {
        for (Slot slot : type.getMembers()) {
            if (slot.getTypeNode().getType().isVoid()) {
                errorHandler.error(slot.getLocation(), "composite type can't contains void member");
            }
        }
    }

    private void checkDuplicatedMember(CompositeType type, ErrorHandler errorHandler) {
        Map<String, Slot> map = new HashMap<>();
        for (Slot slot : type.getMembers()) {
            if (map.containsKey(slot.getName())) {
                errorHandler.error(slot.getLocation(),
                        type.toString() + " has duplicated member: " + slot.toString());
            } else {
                map.put(slot.getName(), slot);
            }
        }
    }

    private void checkVoidMember(ArrayType type, ErrorHandler handler) {
        if (type.baseType().isVoid()) {
            handler.error("array cannot contain void");
        }
    }

    private void _checkRecursiveDefinition(Type t,
                                           Map<Type, Object> map,
                                           ErrorHandler handler) {
        if (map.get(t) == checking) {
            handler.error(((NamedType) t).getLocation(), "recursive type definition: " + t);
            return;
        } else if (map.get(t) == checked) {
            return;
        }
        {
            map.put(t, checking);
            if (t instanceof CompositeType) {
                CompositeType compositeType = (CompositeType) t;
                for (Slot slot : compositeType.getMembers()) {
                    _checkRecursiveDefinition(slot.getTypeNode().getType(), map, handler);
                }
            } else if (t instanceof ArrayType) {
                ArrayType arrayType = (ArrayType) t;
                _checkRecursiveDefinition(arrayType.baseType(), map, handler);
            } else if (t instanceof UserType) {
                UserType userType = (UserType) t;
                _checkRecursiveDefinition(userType.getRealType(), map, handler);
            }
            map.put(t, checked);
        }
    }

    private void checkRecursiveDefinition(Type t, ErrorHandler handler) {
        _checkRecursiveDefinition(t, new HashMap<>(), handler);
    }

    public void semanticAnalyze(ErrorHandler errorHandler) throws SemanticException {
        for (Type type : table.values()) {
            if (type instanceof CompositeType) {
                checkVoidMember((CompositeType) type, errorHandler);
                checkDuplicatedMember((CompositeType) type, errorHandler);
            } else if (type instanceof ArrayType) {
                checkVoidMember((ArrayType) type, errorHandler);
            }
            checkRecursiveDefinition(type, errorHandler);
        }

        if (errorHandler.errorOccured()) {
            throw new SemanticException("compile failed.");
        }
    }
}
