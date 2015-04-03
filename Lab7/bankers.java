import java.io.*;
import java.util.Scanner;


//enter claim and current matrix
class bankers{

	private static int  claim[][],current[][],resource[],need[][],avail[];
	private static int stack[],stack_index=0;
	private static int max_resource=0;
	public static void main(String args[])
	{
		initialize(4);
		input();
		check(); //we got stack of potential process
		process(); //select oone and move forward
		
	}
	
	public static void check()
	{
		int flag=0;
		int flag1=0;
		stack_index=0;
		//check corresponding col of each row of need mat with avail vector
		for(int i=0;i<4;i++)
		{	
			flag=0;
			for(int j=0;j<4;j++)
			{
				if(need[i][j]<=avail[j])
				{	flag1=1;
					continue;
				}
				else
				{
					flag=1;
					break;
				}
			}
			if(flag!=1 && flag1==1)
			{
				stack[stack_index]=i;
				stack_index++;
			}
			if(flag1==0)
			{
				return;
			}
		
		}	
	
	}
	
	public static void process()
	{
		//select one based on the process with max sum
		int temp[][] =new int[4][2];//col 1-index;col 2-sum 
		int sum;
		//initialize temp to 0
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<2;j++)
			{
				temp[i][j]=0;
			}
		}
		for(int i=0;i<4;i++)
		{
			sum=0;
			for(int j=0;j<4;j++)
			{
				sum=need[stack[i]][j]+sum;
				
			}
			temp[i][1]=stack[i];
			temp[i][2]=sum;
		}
	
		int temp_max=0,max_index=0;
		for(int i=0;i<4;i++)
		{
			if(temp[i][2]>=temp_max)
			max_index=temp[i][1];
				
		}
		System.out.println("P"+(max_index+1));
		for(int i=0;i<4;i++)
		{
			avail[i]=(avail[i]-need[max_index][i])+claim[max_index][i];
			need[max_index][i]=max_resource;
		}
		
		check();
	}

	
	
	public static void initialize(int n)
	{
		claim = new int[n][n];
		current=new int[n][n];
		resource=new int[n];
		need=new int[n][n];
		avail=new int[n];
		stack=new int[n];
	}
	
	public static void input()
	{
		Scanner sc = new Scanner(System.in);
		//enter claim matrix
		System.out.println("Enter the claim mat.; cloumn wise:");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				claim[i][j]=sc.nextInt();	
			}
		}
		//calculating avilable vector
		System.out.println("resource vector:");
			for(int j=0;j<4;j++)
			{
				resource[j]=claim[j][0]+claim[j][1]+claim[j][2]+claim[j][3];
				System.out.print(resource[j]);
				if(resource[j]>=max_resource)
				{
					max_resource=resource[j];
				}
			}
		//enter current matrix
		System.out.println("\nEnter the current mat.; cloumn wise:");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				current[i][j]=sc.nextInt();	
			}
		}
		//calculating need matrix
		System.out.println("Need matrix");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				need[i][j]=claim[i][j]-current[i][j];	
				System.out.print(need[i][j]+" ");
			}
			System.out.println();
		}
		// enter available resources
		System.out.println("enter vailable vector:");
		for(int i=0;i<4;i++)
		{
			avail[i]=sc.nextInt();	
		
		}		
		
	
	
	
	}

}
