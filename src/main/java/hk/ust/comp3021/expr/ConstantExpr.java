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
        fillStartBlanks(str);
        if (getEndColOffset() - getColOffset() > value.length())
            str.append("'");
        str.append(this.value);
        if (getEndColOffset() - getColOffset() > value.length())
            str.append("'");
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

    public String getValue() {
        String str = "";
        if (getEndColOffset() - getColOffset() > value.length())
            str += "'";
        str += this.value;
        if (getEndColOffset() - getColOffset() > value.length())
            str += "'";
        return str;
    }
}
