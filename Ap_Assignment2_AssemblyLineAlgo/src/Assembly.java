
public class Assembly {
	public int f;
	public int l;

	
	public void FastestWay( int a[][], int t[][], int e[], int x[], int n)
	{
		int[] l1= new int[n];
		int[] l2= new int[n];
		int[] f1 = new int[n];
		int[] f2 = new int[n];
		
		
		f1[0]= e[0] + a[0][0];
		f2[0]= e[1] + a[1][0];
		
		for(int j=1; j<n; j++)
		{
		
			if(f1[j-1] + a[0][j] <= f2[j-1] + t[1][j-1] + a[0][j])
			{
				f1[j]= f1[j-1] + a[0][j];
			
				l1[j]=1;
			}
			else
			{
				f1[j]= f2[j-1] + t[1][j-1] + a[0][j];
				l1[j]=2;
			}
			
			if(f2[j-1] + a[1][j] <= f1[j-1] + t[0][j-1] + a[1][j])
			{
					f2[j] = f2[j-1]+a[1][j];
					l2[j] = 2;

			}
			
			else 
			{
				f2[j] = f1[j-1] + t[0][j-1] + a[1][j];
				l2[j] =1;
			}
			
		  
		   
		}
		
		 if (f1[n-1] + x[0] <= f2[n-1] + x[1])
			{ 
				f = f1[n-1] + x[0];
				l = 1;
			}
			else
			{
				
				f = f2[n-1] + x[1];
				l = 2;
			}
		
		
	}

	
	public static void main(String[] args) {
		Assembly A = new Assembly();
		 int e[] = {15, 17};
		    int x[] = {5, 10};
		int n= 4;
		 int a[][] = {{2, 9, 8, 1},
	                {1, 1, 7, 10}};
	    int t[][] = {{0, 3, 9, 11},
	                {0, 7, 6, 2}};
	   
	    
	   A.FastestWay(a, t, e, x, n);
	    System.out.println(A.f);
	    System.out.println(A.l);


	}

}
