/**
 * 
 */
package net.codejava;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/**
 * @author loren
 *
 */
class BinarySearchTreeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link BinarySearchTree#add(Association)}.
	 */
	@Test
	void testAdd() {
		BinarySearchTree bTree = new BinarySearchTree<>();
		Association<String,String> a = new Association("dog","perro");
		Association<String,String> b = new Association("house","casa");
	/** No es posible implementar el test ya que el método Add del BinarySearchTree 
	 * implementado es un método void
	 * */
	 
		

		
	}

	/**
	 * Test method for {@link BinarySearchTree#traverseInOrder(BinarySearchTree.TNode, java.util.List)}.
	 */
	@Test
	void testTraverseInOrder() {
		BinarySearchTree bTree = new BinarySearchTree<>();
		Association<String,String> a = new Association("dog","perro");
		Association<String,String> b = new Association("house","casa");
		ArrayList<Association<String, String>> inOrder = new ArrayList<Association<String, String>>();
		ArrayList<Association<String, String>> inOrder2 = new ArrayList<Association<String, String>>();
		bTree.add(b);
		bTree.add(a);
		bTree.traverseInOrder(bTree.getRoot(),inOrder);
		inOrder2.add(a);
		inOrder2.add(b);
		assertEquals(inOrder2,inOrder);

		
	}

}
