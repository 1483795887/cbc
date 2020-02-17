package com.cheng.cbc.ast;


import com.cheng.cbc.parser.Token;

public class Location {
    private String sourceName;
    private Token token;

    public Location(String sourceName, Token token) {
        this.sourceName = sourceName;
        this.token = token;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "(" + sourceName + " " + token.beginLine + ":" + token.beginColumn + ")";
    }
}
