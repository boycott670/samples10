package samples.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import samples.Iterables;

public class IterablesTest
{
	@Test
	public void test_count_1 ()
	{
		final double sum = Iterables.count(0D, 1D, (element, index) -> element < 5, Collectors.summingDouble(element -> element));
		final double expectedSum = 0 + 1 + 2 + 3 + 4;
		
		assertEquals(expectedSum, sum, 0);
	}
	
	@Test
	public void test_count_2 ()
	{
		final List<Double> entries = Iterables.count(2D, 3D, 2, Collectors.toList());
		
		assertNotNull(entries);
		
		assertEquals(2, entries.size());
		
		assertArrayEquals(new Double[] { 2D, 5D }, entries.toArray(new Double[2]));
	}
	
	@Test
	public void test_count_3 ()
	{
		final List<Double> entries = Iterables.count(3L);
		
		assertArrayEquals(new Double[] {0D, 1D, 2D}, entries.toArray(new Double[3]));
	}
}