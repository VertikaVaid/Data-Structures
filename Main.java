import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class LinkedList {
	Node head;
	
	static class Node{
		int data;
		Node next;
		
		//constructor
		Node(int x) {
			data = x;
		}
	}
	
	public void InsertNode(Node x){
		Node p = this.head;
		if (p == null) {
			this.head = x;
		} else {
			while (p.next != null) {
				p = p.next;
			}
			p.next = x;
		}
	}
	
	public void Delete(int x){
		if(this.head.data == x){
			this.head = this.head.next;
		} else {
			Node p = this.head;
			Node previous = p;
			while(p != null){
				if(p.data == x){
					previous.next = p.next;
					break;
				} else {
					previous = p;
					p = p.next;
				}
			}
			if(p == null){
				System.out.println("Node not found");
			}
		}
	}
	
    public Node ReverseList(Node head) {
        Node a1;
        Node a2;
        Node a3;
        
        a1 = head;
        a2 = head.next;
        a3 = head.next.next;
		a1.next = null;
        
        while(a3 != null){
            a2.next = a1;
            a1 = a2;
            a2 = a3;
            a3 = a3.next;
        }
        a2.next = a1;
        head = a2;
		return head;
    }
}
	
class Main{	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		LinkedList list1 = new LinkedList();
		System.out.println("Give the inputs to the linkedlist/ to exit press -1");
		int n = Integer.parseInt(br.readLine());
		
		while(n != -1){
			LinkedList.Node new_node = new LinkedList.Node(n);
			list1.InsertNode(new_node);
			n = Integer.parseInt(br.readLine());
		}
		
		LinkedList.Node p = list1.head;
		while(p !=  null){
			System.out.print("-->" + p.data);
			p = p.next;
		}
		System.out.println();
		
		System.out.println("Give the node to be deleted");
		int k = Integer.parseInt(br.readLine());
		list1.Delete(k);
		
		p = list1.head;
		while(p !=  null){
			System.out.print("-->"+ p.data);
			p = p.next;
		}
		
		p = list1.ReverseList(list1.head);
		System.out.println("Reversed linked list");
		while(p !=  null){
			System.out.print("-->"+ p.data);
			p = p.next;
		}
	}
}

