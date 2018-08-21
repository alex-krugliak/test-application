package al.test;

import java.util.Iterator;
import java.util.List;

public class Application {


    public static void main(String[] arg) {
        BinaryTree<Character> binaryTree = new BinaryTree<>();

        binaryTree.addNode(100, 'A');
        binaryTree.addNode(85, 'B');
        binaryTree.addNode(110, 'C');
        binaryTree.addNode(95, 'E');
        binaryTree.addNode(75, 'D');
        binaryTree.addNode(80, 'I');
        binaryTree.addNode(70, 'H');
        binaryTree.addNode(90, 'J');
        binaryTree.addNode(105, 'F');
        binaryTree.addNode(115, 'G');

        List<Character> path = binaryTree.findAnyMostShallowPath();
        if (path != null) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator<Character> itr = path.iterator();
            while (itr.hasNext()) {
                char value = itr.next();
                stringBuilder.append(String.valueOf(value));
                if (itr.hasNext()) {
                    stringBuilder.append("-");
                }

            }

            System.out.println(stringBuilder.toString());

        } else {
            System.out.println("Application Error");
        }

    }
}
