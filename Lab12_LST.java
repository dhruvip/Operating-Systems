import  java.util.Scanner;
import java.util.*;


class LST{
        /*----------------------------------------
          | Process_no |Arrival Time|Service Time|     
          |     1      |     0      |     4      |
                                        ...*/
                                        
        private int[][] table;
        private int size;
        
       LST(int n){
        size=n;
        table=new int[n][4];
        }
        
        public void enter_table(){
                Scanner input=new Scanner(System.in);
                System.out.println("Enter the processes in the ascending order of their arriving time");
                for(int i=0;i<size;i++)
                {
                        System.out.println("for process"+(i+1));   
                        table[i][0]=(i+1);
                        System.out.println("enter the process arrival time:");   
                        table[i][1]=input.nextInt();
                        System.out.println("enter the process service time:");   
                        table[i][2]=input.nextInt();
                        System.out.println("enter the process service time:");   
                        table[i][3]=input.nextInt();
                } 
        
        }
        
        public void print_table(){
                for(int i=0;i<size;i++)
                {
                        System.out.println(table[i][0]+"   "+table[i][1]+"   "+table[i][2]+"   "+table[i][3]);
                
                }
        
        }

        public void proceed(){
        	int[] dummy=new int[size];
        	for(int k=0;k<size;k++){
                //arrival+id+(deadline+servicetime)
        		dummy[k]=((10*table[k][1]+table[k][0])*100000 + 100*(table[k][3])+table[k][2]+table[k][3]);
        		System.out.println(dummy[k]);
        	}

        	Arrays.sort();

        }

        public static void main(String args[]){
                int n;
                Scanner in =new Scanner(System.in);
                System.out.println("Enter number of process:");
                n=in.nextInt();        
                LST t1 =new LST(n);
                t1.enter_table();
                t1.print_table();
                System.out.println("Least SLack Time!!");

                t1.proceed();
        		t1.print_table();
        
        }         

}