package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("双向链表测试");
				HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
				HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
				HeroNode2 hero3 = new HeroNode2(3, "无用", "智多星");
				HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
//				SingleLinkedList singleLinkedList = new SingleLinkedList();
				DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
				
				doubleLinkedList.add(hero1);
				doubleLinkedList.add(hero2);
				doubleLinkedList.add(hero3);
				doubleLinkedList.add(hero4);
				
				doubleLinkedList.list();
	
				HeroNode2 newHero  = new HeroNode2(4,"公孙胜","入云龙");
				doubleLinkedList.update(newHero);
				
				System.out.println("updated show~");
				
				doubleLinkedList.list();
				System.out.println();
				//del
				doubleLinkedList.del(3);
				System.out.println("deled show~");
				doubleLinkedList.list();
				System.out.println();
			
				//insert
				HeroNode2 newHero3  = new HeroNode2(3,"sdadsad","sadsadd");
				doubleLinkedList.insert(3, newHero3);
				doubleLinkedList.list();
			}
	}


class DoubleLinkedList{
	//初始化头结点
	private HeroNode2 head = new HeroNode2(0,"","");
	public HeroNode2 getHead() {
		return head;
	}
	
	//add到双向列表最后位置
	public void add(HeroNode2 heroNode){
		HeroNode2 temp = head;
		while(true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		//此时temp是最后一个
		temp.next = heroNode;
		heroNode.pre = temp;
	}
	//insert 先遍历找到要插入位置的前一个
	
	//TO DO
	public void insert(int no,HeroNode2 heroNode) {
		HeroNode2 temp = head;
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
				heroNode.pre = temp; 						
				if (temp.next != null) { 
				temp.next.pre = heroNode;					
				}
				temp.next = heroNode;
				
			}
		
	}
	//update
	
	public void update(HeroNode2 newNode) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode2 temp = head;
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
	
	//双向列表删除
	//双向列表可以自行删除
	public void del(int no ) {
		HeroNode2 temp = head;
		boolean flag = false;
		
		while(true) {
			if (temp.next == null ) {
				break;
			}
			if (temp.no == no) {
				System.out.println("要删除的找到了");
				flag =true;
				break;
			}
			temp = temp.next;
		}
		//如果找到了
		if (flag) {
			//temp.next = temp.next.next;
			temp.pre.next = temp.next;
			if (temp!=null) {
				temp.next.pre = temp.pre;
			}
			
		}else {
			System.out.println("要删除的不存在");
		}
	}
	//遍历双向列表方法
	public void list() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}
}

class HeroNode2{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pre;
	public HeroNode2(int no,String name,String nickname) {
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
