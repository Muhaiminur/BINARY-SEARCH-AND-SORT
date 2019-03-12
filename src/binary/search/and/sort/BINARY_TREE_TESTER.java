/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary.search.and.sort;

/**
 *
 * @author ITCLANBD
 */
public class BINARY_TREE_TESTER {

    public static void main(String[] args) {
//        NODE root = new NODE(5);
//        System.out.println("Binary Tree Example");
//        System.out.println("Building tree with root value " + root.value);
//        BINARY_TREE binary_tree = new BINARY_TREE();
//        binary_tree.addRecursive(root,6);
//        binary_tree.addRecursive(root, 8);
//        binary_tree.addRecursive(root, 6);
//        binary_tree.addRecursive(root, 3);
//        binary_tree.addRecursive(root, 9);
//        
//        if(binary_tree.containsNodeRecursive(root,3)){
//            System.out.println("TRUE");
//        }else{
//            System.out.println("NOT FOUND");
//        }
//        
//        binary_tree.traverseInOrder(root);

        BINARY_TREE_TESTING binary_tree_testing = new BINARY_TREE_TESTING();
        BINARY_NODE parent = binary_tree_testing.insert(11, null);
        binary_tree_testing.insert(8, parent);
        binary_tree_testing.insert(6, parent);
        binary_tree_testing.insert(4, parent);
        binary_tree_testing.insert(7, parent);
        binary_tree_testing.insert(10, parent);
        binary_tree_testing.insert(19, parent);
        binary_tree_testing.insert(43, parent);
        binary_tree_testing.insert(31, parent);
        binary_tree_testing.insert(29, parent);
        binary_tree_testing.insert(37, parent);
        binary_tree_testing.insert(49, parent);
        System.out.println("=============== LEFT MOST ITERATION ===============");
        System.out.println(binary_tree_testing.findLeftMost(parent).element);
        System.out.println("=============== LEFT MOST RECURSION ===============");
        System.out.println(binary_tree_testing.findLeftMost_recursion(parent).element);
        System.out.println("=============== RIGHT MOST ITERATION ===============");
        System.out.println(binary_tree_testing.findRightMost(parent).element);
        System.out.println("=============== FIND SUCCESSOR ===============");
        System.out.println(binary_tree_testing.findSuccessor(parent).element);
        System.out.println("=============== SEARCH IN BST ITERATION ===============");
        System.out.println(binary_tree_testing.findNode(7, parent).element);
        System.out.println("=============== SEARCH IN BST RECURSION ===============");
        System.out.println(binary_tree_testing.findNode(29, parent).element);
        System.out.println("=============== PRINT TREE IN SORTED ITERATION ===============");
        binary_tree_testing.printSorted(parent);
        System.out.println("=============== DELETE FROM TREE ===============");
        if (binary_tree_testing.delete(10, parent)) {
            System.out.println("DELETED");
        } else {
            System.out.println("NOT DELETED");
        }
        System.out.println("=============== PRINT TREE AFTER DELTE ===============");
        binary_tree_testing.printSorted(parent);

    }

}
