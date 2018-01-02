import java.util.Scanner;

class Node{
	int key;
	Node left;
	Node right;
	
	public Node(int a){
		key = a;
		left = null;
		right = null;
	}
}

class BinarySearchTree{
	
	Node root;
	
	public Node insertNode(int x, Node root){
		if(root == null){
			Node newNode = new Node(x);
			root = newNode;
			return root;
		} else {
			if(x < root.key){
				root.left = insertNode(x, root.left);
			} else if (x > root.key){
				root.right = insertNode(x, root.right);
			} else {
				System.out.println("Node value " + x + " is already present");
			}
			return root;
		}
	}
	
	public void insertNode_new(int x){
		Node newNode = new Node(x);
		Node node, parent = null;
		node = root;
		if(root == null){
			root = newNode;
			return;
		} else {
			while(node != null){
				parent = node;
				if(x < node.key){
					node = node.left;
				} else if(x > node.key){
					node = node.right;
				} else {
					System.out.println("Node already present");
					return;
				}
			}
			if(x < parent.key){
				parent.left = newNode;
			} else {
				parent.right = newNode;
			}
		}
	}
	
	public void inOrder(Node node){
		if (node == null){
			return;
		} else {
			inOrder(node.left);
			System.out.print(" " + node.key);
			inOrder(node.right);
		}
	}
	
	public void preOrder(Node node){
		if(node == null){
			return;
		} else {
			System.out.print(" "+ node.key);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void postOrder(Node node){
		if(node == null){
			return;
		} else {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(" "+ node.key);
		}
	}

	public boolean searchNode(int x, Node root){
		if(root == null){
			return false;
		} else if(root.key == x) {
			return true;
		} else if(x < root.key){
			return(searchNode(x, root.left));
		} else {
			return(searchNode(x, root.right));
		}
	}
	
	public Node deleteNode(int x, Node root){
		if(root ==null){
			return root;
		} else {
			if(x < root.key){
				root.left = deleteNode(x, root.left);
			} else if(x > root.key) {
				root.right = deleteNode(x, root.right);
			} else {
				if(root.left == null){
					return(root.right);
				} else if(root.right == null){
					return(root.left);
				} else {
					int val = findMin(root.right);
					root.key = val;
					root.right = deleteNode(val, root.right);
				}
			}
			return root;
		}
	}
	
	public int findMin(Node root){
		while(root.left != null){
			root = root.left;
		}
		return root.key;
	}
	
	public int findMax(Node root){
		while(root.right !=null){
			root = root.right;
		}
		return root.key;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int input;
		BinarySearchTree newBST = new BinarySearchTree();
		while(true){
			System.out.println();
			System.out.println("***************************************");
			System.out.println("***************************************");
			System.out.println("1 : Insert");
			System.out.println("2 : Search");
			System.out.println("3 : Delete");
			System.out.println("4 : Inorder traversal");
			System.out.println("5 : PreorderTraversal");
			System.out.println("6 : PostorderTraversal");
			System.out.println("-1 : Exit");
			System.out.println("***************************************");
			System.out.println("***************************************");
			System.out.print("Select one of the above given options : ");
			
			input = sc.nextInt();
			if(input == -1){
				break;
			} else if(input == 1){
				System.out.print("Give the key to be added : ");
				int x = sc.nextInt();
				newBST.root = newBST.insertNode(x, newBST.root);
			} else if(input == 2){
				System.out.print("Give the key to be searched : ");
				int x = sc.nextInt();
				System.out.println("Is the node present ? "+newBST.searchNode(x, newBST.root));
			} else if(input == 3){
				System.out.print("Give the key to be deleted : ");
				int x = sc.nextInt();
				newBST.deleteNode(x, newBST.root);
			}else if(input == 4){
				System.out.println("Inorder Tree Traversal");
				newBST.inOrder(newBST.root);
			} else if(input == 5){
				System.out.println("PreOrder Tree Traversal");
				newBST.preOrder(newBST.root);
			} else if(input == 6){
				System.out.println("PostOrder Tree Traversal");
				newBST.postOrder(newBST.root);
			} else {
				System.out.println("Please enter valid input");
			}
			
			}
	}
}