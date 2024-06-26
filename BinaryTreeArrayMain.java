public class BinaryTreeArrayMain {
    public static void main(String[] args) {

        BinaryTreeArray tree = new BinaryTreeArray();

        int[] data = {5, 3, 7, 2, 4, 6, 8, 0, 0, 0};
        int idxLast = 6;
        tree.populateData(data, idxLast);
        tree.traverseInOrder(0);

        tree.traversePostOrder(0);
        System.out.println("");
        tree.traversePreOrder(0);
    }
}