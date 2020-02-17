package com.cheng.cbc.compiler;

import com.cheng.cbc.ast.AST;
import com.cheng.cbc.ast.Dumper;
import com.cheng.cbc.exception.CompileException;
import com.cheng.cbc.exception.SemanticException;
import com.cheng.cbc.parser.ParseException;
import com.cheng.cbc.parser.Parser;
import com.cheng.cbc.parser.TokenMgrError;
import com.cheng.cbc.type.TypeTable;
import com.cheng.cbc.utils.ErrorHandler;
import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

import java.io.*;

public class Compiler {

    static final String SOURCE_ENCODED = "utf-8";

    private final ErrorHandler errorHandler;
    private final Dumper dumper;

    public Compiler() {
        this.errorHandler = new ErrorHandler(System.err);
        dumper = new Dumper(System.out);
    }

    public static void main(String[] args) {
        Compiler compiler = new Compiler();
        try {
            compiler.compile("src/test/testc/dereferTest.c");
        } catch (CompileException e) {
            compiler.errorHandler.error(e.getMessage());
        }
    }

    public Parser getParser(File file) {
        try {
            BufferedReader r = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file),
                            SOURCE_ENCODED));
            return new Parser(r, file.getPath());
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AST parseFile(String filePath) {
        File file = new File(filePath);
        Parser parser = getParser(file);
        try {
            return parser.compilationUnit();
        } catch (TokenMgrError | ParseException err) {
            throw new SyntaxException(err.getMessage());
        }
    }

    public void compile(String path) throws CompileException {
        AST ast = parseFile(path);
        //ast.dump(dumper);
        TypeTable typeTable = TypeTable.ilp32();
        ast = semanticAnalyze(ast, typeTable);
        //ast.dump(dumper);
    }

    public AST semanticAnalyze(AST ast, TypeTable typeTable) throws SemanticException {
        new LocalResolver(errorHandler).resolve(ast);
        new TypeResolver(typeTable, errorHandler).resolve(ast);
        typeTable.semanticAnalyze(errorHandler);
        new DereferenceChecker(typeTable, errorHandler).check(ast);
        return ast;
    }
}
