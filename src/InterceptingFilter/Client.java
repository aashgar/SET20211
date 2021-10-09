package InterceptingFilter;

public class Client {
	private FilterManager filterManager;


	public Client(FilterManager aFilterManager) {
		this.filterManager= aFilterManager;
	}

	public String sendRequest(String aRequest) {
		return this.filterManager.filterRequest(aRequest);
	}
}