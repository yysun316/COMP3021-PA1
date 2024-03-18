package hk.ust.comp3021.utils;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.stmt.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;


public class ASTModule extends ASTElement {
    // Module(stmt* body, ...)
    private ArrayList<ASTStmt> body;
    private String astID;

    public ASTModule(XMLNode node, String astID) {
        this.astID = astID;

        this.body = new ArrayList<>();
        for (XMLNode bodyNode : node.getChildByIdx(0).getChildren()) {
            this.body.add(ASTStmt.createASTStmt(bodyNode));
        }
    }

    /*
     * Find all AST node whose class type is `FunctionDefStmt` shown in the AST
     * Hints: you need to traverse all the nodes in AST and check its class type.
     * We have prepared the method `getChildren` for you to ease the traversal.
     * You may need to remove the `return null` in the skeleton.
     * */
    public ArrayList<FunctionDefStmt> getAllFunctions() {
        // TODO: complete the definition of the method `getAllFunctions`
        ArrayList<FunctionDefStmt> result = new ArrayList<>();
        Queue<ASTElement> visited = new LinkedList<>();
        for (ASTStmt curStmt : this.body)
            bfsFunctionDef(visited, curStmt, result);

        return result;
    }

    private static void bfsFunctionDef(Queue<ASTElement> visited, ASTElement curStmt, ArrayList<FunctionDefStmt> result) {
        if (curStmt == null) return;
        visited.add(curStmt);
        while (!visited.isEmpty()) {
            ASTElement tmp = visited.poll();

            if (tmp instanceof ASTStmt && tmp.getNodeType().equals("FunctionDef"))
                result.add((FunctionDefStmt) tmp);

            if (tmp.getChildren() != null && !tmp.getChildren().isEmpty())
                visited.addAll(tmp.getChildren());
        }
    }


    /*
     * Find all operators whose class type is `ASTEnumOp` shown in the AST.
     * Hints: We have prepared the method `getChildren` for you to ease the traversal.
     * But ASTEnumOp is not regarded as children node in AST Tree.
     * To find all operators, you need to first find the nodes whose types are BinOpExpr, BoolOpExpr, etc.
     * Then, you obtain their operators by accessing field `op`.
     * Further, Ctx_Store, Ctx_Load and Ctx_Del are not operators as well.
     * You may need to remove the `return null` in the skeleton.
     * */
    public ArrayList<ASTEnumOp> getAllOperators() {
        // TODO: complete the definition of the method `getAllOperators`
        ArrayList<ASTEnumOp> result = new ArrayList<>();
        Queue<ASTElement> visited = new LinkedList<>();

        for (ASTStmt curStmt : this.body)
            bfsOps(visited, curStmt, result);

        return result;
    }

    private static void bfsOps(Queue<ASTElement> visited, ASTElement curStmt, ArrayList<ASTEnumOp> result) {
        if (curStmt == null) return;
        visited.add(curStmt);
        while (!visited.isEmpty()) {
            ASTElement tmp = visited.poll();
            if (tmp instanceof BinOpExpr)
                result.add(((BinOpExpr) tmp).getOp());
            else if (tmp instanceof BoolOpExpr)
                result.add(((BoolOpExpr) tmp).getOp());
            else if (tmp instanceof UnaryOpExpr)
                result.add(((UnaryOpExpr) tmp).getOp());
            else if (tmp instanceof CompareExpr)
                result.addAll(((CompareExpr) tmp).getOps());
            else if (tmp instanceof AugAssignStmt)
                result.add(((AugAssignStmt) tmp).getOp());
            if (tmp.getChildren() != null && !tmp.getChildren().isEmpty())
                visited.addAll(tmp.getChildren());
        }
    }

    /*
     * Find all AST node shown in the AST
     * Hints: you need to traverse all the nodes in AST.
     * You may need to remove the `return null` in the skeleton.
     * */
    public ArrayList<ASTElement> getAllNodes() {
        // TODO: complete the definition of the method `getAllNodes`
        ArrayList<ASTElement> result = new ArrayList<>();
        result.add(this);
        Queue<ASTElement> visited = new LinkedList<>(this.body);
        while (!visited.isEmpty()) {
            ASTElement tmp = visited.poll();
            result.add(tmp);
            if (tmp.getChildren() != null && !tmp.getChildren().isEmpty())
                visited.addAll(tmp.getChildren());
        }
        return result;
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        return new ArrayList<>(this.body);
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

    public String getASTID() {
        return astID;
    }

    @Override
    public String getNodeType() {
        return "Module";
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

    public ArrayList<ASTStmt> getBody() {
        return body;
    }

    public void setBody(ArrayList<ASTStmt> body) {
        this.body = body;
    }

    public String getAstID() {
        return astID;
    }

    public void setAstID(String astID) {
        this.astID = astID;
    }
}
