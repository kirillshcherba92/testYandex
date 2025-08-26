package gr;

/**
 * Java. Деревья ч.1. Рекурсивный обход в глубину
 */
public class SimpleTree {
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

        final int sum = root.sum();
        System.out.println(sum);
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

        public int sum() {
            int result = 0;
            result += value;

            if (left != null) {
                result += left.sum();
            }

            if (right != null) {
                result += right.sum();
            }

            return result;
        }
    }
}
