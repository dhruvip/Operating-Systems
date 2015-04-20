import  java.util.Scanner;
import java.util.*;

class EDF{
        /*------------------------------------------------------
          | Process_no |Arrival Time|Service Time| Deadline    |    
          |     1      |     0      |     4      |   33        |
                                        ...*/
                                        
        private int[][] table;
        private int size;
        
       EDF(int n){
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
                        System.out.println("enter the process Deadline time:");   
                        table[i][3]=input.nextInt();
                } 
        }        

        public void print_table(){
                for(int i=0;i<size;i++)
                {
                        System.out.println(table[i][0]+"   "+table[i][1]+"   "+table[i][2]+"	"+table[i][3]);
                
                }
        
        }

        public void proceed(){
        	int[] dummy=new int[size];
        	for(int k=0;k<size;k++){
                //arrival+deadline+id ...... service time
        		dummy[k]=(10000*table[k][1]+100*table[k][3]+ table[k][0])*100 + table[k][2];
        	}

        	Arrays.sort(dummy);
        	int sum=0;
                for(int j=0;j<size;j++){
                    //System.out.println(dummy[j]);
                    sum=sum+table[j][2];
                }
            int total_clock = dummy[0]/1000000 +  sum;
            int Cnt=0;
            int[] array = new int[total_clock];
            int ind_array=0;
            int[] queue=new int[size];
            int head=0;
            int tail=0;
            int index=0;
            int var=0;
            int a,d,s,id;
            while(Cnt<total_clock && index<size && ind_array<total_clock){

            		a=dummy[index]/1000000;
            		d=dummy[index]%1000000;
            		d=d/10000;
            		id=dummy[index]%10000;
            		s=id%100;
            		id=id/100;

            	if(index+1!=size){
            		if((dummy[index+1]/1000000)==Cnt && s>0){
            			//add to dueue and 
            			queue[tail]=dummy[index];
            			System.out.println("queue tail"+queue[tail]);
            			tail++;
            			index++;
            		}
            		else if((dummy[index+1]/1000000)>Cnt && s>0){
            			//add id to array
	            		array[ind_array]=id;
						System.out.println("array add"+array[ind_array]);
	            		dummy[index]--;
	            		ind_array++;

            		}
            		else if((dummy[index+1]/1000000)==Cnt && s==0){
						index++;
					}
					else if(s==0){
						if((queue[head]%1000000)/10000 < (dummy[index+1]%1000000)/10000){
							dummy[index]=queue[head];
							head++;
						}
						else{
							index++;
						}
					}
            	}
            	else{

            		while(dummy[index]%100!=0){
            		//System.out.println("hi i was not here");
            		var=dummy[index]%10000;
            		var=var/100;
            		array[ind_array]=var;
            		dummy[index]--;
            		Cnt++;}
            		
            	}
            	//System.out.println("hi i was out of here");
            	Cnt++;
            }  

            for(int k=0;k<array.length;k++){
            	System.out.print(array[k]+" ");
            }


        }



       public static void main(String args[]){
                int n;
                Scanner in =new Scanner(System.in);
                System.out.println("Enter number of process:");
                n=in.nextInt();        
                EDF t1 =new EDF(n);
                t1.enter_table();
                t1.print_table();
                System.out.println("Earliest Deadline FIrst!!");

                t1.proceed();
        
        
        }                         
        
}        

