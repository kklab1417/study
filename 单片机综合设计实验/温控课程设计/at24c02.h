#ifndef at24c02
#define at24c02
#include <intrins.h>
#define uchar unsigned char
#define uint unsigned int
uchar flag=0;						//��־,Ϊ1ʱ�ı�����ֵ��Ϊ2ʱ�ı�����ֵ
uchar a1,a2,a3,a0;
char upper;	
char lower;
sbit scl=P1^6;
sbit sda=P1^7;
sbit but1=P3^7;
sbit but2=P3^6;
sbit but3=P3^5;
sbit but4=P3^4;
sbit int_0=P3^2;

void init_delay(uint j) 				//��������ʱ��
{
	uchar i=250;
	for(;j>0;j--)
	{
		while(--i);
		i=249;
		while(--i);
		i=250;
	}
}

void delay5us()					//��ʱ5us
{
	_nop_();
	_nop_();
	_nop_();
	_nop_();
	_nop_();
}

void delay(uint z)			   //��ʱ10us
{	
	uchar x,y;
	for(x=z;x>0;x--)
	{
		for(y=110;y>0;y--);
	}
}

void delay02s()					//��ť�󶨣������ж��ĸ���ť������
 {
	uchar i,j,k;
	for(i=20;i>0;i--)
		for(j=20;j>0;j--)
			for(k=100;k>0;k--)
			{
				if(!but1)
				{
					a0=1;
				}
				if(!but2)
				{
					 a1=1;
				}
				if(!but3)
				{
					 a2=1;
				}
				if(!but4)
				{
					 a3=1;
				}
			}
}


/* ������ʾ���� */
void init_show()								//��������
{					
	uchar i=0;									//����������LCD��Ļ����
	init1602();
	write_ad_str(0x80,"Welcome to AAUCS");
	write_ad_str(0x80+0x40,"N0.02");
	delay(1000);
	while(i<16)
	{
		write_com(0x1c); 						//������Ļ����
		init_delay(100); 						//��ʱ������û��ô��
		i++;
	}
}
/* ��ʼ����ģ���ʽ��ʾ */
void init_fuction()								//��ʼ��������˼���ȹ̶����λ�ã�
{												//��д�ַ���write_ad_data()����
	init1602();									//ʵ�ֹ���ƶ���д�ַ����ֹ���
	write_ad_data(0x80+0x40,'T');				//��ʾT
	write_ad_data(0x80+0x41,':');				//��ʾ��
	write_ad_data(0x80+0x45,'.');				//��ʾ. 
	write_ad_data(0x80+0x47,0xdf);				//��ʾ�� 
	write_ad_data(0x80+0x48,'C');				//��ʾC 
	write_ad_data(0x80+0x4a,'F');				//��ʾF
	write_ad_data(0x80+0x4b,'A');				//��ʾA 
	write_ad_data(0x80+0x4c,'N');				//��ʾN 
	write_ad_data(0x80+0x4d,':');				//��ʾ��
	write_ad_data(0x80,'H');					//��ʾH 
	write_ad_data(0x81,':');					//��ʾ��
	write_ad_data(0x85,0xdf);					//��ʾ�� 
	write_ad_data(0x86,0x43);					//��ʾ��
	write_ad_data(0x89,'L');					//��ʾL 
	write_ad_data(0x8a,':');					//��ʾ�� 
	write_ad_data(0x8e,0xdf);					//��ʾ��
	write_ad_data(0x8f,0x43);					//��ʾ��
}

void start()					//��ʼ�ź�
{
	sda=1;
	delay5us();
	scl=1;
	delay5us();
	sda=0;
	delay5us();
	scl=0;						//����scl,ռ��scl׼����������
	delay5us();
}

void stop()						//��ֹ�ź�
{ 
	sda=0;
	delay5us();
	scl=1;
	delay5us();
	sda=1;
}

bit recack()					//����Ӧ��
{
	uchar upper = 0;
	while(sda)
	{
		if(++upper>200)		 	//�ȴ�����200,��Ϊ��Ӧ��,����ֹͣ�ź�
		{		
			scl=0;
			stop();
			return 0;
		}
	}										
		scl = 0;				//Ӧ������,����scl�γɵ�9��ʱ������
		return 1;
}

void sendbyte(uchar dat)		//��iic����һ�ֽ�����
{	 
	uchar i;
	for(i=0;i<8;i++)
	{
		if(dat&0x80)
		{		
			sda=1;
		}
		else
		{
			sda=0;
		}
		dat=dat<<1;
		scl=1;					//����scl,�ôӻ�����sda
		delay5us();
		scl=0;					//ռ��scl,��sda����ı�
		delay5us();
	}
	scl=1;						//�ͷ�SCL��SDA
	delay5us();
	sda=1;
	delay5us();
}

char rcvbyte()					//��iic����һ�ֽ�����
{
	uchar i;
	char dat;
	
	scl=0;						//�ڸı�sdaǰ��ȷ��sclΪ�͵�ƽ
	delay5us();
	sda=1;						//�����ͷ�sda,�Ա�ӻ����Ըı�sda
	delay5us();
	
	for(i=0;i<8;i++)
	{
		scl=1;					//����scl,���մӻ�������sda
		delay5us();
		dat<<=1;
		dat|=sda;
		scl=0;
		delay5us();				//����scl,�ôӻ����Ըı�sda�ĵ�ƽ
	}
	return dat;
}
/* ָ��λ�ö�ȡ24c02��ֵ */
char read24c02(uchar add)   		//ָ����ַ������
{
	char dat;
	start();
	sendbyte(0xa0);					//д���豸��ַ ���һλΪ0��������Ҫд�����ݵ��ӻ�
	recack();
	sendbyte(add);					//д��Ҫ�����ݵĵ�ַ
	recack();
	start();				
	sendbyte(0xa1);					//д���豸��ַ ���һλΪ1��������Ҫ���ӻ�����
	recack();				   	
	dat=rcvbyte();					//�������������
	stop();							//����������
	return dat;
}
/* ��datֵд��24c02 */
void write24c02(uchar add,char dat)		//ָ����ַд����
{
	start();
	sendbyte(0xa0);					//д���豸��ַ
	recack();
	sendbyte(add);					//д�������ݵĵ�ַ
	recack();
	sendbyte(dat);					//д������
	recack();
	stop();					   		//����д����
}
/* �����¶�ֵ��ʾ */
void show_h(char dat)									//����˼�룺����dat����ֵ�жϹ��λ���Լ�д�������ֵ
{
	if(dat>=100)													//�Ǵ��ڵ���һ�٣���Ҫ3λ��
	{
		write_ad_data(0x82,0x30+dat/100);				//ȡ��λ
		write_ad_data(0x83,0x30+dat/10%10);				//ȡʮλ
		write_ad_data(0x84,0x30+dat%10);				//ȡ��λ
	}
	if(dat>10&&dat<100)									//��λ����
	{
		write_ad_data(0x82,0xfe);						//����λ
		write_ad_data(0x83,0x30+dat/10);				//ȡʮλ
		write_ad_data(0x84,0x30+dat%10);				//ȡ��λ		
	}
	if(dat>=0&&dat<10)									//һλ����
	{
		write_ad_data(0x82,0xfe);						//����λ
		write_ad_data(0x83,0xfe);						//����λ
		write_ad_data(0x84,0x30+dat);					//ֻ��һλ���֣�ֱ����ʾ
	}									  	
	if(dat<0&&dat>-10)									//С��0.������Ҫ��λ
	{	
		write_ad_data(0x82,'-');						//������
		write_ad_data(0x83,0xfe);						//����λ
		write_ad_data(0x84,0x30+(~dat+1));				//ȡ����1���Դ��	
	}
	if(dat<=-10)		//С��0���ܹ���Ҫ��λ
	{
		write_ad_data(0x82,'-');//������
		write_ad_data(0x83,0x30+(~dat+1)/10);			//ȡʮλ
		write_ad_data(0x84,0x30+(~dat+1)%10);			//ȡ��λ
	}	  
}
/* �����¶�ֵ��ʾ */
void show_l(char dat)									//����ͬ��
{
	if(dat>=100)										//�Ǵ��ڵ���һ��
	{
		write_ad_data(0x8b,0x30+dat/100);
		write_ad_data(0x8c,0x30+dat/10%10);
		write_ad_data(0x8d,0x30+dat%10);
	}
	if(dat>10&&dat<100)
	{
		write_ad_data(0x8b,0xfe);
		write_ad_data(0x8c,0x30+dat/10);
		write_ad_data(0x8d,0x30+dat%10);		
	}
	if(dat>=0&&dat<10)
	{
		write_ad_data(0x8b,0xfe);
		write_ad_data(0x8c,0xfe);
		write_ad_data(0x8d,0x30+dat);
	}
	if(dat<0&&dat>-10)
	{	
		write_ad_data(0x8b,'-');
		write_ad_data(0x8c,0xfe);
		write_ad_data(0x8d,0x30+(~dat+1));	
	}
	if(dat<=-10)
	{
		write_ad_data(0x8b,'-');
		write_ad_data(0x8c,0x30+(~dat+1)/10);
		write_ad_data(0x8d,0x30+(~dat+1)%10);		
	}	  
}	

/* ����Ƿ��а������� */								   	
void check_button()					   					//ɨ�谴��
{	
	a0=0;												//��ť������ʼ��  ,����
	a1=0;												//��
	a2=0;												//��
	a3=0;									   			//ȷ��
			
	if(!but1||a0)										//���ϵ��׼ȷ�жϰ�ť�Ƿ񱻰���
	{						
		delay(1);
		
		if(!but1||a0)									//�������
		{
			if(flag==0)
			{
				flag=1;									//����һ�Σ�flag��1
			}
			else if(flag==1)
			{
				flag=2;					
			
			}
			else if(flag==2)
			{
										
				flag=1;									//����ʵ�ְ�ť1��ѭ��
			}
		}
	}
	if(!but2||a1)										//�жϰ�ť2�Ƿ񱻰���
	{
		delay(1);
		if(!but2||a1){
			if(flag==1)
			{
				if(upper<128)							//���ɼӵ�128
				{
					upper++;
				}
				show_h(upper);							//��ʾ
			}
			if(flag==2)
			{
				if(lower<upper)							//�����޿������
				{
					lower++;
				}	  
				show_l(lower);
			}			
		}
	}
	if(!but3||a2)
	{
		delay(1);
		if(!but3||a2)
		{
			if(flag==1)
			{
				if(upper>lower)							//��������޴󣬾Ϳɼ�
				{
					upper--;
				}
				show_h(upper);
			}
			if(flag==2)
			{
				if(lower>-55)							//�����޿������
				{
					lower--;
				}	  
				show_l(lower);
			}
		}
	}
	if(!but4||a3)
	{
		delay(1);
		if(!but4||a3)
		{	 
			write24c02(0X00,upper);					   //����ʱ���޸�����ֵд��24c02
			delay(15);	
			write24c02(0X01,lower);					   //����ʱ���޸�����ֵд��24c02
			flag=0;
		}
	}
	 /* ����flagֵȷ�����������޻�������������˸ */
	if(flag==1)											//�������ޣ�falg��ֵ��button1ȷ����������
	{
		delay02s();
		write_ad_data(0x82,0x11);						//д��λ��
		write_ad_data(0x83,0x11);	
		write_ad_data(0x84,0x11);	
		delay02s();
		show_h(upper);									
	}
	if(flag==2)											//�������ޣ�������
	{
	 	delay02s();
		write_ad_data(0x8b,0x11);						//д��λ��
		write_ad_data(0x8c,0x11);	
		write_ad_data(0x8d,0x11);	
		delay02s();
		show_l(lower);
	}
}


#endif
