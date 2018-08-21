package al.test;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree<T> {

    private Node rootNode;

    public void addNode(int key, T newValue) {
        if (newValue == null) {
            throw new UnsupportedOperationException("");
        }
        Node<T> newNode = new Node<>(key, newValue);

        if (rootNode == null) {
            rootNode = newNode;
            return;
        }

        Node parent = rootNode;
        boolean isParentFound = false;
        while (!isParentFound) {
            int parentValue = parent.key;

            if (parentValue > newNode.key) {
                if (parent.left == null) {
                    parent.left = newNode;
                    isParentFound = true;
                } else {
                    parent = parent.left;
                }
            } else {
                if (parent.right == null) {
                    parent.right = newNode;
                    isParentFound = true;
                } else {
                    parent = parent.right;
                }
            }
        }
    }

    public List<T> findAnyMostShallowPath() {
        Node mostShallowNode = findAnyMostShallowNode();
        if (mostShallowNode == null) {
            return null;
        }

        Node currentNode = rootNode;
        List<T> path = new LinkedList<>();
        path.add((T) currentNode.value);
        while (currentNode.key != mostShallowNode.key) {
            if (currentNode.key > mostShallowNode.key) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }

            if (currentNode == null) {
                return null;
            }

            path.add((T) currentNode.value);
        }

        return path;
    }


    private Node findAnyMostShallowNode() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(rootNode);
        while (!queue.isEmpty()) {
            Node node = queue.removeLast();
            if (node.right == null && node.left == null) {
                return node;
            }

            if (node.left != null) {
                queue.push(node.left);
            }

            if (node.right != null) {
                queue.push(node.right);
            }

        }
        return null;
    }


    private static class Node<T> {
        private int key;
        private T value;
        private Node left;
        private Node right;

        Node(int key, T value) {
            this.value = value;
            this.key = key;
        }

    }

}
