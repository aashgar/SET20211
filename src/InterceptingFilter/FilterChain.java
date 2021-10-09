package InterceptingFilter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
	private List<Filter> filters = new ArrayList<>();
	private Target target;

	public void addFilter(Filter aFilter) {
		this.filters.add(aFilter);
	}

	public void setTarget(Target aTarget) {
		this.target = aTarget;
	}

	public String execute(String aRequest) {
		String output="";
                for(Filter filter: filters)
                    output+= filter.execute(aRequest)+"\n";
                
                output+= target.execute(aRequest)+"\n";
              return output;
	}
}