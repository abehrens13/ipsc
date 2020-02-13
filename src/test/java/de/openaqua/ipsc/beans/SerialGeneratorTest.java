package de.openaqua.ipsc.beans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;



@RunWith(SpringRunner.class)
public class SerialGeneratorTest {

	
	@Test
	public void noPrefix() throws Exception {
		SerialGenerator sg = new SerialGenerator();
		assertEquals(sg.getNumber(), 0);
		assertEquals(sg.getNext(), "1");
		
		assertEquals(sg.getNumber(), 1);
		assertEquals(sg.getNext(), "2");
		
		assertEquals(sg.getNumber(), 2);
		assertEquals(sg.getNext(), "3");

		assertEquals(sg.getNumber(), 3);
		sg.setNumber(1);
		assertEquals(sg.getNumber(), 1);
		assertEquals(sg.getNext(), "2");
		
		assertEquals(sg.getPrefix(), "");
		

	}

	@Test
	public void withPrefix() throws Exception {
		SerialGenerator sg = new SerialGenerator("ABC", 4000);
		assertEquals(sg.getNumber(), 4000);
		assertEquals(sg.getNext(), "ABC4001");
		
		assertEquals(sg.getNumber(), 4001);
		assertEquals(sg.getNext(), "ABC4002");
		
		assertEquals(sg.getNumber(), 4002);
		assertEquals(sg.getNext(), "ABC4003");

		assertEquals(sg.getNumber(), 4003);
		sg.setNumber(1);
		assertEquals(sg.getNumber(), 1);
		assertEquals(sg.getNext(), "ABC2");
		
		assertEquals(sg.getPrefix(), "ABC");
		
	}

}
