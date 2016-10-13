// File: IntTreeBag.java from the package edu.colorado.collections

// The implementation of most methods in this file is left as a student
// exercise from Section 9.5 of "Data Structures and Other Objects Using Java"

// Check with your instructor to see whether you should put this class in
// a package. At the moment, it is declared as part of edu.colorado.collections:
//package edu.colorado.collections;

//import edu.colorado.nodes.IntBTNode; 

/******************************************************************************
 * This class is a homework assignment; An <CODE>IntTreeBag</CODE> is a
 * collection of int numbers.
 * 
 * <dl>
 * <dt><b>Limitations:</b>
 * <dd>
 * Beyond <CODE>Integer.MAX_VALUE</CODE> elements, <CODE>countOccurrences</CODE>
 * , and <CODE>size</CODE> are wrong.
 * 
 * <dt><b>Outline of Java Source Code for this class:</b>
 * <dd>
 * <A HREF="../edu/colorado/collections/IntTreeBag.java">
 * http://www.cs.colorado.edu/~main/edu/colorado/collections/IntTreeBag.java
 * </A>
 * 
 * <dt><b>Note:</b>
 * <dd>
 * This file contains only blank implementations ("stubs") because this is a
 * Programming Project for my students.
 * 
 * @version Jan 24, 1999
 * 
 * @see IntArrayBag
 * @see IntLinkedBag
 ******************************************************************************/
public class TreeBag<E> {

	// Invariant of the IntTreeBag class:
	// 1. The elements in the bag are stored in a binary search tree.
	// 2. The instance variable root is a reference to the root of the
	// binary search tree (or null for an empty tree).
	private BTNode root;

	/**
	 * Insert a new element into this bag.
	 * 
	 * @param <CODE>element</CODE> the new element that is being inserted <dt>
	 *        <b>Postcondition:</b>
	 *        <dd>
	 *        A new copy of the element has been added to this bag.
	 * @exception OutOfMemoryError
	 *                Indicates insufficient memory a new IntBTNode.
	 **/
	// *********************************************************************
	public void add(Comparable x) {
		root = addNode(x, root);
	}

	// *********************************************************************

	/**
	 * Remove one copy of a specified element from this bag.
	 * 
	 * @param <CODE>target</CODE> the element to remove from the bag <dt>
	 *        <b>Postcondition:</b>
	 *        <dd>
	 *        If <CODE>target</CODE> was found in the bag, then one copy of
	 *        <CODE>target</CODE> has been removed and the method returns true.
	 *        Otherwise the bag remains unchanged and the method returns false.
	 **/
	// *********************************************************************
	public void remove(Comparable target) {

		root = removeNode(root, target);
	}

	public BTNode removeNode(BTNode p, Comparable target) {

		if (p == null)
			return p;
		if (target.compareTo(p.getData()) < 0)
			p.setLeft(removeNode(p.getLeft(), target));
		else if (target.compareTo(p.getData()) > 0)
			p.setRight(removeNode(p.getRight(), target));

		else if ((p.getLeft() != null) && (p.getRight() != null)) {

			p.setData(p.getLeft().getRightmostData());
			p.setLeft(p.getLeft().removeRightmost());
		} else if (p.getLeft() == null)
			p = p.getRight();
		else
			p = p.getLeft();
		return p;
	}

	// Add a node to the bag
	private BTNode addNode(Comparable x, BTNode p) {
		if (p == null)
			// Create the node - base case
			p = new BTNode(x, null, null);
		else if (x.compareTo(p.getData()) < 0)
			p.setLeft(addNode(x, p.getLeft()));
		else if (x.compareTo(p.getData()) > 0)
			p.setRight(addNode(x, p.getRight()));
		else
			// Keys are equal - replace with new data
			p.setData(x);
		return p;
	}

	// Display an element of the tree
	public void display(BTNode p) {
		Comparable x;

		if (p != null) {
			this.display(p.getLeft());
			x = (Comparable) root.getData();
			System.out.println(x.toString());
			this.display(p.getRight());
		}
	}
	
	//Retrieve an element of the tree
	public Object retrieveNode (Comparable x, BTNode p){

		if(p == null){
			return null;
		}
		
		if ( x.compareTo(p.getData()) == 0){
			return p.getData();
		}
		else if (x.compareTo(p.getData()) < 0){
		System.out.print("going left");
			this.retrieveNode(x, p.getLeft());
			}
		else if (x.compareTo(p.getData()) > 0){
		System.out.print("going right");
			this.retrieveNode(x, p.getRight());
			}
		
		return p.getData();
	}
	
	public BTNode getRoot(){
		return root;
	}
}
