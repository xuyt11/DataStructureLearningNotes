package cn.ytxu.data_structure_and_algorithm_analysis_learning_notes.tree_04;

public class MyTreeSet<Element extends Comparable<Element>> {
    public static class Node<Element extends Comparable<Element>> {
        public Element data;

        public Node<Element> left, right, parent;

        public Node(Element data, Node<Element> parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    private Node<Element> root;

    public boolean contains(Element data) {
        return find(root, data) != null;
    }

    private Node<Element> find(Node<Element> node, Element data) {
        if (data == null) {
            throw new NullPointerException("data must not be null...");
        }
        if (node == null) {
            return null;
        }
        int compare = node.data.compareTo(data);
        if (compare < 0) {
            return find(node.right, data);
        } else if (compare > 0) {
            return find(node.left, data);
        } else {
            return node;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Element findMin() {
        if (isEmpty()) {
            return null;
        }
        return findMin(root).data;
    }

    private Node<Element> findMin(Node<Element> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    public Element findMax() {
        if (isEmpty()) {
            return null;
        }
        return findMax(root).data;
    }

    private Node<Element> findMax(Node<Element> node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    public Node<Element> insert(Element data) {
        if (data == null) {
            throw new NullPointerException("data must not be null...");
        }

        if (isEmpty()) {
            root = new Node<>(data, null);
            return root;
        }
        Node<Element> node = root;
        do {
            int compare = node.data.compareTo(data);
            if (compare < 0) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = new Node<>(data, node);
                    return node.right;
                }
            } else if (compare > 0) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = new Node<>(data, node);
                    return node.left;
                }
            } else {// insert failure, because has same element
            }
        } while (node != null);
        System.out.println("has same data in this set...");
        return node;
    }

    public Node<Element> remove(Element data) {
        if (data == null) {
            throw new NullPointerException("data must not be null...");
        }
        if (isEmpty()) {
            return null;
        }
        Node<Element> node = root;
        do {
            int compare = node.data.compareTo(data);
            if (compare < 0) {
                node = node.right;
            } else if (compare > 0) {
                node = node.left;
            } else {// find target node
                return node;
            }
        } while (node != null);
        return node;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("is empty set...");
            return;
        }

        Node<Element> node = root;
        print(node, 0);
    }

    private void print(Node<Element> node, int depth) {
        if (node == null) {
            return;
        }

        depth++;
        print(node.left, depth);
        printNode(node, depth);
        print(node.right, depth);
    }

    private void printNode(Node<Element> node, int depth) {
        String depathStr = "\t";
        for (int i = 0; i < depth; i++) {
            depathStr += "\t";
        }
        System.out.println(depathStr + node.data.toString());
    }

}