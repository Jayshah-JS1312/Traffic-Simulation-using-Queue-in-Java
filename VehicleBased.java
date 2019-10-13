package Model;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class VehicleBased {
	Queue[] queue;
	Scanner inp = new Scanner(System.in);
	Timer t = new Timer("timer");
	int limit,kj,k1;
	int totaltime;
	
	public void Inputvehicles()
	{
		
		System.out.println("Enter number of sides.");	
		int n=inp.nextInt();
		queue = new Queue[n];
		System.out.println("Enter limit of vehicles to be dequeued in one turn.");	
		limit=inp.nextInt();
		
		
		for(int i=0;i<n;i++){			
			System.out.println("Enter Number of Vehicles in Side :" + (i+1));
			int m=inp.nextInt();
			queue[i] = new Queue(m);
			queue[i].fillQueue(m - 1);
			queue[i].display();
		}
		
		System.out.println("Do you want to add emergency vehicle?(YES OR NO)");
		int y=inp.nextInt();			
		if(y==1) {
			System.out.println("Write 1 for Emergency vehicle and for 0 no addition of Emergency vehicle(space seperated)");
			for(int i=0;i<n;i++){
				int k = inp.nextInt();
				if(k==1)
					queue[i].AddEmergency(queue[i].VehiclesLeft() - 1);
					queue[i].display();
			}
		}
		this.TimerStart();
	
	}
	
	public void TimerStart() {
		t.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
            	try{
                	Thread.sleep(2000);
                	totaltime = 0;
				for(int j=0;j<queue.length;j++)
				{
					int temp=queue[j].SearchEmergency(); 
					if(temp != -1)
					{
						kj = j+1;
						System.out.println("Queue"+ kj + ":" + queue[j].VehiclesLeft());
						temp = queue[j].VehiclesLeft();
						for(int i = 0; i < temp;i++) {
							Thread.sleep(1000);
							totaltime++;
							queue[j].dequeue();
							queue[j].display(totaltime);
						}
					}
				}
				
				while(queue[0].VehiclesLeft() != 0 || queue[1].VehiclesLeft() != 0 || queue[2].VehiclesLeft() != 0 || queue[3].VehiclesLeft() != 0) {
					for(int i = 0; i < queue.length;i++) {
						k1 = i+1;
						System.out.println("Queue"+ k1 + ":" + queue[i].VehiclesLeft());
						if(queue[i].VehiclesLeft()<limit) 
						{
							
						for(int j = 0; j < queue[i].VehiclesLeft(); j++) {
							Thread.sleep(1000);
							totaltime  += queue[i].VehiclesLeft();
							queue[i].Deleteall();
							System.out.println("\t\t\t\t\tTotalTime: " + totaltime);
						}
						}
						else if(queue[i].VehiclesLeft()>=limit) 
						{
						for(int j = 0; j < limit; j++) {
							Thread.sleep(1000);
							totaltime++;
							queue[i].dequeue();
							queue[i].display(totaltime);
							
						}
						}
					}
				}
				t.cancel();
				
            	}
            	catch(Exception e){
                try {
					throw e;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
            }
		}, 0, 4000);
	}
		
}
