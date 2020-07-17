public class Tree {
    // travers
    // delete

    TreeNode root;
    private int size = 0;


    public boolean isBalanced() {
        return checkDepth(root) != -1;
    }
    public int checkDepth(TreeNode tn) {
        if(tn == null) return 0;

        int leftDepth = checkDepth(tn.left);
        int rightDepth = checkDepth(tn.right);

        if(leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) return -1;

        return Math.max(leftDepth, rightDepth) + 1;
    }



    StringBuilder tempSB = new StringBuilder();
    public String getTree() {
        brunchToString(root);
        return tempSB.toString();
    }
    public void brunchToString(TreeNode tn) {
        if(tn == null) return;
        if(tn.right == null && tn.left == null){
            tempSB.append(tn.c.getAge());
            return;
        }
        tempSB.append(tn.c.getAge() + "(");
        brunchToString(tn.left);
        tempSB.append(", ");
        brunchToString(tn.right);
        tempSB.append(")");
    }


    public void insert(Cat c) {
        size++;
        TreeNode node = new TreeNode(c);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                parent = current;
                if (c.getAge() < current.c.getAge()) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (c.getAge() > current.c.getAge()){
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public Cat find(int age) {
        TreeNode current = root;
        while (current.c.getAge() != age) {
            current = (age < current.c.getAge()) ? current.left : current.right;
            if (current == null) return null;
        }
        return current.c;
    }

    private void preOrderTraverse(TreeNode current) {
        if (current != null) {
            System.out.print(current.c.getAge() + " ");
            preOrderTraverse(current.left);
            preOrderTraverse(current.right);
        }
    }

    public void displayTree() {
        preOrderTraverse(root);
    }

    public boolean delete(int age) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.c.getAge() != age) {
            parent = current;
            if (age < current.c.getAge()) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }

        // leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // one ancestor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // two ancestors
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        size--;
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode curr = node.right;
        while (curr != null) {
            parent = s;
            s = curr;
            curr = curr.left;
        }

        if (s != node.right) {
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }

    @Override
    public String toString() {
        return getTree();
    }



    private class TreeNode implements Comparable {
        private Cat c;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "c=" + c.toString() +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Cat))
                throw new ClassCastException("Not a cat");
            return c.getAge() - ((Cat) o).getAge();
        }
    }

}