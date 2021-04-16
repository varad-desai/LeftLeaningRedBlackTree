package implementation;

import java.util.Stack;

/**
 * 
 * @author varad
 *
 */
public class LeftLeaningRedBlackTree {
	
	public Node root = null;
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public LeftLeaningRedBlackTree() {
    }
	
	public Node rotateLeft(Node current)
    {
        Node n = current.right;
        current.right = n.left;
        n.left = current;
        n.color = n.left.color;
        n.left.color = true;
        return n;
    }
	
	private Node rotateRight(Node current) {
        Node n = current.left;
        current.left = n.right;
        n.right = current;
        n.color = n.right.color;
        n.right.color = true;
        return n;
    }

    public boolean isRed(Node current)
    {
        if (current == null) return false;
        return (current.color == true);
    }

    private void flipColors(Node current) {
        current.color = !current.color;
        current.left.color = !current.left.color;
        current.right.color = !current.right.color;
    }
    
    public void put(Integer data) {
        if (data == null) throw new IllegalArgumentException("Null data cannot be entered");
        root = put(root, data);
        root.color = false;
    }

    private Node put(Node current, Integer data) { 
    	
        if (current == null) return new Node(data, true, 1);

        if      (data < current.data) current.left  = put(current.left, data); 
        else if (data > current.data) current.right = put(current.right, data); 
        else              current.data   = data;

        if (isRed(current.right) && !isRed(current.left))      current = rotateLeft(current);
        if (isRed(current.left)  &&  isRed(current.left.left)) current = rotateRight(current);
        if (isRed(current.left)  &&  isRed(current.right))     flipColors(current);
        return current;
    }


    public boolean search(Integer data) {
        if (data == null) throw new IllegalArgumentException("Null data cannot be found");
        return search(root, data);
    }

    private boolean search(Node x, Integer key) {
        while (x != null) {
            if      (key < x.data) x = x.left;
            else if (key > x.data) x = x.right;
            else if (key == x.data) return true;
        }
        return false;
    }
    
    public boolean check_if_red_node_exists() {
    	
    	if(root == null) return false;
    	Stack<Node> s = new Stack<Node>();
    	Node c = root;
    	int count = 0;
    	
    	while(c!=null || s.size()>0) {
    		while(c!=null) {
    			s.push(c);
    			c = c.left;
    		}
    		c = s.pop();
    		// System.out.println("c.color = "+c.color);
    		if(c.color) count++;
    		c = c.right;
    	}
    	
    	if(count>0) {
    		return true;
    	} else {
    		return false;
    	}
    	
    }
    
    public static void main(String[] args) {
    	LeftLeaningRedBlackTree llrb = new LeftLeaningRedBlackTree();
		
		int[] array = {9,7,8,6,5,4,3,2,1};
		for(int a:array) {
			System.out.println(a);
			llrb.put(a);
		}
		boolean result = llrb.search(15);
		System.out.println(result);
    	System.out.println(llrb.check_if_red_node_exists());
    	
    }
}
