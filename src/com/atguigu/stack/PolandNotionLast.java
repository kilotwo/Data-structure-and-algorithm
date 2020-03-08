package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotionLast{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//先定义逆波兰表达式
		//(30+4)*5-6 =》30 4 + 5 * 6 - =》164
		//4 * 5 - 8 + 60 +8/2 =>
		//4 5 * 8 -60 +8 2 /+
		//String sufString = "4 5 * 8 - 60 + 8 2 / +";
		
		//1.现将中缀表达式(带两位数)字符串按照字符分割
		//2.再将分割后字符放入List
		String sufString = "(30+4)*5-6";
		List<String>list = toInfixExpressionList(sufString);
		System.out.printf("输入的原表达式:"+sufString+"\n");
		System.out.println("中缀List:"+list);
		//3.再将List转化为后缀表达式对应的List
		List<String>suffList = parseSuffix(list);
		System.out.println("逆波兰式List:"+suffList);
		
		System.out.printf("result=%d",calculate(suffList));
		//int res = calculate(list);
		//System.out.println("结果是："+res);
	}
//将中缀表达式转成对应的List
	public static List<String> toInfixExpressionList(String s) {
		List<String>ls = new ArrayList<String>();
		int i = 0;
		String str;
		char c ; 
		do {
			//如果c是一个非数字 需要加入ls
			if ((c=s.charAt(i))<48||(c=s.charAt(i)  )>57) {
				ls.add(""+c);
				i++;
			}else {//是一个数字需要考虑多位数
				str = "";
			while(i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57) {
				str +=c;
				i++;
			}
			ls.add(str);
			} 
		}while(i<s.length());
		return ls;
	}
/**
 * 将得到的中缀表达式对应的List 转化为 -》后缀表达式对应的List
 * 
 */
public static List<String>parseSuffix(List<String>ls){
	//1.定义两个栈
	//s1符号栈
	Stack<String>s1 = new Stack<String>();
	//s2使用List
	List<String> s2 = new ArrayList<String>();
	for (String item : ls) {
		if (item.matches("\\d+")) {
			s2.add(item);
		}else if(item.equals("(")) {
			s1.push(item);
		}else if (item.equals(")")) {
			while (!s1.peek().equals("(")) {
				s2.add(s1.pop());
			}
			s1.pop();//将左括号弹出消除小括号
		}else {
			while (s1.size()!=0&&Operation.getValue(item)<=Operation.getValue(s1.peek())) {
				s2.add(s1.pop());
			}
			s1.push(item);
		}
	}
	while (s1.size()!=0) {
		s2.add(s1.pop());
	}
	//顺序输出后对应的就是逆波兰式List
	return s2;
	
}
	
	
/**
 * 
 * @param 放入一个逆波兰表达式
 * @return 返回按照字符分割后的list
 */
//	public static List<String>getListString(String suffString){
//		//将其分割
//		String[] split	= suffString.split(" ");
//		//list来装分割后的每个字符
//		List<String> list = new ArrayList<String>();
//		for (String string : split) {
//			list.add(string);
//		}
//			return list;
//	}

	
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
class Operation{
	private static int ADD =1;
	private static int SUB =1;
	private static int MUL =2;
	private static int DIV =2;
	//返回对应的优先级数字
	public static int getValue(String operString) {
		int result = 0;
		switch (operString) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			//System.out.println("No exist");
			break;
		}
		return result;
	}
}
