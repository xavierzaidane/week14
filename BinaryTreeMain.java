import java.util.Scanner;
import java.util.Random;

public class BinaryTreeMain {

    static void menu() {
        System.out.println("");
        System.out.println("1. Add");
        System.out.println("2. Delete");
        System.out.println("3. Find");
        System.out.println("4. Traverse In-Order");
        System.out.println("5. Traverse Pre-Order");
        System.out.println("6. Traverse Post-Order");
        System.out.println("7. Exit");
    } 
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Random rand = new Random();

        int choose;
        do {
            menu();
            System.out.print("Choose: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    tree.add(rand.nextInt(100));
                    break;
                case 2:
                    System.out.print("Enter data to be deleted: ");
                    tree.delete(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter data to be found: ");
                    System.out.println(tree.find(sc.nextInt()));
                    break;
                case 4:
                    tree.traverseInOrder(tree.root);
                    break;
                case 5:
                    tree.traversePreOrder(tree.root);
                    break;
                case 6:
                    tree.traversePostOrder(tree.root);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (choose != 7);
    }
}