//Producer Consumer with infinte buffer
interface sharedConst{
int PRODUCER =30;
int CONSUMER =20;
}



class buffer 
{
	private int buff_cap;
	private int empty; //if empty ; then empty =1
	//private boolean full; //if full;then full=1
	
	//constructor
	public buffer()
	{	
		//if buffer capacity is 0;then empty
		empty=1;
		//full=0;
		buff_cap=0;
	}
	
	//private method
	private int get_buff()
	{
		return buff_cap;
	}
	private void set_buff(int x)
	{
		buff_cap=buff_cap+x;
	}
	
	private int get_empty() //empty hase to 1 hase
	{
		return empty;
	}
	
	private int set_empty(int x)
	{
		if(x==0)
		{
			empty=0;
		}
		else if(x==1)
		{
			empty=1;
		}		
		return 1;
	}
	
	//public synchronized methods
	
	public synchronized int add(int amt)
	{
		
		set_buff(get_buff() + amt);
		
		if(get_empty()==1)
		{
			set_empty(0);
		}
		return 1;
	}
	public synchronized int eat(int amt)
	{
		int i;
		
		for(i=amt;amt<0;amt--)
		{
			if(get_empty()==0)
			{	
			
					set_buff(get_buff()-1);
					if(get_buff()==0) //have buffer empty che
					{
						set_empty(1);
					}
				
				
			}
			else 
			{
				System.out.println("Buffer empty...cant eat");
		
				return 0;
			}
		}	
	}
	

}

class buffer_handle implements Runnable,sharedConst{
	
	buffer b1=new buffer();
	
	int pro,con;
	int amt;
	
	public void run(int cnt,int flag )
	{
		if(flag==1) //producer
		{
			amt=(int)Math.random()*50;
			if(b1.add(amt)==1)
			{
				System.out.println("producer "+pro+ "adding!!");
			}
		}
		else if(flag==-1)//customer
		{
			amt=(int)Math.random()*50;
			if(b1.eat(amt)==1)
			{
				System.out.println("consumer" +con + "eating!!");
			}
		
		}
		
	}
	
	
	public void start(int flag)
	{
		if(flag==1)//producer
		{
			pro=RandGen(0,PRODUCER);
			run(pro,flag);
		}
		
		else if(flag==-1)
		{
			con=RandGen(0,CONSUMER);
			run(con,flag);
		}
	}	
	static int RandGen(double neg, double pos)
	{
		double generator1 = Math.random();
		double generator2 = generator1;
		int ans=(int)pos;
		
		if(generator1<=0.5)
		{
			generator2=Math.random();
			ans= (int)(neg*(-1)*generator2);
		}
		
		else if(generator1>0.5)
		{
			generator2=Math.random();
			ans=(int)(pos*generator2);
		
		}
		if(ans==0)
		ans=ans+2;
		
		return ans;
	}

		
		
}


class Producer_Consumer{
	public static void main(String args[])
	{
		
		buffer_handle h1=new buffer_handle();
		
		Thread producer = new Thread(h1);
		Thread consumer = new Thread(h1);
		
				while(TRUE)
		{
			Thread(producer).start(1);
			Thread(consumer).start(-1);
		}	
		
	}
}
