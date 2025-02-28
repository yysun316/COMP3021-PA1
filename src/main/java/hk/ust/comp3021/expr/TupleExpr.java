package hk.ust.comp3021.expr;

import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.*;

public class TupleExpr extends ASTExpr {
    //  Tuple(expr* elts, expr_context ctx)
    private ArrayList<ASTExpr> elts = new ArrayList<>();
    private ASTEnumOp ctx;

    public TupleExpr(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.exprType = ASTExpr.ExprType.Tuple;
        for (XMLNode eltNode : node.getChildByIdx(0).getChildren())
            this.elts.add(ASTExpr.createASTExpr(eltNode));
        this.ctx = new ASTEnumOp(node.getChildByIdx(1));
    }

    @Override
    public void printByPos(StringBuilder str) {
        // TODO: (Bonus) complete the definition of the method `printByPos`
        fillStartBlanks(str);
        str.append("(".repeat(Math.max(0, this.elts.get(0).getColOffset() - this.getColOffset())));

        for (int i = 0; i < this.elts.size(); i++) {
            this.elts.get(i).printByPos(str);
            if (i != this.elts.size() - 1)
                str.append(", ");
        }
        str.append(")".repeat(Math.max(0, this.getEndColOffset() - this.elts.get(this.elts.size() - 1).getEndColOffset())));
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        return new ArrayList<>(this.elts);
    }

    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        return CountChildren.countChildren(this);
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
