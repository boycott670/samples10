package samples;

final class DefaultPair<F, S> extends Pair<F, S>
{
	private final F first;
	private final S second;
	
	public DefaultPair(final F first, final S second)
	{
		this.first = first;
		this.second = second;
	}
	
	@Override
	public F getFirst()
	{
		return first;
	}

	@Override
	public S getSecond()
	{
		return second;
	}
}