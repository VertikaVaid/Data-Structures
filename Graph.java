import java.util.ArrayList;
import java.util.Scanner;

class Vertex{
	int node;
	int weight;
	Vertex next;
	
	public Vertex(int a, int b){
		node = a;
		weight = b;
		next = null;
	}
}

class Graph{
	ArrayList<Vertex> List;
	int noOfVertex;
	boolean directed;
	
	public Graph(int x, boolean a){
		noOfVertex = x;
		directed = a;
		List = new ArrayList<Vertex>(x);
		
		int i = 0;
		for(i = 0; i < noOfVertex; i++){
			List.add(null);
		}
	}
	
	public void addEdge(int src, int dest, int weight){
		Vertex head = List.get(src);
		if(head == null){
			Vertex newVertex = new Vertex(dest, weight);
			List.set(src, newVertex);
			return;
		}
		while(head.next != null){
			if(head.node == dest){
				System.out.println("Edge already present");
				return;
			}
			head = head.next;
		}
		if(head.node == dest){
				System.out.println("Edge already present");
				return;
		} else {
			Vertex newVertex = new Vertex(dest, weight);
			head.next = newVertex;
		}
	}
	
	public boolean removeEdge(int src, int dest){
		Vertex head = List.get(src);
		Vertex history = null;
		while(head != null){
			if(head.node == dest){
				if(history != null){
					history.next = head.next;
					return true;
				} else {
					List.set(src, null);
					return true;
				}
			} else {
				history = head;
				head = head.next;
			}
		}
		if(head == null){
			System.out.println("Edge not found");
		}
		return false;
	}
	
	public void printGraph(){
		int i = 0;
		for(i = 0; i < noOfVertex; i++){
			Vertex head = List.get(i);
			System.out.print("Vertex " + i + " :");
			while(head != null){
				System.out.print(" --> (" + head.node + ", " + head.weight + ")");
				head = head.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int V, input;
		boolean directed;
		System.out.print("Give the number of Vertices : "); 
		V = sc.nextInt();
		System.out.print("Plese enter true if the graph is directed, else enter false : "); 
		directed = sc.nextBoolean();
		
		Graph newGraph = new Graph(V, directed);
		
		while(true){
			System.out.println();
			System.out.println("***************************************");
			System.out.println("***************************************");
			System.out.println("1 : Add edge");
			System.out.println("2 : Remove Edge");
			System.out.println("3 : Print Graph");
			System.out.println("-1 : Exit");
			System.out.println("***************************************");
			System.out.println("***************************************");
			System.out.print("Select one of the above given options : ");
			
			input = sc.nextInt();
			
			if(input == 1){
				System.out.print("Give the src vertex : ");
				int src = sc.nextInt();
				System.out.print("Give the dest vertex : ");
				int dest = sc.nextInt();
				System.out.print("Give the edge weight: ");
				int weight = sc.nextInt();
				if(newGraph.directed){
					newGraph.addEdge(src, dest, weight);
				} else {
					newGraph.addEdge(src, dest, weight);
					newGraph.addEdge(dest, src, weight);
				}
			} else if(input == 2){
				System.out.print("Give the src vertex to be deleted : ");
				int src = sc.nextInt();
				System.out.print("Give the dest vertex to be deleted : ");
				int dest = sc.nextInt();
				if(newGraph.directed){
					newGraph.removeEdge(src, dest);
				} else {
					newGraph.removeEdge(src, dest);
					newGraph.removeEdge(dest, src);
				}
			} else if(input == 3){
				newGraph.printGraph();
			} else if(input == -1){
				return;
			} else {
				System.out.println("Please enter valid input");
			}
		}
	}
	
	
}

