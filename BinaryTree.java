public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void add(int data) {
        if (isEmpty()) {
            root = new Node(data);
        } else {
            Node current = root;
            while (true) {
                if (data < current.data) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = new Node(data);
                        break;
                    }
                } else if (data > current.data) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = new Node(data);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    boolean find(int data) {
        boolean result = false;
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                return result = true;
            } else if (data > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return result;
    }

    void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.data + " ");
            traverseInOrder(node.right);
        }
    }

    Node getSuccessor(Node node) {
        Node successor = node.right;
        Node successorParent = node;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != node.right) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }

        return successor;
    }

    void delete (int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        // Find the node to be deleted
        while (current != null) {
            if (current.data == data) {
                break;
            } else if (data < current.data) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (data > current.data) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        // Delete the node
        if (current == null) {
            System.out.println("Could not find the node to be deleted");
            return;
        } else {
            // Node with no child
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            // Node with one child (Left)
            } else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            // Node with 2 children
            } else {
                Node successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }

    void insertRecursive(int data) {
        root = addRecursive(root, data);
    }

    Node addRecursive(Node current, int data) {
        if (isEmpty()) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        }

        return current;
    }

    void displayMinMaxValues() {
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }

        Node minNode = findMin(root);
        Node maxNode = findMax(root);

        System.out.println("Smallest value in the tree: " + minNode.data);
        System.out.println("Largest value in the tree: " + maxNode.data);
    }

    Node findMin(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    Node findMax(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    void displayLeaf(Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }

        displayLeaf(node.left);
        displayLeaf(node.right);
    }

    int getLeafCount(Node node) {
        int count = 0;
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        count += getLeafCount(node.left);
        count += getLeafCount(node.right);
        return count;
    }

}