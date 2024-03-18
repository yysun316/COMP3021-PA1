package hk.ust.comp3021.stmt;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.ArrayList;


public class IfStmt extends ASTStmt {
    // If(expr test, stmt* body, stmt* orelse)
    private ASTExpr test;
    private ArrayList<ASTStmt> body = new ArrayList<ASTStmt>();
    private ArrayList<ASTStmt> orelse = new ArrayList<ASTStmt>();

    public IfStmt(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.stmtType = ASTStmt.StmtType.If;
        this.test = ASTExpr.createASTExpr(node.getChildByIdx(0));
        for (XMLNode child : node.getChildByIdx(1).getChildren())
            this.body.add(ASTStmt.createASTStmt(child));
        for (XMLNode child : node.getChildByIdx(2).getChildren())
            this.orelse.add(ASTStmt.createASTStmt(child));
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> children = new ArrayList<>();
        children.add(test);
        children.addAll(body);
        children.addAll(orelse);
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
        str.append("if ");
        test.printByPos(str);
        str.append(":");
        for (ASTStmt stmt : body)
            stmt.printByPos(str);
        for (ASTStmt stmt : orelse)
            stmt.printByPos(str);
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
}
