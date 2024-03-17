package hk.ust.comp3021.misc;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.utils.*;

import java.util.*;

public class ASTKeyWord extends ASTElement {
    /*
     * keyword = (identifier? arg, expr value)
     * attributes (int lineno, int colOffset, int? endLineno, int? endColOffset)
     */
    private String arg;
    private ASTExpr value;

    public ASTKeyWord(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTElement.
        super(node);
        if (node.hasAttribute("arg"))
            this.arg = node.getAttribute("arg");
        this.value = ASTExpr.createASTExpr(node.getChildByIdx(0));
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> children = new ArrayList<>();
        children.add(this.value);
        return children;
    }

    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        return 0;
    }

    @Override
    public String getNodeType() {
        return "keyword";
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
