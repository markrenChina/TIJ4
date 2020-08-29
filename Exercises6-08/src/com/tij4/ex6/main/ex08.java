package com.tij4.ex6.main;

import com.tij4.ex6.test.*;

import static com.tij4.ex6.util.Print.*;
public class ex08 {
	public static void main(String[] args) {
		ConnectionManager a1=new ConnectionManager();
		print(a1);
		ConnectionManager a2=new ConnectionManager(10);
		print(a2);
	}


}


class ConnectionManager {
	static Connection[] a;
	ConnectionManager(){
		a=null;
	}
	ConnectionManager(int i) {
		a=makeConnections(i);
	}
	//构造器不能用return
	public static Connection[] makeConnections(int index) {
		if(index==0) {return a=null;}else
		{
		a=new Connection[index];//不能忘记分配数组内存,没有这句编译器不报错
		for(int i=0;i<index;i++) {
			a[i]=Connection.makeConnection();
	    }
	    return a;
	    }
	}
}


class Connection {
	private Connection() {}
	public static Connection makeConnection() {
		System.out.println("Connection被创建");;
		return new Connection();
	}
}