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

public interface ASTVisitor<S, E> {
    S visit(BlockNode node);

    S visit(BreakNode node);

    S visit(ContinueNode node);

    S visit(ExprStmtNode node);

    S visit(ForNode node);

    S visit(IfNode node);

    S visit(ReturnNode node);

    S visit(WhileNode node);

    E visit(AssignNode node);

    E visit(OpAssignNode node);

    E visit(AddressNode node);

    E visit(ArefNode node);

    E visit(DereferenceNode node);

    E visit(MemberNode node);

    E visit(PtrMemberNode node);

    E visit(VariableNode node);

    E visit(IntegerLiteralNode node);

    E visit(StringLiteralNode node);

    E visit(PrefixOpNode node);

    E visit(SuffixOpNode node);

    E visit(UnaryArithmeticOpNode node);

    E visit(UnaryOpNode node);

    E visit(BinaryOpNode node);

    E visit(CastNode node);

    E visit(CondExprNode node);

    E visit(FuncallNode node);

    E visit(LogicalAndNode node);

    E visit(LogicalOrNode node);

    E visit(SizeofExprNode node);

    E visit(SizeofTypeNode node);
}
