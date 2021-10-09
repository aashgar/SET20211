package InterceptingFilter;

public class FilterManager {
	private FilterChain filterChain;


	public FilterManager(Target aTarget) {
		this.filterChain = new FilterChain();
                this.filterChain.setTarget(aTarget);
	}

	public void setFilter(Filter aFilter) {
		this.filterChain.addFilter(aFilter);
	}

	public String filterRequest(String aRequest) {
		return this.filterChain.execute(aRequest);
	}
}