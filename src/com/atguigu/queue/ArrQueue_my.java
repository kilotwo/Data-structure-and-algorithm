package com.atguigu.queue;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class ArrQueue_my {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraryQueue arraryQueue= new ArraryQueue(3);
		boolean loop =true;
		Scanner scanner = new Scanner(System.in);
		char key =' ';
		while(loop) {
			System.out.println("请输入：");
			System.out.println("s:show");
			System.out.println("e:退出");
			System.out.println("a添加");
			System.out.println("g:取出数据");
			System.out.println("h:查看队列头");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				arraryQueue.show();
				break;
			case 'e':
				scanner.close();
				loop =false;
				break;
				
			case 'a':
				System.out.println("输入一个数字");
				int value =scanner.nextInt();
				arraryQueue.add(value);
				break;
			case 'g':
				System.out.printf("%d",arraryQueue.get());
				break;
			case 'h':
				arraryQueue.getHead();
				break;
				
			default:
				break;
			}
		}
		
	}
	
}
class ArraryQueue{
	private int maxSize = 0;
	private int head ;
	private int end  ;
	private int[] arrque;
	
	public  ArraryQueue(int n) {
		arrque = new int[n];
		maxSize = n;
		head = -1;
		end  = -1;
	}
	public boolean isFull() {
		return end == maxSize-1;

	}
	public boolean isEmpty() {
		return head == end;
	}
	
	public void add(int n) {
			
			if (isFull()) {
				System.out.println("已满");
				return;
			}		
		end++;
		arrque[end] = n;
	}
	public void show() {
		if (isEmpty()) {
			System.out.println("空");
			return;
		}
		for (int i = 0; i < arrque.length; i++) {
			System.out.printf("%d\n",arrque[i]);
		}
	}	
	public int  get() {
		if (isEmpty()) {
			throw new RuntimeException("空");
		}
		return  arrque[++head];
		
	}
	public void  getHead() {
		if (isEmpty()) {
			throw new RuntimeException("空");
		}
		System.out.println(arrque[head+1]);
	}
	
	
}