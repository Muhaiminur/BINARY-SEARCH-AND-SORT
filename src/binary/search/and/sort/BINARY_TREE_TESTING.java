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
public class BINARY_TREE_TESTING {

    public BINARY_NODE findLeftMost(BINARY_NODE n) {
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public BINARY_NODE findLeftMost_recursion(BINARY_NODE n) {
        if (n.left == null) {
            return n;
        } else {
            return findLeftMost(n.left);
        }
    }

    public BINARY_NODE findRightMost(BINARY_NODE n) {
        if (n.right == null) {
            return n;
        } else {
            return findRightMost(n.right);
        }
    }

    public BINARY_NODE insert(Object key, BINARY_NODE root) {
        // The tree may be empty, in which case we set root to the new
        // node containing the given element.
        if (root == null) {
            root = new BINARY_NODE(key);
        } else {
            // Otherwise, tree is not empty, so we find the *parent* node
            // to which we'll attach the new node as a child. We use two
            // references in lock-step until one reaches an external node.
            BINARY_NODE p = null; // the parent node.
            BINARY_NODE n = root;
            while (n != null) {
                int compare = ((Comparable) key).compareTo(n.element);
                if (compare == 0) {
                    //throw new DuplicateKeyException();
                    System.out.println("DUPLICATE KEY");
                } else if (compare > 0) {
                    p = n;
                    n = n.right;
                } else {
                    p = n;
                    n = n.left;
                }
            }

            // At this point, n points to the external node which will be
            // replaced by the new node, and p points to the parent of n.
            // So we just have to attach the new node to either left or
            // the right child of p, depending on the relative values of
            // p.element and element.
            BINARY_NODE newNode = new BINARY_NODE(key);
            if (((Comparable) key).compareTo(p.element) > 0) {
                p.right = newNode;
            } else {
                p.left = newNode;
            }

            // p will become newNode's parent.
            newNode.parent = p;
        }
        return root;
    }

    public BINARY_NODE findSuccessor(BINARY_NODE n) {
        if (n.right != null) {
            // If n has a right subtree, then the successor node is the
            // leftmost node in the right subtree.
            BINARY_NODE p = findLeftMost(n.right);
            return p;
        } else {
            // If n does not have a right subtree, the successor node is
            // an ancestor node, but only if it's to the "right" of n. The
            // successor to the largest node (which is the rightmost node
            // in the tree) is the parent of root, which is null.
            BINARY_NODE q = n;
            BINARY_NODE p = q.parent;
            while (p != null && p.right == q) {
                q = p;
                p = p.parent;
            }
            return p;
        }
    }

    public BINARY_NODE findNode(Object key, BINARY_NODE n) {
        while (n != null) {
            if (key.equals(n.element)) {
                return n;
            } else if (((Comparable) key).compareTo(n.element) > 0) {
                n = n.right;
            } else {
                n = n.left;
            }
        }
        return n;
    }

    public BINARY_NODE findNode_recursive(Object key, BINARY_NODE n) {
        if (n == null) {
            return null;
        } else if (key.equals(n.element)) {
            return n;
        } else if (((Comparable) key).compareTo(n.element) > 0) {
            return findNode(key, n.right);
        } else {
            return findNode(key, n.left);
        }
    }

    public void printSorted(BINARY_NODE n) {
        System.out.println("");
        n = findLeftMost(n);
        while (n != null) {
            System.out.print(n.element + " , ");
            n = findSuccessor(n);
        }
        System.out.println("");
    }

    public boolean delete(Object id, BINARY_NODE root) {
        BINARY_NODE parent = root;
        BINARY_NODE current = root;
        boolean isLeftChild = false;
        while (current.element != id) {
            parent = current;
            if ((int) current.element > (int) id) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } //Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {

            //now we have found the minimum element in the right sub tree
            BINARY_NODE successor = findSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }
}
