package com.atguigu.queue;

import java.util.Scanner;

public class ArrQueue {

	public static void main(String[] args) {
		// TODO 测试
		ArrayQueue queue =new ArrayQueue(3);
		char key =' ';
		Scanner scanner =new Scanner(System.in);
		boolean loop =true;
		//输出菜单
		while(loop) {
			System.out.println("s:show");
			System.out.println("e:退出");
			System.out.println("add添加");
			System.out.println("get:取出数据");
			System.out.println("head:查看队列头");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				queue.show();
				break;
			case 'a':
				System.out.println("输入一个数字");
				int value =scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res =queue.getQueue();
					System.out.printf("取出的数据%d",res);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 'e':
				scanner.close();
				loop =false;
				break;
			
			default:
				break;
			}
		}
	System.out.println("over");
	}

}
//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	//创建队列构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize =arrMaxSize;
		arr =new int[maxSize];
		front = -1;
		rear = -1;
	}
	public void addQueue(int n ) {
		if(isFull()) {
			System.out.println("队列已满");
			return;
		}
		rear++;
		arr[rear] = n;
	}
	public boolean isEmpty() {
		return rear==front;
	}
	//判断队列是否满
	public boolean isFull() {
		return rear == maxSize-1;
	}
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列空");
			
		}
		front++;
		return arr[front];
	}
	public void show() {
		if (isEmpty()) {
			System.out.println("空");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.err.printf("arr[%d]=%d\n",i,arr[i]);
			
		}	
	}
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		return arr[front+1];
	}
}
	


