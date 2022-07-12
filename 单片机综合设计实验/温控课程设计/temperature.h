#ifndef temperature
#define temperature 
#include <ds18b20.h>
#define uint unsigned int
#define uchar unsigned char
sbit beep = P1^4;								//�������ӿ�
sbit relay=P2^3;
uchar flagg,gear;								//flagg��־λ����־�¶����������Ǹ�����gear���ڻ�ȡ��λ
char top;											//����
char low;											//����


float readtemp(void)						//��ȡ�¶Ⱥ���
{	
	uchar a,b;
	uint t;
	float tt=0;
	init_ds18b20();
	writebyte(0xCC);					
	writebyte(0x44);						//�����¶�ת��
	init_ds18b20();
	writebyte(0xCC);
	writebyte(0xBE);						//��ȡ�ݴ����е��¶�����
	a=readbyte();
	b=readbyte();
	t=b;
	t<<=8;
	t=t|a;
	if(t>=0xfc90)			   				//-55�����Ϊ0xfc90,Ҫȡ���Ĳ���
	{
		flagg=1;								//�ñ��λΪ1�����Ϊ����
		tt=(~t+1)*0.0625+0.5;			    //���10����
		return(tt);
	}
	else
	{
		flagg=0;
		tt=t*0.0625;
		return(tt);
	}	
}

void display(float s)						//��ʾ�¶�
{
	uint t=s*10;							//��10���˴������ȡС��
	uint t1,t2,t3,t4;
	if(flagg==1)							//����
	{
		if(t==0)
		{
			write_ad_data(0x80+0x42,0xfe);
			write_ad_data(0x80+0x43,0xfe);
			write_ad_data(0x80+0x44,0x30);
			write_ad_data(0x80+0x46,0x30);
		}
		if(t<100&&t>0)
		{
			t1=t/10;
			t2=t%10;
			write_ad_data(0x80+0x42,0xfe);
			write_ad_data(0x80+0x43,0x2d);
			write_ad_data(0x80+0x44,0x30+t1);
			write_ad_data(0x80+0x46,0x30+t2);
		}
		if(t>=100)
		{
			t1=t/100;						//���ʮλ�ϵ���
			t2=t/10%10;						//��ø�λ�ϵ���
			t3=t%10;
			write_ad_data(0x80+0x42,0x2d);
			write_ad_data(0x80+0x43,0x30+t1);
			write_ad_data(0x80+0x44,0x30+t2);
			write_ad_data(0x80+0x46,0x30+t3);
		}	
	}
	if(flagg==0)							//����
	{
		if(t<100)
		{
			t1=t/10;
			t2=t%10;
			write_ad_data(0x80+0x42,0xfe);
			write_ad_data(0x80+0x43,0xfe);
			write_ad_data(0x80+0x44,0x30+t1);
			write_ad_data(0x80+0x46,0x30+t2);
		}
		if(t>=100&&t<1000)
		{
			t1=t/100;						//���ʮλ�ϵ���
			t2=t/10%10;						//��ø�λ�ϵ���
			t3=t%10;						//���С��
			write_ad_data(0x80+0x42,0xfe);
			write_ad_data(0x80+0x43,0x30+t1);
			write_ad_data(0x80+0x44,0x30+t2);
			write_ad_data(0x80+0x46,0x30+t3);
		}
		if(t>=1000&&t<=1280)
		{
			t1=t/1000;						//��ð�λ�ϵ���
			t2=t/100%10;					//���ʮλ�ϵ���
			t3=t%100/10;					//��ø�λ�ϵ���
			t4=t%100%10;					//���С��
			write_ad_data(0x80+0x42,0x30+t1);
			write_ad_data(0x80+0x43,0x30+t2);
			write_ad_data(0x80+0x44,0x30+t3);
			write_ad_data(0x80+0x46,0x30+t4);
		}
	}
}


/*  ��ȡ��ǰ��λ */
uchar read_gear()
{
	float temp=readtemp();					//������¼��18B20�������¶�
	display(temp);							//��ʾ��ȡ���¶�
	top=read24c02(0);						//����������
	low=read24c02(1);
	if(temp<=top) 							//С�ڵ����¶�����
	{
		gear=0;								//��λ��0�����Ȳ���
		if(temp<low)						//С������
		{
			relay=0;						//���ϼ̵���
			beep=0;							//��
		}
		else								//������Χ
		{
			relay=1;						//�򿪼̵���
			beep=1;							//����
		}
	}
	else									//�����¶�����
	{
		beep=0;								//��
		if(temp<=top+2)						//һ��
		{
			gear=1;
		}
		else if(temp<=top+4)				//����
		{
			gear=2;
		}
		else								//����
		{
			gear=3;
		}
	}
	write_ad_data(0x80+0x4e,0x30+gear);	   //��ʾ��ǰ��λ
	return gear;								//���ص�λ��ֵ��������ʹ��
}

#endif
