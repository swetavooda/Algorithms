import java.util.Scanner;

public class JumpSearch
{
	public static int jumpSearch(int[] arr,int x)
	{
		int n=arr.length;

		//finding block size to jump 
		int block = (int)(Math.sqrt(n));

		//step stores current step begining
		int step = block;
			
		//store current position
		int prev=0;
		
		//to find the block where the element could be present
		while(arr[Math.min(step,n)-1]<x)
		{
			prev=step;
			step+=block;

			//if previous also greater then element doesnt exist
			if(prev>=n)
				return -1;		
		}

		//performing linear search
		while(arr[prev]<x && prev<step)
		{
			prev++;
			if(arr[prev]==x)
				return prev;
		}
		return -1;
	}
	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		int n;
		n=sc.nextInt();
		//for example take input of integers array which is sorted.
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		//element to search
		int k;
		k=sc.nextInt();
	
		int pos = jumpSearch(arr,k);

		if(pos!=-1)
			System.out.println("\nNumber " +                            " is at index " + pos); 
		else
		
			System.out.println("Number not found");
	}
}