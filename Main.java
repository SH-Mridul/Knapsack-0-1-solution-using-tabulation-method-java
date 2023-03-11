package knapsackZeroOne;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter n value:");
		int n = input.nextInt();
		System.out.print("Enter weight value:");
		int wt = input.nextInt();
		
		int w[] = new int[n];
		int p[] = new int[n];
		System.out.println("-----------------------------getting input---------------------------------------");
		for(int i = 0; i<n; i++)
		{
			System.out.print("Enter weight for "+(i+1)+":");
			w[i] = input.nextInt();
			
			System.out.print("Enter profit for "+w[i]+":");
			p[i] = input.nextInt();
		}
		
		System.out.println("-----------------------------end---------------------------------------");
		
		
		var ans = findBestknapsackItem(p,w,wt,n);
		System.out.println("set:"+Arrays.toString(ans));
		
		input.close();
	}
	
	
	public static int[] findBestknapsackItem(int[] p,int[] w,int wt,int n)
	{
		//declare 2d array where row n+1 and column wt+1
		int k[][] = new int[n+1][wt+1];
		
		for(int i = 0; i<=n; i++)
		{
			for(int j = 0; j<=wt; j++)
			{
				if(i == 0 || j == 0) {
					k[i][j] = 0;
				}else if(w[i-1]<=j)
				{
					k[i][j] = Math.max(k[i-1][j],k[i-1][j-w[i-1]]+p[i-1]);
				}else {
					k[i][j] = k[i-1][j];
				}
			}
		}
		
		System.out.println("------------------------------calculation----------------------------------------");
		for(int i = 0; i<=n; i++)
		{
			System.out.println(Arrays.toString(k[i]));
		}
		System.out.println("------------------------------end----------------------------------------");
		
		int[] set = new int[n];
		
		int row = n;
		int weight = wt;
		
		while(row>-1 && weight > 0)
		{
			if(k[row][weight] == k[row-1][weight])
			{
				set[row-1] = 0;
			}else {
				set[row-1] = 1;
				weight = weight-w[row-1];
			}
			
			row--;
			
		}
		
		
		return set;
	}
}
