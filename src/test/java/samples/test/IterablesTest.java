package samples.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import samples.Iterables;
import samples.Pair;

public class IterablesTest
{
	@Test
	public void test_enumerate_1 ()
	{
		final Long actual = Iterables.enumerate(Arrays.<String>asList(), 22L, Collectors.summingLong(Pair::getFirst));
		final Long expected = 0L;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_enumerate_2 ()
	{
		final Long actual = Iterables.enumerate(Arrays.<String>asList(null, null, null), 0L, Collectors.summingLong(Pair::getFirst));
		final Long expected = 0L + 1L + 2L;
		
		assertEquals(expected, actual);
	}
	
	@Test
	@SuppressWarnings("rawtypes")
	public void test_enumerate_3 ()
	{
		final List<? extends Pair<? extends Long, ? extends String>> input = Iterables.enumerate(Arrays.<String>asList(null, null, null), 0L, Collectors.toList());

		final Pair expectedFirstPair = Pair.of(0L, null);
		final Pair expectedSecondPair = Pair.of(1L, null);
		final Pair expectedThirdPair = Pair.of(2L, null);
		
		assertEquals(expectedFirstPair, input.get(0));
		assertEquals(expectedSecondPair, input.get(1));
		assertEquals(expectedThirdPair, input.get(2));
	}
	
	@Test
	@SuppressWarnings("rawtypes")
	public void test_enumerate_4 ()
	{
		final List<? extends Pair<? extends Long, ? extends String>> input = Iterables.enumerate(Arrays.<String>asList(null, null, "samples"));

		final Pair expectedFirstPair = Pair.of(0L, null);
		final Pair expectedSecondPair = Pair.of(1L, null);
		final Pair expectedThirdPair = Pair.of(2L, "samples");
		
		assertEquals(expectedFirstPair, input.get(0));
		assertEquals(expectedSecondPair, input.get(1));
		assertEquals(expectedThirdPair, input.get(2));
	}
	
	@Test
	@SuppressWarnings("rawtypes")
	public void test_enumerate_5 ()
	{
		final List<? extends Pair<? extends Long, ? extends String>> input = Iterables.enumerate(Arrays.<String>asList(null, null, "samples"), 2L);

		final Pair expectedFirstPair = Pair.of(2L, null);
		final Pair expectedSecondPair = Pair.of(3L, null);
		final Pair expectedThirdPair = Pair.of(4L, "samples");
		
		assertEquals(expectedFirstPair, input.get(0));
		assertEquals(expectedSecondPair, input.get(1));
		assertEquals(expectedThirdPair, input.get(2));
	}
}