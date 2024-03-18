package hk.ust.comp3021.stmt;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.*;

public class AugAssignStmt extends ASTStmt {
    // AugAssign(expr target, operator op, expr value)
    private ASTExpr target;
    private ASTEnumOp op;
    private ASTExpr value;

    public AugAssignStmt(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.stmtType = ASTStmt.StmtType.AugAssign;
        this.target = ASTExpr.createASTExpr(node.getChildByIdx(0));
        this.op = new ASTEnumOp(node.getChildByIdx(1));
        this.value = ASTExpr.createASTExpr(node.getChildByIdx(2));
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> children = new ArrayList<>();
        children.add(target);
        children.add(value);
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
        this.fillStartBlanks(str);
        target.printByPos(str);
        str.append(" ");
        this.op.printByPos(str);
        str.append("= ");
        value.printByPos(str);
        this.fillEndBlanks(str);
    }

    /**
     * Attention: You may need to define more methods to update or access the field
     * of the class ASTStmt, i.e., getters or setters Feel free to define more
     * method but remember not
     * (1) removing the fields or methods in our skeleton.
     * (2) changing the type signature of `public` methods
     * (3) changing the modifiers of the fields and methods, e.g., changing a modifier from "private"
     * to "public"
     */
    @Override
    public void yourMethod() {
    }

    public ASTExpr getTarget() {
        return target;
    }

    public void setTarget(ASTExpr target) {
        this.target = target;
    }

    public ASTEnumOp getOp() {
        return op;
    }

    public void setOp(ASTEnumOp op) {
        this.op = op;
    }

    public ASTExpr getValue() {
        return value;
    }

    public void setValue(ASTExpr value) {
        this.value = value;
    }
}
