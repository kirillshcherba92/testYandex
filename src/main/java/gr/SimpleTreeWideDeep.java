package gr;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class SimpleTreeWideDeep {
    public static void main(String[] args) {
        Tree root = new Tree(20,
                new Tree(7,
                        new Tree(4,
                                null,
                                new Tree(6)
                        ),
                        new Tree(9)
                ),
                new Tree(35,
                        new Tree(31,
                                new Tree(28),
                                null
                        ),
                        new Tree(40,
                                new Tree(38),
                                new Tree(52)
                        )
                )
        );

//        int result = deepLoop(root);
        int result = wideLoop(root);
        System.out.println(result);
    }

    static class Tree {
        private int value;
        private Tree left;
        private Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }

    }

    public static int deepLoop(Tree root) {
        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        int result = 0;
        while (!stack.isEmpty()) {
            final Tree pop = stack.pop();
            result += pop.value;

            if (pop.left != null) {
                stack.push(pop.left);
            }

            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        return result;
    }

    public static int wideLoop(Tree root) {
        Queue<Tree> queue = new ArrayBlockingQueue<Tree>(20);
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            final Tree pop = queue.remove();
            result += pop.value;

            if (pop.left != null) {
                queue.add(pop.left);
            }

            if (pop.right != null) {
                queue.add(pop.right);
            }
        }
        return result;
    }
}
