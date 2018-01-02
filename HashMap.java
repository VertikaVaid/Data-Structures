import java.util.Scanner;
import java.util.ArrayList;

class HashNode<K, V>{
	K key;
	V value;
	HashNode<K, V> next;
	
	public HashNode(K key, V value){
		this.key = key;
		this.value = value;
		this.next = null;
	}
}

class HashMap<K, V>{
	
	int size;
	int numberOfBuckets;
	ArrayList<HashNode<K, V>> buckets;
	
	public HashMap(int x){
		size = 0;
		numberOfBuckets = x;
		buckets = new ArrayList<HashNode<K, V>>(numberOfBuckets); 
		
		int i = 0;
		for(i = 0; i < numberOfBuckets; i++){
			buckets.add(null);
		}
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
	public int getIndex(K key){
		int index = key.hashCode();
		index = index % numberOfBuckets;
		return index;
	}

	public void add(K key, V value){
		int index = getIndex(key);
		HashNode<K, V>  head = buckets.get(index);
		while(head != null){
			if(head.key.equals(key)){
				head.value = value;
				return;
			} else {
				head = head.next;
			}
		}
		if(head == null){
			size++;
			HashNode<K, V> newNode = new HashNode<K, V>(key, value);
			head = buckets.get(index);
			buckets.set(index, newNode);
			newNode.next = head;
		}
	}
	
	public V getValue(K key){
		int index = getIndex(key);
		HashNode<K, V> head = buckets.get(index);
		while(head != null){
			if(head.key.equals(key)){
				return head.value;
			} else {
				head = head.next;
			}
		}
		if(head == null){
			System.out.println("Key not found");
		}
		return null;
	}
	
	public void removeKey(K key){
		int index = getIndex(key);
		HashNode<K, V> head = buckets.get(index);
		HashNode<K, V> history = null;
		while(head != null){
			if(head.key.equals(key)){
				size--;
				if(history == null){
					HashNode<K, V> tmp = buckets.get(index);
					buckets.set(index, tmp.next);
					return;
				} else {
					history.next = head.next;
				}
			} else {
				history = head;
				head = head.next;
				return;
			}
		}
		if(head == null){
			System.out.println("Key not found");
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int maxBuckets, input;
		System.out.println("Five the number of buckets needed");
		maxBuckets = sc.nextInt();
		HashMap<String, Long> phoneDirectory = new HashMap<String, Long>(maxBuckets);
		
		while(true){
			System.out.println();
			System.out.println("***************************************");
			System.out.println("***************************************");
			System.out.println("1 : Add key value pair");
			System.out.println("2 : Remove key");
			System.out.println("3 : Get value");
			System.out.println("4 : Get Size");
			System.out.println("5 : Is Empty");
			System.out.println("-1 : Exit");
			System.out.println("***************************************");
			System.out.println("***************************************");
			System.out.print("Select one of the above given options : ");
			
			input = sc.nextInt();
			
			if(input == 1){
				System.out.print("Give the name : ");
				String key = sc.next();
				System.out.print("Give the Phone number : ");
				long value = sc.nextLong();
				phoneDirectory.add(key, value);
			} else if(input == 2) {
				System.out.print("Give the name to be deleted : ");
				String key = sc.next();
				phoneDirectory.removeKey(key);
			} else if(input == 3) {
				System.out.print("Give the name to get the Phone number : ");
				String key = sc.next();
				System.out.println("The phone number for "+ key + " is : " + phoneDirectory.getValue(key));
			} else if(input == 4) {
				System.out.print("The size of the hashMap is : " + phoneDirectory.getSize());
			} else if(input == 5) {
				System.out.print("The the hashMap Empty : " + phoneDirectory.isEmpty());
			} else if(input == 6) {
				
			} else if(input == -1) {
				return;
			}else {
				System.out.print("Please enter a valid input. ");
			}
		}
	}
	

}
