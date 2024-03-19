package hk.ust.comp3021.expr;

import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.ArrayList;

public class ConstantExpr extends ASTExpr {
    // Constant(constant value, string? kind)
    private String value;
    private String kind;

    public ConstantExpr(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.exprType = ASTExpr.ExprType.Constant;
        this.value = node.getAttribute("value");
        if (!node.hasAttribute("kind"))
            this.kind = node.getAttribute("kind");
    }

    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        return CountChildren.countChildren(this);
    }
    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        return new ArrayList<>(); // follow professor's code.
    }
    @Override
    public void printByPos(StringBuilder str) {
        // TODO: (Bonus) complete the definition of the method `printByPos`
        if (!isDigit(this.value) && !this.value.equals("None") && !this.value.equals("True") && !this.value.equals("False"))
            str.append("'");
        str.append(this.value);
        if (!isDigit(this.value) && !this.value.equals("None") && !this.value.equals("True") && !this.value.equals("False"))
            str.append("'");
        if (this.kind != null)
            str.append(" ").append(this.kind);
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

    public static boolean isDigit(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }
}
