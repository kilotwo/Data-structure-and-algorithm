package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotionList_my {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//先定义逆波兰表达式
				//(30+4)*5-6 =》30 4 + 5 * 6 - =》164
				//4 * 5 - 8 + 60 +8/2 =>
				//4 5 * 8 -60 +8 2 /+
				//String sufString = "4 5 * 8 - 60 + 8 2 / +";
				
				//1.将中缀表达式(带两位数)字符串按照字符分割
				String midString = "4*5-8+60+8/2";
				//2.再将分割后字符放入List
				List<String> splitList = midtoList(midString);
				System.out.println("输入的原表达式:"+midString);
				System.out.println("中缀表达式List:"+splitList);
				//3.再将List转化为后缀表达式对应的List
				List<String> polanList = midtoPoList(splitList);
				System.out.println("逆波兰式List:"+polanList);
				//4.计算逆波兰式
				int result = calculate(polanList);
				System.out.println("最终结果:"+result);
	}
//将中缀表达式转成对应的List
	
	public static List<String> midtoList(String string) {
		List<String> sList = new ArrayList<String>();
		int i =0;
		char c;
		String s;
		
			do {
				
				//fuhao
				if (string.charAt(i)<48||string.charAt(i)>57) {
					sList.add(""+string.charAt(i));
					i++;
				//is  num
				}else {
					s = "";
				while (i<string.length()&&(string.charAt(i)>=48)&&(string.charAt(i)<=57)) {
					s += string.charAt(i);;
					i++;
					}
				sList.add(s);
				}
			} while (i<string.length());
			
			return  sList;
	}
	/**
	 * 将得到的中缀表达式对应的List 转化为 -》后缀表达式对应的List
	 * 
	 */
	public static List<String> midtoPoList(List<String> lStrings){
		
		Stack<String> s1 = new Stack<String>();
		List<String> s2 = new ArrayList<String>();
		for (String item : lStrings) {
			if (item.matches("\\d+")) {
				s2.add(item);
			}else if (item.equals("(")) {
				//左小括号压入s1
				s1.push(item);
			}else if (item.equals(")")) {
				//遇到右括号 开始弹出s1的运算符号 直到遇到(
				while (!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				//并将（ 丢弃
				s1.pop();//左括号弹出
			}else  {
				//当此时的优先级小于s1栈顶符 就先一直将s1弹出并放入s2
				while (s1.size()!=0&&Youxianji.getValue(item)<=Youxianji.getValue(s1.peek())) {
					s2.add(s1.pop());
				}
				//执行完后再将这个新符号放入s1
				s1.push(item);
			}
		}
		//最后将剩余s1中符号全部弹出 放入s2
		while (s1.size()!=0) {
			s2.add(s1.pop());
		}
			//最后返回 s2  List顺序输出 后缀表达式对应的List
			return s2;
	}
	/**
	 * 完成对逆波兰式的运算
	 *  
	 */
	public static int calculate(List<String> list) {
		int result = 0;
		int num1 = 0;
		int num2 = 0;
		Stack<String> stack = new Stack<String>();
		for (String item : list) {
			if (item.matches("\\d+")) {
				stack.push(item);
			}else {
				num2 = Integer.parseInt(stack.pop());
				num1 = Integer.parseInt(stack.pop());
				switch (item) {
				case "+":
					result = num1 + num2;
					break;
				case "-":
					result = num1 - num2;
					break;
				case "*":
					result = num1*num2;
					break;
				case "/":
					result = num1 / num2;
					break;
				default:
					break;
				}
				stack.push(result+"");
			}
			
		}
		return Integer.parseInt(stack.pop());
	}
	
}


//优先级
class Youxianji{
	private static int ADD = 1;
	private static int DEC = 1;
	private static int MUV = 2;
	private static int DIV = 2;
	
	public static int getValue(String s) {
			int result = 0 ;
		switch (s) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = DEC;
			break;
		case "*":
			result = MUV;
			break;
		case "/":
			result = DIV;
			break;
		default:
			break;
		}
			return result;
	}
	
}