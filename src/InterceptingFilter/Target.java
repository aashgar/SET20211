package InterceptingFilter;

public class Target {
	public FilterChain _uses;

	public String execute(String aRequest) {
		return "Target Request: "+ aRequest;
	}
}