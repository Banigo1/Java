package com.ratelsoft.tutorial;

import com.ratelsoft.tutorial.Network.Node;

public class Test {
	public static void main(String[] args){
		Network n = Network.getInstance();
		
		Node node = n.getSomeNode();
		Node rootNode = n.getRootNode(node);
		
		System.out.println(rootNode.getID());
		
		//another version
		while( node.getParentNode() != null ){
			node = node.getParentNode();
		}
		
		System.out.println(node.getID());
	}
}
