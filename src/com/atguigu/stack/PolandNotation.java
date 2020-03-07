package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//先定义逆波兰表达式
		//(30+4)*5-6 =》30 4 + 5 * 6 - =》164
		//4 * 5 - 8 + 60 +8/2 =>
		//4 5 * 8 -60 +8 2 /+
		//String sufString = "4 5 * 8 - 60 + 8 2 / +";
		String sufString = "30 4 + 5 * 6 -";
		List<String>list = getListString(sufString);
		System.out.println("rpnList:"+list);
		int res = calculate(list);
		System.out.println("结果是："+res);
	}
/**
 * 
 * @param 放入一个逆波兰表达式
 * @return 返回按照字符分割后的list
 */
	public static List<String>getListString(String suffString){
		//将其分割
		String[] split	= suffString.split(" ");
		//list来装分割后的每个字符
		List<String> list = new ArrayList<String>();
		for (String string : split) {
			list.add(string);
		}
			return list;
	}
/**
 * 完成对逆波兰式的运算
 * 
 * 
 * 
 */
	public static int calculate(List<String>ls) {
		//创建栈
		Stack<String> stack = new Stack<String>();		
		//list
		for (String item : ls) {
			if (item.matches("\\d+")) {
				//入栈
				stack.push(item);
			}else {
				//pop出两个数字
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if (item.equals("+")) {
					res = num1 + num2;
				}else if (item.equals("-")) {
					res = num1 - num2;	
				}else if (item.equals("*")) {
					res = num1 * num2;	
				}else if (item.equals("/")) {
					res = num1 / num2;	
				}else {
					throw new RuntimeException("运算符有误");
				}
				//把res入栈
				stack.push(""+res);
			}
		}
		return Integer.parseInt(stack.pop());
	}
}
