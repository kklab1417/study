#ifndef xiaofengshan
#define xiaofengshan 
#define uint unsigned int
#define uchar unsigned char
#define f1(a) (65536-a)/256
#define f2(a) (65536-a)%256	
unsigned char m_gear=0;						//������ȡ��λ0,1,2,3  
uint i;										//��������ռ�ձ�													 
sbit p=P2^7;								//�������ߵ�ƽ�͵͵�ƽ

void TH_TL(){
	TH0=f1(200);								//ÿ�μ�ʱ0.2ms
	TL0=f2(200);								
	i++;
}

											//����ʱ���Ȳ���

//�˴�����˼�룺��ÿ����λ������д����ÿ���жϵ�λ��һ�������ĵ�λֵ���ԣ�����ֹͣ

//һ��
void speed_one()									
{
	while(1)
	{	if(m_gear!=1)
		{	
			TR0=1;							//��ʱ������
			break;
		}
		if(i>5&&i<=10)						//ռ�ձ�Ϊһ��
			p=0;
		if(i>10)
		{
			p=1;
			i=1;
		}
	}	
}
				
void speed_two()
{
	while(1)
	{
		if(m_gear!=2)
		{	
			TR0=0;			   				//��ʱ���ر�
			break;							//����ѭ��
		}	
		if(i>8&&i<=10)						//ռ�ձ�Ϊ�ٷ�֮��ʮ
			p=0;
		if(i>10)
		{	
			p=1;
			i=1;
		}
	}
}
void speed_three()						     //ռ�ձ�Ϊ�ٷְ�
{	
	while(1)
	{
		if(m_gear!=3)
		{	
			TR0=0; 							//��ʱ���ر�
			break;							//����ѭ��
		}
	}
}
void speed_zero()
{
	p=0;
	while(1)
	{
		if(m_gear!=0)
		{	
			TR0=0;						   //��ʱ���ر�
			break;						   //����ѭ��
		}
	}	
}

void set_speed(int setspeed){
	 setspeed=m_gear;
	if(m_gear==0)
	{	
		speed_zero();
	}
	else if(m_gear==1)
	{
		speed_one();
	}
	else if(m_gear==2) 
	{
		speed_two();
	} 
	else if(m_gear==3)
	{	
		speed_three();
	} 
}

void motor_init(){      							
	EA=1;									//���ж�
	ET0=1;
	TMOD=0X01;								//���ö�ʱ��
	p=1;
	TR0=1;									//��ʱ������
	i=1;
	TH0=f1(200);							//�߰�λ��ÿ�μ�ʱ0.2ms
	TL0=f2(200);							//�Ͱ�λ
	set_speed(m_gear);					//���õ���ٶ�
}

#endif
