import java.util.Scanner;

class Heap{
	int heapSize;
	int capacity;
	int[] minHeap;
	
	public Heap(int x){
		heapSize = -1;
		capacity = x;
		minHeap = new int[capacity]; 
	}
	
	public int getMin(){
		if(heapSize == -1){
			System.out.println("Heap is empty");
			return -1;
		} else {
			return minHeap[0];
		}
	}
	
	public void heapifyUp(int index){
		int parent = 0;
		parent = (index - 1) / 2;
		while((minHeap[parent] > minHeap[index]) && (index >= 0)) {
			int tmp;
			tmp = minHeap[index];
			minHeap[index] = minHeap[parent];
			minHeap[parent] = tmp;
			index = parent;
			parent = (index - 1) / 2;
		}
	}
	
	public boolean insert(int x){
		if(heapSize == capacity - 1){
			System.out.println("Heap full");
			return false;
		} else {
			heapSize = heapSize + 1;
			minHeap[heapSize] = x;
			heapifyUp(heapSize);
			return true;
		}
	}
	
	public void printHeap(){
		int i = 0;
		for(i = 0; i <= heapSize; i++){
			System.out.print(" "+ minHeap[i]);
		}
	}
	
	public void delete(int index){
		minHeap[index] = minHeap[heapSize];
		heapSize--;
		int parent = (index - 1)/2;
		if(minHeap[index] < minHeap[parent]){
			heapifyUp(index);
		} else {
			heapifyDown(index);
		}
	}
	
	public void heapifyDown(int index){
		int ch1, ch2;
		while(2*index + 1 <= heapSize){
			ch1 = 2*index + 1;
			ch2 = 2*index + 2;
			if(ch2 <= heapSize){
				if((minHeap[index] < minHeap[ch1]) && (minHeap[index] < minHeap[ch2])){
					break;
				} else {
					if(minHeap[ch1] < minHeap[ch2]){
						int tmp;
						tmp = minHeap[ch1];
						minHeap[ch1] = minHeap[index];
						minHeap[index] = tmp;
						index = ch1;
					} else {
						int tmp;
						tmp = minHeap[ch2];
						minHeap[ch2] = minHeap[index];
						minHeap[index] = tmp;
						index = ch2;
					}
				}
			} else {
				if(minHeap[index] < minHeap[ch1]){
					break;
				} else {
					int tmp;
					tmp = minHeap[ch1];
					minHeap[ch1] = minHeap[index];
					minHeap[index] = tmp;
					index = ch1;
				}
			}
		}
	}
	
	public int extractMin(){
		int x = this.getMin();
		this.delete(0);
		return x;
	}
	
	public void decreaseKey(int index, int key){
		if(minHeap[index] < key){
			System.out.println("Cannot perform decrease key :: The key given is larger that the present value of the key.");
		} else if (minHeap[index] > key) {
			int parent;
			minHeap[index] = key;
			parent = (index - 1)/2;
			if(minHeap[index] < minHeap[parent]){
				heapifyUp(index);
			} else {
				heapifyDown(index);
			}
		} else {
			System.out.println("Cannot perform decrease key :: The key given is equal to the present value of the key.");
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int input;
		Heap newHeap = new Heap(100); 
		System.out.println(newHeap.capacity);
		while(true){
			System.out.println();
			System.out.println("***************************************");
			System.out.println("***************************************");
			System.out.println("1 : Insert");
			System.out.println("2 : Delete");
			System.out.println("3 : Get Min");
			System.out.println("4 : Extact Min");
			System.out.println("5 : Decrease Key");
			System.out.println("6 : Print Heap");
			System.out.println("-1 : Exit");
			System.out.println("***************************************");
			System.out.println("***************************************");
			System.out.print("Select one of the above given options : ");
			
			input = sc.nextInt();
			
			if(input == 1){
				System.out.print("Give the key to be inserted : ");
				int x = sc.nextInt();
				newHeap.insert(x);
			} else if(input == 2){
				System.out.print("Give the key to be deleted : ");
				int x = sc.nextInt();
				newHeap.delete(x);
			} else if(input == 3){
				System.out.println("The minimum element is : "+ newHeap.getMin());
			} else if(input == 4){
				System.out.println("The minimum element is : "+ newHeap.extractMin());
			} else if(input == 5){
				System.out.print("Give the index : ");
				int index = sc.nextInt();
				System.out.print("Give the key value : ");
				int key = sc.nextInt();
				newHeap.decreaseKey(index, key);
			} else if(input == 6){
				newHeap.printHeap();
			} else if(input == -1){
				break;
			}else {
				System.out.println("Please eneter valid input");
			}
		}
	}
}