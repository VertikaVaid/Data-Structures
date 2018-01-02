class Node {
	int key;
	Node left;
	Node right;
	
	public Node(int a){
		key = a;
		left = null;
		right = null;
	}
}

class BinaryTree{
	Node root;
	
	public void inOrder(Node p){
		if(p == null){
			return;
		} else {
			inOrder(p.left);
			System.out.print(" " + p.key);
			inOrder(p.right);
		}
	}
	
	public static void main(String[] args){
		BinaryTree newBinaryTree = new BinaryTree();
		Node first = new Node(1);
		newBinaryTree.root = first;
		
		Node second = new Node(2);
		newBinaryTree.root.left = second;
		Node third = new Node(3);
		newBinaryTree.root.right = third;
		
		Node fourth = new Node(4);
		newBinaryTree.root.left.left = fourth;
		
		newBinaryTree.inOrder(newBinaryTree.root);
		
	}
}
