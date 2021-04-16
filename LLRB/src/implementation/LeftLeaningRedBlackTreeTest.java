package implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.After;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * 
 * @author varad
 *
 */
class LeftLeaningRedBlackTreeTest {
	
	@Test
	public void test1_successfulSearch() {
		LeftLeaningRedBlackTree llrb = new LeftLeaningRedBlackTree();
		
		int[] array = {8,9,4,6,5,7,0,1,3,2};
		for(int a:array) {
			System.out.println(a);
			llrb.put(a);
		}
		boolean result = llrb.search(0);
		// System.out.println(result);
		assertEquals(true, result);
	}
	
	@Test
	public void test2_uncessfulSearch() {
		LeftLeaningRedBlackTree llrb = new LeftLeaningRedBlackTree();
		
		int[] arr = {8,9,4,6,5,7,0,1,3,2};
		for(int a:arr) {
			System.out.println(a);
			llrb.put(a);
		}
		boolean result = llrb.search(15);
		// System.out.println(result);
		assertEquals(false, result);

	}
	
	@Test
	public void test3_testLeftRotateFunction() {
		LeftLeaningRedBlackTree llrb = new LeftLeaningRedBlackTree();
		
		llrb.put(7);
		llrb.put(9);
		
		Node current = llrb.getRoot();
		Node current_left = current.left;
		
		// System.out.println("current.data "+ current.getData());
		// System.out.println("current.left.data "+ current_left.getData());
		
		assertEquals(7, current_left.data);
	}
	
	@Test
	public void test4_testRightRotateFunction() {
		LeftLeaningRedBlackTree llrb = null;
		llrb = new LeftLeaningRedBlackTree();
		
		llrb.put(9);
		llrb.put(7);
		llrb.put(5);
		
		Node current = llrb.getRoot();
		Node current_left = current.getLeft();
		Node current_right = current.getRight();
		
		// System.out.println("current.data "+ current.getData());
		// System.out.println("current.left.data "+ current_left.getData());
		// System.out.println("current.right.data "+ current_right.getData());
		
		assertEquals(7, current.getData());
		assertEquals(5, current_left.getData());
		assertEquals(9, current_right.getData());
	}
	
	@Test
	public void test5_testFlipColors() {
		LeftLeaningRedBlackTree llrb = null;
		llrb = new LeftLeaningRedBlackTree();
		
		llrb.put(9);
		llrb.put(7);
		llrb.put(11);
		
		Node current = llrb.getRoot();
		Node current_left = current.getLeft();
		Node current_right = current.getRight();
		
		// System.out.println("current.data "+ current.isColor());
		// System.out.println("current.left.data "+ current_left.isColor());
		// System.out.println("current.right.data "+ current_right.isColor());
		
		assertFalse(current.isColor());
		assertFalse(current_left.isColor());
		assertFalse(current_right.isColor());
	}
	
	@Test
	public void test6_RedLinkWhenElementsEnteredInRandomOrder(){
		LeftLeaningRedBlackTree llrb = new LeftLeaningRedBlackTree();
		Random random = new Random();
		for(int j=1; j<=255; j++) {
    		llrb.put(random.nextInt(256));
    	}
		boolean result4 = llrb.check_if_red_node_exists();
		// System.out.println("test4 = "+result4);
		assertEquals(true, result4);

	}
	
	@Test
	public void test7_noRedLinkWhenElementsEnteredInOrder(){
		LeftLeaningRedBlackTree llrb = new LeftLeaningRedBlackTree();
		
		for(int i=1; i<=255; i++) {
    		llrb.put(i);
    	}
		boolean result = llrb.check_if_red_node_exists();
		// System.out.println("test1 = "+result);
		assertFalse(result);

	}

}
