package hk.ust.comp3021.stmt;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.ArrayList;


public class ForStmt extends ASTStmt {
    //  For(expr target, expr iter, stmt* body, stmt* orelse, ...)
    private ASTExpr target;
    private ASTExpr iter;
    private ArrayList<ASTStmt> body = new ArrayList<>();
    private ArrayList<ASTStmt> orelse = new ArrayList<>();
    public ForStmt(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.stmtType = ASTStmt.StmtType.For;
        this.target = ASTExpr.createASTExpr(node.getChildByIdx(0));
        this.iter = ASTExpr.createASTExpr(node.getChildByIdx(1));
        for (XMLNode child : node.getChildByIdx(2).getChildren())
            this.body.add(ASTStmt.createASTStmt(child));
        for (XMLNode child : node.getChildByIdx(3).getChildren())
            this.orelse.add(ASTStmt.createASTStmt(child));
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> children = new ArrayList<>();
        children.add(target);
        children.add(iter);
        children.addAll(body);
        children.addAll(orelse);
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
}
