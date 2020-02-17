package com.cheng.cbc.ast;

import com.cheng.cbc.type.TypeRef;

import java.io.PrintStream;
import java.util.List;

public class Dumper {
    private PrintStream stream;
    private int indent;

    public Dumper(PrintStream stream) {
        this.stream = stream;
        indent = 0;
    }

    private void printIndent() {
        for (int i = 0; i < indent; i++)
            stream.print('\t');
    }

    public void printClass(Object object, Location location) {
        printIndent();
        stream.println("<" + object.getClass().getSimpleName() + ">" + location);
    }

    public void printMember(String name, long value) {
        printPair(name, value);
    }

    public void printMember(String name, String value) {
        printPair(name, value);
    }

    public void printMember(String name, Boolean b) {
        printPair(name, b);
    }

    public void printMember(String name, TypeRef typeRef) {
        printMember(name, typeRef.toString());
    }

    public void printMember(String name, TypeNode typeNode) {
        printPair(name, typeNode.getTypeRef() + (typeNode.isResolved() ? "(resolved)" : ""));
    }

    public void printMember(String name, Dumpable dumpable) {
        printIndent();
        if (dumpable == null) {
            stream.println(name + ":null");
        } else {
            stream.println(name + ":");
            indent++;
            dumpable.dump(this);
            indent--;
        }
    }

    public void printMember(String name, List<? extends Dumpable> dumpableList) {
        printIndent();
        stream.println(name + ":");
        indent++;
        for (Dumpable node : dumpableList) {
            node.dump(this);
        }
        indent--;
    }

    private void printPair(String name, Object value) {
        printIndent();
        stream.println(name + ":" + value);
    }

}
