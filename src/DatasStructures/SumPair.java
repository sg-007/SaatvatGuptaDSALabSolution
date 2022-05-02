package DatasStructures;
import java.util.*;

public class SumPair {

	static class Node {
		int nodeData;
		Node leftNode, rightNode;
	};

	static Node newNode(int data) {
		Node temp = new Node();

		temp.nodeData = data;
		temp.leftNode = null;
		temp.rightNode = null;

		return temp;
	}

	Node insert(Node root, int key) {

		Node newnode = newNode(key);
		Node x = root;
		Node y = null; // y maintains pointer to x

		while (x != null) {
			y = x;
			if (key < x.nodeData)
				x = x.leftNode;
			else if (key > x.nodeData)
				x = x.rightNode;
			else {
				System.out.println("Value already exists!!!");
				return newnode;
			}
		}

		// If the root is null, the tree is empty.
		if (y == null)
			y = newnode;

		// assign the new node to the left child
		else if (key < y.nodeData)
			y.leftNode = newnode;

		// assign the new node to the right child
		else
			y.rightNode = newnode;

		// return pointer to new node
		return y;
	}

	public boolean findPair(Node root, int sum, HashSet<Integer> set) {
		
		if (root == null)
			return false;
		if (findPair(root.leftNode, sum, set))
			return true;
		if (set.contains (sum - root.nodeData)) {
			System.out.println("Pair is found (" + (sum - root.nodeData) + ", " + root.nodeData + ")");
			return true;
		}
		else 
			set.add(root.nodeData);
		
		return findPair(root.rightNode, sum, set);
	}
	
	public void findPairSum (Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>(); 
		if (!findPair(root, sum, set))
			System.out.println("Pairs do not exist" + "\n");
	}
	
	public static void main(String[] args) {

		Node root = null;
		SumPair sp = new SumPair();
		root = sp.insert(root, 40);
		root = sp.insert(root, 20);
		root = sp.insert(root, 60);
		root = sp.insert(root, 10);
		root = sp.insert(root, 30);
		root = sp.insert(root, 50);
		root = sp.insert(root, 70);
		
		int sum = 130;
		sp.findPairSum(root, sum);
	}

}
