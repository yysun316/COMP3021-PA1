package hk.ust.comp3021.expr;

import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;

import java.util.*;

public class CallExpr extends ASTExpr {
    // Call(expr func, expr* args, keyword* keywords)
    private ASTExpr func;
    private ArrayList<ASTExpr> args = new ArrayList<>();
    private ArrayList<ASTKeyWord> keywords = new ArrayList<>();

    public CallExpr(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.exprType = ASTExpr.ExprType.Call;
        this.func = ASTExpr.createASTExpr(node.getChildByIdx(0));
        for (XMLNode argNode : node.getChildByIdx(1).getChildren())
            this.args.add(ASTExpr.createASTExpr(argNode));
        for (XMLNode keywordNode : node.getChildByIdx(2).getChildren())
            this.keywords.add(new ASTKeyWord(keywordNode));
    }

    /*
     * Find all paths from func node to node with class type Name, which contain several cases
     * (1) if the path is func -> Attribute (attr: b) -> Name (id: self), then the name is self.b
     * (2) if the path is func -> Attribute (attr: b) -> Attribute (attr: a) -> Name (id: self), then the name is self.a.b
     * (3) if the path is func -> Name (id: bubbleSort), then the name is bubbleSort
     * @return: name of called function
     */
    public String getCalledFuncName() {
        // TODO: complete the definitaion of the method `getCalledFuncName`
        if (func instanceof NameExpr)
            return ((NameExpr) func).getId();
        if (func instanceof AttributeExpr) {
            StringBuilder res = new StringBuilder();
            ASTElement cur = func;
            while (cur instanceof AttributeExpr) {
                res.insert(0, "." + ((AttributeExpr) cur).getAttr());
                cur = ((AttributeExpr) cur).getValue();
            }
            if (cur instanceof NameExpr)
                res.insert(0, ((NameExpr) cur).getId());
            return res.toString();
        }
        return "";
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> children = new ArrayList<>();
        children.add(this.func);
        children.addAll(this.args);
        children.addAll(this.keywords);
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
        if (func instanceof NameExpr) {
            str.append(((NameExpr) func).getId());
        } else if (func instanceof AttributeExpr) {
            func.printByPos(str);
        }
        str.append("(");
        for (int i = 0; i < args.size(); i++) {
            args.get(i).printByPos(str);
            if (i != args.size() - 1)
                str.append(", ");
        }
        for (int j = 0; j < keywords.size(); j++) {
            keywords.get(j).printByPos(str);
            if (j != keywords.size() - 1)
                str.append(", ");
        }
        str.append(")");
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
