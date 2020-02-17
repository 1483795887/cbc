package com.cheng.cbc.utils;

import com.cheng.cbc.ast.Location;

import java.io.PrintStream;

public class ErrorHandler {
    private PrintStream stream;

    private long errors = 0;
    private long warns = 0;

    public ErrorHandler(PrintStream stream) {
        this.stream = stream;
    }

    public void error(Location location, String error) {
        stream.println(location.toString() + ": error: " + error);
        errors++;
    }

    public void error(String error) {
        stream.println("error: " + error);
        errors++;
    }

    public void warn(Location location, String warn) {
        stream.println(location.toString() + ": warn: " + warn);
        warns++;
    }

    public void warn(String warn) {
        stream.println("warn: " + warn);
        warns++;
    }

    public boolean errorOccured() {
        return errors > 0;
    }
}
