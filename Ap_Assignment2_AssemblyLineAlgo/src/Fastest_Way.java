
public class Fastest_Way {
	int n;
	int exec[][];
    int transfer[][];
    int[] entry,exit;
   	int[] l1,l2,f1,f2;
   	int out[]=new int[2];
	
	Fastest_Way(){
		n=4;
		l1=new int[n];
		l2=new int[n];
		f1=new int[n];
		f2=new int[n];
		exec = new int[][]{{2, 1, 90, 4},
                {1,9,7,10}};
		transfer = new int[][]{{3,9,11},
                {7,6,2}};
		entry=new int[]{15,17};
		exit=new int[]{50,100};
		f1[0]=entry[0]+exec[0][0];
		f2[0]=entry[1]+exec[1][0];
	}
	public static void main(String[] args){
		
		Fastest_Way temp=new Fastest_Way();
		for (int j=1;j<4;j++){
			temp.fastest_way(j);
		}
		temp.result();
	}
	public void result(){
		if(f1[3]+exit[0]<=f2[3]+exit[1]){
			out[0]=f1[3]+exit[0];
			out[1]=1;
		}
		else{
			out[0]=f2[3]+exit[1];
			out[1]=2;
		}
		System.out.println(out[0]+" "+out[1]);
	}
	public  void fastest_way(int j){
			if(f1[j-1]+exec[0][j]<=f2[j-1]+exec[0][j]+transfer[1][j-1]){
				f1[j]=f1[j-1]+exec[0][j];
				l1[j]=1;
			}
			else{
				f1[j]=f2[j-1]+exec[0][j]+transfer[1][j-1];
				l1[j]=2;
			}
			if(f2[j-1]+exec[1][j]<=f1[j-1]+exec[1][j]+transfer[0][j-1]){
				f2[j]=f2[j-1]+exec[1][j];
				l2[j]=2;
			}
			else{
				f2[j]=f1[j-1]+exec[1][j]+transfer[0][j-1];
				l2[j]=1;
			}
	}
}
