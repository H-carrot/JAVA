package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler{
	private Object sub;//�� ����Ķ���,����һ��Object���͵Ķ���˵������ ����Ķ����ǿ��Զ�̬�ı��
	
	public DynamicSubject(){
		
	}
	
	//�����췽�����ݲ�ͬ�����͵� ������Ķ��󣬾Ϳ��� ʵ�� ��̬����--��������ʱȷ��������Ķ��������
	public DynamicSubject(Object obj){
		sub = obj;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
		System.out.println("before calling " + method);
		
		/*
		 * �ڹ��췽���л���˱�����Ķ���RealSubject sub
		 */
		method.invoke(sub, args);//���� ʵ�� �ķ��������ñ�����Ķ���ķ�������RealSubject.request()
		
		System.out.println("after calling " + method);
		return null;
	}
}
