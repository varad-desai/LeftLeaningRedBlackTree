/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

/**
 *
 * @author varad
 */
public class Node {
    
    Node left;
    Node right;
    boolean color = false; // Red = true; Black = false
    int data;
    
    Node(int value, boolean color, int size){
        this.data = value;
        this.color = color;
    }

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
    
}
