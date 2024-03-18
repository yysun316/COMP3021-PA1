package hk.ust.comp3021.expr;

import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.*;


public class CompareExpr extends ASTExpr {
    // Compare(expr left, cmpop* ops, expr* comparators)
    private ASTExpr left;
    private ArrayList<ASTEnumOp> ops = new ArrayList<>();
    private ArrayList<ASTExpr> comparators = new ArrayList<>();

    public CompareExpr(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.exprType = ASTExpr.ExprType.Compare;
        this.left = ASTExpr.createASTExpr(node.getChildByIdx(0));
        for (XMLNode opNode : node.getChildByIdx(1).getChildren())
            this.ops.add(new ASTEnumOp(opNode));
        for (XMLNode comparatorNode : node.getChildByIdx(2).getChildren())
            this.comparators.add(ASTExpr.createASTExpr(comparatorNode));
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> children = new ArrayList<>();
        children.add(this.left);
        children.addAll(this.comparators);
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
        this.left.printByPos(str);
        str.append(" ");
        for (int i = 0; i < this.ops.size(); i++) {
            this.ops.get(i).printByPos(str);
        }
        str.append(" ");
        for (int i = 0; i < this.comparators.size(); i++) {
            this.comparators.get(i).printByPos(str);
        }
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

    public ASTExpr getLeft() {
        return left;
    }

    public void setLeft(ASTExpr left) {
        this.left = left;
    }

    public ArrayList<ASTEnumOp> getOps() {
        return ops;
    }

    public void setOps(ArrayList<ASTEnumOp> ops) {
        this.ops = ops;
    }

    public ArrayList<ASTExpr> getComparators() {
        return comparators;
    }

    public void setComparators(ArrayList<ASTExpr> comparators) {
        this.comparators = comparators;
    }
}
