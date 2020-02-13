package de.openaqua.ipsc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.openaqua.ipsc.beans.SerialGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
public class JavaConfigTest {
	private SerialGenerator sg;

	@Autowired
	public void setSerialGenerator(final SerialGenerator sg) {
		this.sg = sg;
	}

	@Test
	public void noPrefix() throws Exception {
		assertEquals(sg.getNext(), "TEST40001");
		assertEquals(sg.getNext(), "TEST40002");
		assertEquals(sg.getNext(), "TEST40003");
		assertEquals(sg.getNext(), "TEST40004");
	}
}
