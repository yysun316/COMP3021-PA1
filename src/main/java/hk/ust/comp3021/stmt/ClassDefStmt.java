package hk.ust.comp3021.stmt;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;

import java.util.*;

public class ClassDefStmt extends ASTStmt {
    /*
     * ClassDef(identifier name,
     *         expr* bases,
     *         keyword* keywords,
     *         stmt* body,
     *         expr* decorator_list,...)
     */
    private String name;
    private ArrayList<ASTExpr> bases = new ArrayList<>();
    private ArrayList<ASTKeyWord> keywords = new ArrayList<>();
    private ArrayList<ASTStmt> body = new ArrayList<>();
    private ArrayList<ASTExpr> decoratorList = new ArrayList<>();

    public ClassDefStmt(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.stmtType = ASTStmt.StmtType.ClassDef;
        this.name = node.getAttribute("name");
        for (XMLNode baseNode : node.getChildByIdx(0).getChildren())
            this.bases.add(ASTExpr.createASTExpr(baseNode));
        for (XMLNode keywordNode : node.getChildByIdx(1).getChildren())
            this.keywords.add(new ASTKeyWord(keywordNode));
        for (XMLNode bodyNode : node.getChildByIdx(2).getChildren())
            this.body.add(ASTStmt.createASTStmt(bodyNode));
        for (XMLNode decoratorListNode : node.getChildByIdx(3).getChildren())
            this.decoratorList.add(ASTExpr.createASTExpr(decoratorListNode));
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> children = new ArrayList<>(bases);
        children.addAll(keywords);
        children.addAll(body);
        children.addAll(decoratorList);
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
        for (ASTExpr astExpr : decoratorList) {
            astExpr.printByPos(str);
            str.append("\n");
        }
        str.append("class ").append(this.name);
        if (!this.bases.isEmpty())
            str.append("(");
        for (int i = 0; i < this.bases.size(); i++) {
            this.bases.get(i).printByPos(str);
            if (i != this.bases.size() - 1)
                str.append(", ");
        }
        if (!this.bases.isEmpty())
            str.append(")");
        str.append(":");

        for (int i = 0; i < keywords.size(); i++) {
            keywords.get(i).printByPos(str);
            if (i != keywords.size() - 1)
                str.append("\n");
        }

        for (ASTStmt astStmt : this.body)
            astStmt.printByPos(str);

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
