package com.hyqin.tree;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Tree<String>> list = new ArrayList<>();
		list.add(new Tree<String>("A",7));
		list.add(new Tree<String>("B",5));
		list.add(new Tree<String>("C",4));
		list.add(new Tree<String>("D",2));
		list.add(new Tree<String>("E",13));
		list.add(new Tree<String>("F",90));
		
		Tree<String> tree = HaffManTree.createTree(list);
		System.out.println(tree.toString());
	}
}
