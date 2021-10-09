package InterceptingFilter;

public class DebugFilter implements Filter {

	public String execute(String aRequest) {
		return "Debug Request: "+ aRequest;
	}
}