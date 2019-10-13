package Controller;
import java.util.Scanner;

import Model.ShortestJobBased;
import Model.TimerBased;
import Model.VehicleBased;
import Model.ShortestJobBased;
	class main
	{
		public static void main(String args[])
		{
			Scanner inp =new Scanner(System.in);
			int choice = 0;
			VehicleBased obj1 = new VehicleBased();
			TimerBased obj2 = new TimerBased();
			ShortestJobBased  obj3 = new ShortestJobBased();
				System.out.println("1.)Vehicle Based.");
				System.out.println("2.)Time Based.");
				System.out.println("3.)Shortest Job.");
				System.out.println("4.)Exit.");
				System.out.println("Enter your choice.");
				choice  = inp.nextInt();
				switch(choice){
					case 1:
					obj1.Inputvehicles();
					break;
					case 2:
					obj2.Inputvehicles();
					break;
					case 3:
					obj3.InputVehciles();	
					break;
				}
			
		}
		
		
	}
			

