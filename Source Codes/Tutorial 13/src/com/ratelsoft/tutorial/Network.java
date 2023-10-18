package com.ratelsoft.tutorial;

import java.util.ArrayList;

public class Network {
	
	private static Network network = null;
	private Node someNode;
	
	private Network(){
		createNodes();
	}
	
	private void createNodes(){
		int pos = 1;
		Node rootNode = new Node(null, pos++);
		Node firstChildNode = new Node(rootNode, pos++);
		Node node1 = new Node(firstChildNode, pos++);
		Node node2 = new Node(firstChildNode, pos++);
		Node node3 = new Node(node1, pos++);
		Node node4 = new Node(node1, pos++);
		Node node5 = new Node(node1, pos++);
		Node node6 = new Node(node5, pos++);
		Node node7 = new Node(node5, pos++);
		Node node8 = new Node(node7, pos++);
		Node node9 = new Node(node8, pos++);
		someNode = node9;
	}
	
	public Node getSomeNode(){
		return someNode;
	}
	
	public Node getRootNode(Node node){
		Node n = null;
		
		if( node.getParentNode() == null )
			n = node;
		else{
			n = getRootNode(node.getParentNode());
		}
		return n;
	}
	
	public static Network getInstance(){
		if( network == null ){
			network = new Network();
		}
		
		return network;
	}
	
	
	public class Node{
		private Node parentNode;
		private int nodeID;
		private ArrayList<Node> children;
		
		public Node(Node parent, int id){
			parentNode = parent;
			nodeID = id;
			
			children = new ArrayList<Node>();
			
			if( parent != null )
				parent.addChild(this);
		}
		
		private void addChild(Node child){
			children.add(child);
		}
		
		public Node getParentNode(){
			return parentNode;
		}
		
		public int getID(){
			return nodeID;
		}
	}
}
