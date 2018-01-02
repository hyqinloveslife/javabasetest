package com.hyqin.map;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树
 * @author hyqin
 *
 */
public class BinaryTree {
	/**
	 * 二叉树的节点数据结构 
	 */
	private class TreeNode{
		/**
		 * 序号
		 */
		private int key = 0;
		
		private String data = null;
		private boolean isVisited = false;
		
		private TreeNode leftChild = null;
		private TreeNode rightChild = null;
		
		public TreeNode() {}
		public TreeNode(int key,String data) {
			this.key = key;
			this.data = data;
			leftChild = null;
			rightChild = null;
		}
	}
	
	private TreeNode root = null;
	
	public BinaryTree() {
		root = new TreeNode(1, "root");
	}
	
	public void createBinTree(TreeNode node) {
		/**
		 * 				root
		 *           B        C
		 *        D    E          G
		 *     F              H
		 */
		TreeNode node1 = new TreeNode(2,"B");
		TreeNode node2 = new TreeNode(2,"C");
		TreeNode node3 = new TreeNode(2,"D");
		TreeNode node4 = new TreeNode(2,"E");
		TreeNode node5 = new TreeNode(2,"F");
		TreeNode node6 = new TreeNode(2,"G");
		TreeNode node7 = new TreeNode(2,"H");
		
		node1.leftChild = node3;
		node1.rightChild = node4;
		node2.rightChild = node6;
		node3.leftChild = node5;
		node6.leftChild = node7;
		
		root.leftChild = node1;
		root.rightChild = node2;
	}
	/**
	 * 判断节点是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return root ==null;
	}
	/**
	 * 树的高度
	 * @return
	 */
	public int height() {
		return height(root);
	}
	/**
	 * 计算二叉树节点的高度
	 * @param root2
	 * @return
	 */
	private int height(TreeNode subRoot) {
		if(subRoot==null) {
			return 0;
		}else {
			int i = height(subRoot.leftChild);
			int j = height(subRoot.rightChild);
			return (i<j)?(j+1):(i+1);
		}
	}

	/**
	 * 节点个数
	 * @return
	 */
	public int size() {
		return size(root);
	}
	/**
	 * 计算节点大小
	 * @param root2
	 * @return
	 */
	private int size(TreeNode subTree) {
		if(subTree==null) {
			return 0;
		}else {
			 return 1 + size(subTree.leftChild) + size(subTree.rightChild);
		}
	}
	
	//返回双亲结点
	public TreeNode parent(TreeNode element) {
		return (root==null||root==element)?null:parent(root,element);
	}

	private TreeNode parent(TreeNode subTree, TreeNode element) {
		if(subTree==null) {
			return null;
		}
		if(subTree.leftChild==element||subTree.rightChild==element) {
			 //返回父结点地址
			return subTree;
		}
		TreeNode p;
		//现在左子树中找，如果左子树中没有找到，才到右子树去找
		if((p=parent(subTree.leftChild, element))!=null) {
			//递归在左子树中搜索
			return p;
		}else {
			//递归在右子树中搜索
			return parent(subTree.rightChild, element);
		}
	}
	
	public TreeNode getLeftChildNode(TreeNode element) {
		return (element!=null)?element.leftChild:null;
	}
	
	public TreeNode getRightChildNode(TreeNode element) {
		return (element!=null)?element.rightChild:null;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	//在释放某个结点时，该结点的左右子树都已经释放，
    //所以应该采用后续遍历，当访问某个结点时将该结点的存储空间释放
	public void destroy(TreeNode subTree) {
		//删除根为subTree的子树
		if(subTree!=null) {
			destroy(subTree.leftChild);
			
			destroy(subTree.rightChild);
			
			subTree=null;
		}
	}
	
	public void traverse(TreeNode subTree) {
		System.out.println("key:"+subTree.key+"---name:"+subTree.data);
		traverse(subTree.leftChild);
		traverse(subTree.rightChild);
	}
	
	//先序遍历
	public void preOrder(TreeNode subTree) {
		if(subTree!=null) {
			visted(subTree);
			preOrder(subTree.leftChild);
			preOrder(subTree.rightChild);
		}
	}
	//中序遍历
	public void inOrder(TreeNode subTree) {
		if(subTree!=null) {
			inOrder(subTree.leftChild);
			visted(subTree);
			inOrder(subTree.rightChild);
		}
	}
	//后序遍历
	public void postOrder(TreeNode subTree) {
		if(subTree!=null) {
			postOrder(subTree.leftChild);
			postOrder(subTree.rightChild);
			visted(subTree);
		}
	}
	
	//前序遍历的非递归实现
	public void nonRecPreOrder(TreeNode p) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = p;
		while(node!=null||stack.size()>0) {
			while(node!=null) {
				visted(node);
				stack.push(node);
				node = node.leftChild;
			}
			while(stack.size()>0) {
				node = stack.pop();
				node = node.rightChild;
			}
		}
	}
	//中序遍历的非递归实现
    public void nonRecInOrder(TreeNode p){
        Stack<TreeNode> stack =new Stack<BinaryTree.TreeNode>();
        TreeNode node =p;
        while(node!=null||stack.size()>0){
            //存在左子树
            while(node!=null){
                stack.push(node);
                node=node.leftChild;
            }
            //栈非空
            if(stack.size()>0){
                node=stack.pop();
                visted(node);
                node=node.rightChild;
            }
        }
    }

    //后序遍历的非递归实现
    public void noRecPostOrder(TreeNode p){
        Stack<TreeNode> stack=new Stack<BinaryTree.TreeNode>();
        TreeNode node =p;
        while(p!=null){
            //左子树入栈
            for(;p.leftChild!=null;p=p.leftChild){
                stack.push(p);
            }
            //当前结点无右子树或右子树已经输出
            while(p!=null&&(p.rightChild==null||p.rightChild==node)){
                visted(p);
                //纪录上一个已输出结点
                node =p;
                if(stack.empty())
                    return;
                p=stack.pop();
            }
            //处理右子树
            stack.push(p);
            p=p.rightChild;
        }
    }

	public void visted(TreeNode subTree) {
		subTree.isVisited = true;
		System.out.println("key:" + subTree.key + "--name:" + subTree.data);
		
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinTree(bt.root);
		System.out.println("the size of the tree is " + bt.size());
		System.out.println("the height of the tree is " + bt.height());
		
		System.out.println("*******(前序遍历)[ABDECF]遍历*****************");
        bt.preOrder(bt.root);

        System.out.println("*******(中序遍历)[DBEACF]遍历*****************");
        bt.inOrder(bt.root);

        System.out.println("*******(后序遍历)[DEBFCA]遍历*****************");
        bt.postOrder(bt.root);

        System.out.println("***非递归实现****(前序遍历)[ABDECF]遍历*****************");
        bt.nonRecPreOrder(bt.root);

        System.out.println("***非递归实现****(中序遍历)[DBEACF]遍历*****************");
        bt.nonRecInOrder(bt.root);

        System.out.println("***非递归实现****(后序遍历)[DEBFCA]遍历*****************");
        bt.noRecPostOrder(bt.root);

      
	}
	
}
