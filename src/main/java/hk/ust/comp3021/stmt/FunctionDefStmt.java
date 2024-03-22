package hk.ust.comp3021.stmt;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;

import java.util.*;

public class FunctionDefStmt extends ASTStmt {
    /*
     * FunctionDef(identifier name, arguments args, stmt* body, expr*
     * decorator_list, expr? returns, ..)
     */
    private String name;
    private ASTArguments args;
    private ArrayList<ASTStmt> body = new ArrayList<>();
    private ArrayList<ASTExpr> decoratorList = new ArrayList<>();
    private ASTExpr returns = null;

    public FunctionDefStmt(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.stmtType = ASTStmt.StmtType.FunctionDef;
        this.name = node.getAttribute("name");
        this.args = new ASTArguments(node.getChildByIdx(0));
        for (XMLNode child : node.getChildByIdx(1).getChildren())
            this.body.add(ASTStmt.createASTStmt(child));
        for (XMLNode child : node.getChildByIdx(2).getChildren())
            this.decoratorList.add(ASTExpr.createASTExpr(child));
        if (node.getAttribute("returns") != null && node.getAttribute("returns").equals("None"))
            this.returns = null;
        else
            this.returns = ASTExpr.createASTExpr(node.getChildByIdx(3));
    }

    /*
     * Find all AST node whose class type is `CallExpr` shown in the AST
     * Hints: you need to traverse all the nodes in AST and check its class type.
     * We have prepared the method `getChildren` for you to ease the traversal.
     * You may need to remove the `return null` in the skeleton.
     * */
    public ArrayList<CallExpr> getAllCalledFunc() {
        // TODO: complete the definition of the method `getAllCalledFunc`
        ArrayList<CallExpr> res = new ArrayList<>();
        Queue<ASTElement> q = new LinkedList<>();
        q.add(this);

        while (!q.isEmpty()) {
            ASTElement el = q.poll();
            if (el instanceof CallExpr)
                res.add((CallExpr) el);
            q.addAll(el.getChildren());
        }
//        for (ASTElement el : getChildren())
//            if (el instanceof CallExpr)
//                res.add((CallExpr) el);

        return res;
    }

    public int getParamNum() {
        return args.getParamNum();
    }

    public String getName() {
        return name;
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> children = new ArrayList<>();
        children.add(args);
        children.addAll(body);
        children.addAll(decoratorList);
        if (returns != null)
            children.add(returns);
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
        str.append("def ").append(this.name).append("(");
        this.args.printByPos(str);
        str.append(")");

        if (returns != null) {
            str.append(" -> ");
            returns.printByPos(str);
        }
        str.append(":");

        for (ASTStmt stmt : body)
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
