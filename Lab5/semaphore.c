#include<stdio.h>
#define BUFFER_CAP 50
#define PRODUCER  20
#define CONSUMER 10
typedef bool semaphore;

struct pack{
	int index;
	int amt;
};



int buffer=0;
semaphore flag=0;
semaphore head=0;
semaphore tail=0;

void flag_semwait()
{
	flag=1;
}
void flag_semsignal()
{
	flag=0;
	
}
void head_semwait()
{
	head=1;
}
void head_semsignal()
{
	head=0;
	
}
void tail_semwait()
{
	tail=1;
}
void tail_semsignal()
{
	tail=0;
	
}
void *Producer(void *handle)
{
	int amt=*(int*)handle.amt*100;
	int index=*(int*)handle.index;
	int i;
	//check if the critical section is free
	while(!flag)
	{
		flag_semwait(); //revoke all access to critical section
		
		if(!head)//check if the buffer is full
		{
			for(i=0;i<amt;i++)
			{
				if(buffer!=BUFFER_CAP) //is buffer full?
				{	
					if(tail==1)
					{
						tail_semsignal();
					}
					buffer++;
				}
				else if(buffer==BUFFER_CAP)//if full..
				{
					printf("buffer is full");
					head_semwait();
					break;
				}
			}
			
		}
		else if(head==1)
		{
		printf("buffer is full");
		printf("Producer %d can't add",index);
		}
		
		buff_semsignal();
	}
}
void *Consumer(void *handle)
{
	int amt=*(int*)handle.amt*100;
	int index=*(int*)handle.index;
	int i;
	//check if the critical section is free
	while(!flag)
	{
		flag_semwait(); //revoke access to critical section
		
		printf("Consumer %d is eating",index);
		//check if the buffer is already full
		if(!tail) //while buffer is nonempty
		{
			for(i=0;i<amt;i++)
			{
				if(buffer!=0)//is buffer empty
				{	
					if(full==1)
					{
						full_semsignal();
					}
					buffer--;
				}
				else if(buffer==0)//if empty..
				{
					printf("buffer is empty");
					tail_semwait();
					break;
				}
			}
			
			
		}
		else if(tail==1)
		{
		printf("buffer is empty");
		printf("Consumer %d can't eat",index);		
		}
		tail_semsignal();
	}

}

void main()
{
	
	int randno1;
	int randno2=0;
	int randno3=0;
	int i;
	pthread_t t1, t2;
	struct pack handle;
	//int ret1, ret2;		
	for(i=0;i<100;i++)
	{
		randno1=rand()%2;
		if(randno1==1)
		{
		
			handle.index=rand()%20;//Producer select
			handle.amt=rand()%20;//select buffer ma ketlu bharvu che
			
			pthread_create(&t1, NULL, Producer, (void *)&handle);//call function Producer with thread
		
		}
		else
		{
			handle.index=rand()%10;//COnsumer select
			handle.amt=rand()%20;//ketlu khavu che
			pthread_create(&t1, NULL, Comsumer, (void *)&handle);
		}
	}	
	
}


