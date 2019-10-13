package Model;

import java.lang.Exception;
public class Queue {

	int[] queue;
	int front,rear;
	
	public Queue(int n) {
		queue = new int[n];
		front = rear = -1;
	}
	
	public void fillQueue(int n) {
		
		if(n < queue.length) {
			for(int i = 0;i < queue.length;i++) {
				enqueue(i+1);
			}
		}
	}
	
	public void display(int totalTime) {
		
		for(int i = 0; i <= front;i++){
			System.out.print(queue[i] + " ");
		}
		System.out.print("\t\t\tTotalTime: " + totalTime);
		System.out.println();
	}
	
	public void display() {
		
		for(int i = 0; i <= front;i++){
			System.out.print(queue[i] + " ");
		}
		System.out.println();
	}
	public boolean AddEmergency(int index) {
		if(index <= queue.length) {
			queue[index] = 0;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean enqueue(int n){
		
		
		if(this.Isfull() == false){
			
			front++;
			queue[front] = n;
			return true;
		}
		else
			return false;
	}
	
	public int dequeue(){
	
		if(this.isEmpty() == false) {
			rear++;
			int data = queue[rear];
			queue[rear] = -1;
			return data;	
		}
		else
			return Integer.MIN_VALUE;
		}
	
	
	public boolean Isfull() {
		if(front < queue.length)
			return false;
		else 
			return true;
	}
	
	public boolean isEmpty() {
		if(rear < queue.length && rear <= front)
			return false;
		else
			return true;
	}
	public int SearchEmergency() 
	{
		for(int i = 0; i <= front;i++) 
		{
			if(queue[i] == 0)
				return i;
		}
		return -1;
	}
	
	public int[] getQueue() {
		return queue;
	}

	public int getFront() {
		return front;
	}

	public int getRear() {
		return rear;
	}
	
	public int VehiclesLeft() {
		return front - rear;
	}
	
	public void Deleteall() {
		while(front!=rear) {
			if(this.isEmpty() == false) {
				rear++;
				queue[rear] = -1;
				for(int i = 0; i <= front;i++){
					System.out.print(queue[i] + " ");
				}
				System.out.println();
			
			}
		}
		
		
	}

}