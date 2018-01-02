package com.hyqin.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * 哈夫曼树
 * @author hyqin
 *
 */
public class HaffManTree<T> {
	public static <T> Tree<T> createTree(List<Tree<T>> trees){
		while(trees.size()>1) {
			Collections.sort(trees);
			Tree<T> left = trees.get(trees.size()-1);
			Tree<T> right = trees.get(trees.size()-2);
			Tree<T> parent = new Tree<>(null,left.getWeight()+right.getWeight());
			
			parent.setLeft(left);
			parent.setRight(right);
			
			trees.remove(left);
			trees.remove(right);
			
			trees.add(parent);
		}
		return trees.get(0);
	}
	
	public static <T> List<Tree<T>> breadth(Tree<T> root){
		List<Tree<T>> list = new ArrayList<Tree<T>>();
		Queue<Tree<T>> queue = new ArrayDeque<>();
		if(root!=null) {
			queue.offer(root);
		}
		while(!queue.isEmpty()) {
			list.add(queue.peek());
			Tree<T> tree = queue.poll();
			
			if(tree.getLeft()!=null) {
				queue.offer(tree.getLeft());
			}
			
			if(tree.getRight()!=null) {
				queue.offer(tree.getRight());
			}
		}
		return list;
		
	}
	
	
}
