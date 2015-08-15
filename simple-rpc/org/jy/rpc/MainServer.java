package org.jy.rpc;

import org.jy.rpc.op.AnOtherEchoService;
import org.jy.rpc.op.AnOtherEchoServiceImpl;
import org.jy.rpc.op.Echo;
import org.jy.rpc.op.RemoteEcho;
import org.jy.rpc.support.Server;

public class MainServer {
	public static void main(String[] args) {
		Server server = new RPC.RPCServer();

		/*
		 * server ������,��Ҫע��server���ܹ��ṩ�ķ���,����clientʹ�� ��������֡�
		 * ��������IP���Լ����������еĶ˿� ������ server �ķ���
		 */
		server.register(Echo.class, RemoteEcho.class);//ע����������
		server.register(AnOtherEchoService.class, AnOtherEchoServiceImpl.class);
		
		server.start();//����server
	}
}
