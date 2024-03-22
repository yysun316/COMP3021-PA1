package hk.ust.comp3021.expr;

import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.*;

public class BinOpExpr extends ASTExpr {
    // BinOp(expr left, operator op, expr right)
    private ASTExpr left;
    private ASTEnumOp op;
    private ASTExpr right;

    public BinOpExpr(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.exprType = ASTExpr.ExprType.BinOp;
        this.left = ASTExpr.createASTExpr(node.getChildByIdx(0));
        this.op = new ASTEnumOp(node.getChildByIdx(1));
        this.right = ASTExpr.createASTExpr(node.getChildByIdx(2));
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> children = new ArrayList<>();
        children.add(this.left);
        children.add(this.right);
        return children;
    }

    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        return CountChildren.countChildren(this);
    }

    @Override
    public void printByPos(StringBuilder str) {
        // TODO: (Bonus) complete the definition of the method `printByPos`
        fillStartBlanks(str);
        int brankets = this.left.getColOffset() - this.getColOffset();
        if (this.left.getColOffset() > this.getColOffset())
            str.append("(".repeat(this.left.getColOffset() - this.getColOffset()));
        this.left.printByPos(str);
        if (this.left.getColOffset() > this.getColOffset())
            str.append(")".repeat(this.left.getColOffset() - this.getColOffset()));

        int oplength = ASTEnumOp.getOpLength(this.op);
        int spaces = (this.right.getColOffset() - this.left.getEndColOffset() - oplength - brankets) / 2;
        if (spaces > 0)
            str.append(" ".repeat(spaces));
        this.op.printByPos(str);
        if (spaces > 0)
            str.append(" ".repeat(spaces));

        if (this.getEndColOffset() > this.right.getEndColOffset())
            str.append("(".repeat(this.getEndColOffset() - this.right.getEndColOffset()));
        this.right.printByPos(str);
        if (this.getEndColOffset() > this.right.getEndColOffset())
            str.append(")".repeat(this.getEndColOffset() - this.right.getEndColOffset()));
        fillEndBlanks(str);
    }

    /**
     * Attention: You may need to define more methods to update or access the field of the class `User`
     * Feel free to define more method but remember not
     * (1) removing the fields or methods in our skeleton.
     * (2) changing the type signature of `public` methods
     * (3) changing the modifiers of the fields and methods, e.g., changing a modifier from "private" to "public"
     */
    public void yourMethod() {

    }


    public ASTEnumOp getOp() {
        return op;
    }

}
