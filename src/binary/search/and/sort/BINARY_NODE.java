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
public class BINARY_NODE {

    public Object element;
    public BINARY_NODE left;
    public BINARY_NODE right;
    public BINARY_NODE parent;

    public BINARY_NODE(Object e) {
        this(e, null, null, null);
    }

    public BINARY_NODE(Object e, BINARY_NODE l, BINARY_NODE r, BINARY_NODE p) {
        element = e;
        left = l;
        right = r;
        parent = p;
    }
}
