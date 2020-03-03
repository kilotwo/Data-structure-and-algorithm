package com.atguigu.sparsearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class SparseArray_my {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个原始的二维数组 11*11
		//0：表示没有棋子 1：黑子 2：蓝子
		int chessAry[][] = new int[11][11];
		chessAry[1][2] = 1;
		chessAry[2][3] = 2;
		chessAry[3][4] = 2;
		//输出原始的二维数组
		for (int[] row : chessAry) {
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
					if (chessAry[i][j]!=0) {
						sum ++;
					}
				}
			}
		//2.创建对应的稀疏数组
			int sparseArr[][] = new int[sum+1][3];
			sparseArr[0][0]=11;
			sparseArr[0][1]=11;
			sparseArr[0][2]=sum;
		//给稀疏数组赋值
		//遍历二维数组，讲非0的值存放到sparseArr中
			int count = 0;
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					if (chessAry[i][j]!=0) {
						count++;
						sparseArr[count][0]=i;
						sparseArr[count][1]=j;
						sparseArr[count][2]=chessAry[i][j];
					}
				}
			}
		//输出稀疏数组到文件
			System.out.println();
			for (int i = 0; i < sparseArr.length; i++) {
				System.out.printf("%d\t%d\t%d", sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
				System.out.println();
			}
			try {
				File file = new File("test.txt");
				FileWriter outFileWriter = new FileWriter(file);
				for (int i = 0; i < sparseArr.length; i++) {
					//System.out.printf("%d\t%d\t%d", sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
					outFileWriter.write(sparseArr[i][0] +"\t"+ sparseArr[i][1] +"\t"+ sparseArr[i][2] + "\t");
					outFileWriter.write("\n");
					//System.out.println();
				}
				outFileWriter.close();
			} catch (Exception e) {

				System.out.println(e.toString());
			}
			
			System.out.println("此处读进来的文件");
			
			try {
				
				FileReader fileReader = new FileReader("test.txt");
				BufferedReader bReader = new BufferedReader(fileReader);
				//读取第一行
			
				String line = null;
			
				int flag = 0;
				String[] sp = new String[20];
				
				while((line=bReader.readLine())!=null) {
					sp[flag]=line;
					flag++;	
				}
				//自制稀疏矩阵
				int sparse2[][]=new int[flag][3];
					for (int i = 0; i < flag; i++) {
						String[] string = sp[i].split("\t");
						sparse2[i][0] = Integer.parseInt(string[0]);
						sparse2[i][1] = Integer.parseInt(string[1]);
						sparse2[i][2] = Integer.parseInt(string[2]);
					}
////					System.out.println();
//				}
					System.out.println("输出自制稀疏矩阵");
					for (int i = 0; i < sparse2.length; i++) {
						System.out.printf("%d\t%d\t%d", sparse2[i][0],sparse2[i][1],sparse2[i][2]);
						System.out.println();
					}
					bReader.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
			}
			
			
			
			
			System.out.println("---------------");
		//将稀疏数组——》恢复成原始的二维数组
		//先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr2 = int [11][11]
		int  chessArry2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

		
		//2.再读取稀疏数组后几行的数据（从第二行开始)并赋给原始的二维数组即可
			for (int i = 1; i < sparseArr.length; i++) {
			chessArry2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
			System.out.println();
		//输出恢复后的二维数组
			for (int[] row : chessArry2) {
				for (int data : row) {
					System.out.printf("%d\t",data);
				}
				System.out.println();
			}
	}

}
