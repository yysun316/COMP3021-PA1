package hk.ust.comp3021.expr;

import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.*;

public class SubscriptExpr extends ASTExpr {
    // Subscript(expr value, expr slice, expr_context ctx)
    private ASTExpr value;
    private ASTExpr slice;
    private ASTEnumOp ctx;

    public SubscriptExpr(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.exprType = ASTExpr.ExprType.Subscript;
        this.value = ASTExpr.createASTExpr(node.getChildByIdx(0));
        this.slice = ASTExpr.createASTExpr(node.getChildByIdx(1));
        this.ctx = new ASTEnumOp(node.getChildByIdx(2));
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> children = new ArrayList<>();
        children.add(this.value);
        children.add(this.slice);
        return children;
    }
    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        return 0;
    }

    @Override
    public void printByPos(StringBuilder str) {
        // TODO: (Bonus) complete the definition of the method `printByPos`
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
}
