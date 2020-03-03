package com.atguigu.sparsearray;

import java.util.Iterator;

public class SparseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个原始的二维数组 11*11
		//0：表示没有棋子 1：黑子 2：蓝子
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[3][4] = 2;
		//输出原始的二维数组
		System.out.println("原始的二维数组~~~");
		for (int[] row : chessArr1) {
			for (int data : row) {
				System.out.printf("%d\t",data);
				
			}
			System.out.println();
		}
		//讲二维数组 转 稀疏数组
		//1.先遍历二维数组 得到非0数据的个数
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if(chessArr1[i][j]!=0)
					sum++;
			}
		}
		//2.创建对应的稀疏数组
		//给稀疏数组赋值
		int spareArr[][] = new int[sum+1][3];
		spareArr[0][0]=11;
		spareArr[0][1]=11;
		spareArr[0][2]=sum;
		//遍历二维数组，讲非0的值存放到sparseArr中
		int count=0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j]!=0) {
					count++;
					spareArr[count][0] = i;
					spareArr[count][1] = j;
					spareArr[count][2] = chessArr1[i][j];
				}
			}
		}
		//输出稀疏数组的形式
		System.err.println();
		for (int i = 0; i < spareArr.length; i++) {
			System.out.printf("%d\t%d\t%d\n",spareArr[i][0],spareArr[i][1],spareArr[i][2]);
		}
		//将稀疏数组——》恢复成原始的二维数组
		//先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr2 = int [11][11]
			int chessAry2[][] = new int[spareArr[0][0]][spareArr[0][1]];
		//2.在读取稀疏数组后几行的数据，并赋给原始的二维数组既可以
			for (int i = 1; i < spareArr.length; i++) {
				chessAry2[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
			}
		
		//1.先读取稀疏数组的第一行，根据第一行的数据 创建原始的二维数组
		
		
		//2.再读取稀疏数组后几行的数据（从第二行开始)并赋给原始的二维数组即可
		
		
		//输出恢复后的二维数组
		System.out.println();
		System.out.println("恢复后的二维数组");
		for (int[] row : chessAry2) {
			for (int data : row) {
				System.out.printf("%d\t",data);
				
			}
			System.out.println();
		}
			
	}

}
