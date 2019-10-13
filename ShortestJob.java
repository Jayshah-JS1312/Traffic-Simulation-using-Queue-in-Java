package Model;
public class ShortestJob {

	public ShortestJob() {	
	}

	int shortest[] = new int[4];
	///////////IN THIS METHOD THE ARGUMENTS ARE LENGTH(FRONT - REAR) OF EVERY SIDE  
	public static int[] CheckShortestJob(int l1, int l2, int l3, int l4){
		int shortest[] = new int[4];
		if(l1 != 0) {
			if(l2 / l1 > 4)
				shortest[0] = 1;
			else if(l3 / l1 > 4)
				shortest[0] = 1;
			else if(l4 / l1 > 4)
				shortest[0] = 1;
			else
				shortest[0] = -1;
		}
		if(l2 != 0) {
			if(l1 / l2 > 4)
				shortest[1] = 2;
			else if(l3 / l2 > 4)
				shortest[1] = 2;
			else if(l4 / l2 > 4)
				shortest[1] = 2;
			else
				shortest[1] = -1;
		}
		if(l3 !=0) {
			if(l1 / l3 > 4)
				shortest[2] = 3;
			else if(l2 / l3 > 4)
				shortest[2] = 3;
			else if(l4 / l3 > 4)
				shortest[2] = 3;
			else
				shortest[2] = -1;
		}	
		if(l4 != 0) {
			if(l1 / l4 > 4)
				shortest[3] = 4;
			else if(l3 / l4 > 4)
				shortest[3] = 4;
			else if(l2 / l4 > 4)
				shortest[3] = 4;
			else
				shortest[3] = -1;
		}
		else
			for(int i=0;i<4;i++)
			{
				shortest[i] = -1;
			}
		return shortest;
		
		
	}


public static int Maximum(int a,int b,int c,int d) {
	int max = 0;
	if(a>=b && a>=c && a>=d)
		max= a;
	else if(b>=a && b>=c && b>=d)
		max =b;
	else if(c>=b && c>=a && c>=d)
		max =c;
	else if(d>=b && d>=c && d>=a)
		max =d;
	//System.out.println(max);
	return max;		
	
}

public static int Minimum(int a,int b,int c,int d) {
	int min = 0;
	if(a<=b && a<=c && a<=d)
		min= a;
	else if(b<=a && b<=c && b<=d)
		min =b;
	else if(c<=b && c<=a && c<=d)
		min =c;
	else if(d<=b && d<=c && d<=a)
		min =d;
	return min;		
}
}

