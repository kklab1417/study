#include <reg51.h>
#include <lcd1602.h>
#include <at24c02.h>
#include <temperature.h>
#include <motor.h>
#define uint unsigned int
#define uchar unsigned char

void main()
{
	init_show();							//����������ʾ
	init_fuction();							//������ʾ

	upper=read24c02(0);						//��ȡ24C02����,��ȡ��������ֵ
	lower=read24c02(1);						//��ȡ24C02����,��ȡ��������ֵ

	show_h(upper);							//��������ʾ����,��ʾ��������ֵ
	show_l(lower);							//��������ʾ����,��ʾ��������ֵ

	while(1)								/* ϸ��check�������ֳ��ж϶�ȡ�����λ������ɨ�� */ 
	{
		motor_init();		    			//��������жϳ���,���жϣ������ж�			    
	}
}

void fun() interrupt 1{
	TR0=0;									//��ʱ���ر�
	TH_TL();								//�߰�λ�Ͱ�λ

	m_gear=read_gear();					    //��ȡ��ǰ��λ���ж��¶��Ƿ񳬹�������
	check_button();						    //�ж���û�а�ť�Ĳ����������¶ȵ�������

	TR0=1; 								    //��ʱ������
}