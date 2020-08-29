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
		//1:[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]伪随机生成
		Hamster h=new Hamster();
		pets.add(h);
		print("2:"+pets);
		//2:[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Hamster]增加一个h（Hamster）
		print("3:"+pets.contains(h));
		//3:true           contains（）确定对象是否在列表
		pets.remove(h);//删除h
		Pet p=pets.get(2);
		print("4:"+p+" "+pets.indexOf(p));
		//4:Cymric 2  indexOf()查询p的索引
		Pet cymric =new Cymric();
		print("5:"+" "+pets.indexOf(cymric));
		//5: -1                    新建的cymric对象并未在列表中被找到.虽然列表中有cymric.List中equals()对比的是索引
		print("6:"+" "+pets.remove(cymric));
		//6: false    新建cymric对象不在列表,所以删除失败
		print("7:"+" "+pets.remove(p));
		//7: true     删除成功。
		print("8:"+" "+pets);
		//8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
		pets.add(3,new Mouse());//插入对象，参数是索引
		print("9:"+pets);
		//9:[Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
		List<Pet> sub=pets.subList(1, 4);
		print("subList"+sub);
		//subList[Manx, Mutt, Mouse]
	}
}
