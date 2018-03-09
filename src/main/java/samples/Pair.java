package samples;

import java.util.Objects;
import java.util.Optional;

public abstract class Pair<F, S>
{
	public static <F, S> Pair<F, S> of (final F first, final S second)
	{
		return new DefaultPair<>(first, second);
	}
	
	public abstract F getFirst ();
	
	public abstract S getSecond ();
	
	@Override
	public boolean equals (final Object other)
	{
		if (other instanceof Pair)
		{
			@SuppressWarnings("rawtypes")
			final Pair otherPair = (Pair)other;
			
			return Objects.equals(getFirst(), otherPair.getFirst()) && Objects.equals(getSecond(), otherPair.getSecond());
		}
		
		return false;
	}

	@Override
	public int hashCode()
	{
		return 37 * (37 * 17 + Optional.ofNullable(getFirst()).map(Object::hashCode).orElse(1)) + Optional.ofNullable(getSecond()).map(Object::hashCode).orElse(1);
	}
}