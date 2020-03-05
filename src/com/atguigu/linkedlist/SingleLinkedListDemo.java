package com.atguigu.linkedlist;

import java.security.Signature;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "无用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		SingleLinkedList singleLinkedList = new SingleLinkedList();
	
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);
		singleLinkedList.add(hero4);
	
		singleLinkedList.list();
		System.out.println();
		
		HeroNode newHero  = new HeroNode(2,"xiaolulu","yuqil~~~");
		singleLinkedList.update(newHero);
		
		System.out.println("updated show~");
		
		singleLinkedList.list();
		System.out.println();
		//del
		singleLinkedList.del(1);
		//show
		System.out.println();
		System.out.println("deled show~");
		singleLinkedList.list();
		System.out.println();
		
		//insert
		HeroNode newHero2  = new HeroNode(1,"sdadsad","sadsadd");
		singleLinkedList.insert(1, newHero2);
		singleLinkedList.list();
	}

}

class SingleLinkedList{
	//初始化头结点
	private HeroNode head = new HeroNode(0,"","");
	//add先遍历找到最后一个然后再添加
	public void add(HeroNode heroNode){
		HeroNode temp = head;
		while(true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
	}
	//insert 先遍历找到要插入位置的前一个
	public void insert(int no,HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no >no) {
				break;
			}else if (temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
			if (flag) {
				System.out.println("已经存在无法插入");
			}else {
				heroNode.next = temp.next;
				temp.next = heroNode;
			}
		
	}
	//update
	//to do 找到2改了1
	public void update(HeroNode newNode) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if (temp == null) {
				break;
			}
			if (temp.no == newNode.no) {
				//find it
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			
			System.out.println("找到");
			temp.name = newNode.name;
			temp.nickname = newNode.nickname;
		}else {
			System.out.println("没找到");
		}
	}
	public void del(int no ) {
		HeroNode temp = head;
		boolean flag = false;
		
		while(true) {
			if (temp.next == null ) {
				break;
			}
			if (temp.next.no == no) {
				System.out.println("要删除的找到了");
				flag =true;
				break;
			}
			temp = temp.next;
		}
		
		if (flag) {
			temp.next = temp.next.next;
		}else {
			System.out.println("要删除的不存在");
		}
	}
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
}

class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	public HeroNode(int no,String name,String nickname) {
		// TODO Auto-generated constructor stub
		this.no = no;
		this.name =name;
		this.nickname = nickname;
	}	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "该英雄id"+no+"name"+name;
	}
}