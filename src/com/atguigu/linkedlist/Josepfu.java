package com.atguigu.linkedlist;

import javax.swing.plaf.TextUI;

public class Josepfu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
			circleSingleLinkedList.addBoy(5);
			circleSingleLinkedList.show();
			
			circleSingleLinkedList.countBoy(1, 2, 5);
	}

}
	
class Boy{
	private int no;
	private Boy next;
	public Boy(int no) {
		this.no = no;
	}
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getNo(){
		return no;
	}

}
 
class CircleSingleLinkedList{
	private Boy first = null;
	
	
	public void addBoy(int nums) {
		if (nums<1) {
			System.out.println("num is false");
			return;
		}
		Boy curBoy =null;
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				//第一个形成一个自环
				first = boy;
				first.setNext(first);
				//当前==first
				curBoy = first;
			}else {
				//当前这个指向新来的
				curBoy.setNext(boy);
				//新来的回环指向第一个
				boy.setNext(first);
				//将新加入的设置为当前值
				curBoy = boy;
			}
		}	
	}
	//遍历当前环形链表
	public void show() {
		//判空
		if (first == null) {
			System.out.println("没有任何小孩");
			return;
		}
		Boy curBoy = first;
		while(true) {
			System.out.printf("小孩编号%d\n",curBoy.getNo());
			if (curBoy.getNext() == first) {
				//说明已经遍历到最后一个并回环指向第一个
				break;
			}
			curBoy = curBoy.getNext();//curBoy后移
		}
	}
	//根据用户的输入 计算小孩出圈顺序
	/**
	 * startNo 表示从第几个小孩开始数数
	 * 
	 * countNum 表示数几下
	 * 
	 * nums 表示最初有多少小孩在圈中
	 */
	public void countBoy(int startNo,int countNum,int nums) {
		//先对数据进行校验
		if (first == null||startNo<1||startNo>nums) {
			System.out.println("false");
			return;	
		}
		Boy helper =first;
		while (true) {
			if (helper.getNext()==first) {
				break;
			}
			helper = helper.getNext();
		}
		//此时helper到达最后一个和first相差一个
		//小孩报数前先让first和helper移动k-1次
		for (int i = 0; i < startNo -1; i++) {
			//两个同时移动
			first =first.getNext();
			helper = helper.getNext();
		}
		//当小孩报数时，让first和helper指针同时移动m-1次，然后出圈
		//进行循环  直到圈中只有一个节点
		while (true) {
			if (helper == first) {
				break;
			}
			//first 和 helper 指针同时移动 countNum-1
			for (int i = 0; i < countNum -1 ; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			//此时first指向的节点 就是要出圈的小孩节点
			System.out.printf("%d out->",first.getNo());
			//此时将他出圈
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("最后留下%d\n",first.getNo());
	} 
}

