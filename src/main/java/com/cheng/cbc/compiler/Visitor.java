package com.cheng.cbc.compiler;

import com.cheng.cbc.ast.ExprNode.*;
import com.cheng.cbc.ast.ExprNode.AssignNode.AssignNode;
import com.cheng.cbc.ast.ExprNode.AssignNode.OpAssignNode;
import com.cheng.cbc.ast.ExprNode.LHSNode.*;
import com.cheng.cbc.ast.ExprNode.LiteralNode.IntegerLiteralNode;
import com.cheng.cbc.ast.ExprNode.LiteralNode.StringLiteralNode;
import com.cheng.cbc.ast.ExprNode.UnaryOpNode.PrefixOpNode;
import com.cheng.cbc.ast.ExprNode.UnaryOpNode.SuffixOpNode;
import com.cheng.cbc.ast.ExprNode.UnaryOpNode.UnaryArithmeticOpNode;
import com.cheng.cbc.ast.ExprNode.UnaryOpNode.UnaryOpNode;
import com.cheng.cbc.ast.StmtNode.*;
import com.cheng.cbc.entity.DefinedVariable;

import java.util.List;

abstract public class Visitor implements ASTVisitor<Void, Void> {
    protected void visitStmt(StmtNode node) {
        node.accept(this);
    }

    protected void visitExpr(ExprNode node) {
        node.accept(this);
    }

    protected void visitStmts(List<? extends StmtNode> nodes) {
        for (StmtNode s : nodes) {
            visitStmt(s);
        }
    }

    protected void visitExprs(List<? extends ExprNode> nodes) {
        for (ExprNode e : nodes) {
            visitExpr(e);
        }
    }

    @Override
    public Void visit(BlockNode node) {
        for (DefinedVariable var : node.getVars())
            if (var.hasInitialize())
                visitExpr(var.getInit());
        visitStmts(node.getStmts());
        return null;
    }

    @Override
    public Void visit(BreakNode node) {
        return null;
    }

    @Override
    public Void visit(ContinueNode node) {
        return null;
    }

    @Override
    public Void visit(ExprStmtNode node) {
        visitExpr(node.getExprNode());
        return null;
    }

    @Override
    public Void visit(ForNode node) {
        visitExpr(node.getStart());
        visitExpr(node.getEnd());
        visitExpr(node.getStep());
        visitStmt(node.getBody());
        return null;
    }

    @Override
    public Void visit(IfNode node) {
        visitExpr(node.getCond());
        visitStmt(node.getThenBody());
        if (node.getElseBody() != null)
            visitStmt(node.getElseBody());
        return null;
    }

    @Override
    public Void visit(ReturnNode node) {
        visitExpr(node.getResult());
        return null;
    }

    @Override
    public Void visit(WhileNode node) {
        visitExpr(node.getExpr());
        visitStmt(node.getBody());
        return null;
    }

    @Override
    public Void visit(AssignNode node) {
        visitExpr(node.getLeft());
        visitExpr(node.getRight());
        return null;
    }

    @Override
    public Void visit(OpAssignNode node) {
        visitExpr(node.getLeft());
        visitExpr(node.getRight());
        return null;
    }

    @Override
    public Void visit(AddressNode node) {
        visitExpr(node.getNode());
        return null;
    }

    @Override
    public Void visit(ArefNode node) {
        visitExpr(node.getNode());
        visitExpr(node.getIdx());
        return null;
    }

    @Override
    public Void visit(DereferenceNode node) {
        visitExpr(node.getNode());
        return null;
    }

    @Override
    public Void visit(MemberNode node) {
        visitExpr(node.getNode());
        return null;
    }

    @Override
    public Void visit(PtrMemberNode node) {
        visitExpr(node.getNode());
        return null;
    }

    @Override
    public Void visit(VariableNode node) {
        return null;
    }

    @Override
    public Void visit(IntegerLiteralNode node) {
        return null;
    }

    @Override
    public Void visit(StringLiteralNode node) {
        return null;
    }

    @Override
    public Void visit(PrefixOpNode node) {
        visitExpr(node.getNode());
        return null;
    }

    @Override
    public Void visit(SuffixOpNode node) {
        visitExpr(node.getNode());
        return null;
    }

    @Override
    public Void visit(UnaryArithmeticOpNode node) {
        visitExpr(node.getNode());
        return null;
    }

    @Override
    public Void visit(UnaryOpNode node) {
        visitExpr(node.getNode());
        return null;
    }

    @Override
    public Void visit(BinaryOpNode node) {
        visitExpr(node.getLeft());
        visitExpr(node.getRight());
        return null;
    }

    @Override
    public Void visit(CastNode node) {
        visitExpr(node.getExprNode());
        return null;
    }

    @Override
    public Void visit(CondExprNode node) {
        visitExpr(node.getCond());
        visitExpr(node.getLeft());
        visitExpr(node.getRight());
        return null;
    }

    @Override
    public Void visit(FuncallNode node) {
        visitExpr(node.getFunc());
        visitExprs(node.getArgs());
        return null;
    }

    @Override
    public Void visit(LogicalAndNode node) {
        visitExpr(node.getLeft());
        visitExpr(node.getRight());
        return null;
    }

    @Override
    public Void visit(LogicalOrNode node) {
        visitExpr(node.getLeft());
        visitExpr(node.getRight());
        return null;
    }

    @Override
    public Void visit(SizeofExprNode node) {
        visitExpr(node.getNode());
        return null;
    }

    @Override
    public Void visit(SizeofTypeNode node) {
        return null;
    }
}
