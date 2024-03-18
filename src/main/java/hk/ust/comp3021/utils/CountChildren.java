package hk.ust.comp3021.utils;

import hk.ust.comp3021.misc.ASTElement;

import java.util.LinkedList;
import java.util.Queue;

public class CountChildren {
    public static int countChildren(ASTElement element) {
        int count = 0;
        Queue<ASTElement> queue = new LinkedList<>();
        queue.add(element);
        while (!queue.isEmpty()) {
            ASTElement cur = queue.poll();
            count++;
            if (cur.getChildren() != null && !cur.getChildren().isEmpty())
                queue.addAll(cur.getChildren());
        }
        return count;
    }
}
