package samples;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Iterables
{
	public static <R> R count (double start, double step, BiPredicate<? super Double, ? super Long> takeWhile, Collector<? super Double, ?, ? extends R> collector)
	{
		final long[] mutableIndex = { 0L };
		
		return Stream.<Double>iterate(
			start,
			current -> takeWhile.test(current, mutableIndex[0]++),
			current -> current + step
		)
			.collect(collector)
		;
	}
	
	public static <R> R count (double start, double step, long count, Collector<? super Double, ?, ? extends R> collector)
	{
		return count(start, step, (element, index) -> index < count, collector);
	}
	
	public static List<Double> count (double start, double step, BiPredicate<? super Double, ? super Long> takeWhile)
	{
		return count(start, step, takeWhile, Collectors.toList());
	}
	
	public static List<Double> count (double start, double step, long count)
	{
		return count(start, step, count, Collectors.toList());
	}
	
	public static List<Double> count (double start, BiPredicate<? super Double, ? super Long> takeWhile)
	{
		return count(start, 1, takeWhile);
	}
	
	public static List<Double> count (double start, long count)
	{
		return count(start, 1, count);
	}
	
	public static List<Double> count (BiPredicate<? super Double, ? super Long> takeWhile)
	{
		return count(0, takeWhile);
	}
	
	public static List<Double> count (long count)
	{
		return count(0, count);
	}
}