import static org.junit.Assert.*;
import edu.princeton.cs.introcs.In;
import org.junit.Test;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class TestArrayDequeGold {
	@Test
	public void testArrayDeque() {
		StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
		ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

		//addFirst
		for (int i = 0; i < 10; i++) {
			int random = StdRandom.uniform(100);
			sad.addFirst(random);
			ads.addFirst(random);
		}
		for (int i = 0; i < 10; i++) {
			int actual = sad.get(i);
			int expected = ads.get(i);
			assertEquals("Oh noooo!\nThis is bad in addFirst():\n   Random number " + actual
							+ " not equal to " + expected + "!",
					expected, actual);
		}

		//addLast
		for (int i = 0; i < 10; i++) {
			int random = StdRandom.uniform(100);
			sad.addLast(random);
			ads.addLast(random);
		}
		for (int i = 0; i < 10; i++) {
			int actual = sad.get(i);
			int expected = ads.get(i);
			assertEquals("Oh noooo!\nThis is bad in addLast():\n   Random number " + actual
							+ " not equal to " + expected + "!",
					expected, actual);
		}

		//removeFirst
		List<Integer> actualList1 = new ArrayList<>();
		List<Integer> expectedList1 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			actualList1.add(sad.removeFirst());
			expectedList1.add(ads.removeFirst());
		}
		for (int i = 0; i < 10; i++) {
			int actual = actualList1.get(i);
			int expected = expectedList1.get(i);
			assertEquals("Oh noooo!\nThis is bad in removeFirst():\n   Random number " + actual
							+ " not equal to " + expected + "!",
					expected, actual);
		}
		for (int i = 0; i < 10; i++) {
			int actual = sad.get(i);
			int expected = ads.get(i);
			assertEquals("Oh noooo!\nThis is bad in removeFirst():\n   Random number " + actual
							+ " not equal to " + expected + "!",
					expected, actual);
		}

		//removeLast
		List<Integer> actualList2 = new ArrayList<>();
		List<Integer> expectedList2 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			actualList2.add(sad.removeLast());
			expectedList2.add(ads.removeLast());
		}
		for (int i = 0; i < 10; i++) {
			int actual = actualList2.get(i);
			int expected = expectedList2.get(i);
			assertEquals("Oh noooo!\nThis is bad in removeLast():\n   Random number " + actual
							+ " not equal to " + expected + "!",
					expected, actual);
		}
		for (int i = 0; i < 10; i++) {
			int actual = sad.get(i);
			int expected = ads.get(i);
			assertEquals("Oh noooo!\nThis is bad in removeLast():\n   Random number " + actual
							+ " not equal to " + expected + "!",
					expected, actual);
		}

	}
}
