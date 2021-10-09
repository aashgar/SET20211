package InterceptingFilter;

public class AuthenticationFilter implements Filter {

	public String execute(String aRequest) {
		return "Authentication Request: "+ aRequest;
	}
}