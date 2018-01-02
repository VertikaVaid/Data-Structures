class Stack{
	int maxSize;
	int top;
	int[] myStack = new int[1000];
	
	Stack(int size){
		maxSize = size;
		top = -1;
	}
	
	public void push(int x){
		if(top < maxSize) {
			top = top + 1;
			myStack[top] = x;
		} else {
			System.out.println("Stack overflow");
		}
	}
	
	public int pop(){
		if(top == -1){
			System.out.println("Stack underflow");
			return -1;
		} else {
			int x = myStack[top];
			top = top - 1;
			return x;
		}
	}
	
	boolean isEmpty(){
		if(top == -1){
			return true;
		} else {
			return false;
		}
	}
		
	public static void main(String[] args){
		Stack stack1 = new Stack(10);
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		
	}
}