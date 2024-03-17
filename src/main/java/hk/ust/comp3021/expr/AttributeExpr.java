package hk.ust.comp3021.expr;

import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.XMLNode;

import java.lang.reflect.Array;
import java.util.*;

public class AttributeExpr extends ASTExpr {
    // Attribute(expr value, identifier attr, expr_context ctx)
    private ASTExpr value;
    private String attr;
    private ASTEnumOp ctx;

    public AttributeExpr(XMLNode node) {
        super(node);
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        this.exprType = ASTExpr.ExprType.Attribute;
        this.value = ASTExpr.createASTExpr(node.getChildByIdx(0));
        this.attr = node.getAttribute("attr");
        this.ctx = new ASTEnumOp(node.getChildByIdx(1));
    }

    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        return 0;
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> children = new ArrayList<>();
        children.add(this.value);
        return children;
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
