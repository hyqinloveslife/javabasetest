package com.hyqin.tree;

public class Tree<T> implements Comparable<Tree<T>> {
	private T data;
	private double weight;
	private Tree<T> left;
	private Tree<T> right;
	
	public Tree() {
		
	}

	public Tree(T data,double weight) {
		this.data = data;
		this.weight = weight;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Tree<T> getLeft() {
		return left;
	}

	public void setLeft(Tree<T> left) {
		this.left = left;
	}

	public Tree<T> getRight() {
		return right;
	}

	public void setRight(Tree<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Tree [data=" + data + ", weight=" + weight + ", left=" + left + ", right=" + right + "]";
	}

	@Override
	public int compareTo(Tree<T> o) {
		if(o.getWeight()>this.getWeight())
			return 1;
		if(o.getWeight()<this.getWeight())
			return -1;
		return 0;
	}
	
}
