package com.tij4.ex6.test;
import pets.*;

import java.util.List;
import java.util.Random;

import static com.tij4.util.Print.*;

public class ListFeatures {
	public static void main(String[] args) {
		Random rand=new Random(47);
		List<Pet> pets=Pets.arrayList(7);
		print("1:"+pets);
		//1:[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]α�������
		Hamster h=new Hamster();
		pets.add(h);
		print("2:"+pets);
		//2:[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Hamster]����һ��h��Hamster��
		print("3:"+pets.contains(h));
		//3:true           contains����ȷ�������Ƿ����б�
		pets.remove(h);//ɾ��h
		Pet p=pets.get(2);
		print("4:"+p+" "+pets.indexOf(p));
		//4:Cymric 2  indexOf()��ѯp������
		Pet cymric =new Cymric();
		print("5:"+" "+pets.indexOf(cymric));
		//5: -1                    �½���cymric����δ���б��б��ҵ�.��Ȼ�б�����cymric.List��equals()�Աȵ�������
		print("6:"+" "+pets.remove(cymric));
		//6: false    �½�cymric�������б�,����ɾ��ʧ��
		print("7:"+" "+pets.remove(p));
		//7: true     ɾ���ɹ���
		print("8:"+" "+pets);
		//8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
		pets.add(3,new Mouse());//������󣬲���������
		print("9:"+pets);
		//9:[Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
		List<Pet> sub=pets.subList(1, 4);
		print("subList"+sub);
		//subList[Manx, Mutt, Mouse]
	}
}
