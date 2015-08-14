package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) throws Exception{
		RealSubject rs = new RealSubject();// ��Ҫ �� �������,���ͻ���������Ҫ�Ĵ���һ������Ϊ RealSubject �Ķ���
		
		/*
		 * ע�⣬������Ĺ��췽���Ĳ���ΪObject���ͣ�˵�������Դ��� �������͵Ķ���---����������ǰDynamicSubject����֪����Ҫ����Ķ���
		 * AnOtherRealSubject anotherRs = new AnOtherRealSubject();
		 * InvocationHandler handler = new DynamicSubject(anotherRs);
		 * 
		 */
		InvocationHandler handler = new DynamicSubject(rs);// �����࣬����Ҫ �� ������� ��Ϊ ������Ĺ��� �����Ĳ�������
		
		
		Class cls = rs.getClass();
		
		/*
		 * Class c = Proxy.getProxyClass(cls.getClassLoader(), cls.getInterfaces());
		   Constructor ct = c.getConstructor(new Class[]{InvocationHandler.class});
		   Subject subject = (Subject) ct.newInstance(new Object[]{handler});
		 */
		
		
		/*
		 * 
		 */
		Subject subject = (Subject)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
		
		
		/*
		 * �������ִ��ʱ������ί�е�InvocationHandler ���е� invoke��������ִ�� method.invoke()����ʵ�ʵ���
		 * ע�⣺InvocationHandler.invoke()�������������䣬����Client���ڿ���̨�п���������������˵���÷�����ί��ִ����
		 */
		subject.request();
		
		/*
		 * �����com.sun.proxy.$Proxy0
		 * �������subject ���������� $Proxy0,������ Subject �� InvocationHandler ����
		 * ������ 22������У�ȴ���Խ�֮����ǿ������ת����ת��Subject����
		 * ԭ���ǣ�Proxy.newProxyInstance���ɵ���һ����̬���󣬼���JVM����ʱ���ɵġ���newProxyInstance()�ĵڶ��������ϣ������ṩ��һ��ӿ�
		 * �ô������ͻ�ʵ������ӿڣ����Ҳ�Ϳ��Խ��ö���ǿ��ת��Ϊ����ӿ��е�����һ��
		 */
		System.out.println(subject.getClass().getName());
	}
}
