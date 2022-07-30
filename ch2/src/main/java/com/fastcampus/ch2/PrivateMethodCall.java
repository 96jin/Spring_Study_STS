package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {
	public static void main(String[] args) throws Exception{
//		Hello hello = new Hello();
//		hello.main(); // private�̶� �ܺ� ȣ�� �Ұ�
		//------------------------------------	
		// Hello ���� url ȣ���� ������ ����
		// Reflection API�� ��� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ��� ����
		// java.lang.reflect ��Ű���� ����
		//-----------�������������-------------
		// �ٸ� Ŭ�������� private Ŭ������ ȣ���Ѵ�.
		// Hello Ŭ������ Class��ü(Ŭ������ ������ ����ִ� ��ü)�� ���´�
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // Class ��ü�� ���� ������ ��ü ����
					  // newInstance()�� ��ȯ���� object�� ����ȯ������Ѵ�.
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); // private�� main()�� ȣ�Ⱑ���ϰ��Ѵ�.
		
		main.invoke(hello); // hello.main() ȣ���ѰͰ� ����.
		
		
	}
}
