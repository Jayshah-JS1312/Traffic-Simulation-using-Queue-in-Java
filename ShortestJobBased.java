package Model;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class ShortestJobBased
{
	Queue[] queue;
	int limit;
	int k1,kj;
	int n;
	Timer t = new Timer("timer");
	int totaltime;
	
	public void InputVehciles()
	{
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter number of sides.");	
		n=inp.nextInt();
		queue = new Queue[n];
		System.out.println("Enter limit of vehicles to be dequeued in one turn.");	
		this.limit=inp.nextInt();
		int[] temp=new int[4] ;
		

		// Taking the input of vehicles.......
		for(int i=0;i<n;i++)
		{			
			System.out.println("Enter Number of Vehicles in Side :" + (i+1));
			int m=inp.nextInt();
			queue[i] = new Queue(m);
			queue[i].fillQueue(m - 1);
			queue[i].display();
		}

		System.out.println("Do you want to add emergency vehicle?(1 for YES & 0 for NO)");
		int y=inp.nextInt();			
		if(y==1) 
		{
			System.out.println("Write 1 for Emergency vehicle and 0 for no addition of Emergency vehicle(space seperated)");
			for(int i=0;i<n;i++)
			{
				int k = inp.nextInt();
				if(k==1)
				{
					queue[i].AddEmergency(queue[i].VehiclesLeft() - 1);
				}
					queue[i].display();
			}
		}
		
		TimerStart();
		
	}
		public void TimerStart() {
			t.scheduleAtFixedRate(new TimerTask(){
	            @Override
	            public void run() {
	            	try {
	            	int counter = 0;
	            	while(queue[0].VehiclesLeft() != 0 || queue[1].VehiclesLeft() != 0 || queue[2].VehiclesLeft() != 0 || queue[3].VehiclesLeft() != 0)
	        		{
	        		
	        			int[] shortest = ShortestJob.CheckShortestJob(queue[0].VehiclesLeft(),queue[1].VehiclesLeft(),queue[2].VehiclesLeft(),queue[3].VehiclesLeft());
	        					
	        			if(shortest[0] != -1 && shortest[1] != -1 && shortest[2] != -1 && shortest[3] != -1 ) {
	        				System.out.println("Shortest Job Exists");
	        				
	        				for(int j=0;j<n;j++)
	        				{
	        					int temp1=queue[j].SearchEmergency(); 
	        					kj = j+1;
	        					if(temp1 != -1)
	        					{
	        						System.out.println("Queue"+ kj + ":" + queue[j].VehiclesLeft());
	        						temp1 = queue[j].VehiclesLeft();
	        						for(int i = 0; i < temp1;i++) {
	        							Thread.sleep(1000);
	        							queue[j].dequeue();
	        							totaltime++;
	        							queue[j].display(totaltime);
	        						}
	        					}
	        				}

	        				for(int i = 0;i<4;i++) {
	        					if(shortest[i]!=-1)
	        						counter += 1;
	        					}
	        					int[] Minimum = new int[counter];	
	        					
	        				for(int i = 0;i<counter;i++) {
	        						if(shortest[i]!=-1) {
	        							Minimum[i] = shortest[i];
	        						}
	        					}
	        				int Min = ShortestJob.Minimum(shortest[0],shortest[1],shortest[2],shortest[3]);
	        				
	        				for(int i=0;i < counter;i++) {	
	        					k1 = i+1;
	        					if(queue[Min].VehiclesLeft() < limit ) {			
	        						System.out.println("Queue"+ k1 + ":" + queue[i].VehiclesLeft());
	        						totaltime += queue[Min].VehiclesLeft();
        							Thread.sleep(1000);
	        						queue[Minimum[i]].Deleteall();					
	        						
	        					}	
	        				}
	        			}
	        			
	        			else
	        			{
	        				for(int j=0;j<n;j++)
	        				{
	        					int temp1=queue[j].SearchEmergency(); 
	        					kj=j+1;
	        					
	        					if(temp1 != -1)
	        					{
	        						System.out.println("Queue"+ kj + ":" + queue[j].VehiclesLeft());
	        						temp1 = queue[j].VehiclesLeft();
	        						for(int i = 0; i < temp1;i++) {
	        							totaltime++;
	        							Thread.sleep(1000);
	        							queue[j].dequeue();
	        							queue[j].display(totaltime);
	        						}
	        					}
	        				}
	        				while(queue[0].VehiclesLeft() != 0 || queue[1].VehiclesLeft() != 0 || queue[2].VehiclesLeft() != 0 || queue[3].VehiclesLeft() != 0) {
	        					for(int i = 0; i < n;i++) {
	        						k1 = i+1;
	        						if(queue[i].VehiclesLeft()<limit) 
	        						{
	        							System.out.println("Queue"+ k1 + ":" + queue[i].VehiclesLeft());
	        						for(int j = 0; j < queue[i].VehiclesLeft(); ++j) {
	        							totaltime += queue[i].VehiclesLeft();
	        							Thread.sleep(1000);
	        							queue[i].Deleteall();
	        							System.out.println("\t\t\t\t\tTotalTime: " + totaltime);
	        						
	        						}
	        						}
	        						else if(queue[i].VehiclesLeft()>=limit) 
	        						{
	        							System.out.println("Queue"+ k1 + ":" + queue[i].VehiclesLeft());
	        						for(int j = 0; j < limit; j++) {
	        							totaltime++;
	        							Thread.sleep(1000);
	        							queue[i].dequeue();
	        							queue[i].display(totaltime);
	        						}
	        						}
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