package panda.benchmark.lang;

import java.util.Set;

import org.junit.Test;

import panda.lang.Classes;

public class ClassesTest {
	@Test
	public void testGetAllClasses() {
		Set<String> cs = Classes.getAllClasses();
		for (String c : cs) {
			System.out.println(c);
		}
	}
}
