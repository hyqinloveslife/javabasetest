package com.hyqin.map;


public class MatrixDG {
	int size;
	char [] vertexs;
	int [][] matrix;
	
	public MatrixDG() {
		
	}
	
	public MatrixDG(char [] vertexs,char [][]edges) {
		size = vertexs.length;
		matrix = new int [size][size];
		this.vertexs = vertexs;
		
		 //和邻接矩阵无向图差别仅仅在这里
		for(char [] c:edges) {
			int p1 = getPosition(c[0]);
			int p2 = getPosition(c[1]);
			
			matrix[p1][p2] = 1;
		}
	}
	
	private int getPosition(char ch) {
		for (int i = 0; i < matrix.length; i++) {
			if(vertexs[i]==ch) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 打印
	 */
	public void print() {
		for (int[] is : matrix) {
			for (int i : is) {
				System.out.print(i+"  ");
			}
			System.out.println();
		}
	}
}
