import  java.util.Scanner;
import java.util.*;


class SJN{
        /*----------------------------------------
          | Process_no |Arrival Time|Service Time|     
          |     1      |     0      |     4      |
                                        ...*/
                                        
        private int[][] table;
        private int size;
        
       SJN(int n){
        size=n;
        table=new int[n][3];
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
                } 
        
        }
        
        public void print_table(){
                for(int i=0;i<size;i++)
                {
                        System.out.println(table[i][0]+"   "+table[i][1]+"   "+table[i][2]);
                
                }
        
        }

        public void proceed(){
        	int[] dummy=new int[size];
        	for(int k=0;k<size;k++){
                //arrival+ service+id
        		dummy[k]=100*table[k][1]+10*table[k][2]+table[k][0];
        	}

        	Arrays.sort(dummy);
            int a,s,i;
        	for(int l=0;l<size;l++){
                a =dummy[l]/100;
                dummy[l]=dummy[l]%100;
                s =dummy[l]/10;
                dummy[l]=dummy[l]%10;
                i=dummy[l];

                for(int j=0;j<s;j++){
                    System.out.print(i+ " ");
                }
                System.out.println();
        	}
        }
 
        
       
        
        public static void main(String args[]){
                int n;
                Scanner in =new Scanner(System.in);
                System.out.println("Enter number of process:");
                n=in.nextInt();        
                SJN t1 =new SJN(n);
                t1.enter_table();
                t1.print_table();
                System.out.println("Shortest job next!!");

                t1.proceed();
        
        
        } 
}                                           