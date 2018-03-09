package samples;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public final class Iterables
{
	public static <T> List<Pair<Long, T>> enumerate (final Iterable<? extends T> source)
	{
		return enumerate(source, 0L);
	}
	
	public static <T> List<Pair<Long, T>> enumerate (final Iterable<? extends T> source, final long start)
	{
		return enumerate(source, start, Collectors.toList());
	}
	
	public static <T, R> R enumerate (final Iterable<? extends T> source, final long start, final Collector<Pair<Long, T>, ?, R> collector)
	{
		final Long[] startIndex = { start };
		
		return StreamSupport.stream(source.spliterator(), false)
			.map(element -> new DefaultPair<Long, T>(startIndex[0]++, element))
			.collect(collector)
		;
	}
}