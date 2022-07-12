#ifndef lcd1602
#define lcd1602
#define uchar unsigned char
#define uint unsigned int

sbit lcdrs=P1^0;
sbit lcdrw=P1^1;
sbit lcden=P1^2;

void check_busy(void)				  			//���æ��־λ
{
	uchar dt;
	do
	{
		dt=0xff;
		lcden=0;
		lcdrs=0;
		lcdrw=1;
		lcden=1;
		dt=P0;
	}while(dt&0x80);
	lcden=0;
}


void delay_ms(uint temp)					  	//��ʱ����
{
 	uint x,y;
 	for(x=temp;x>0;x--)
  		for(y=110;y>0;y--);		
}

void write_com(uchar com)			  			//д���� 
{
 	check_busy();
 	lcdrs=0;
 	lcdrw=0;
	P0=com;
 	delay_ms(10);
 	lcden=1;
 	delay_ms(10);
 	lcden=0;
}

void write_ad_data(uchar ad,uchar dat) 			//��ָ����ַдҪ��ʾ���ַ�
{
 	write_com(ad);														
 	check_busy();
 	lcdrs=1;
 	lcdrw=0;
 	P0=dat;
 	delay_ms(10);
 	lcden=1;
	delay_ms(10);
	lcden=0;
}

void write_ad_str(uchar ad,uchar *s) 			//��ָ����ַдҪ��ʾ�Ķ���ַ�
{
	while(*s)
	{
		write_ad_data(ad++,*s++);				//��ַ��1��ָ����1
	}	
}

void init1602()									//��ʼ��
{
 	lcden=0;
 	write_com(0x38); 							//������ʾ��5*7����8λ���ݽӿ�
 	write_com(0x0c);							//��������ʾ�����أ�����˸
 	write_com(0x04);						  	//д��һ���ַ����������ƶ�
 	write_com(0x01);							//����
}

#endif