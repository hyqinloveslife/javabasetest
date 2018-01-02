package com.hyqin.map;

/**
 * 邻接矩阵模型类
 * 
 * @author hyqin
 *
 */
public class AMWGraph {
	public static void main(String[] args) {
		char[] vexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K' };
		char[][] edges = new char[][] { { 'A', 'C' }, 
										{ 'A', 'D' }, 
										{ 'A', 'F' }, 
										{ 'B', 'C' }, 
										{ 'C', 'D' },
										{ 'E', 'G' }, 
										{ 'D', 'G' }, 
										{ 'I', 'J' }, 
										{ 'J', 'G' }, };

		MatrixDG matrixDG = new MatrixDG(vexs, edges);

		matrixDG.print();
	}
}
