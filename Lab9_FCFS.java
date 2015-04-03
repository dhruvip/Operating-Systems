
import  java.util.Scanner;

class FCFS{
        /*----------------------------------------
          | Process_no |Arrival Time|Service Time|     
          |     1      |     0      |     4      |
                                        ...*/
                                        
        private int[][] table;
        private int size;
        
        FCFS(int n){
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
                int tick=0;
                int que_index=0;
                int[] queue=new int[size];
                for(int i=0;i<=size;i++,tick++) //tick&queue
                {
                        for (int j=0;j<size;j++)//table
                        {
                                if(tick==table[j][1]){
                                        queue[que_index]=table[j][0];
                                        que_index++;
                                        
                                }                             
                        
                        }                
                }
                System.out.println("Waiting queue according to ids:");
                
                for(int i=0;i<size;i++)
                {
                        System.out.print(queue[i]+" ");
                
                }
                
                System.out.println("\nGraph: ");
                
                for(que_index=0;que_index<size;que_index++)
                {
                        for(int rep=0;rep<table[queue[que_index]-1][2];rep++)
                        {
                                System.out.print(queue[que_index]+" ");
                        }
                              System.out.println();        
                }
          }
        
        
        public static void main(String args[]){
                int n;
                Scanner in =new Scanner(System.in);
                System.out.println("Enter number of process:");
                n=in.nextInt();        
                FCFS t1 =new FCFS(n);
                t1.enter_table();
                t1.print_table();
                t1.proceed();
        
        
        }                            

}
