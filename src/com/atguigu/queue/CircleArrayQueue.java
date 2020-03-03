package com.atguigu.queue;

import java.awt.Font;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class CircleArrayQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleArray circleArray = new CircleArray(4);
		Scanner scanner =new Scanner(System.in);
		boolean loop = true;
		char key =' ';
		
		while(loop) {
		System.out.print("请输入操作");	
		System.out.println("s:show");
		System.out.println("e:退出");
		System.out.println("a：添加");
		System.out.println("g:取出数据");
		System.out.println("h:查看队列头");
		key = scanner.next().charAt(0);
		switch (key) {
		case  's':
			circleArray.show();
			break;
		case  'a':
			System.out.println("请输入添加数字");
			int value = scanner.nextInt();
			circleArray.add(value);
			break;
		case  'e':
			scanner.close();
			loop = false;
			break;
		case  'g':
			System.out.printf("%d",circleArray.get());
			break;
		case  'h':
			circleArray.head();
			break;
		default:
			break;
		}
		}
	}

}
class CircleArray{
	private int max;
	private int front;
	private int rear;
	private int[] arr;
	public CircleArray(int n) {
		max = n;
		front =0;
		rear =0;
		arr = new int[n];
	}
	public boolean isFull() {
		return (rear+1)%max==front;
	}
	public boolean isEmpty() {
		return front == rear;
	}
	public void add(int n) {
		if (isFull()) {
			System.out.println("已满");
			return;	
		}
		arr[rear]=n;
		//往后移一位
		rear = (rear+1)%max;
	}
	public int  get() {
		if (isEmpty()) {
			throw new RuntimeException("空");			
		}
		int value = arr[front];
		front = (front+1)%max;
		return value;
	}
	public void show() {
		if (isEmpty()) {
			System.out.print("空");
			return;
		}
		for (int i = front; i <front+((rear+max-front)%max) ; i++) {
			System.out.printf("arr[%d] is %d\n",i%max,arr[i%max]);
		}
	}
	public  int head() {
		if (isEmpty()) {
			throw new RuntimeException("空的");
		}
		return arr[front];
	}
	
}