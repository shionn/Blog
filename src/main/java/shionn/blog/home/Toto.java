package shionn.blog.home;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request")
public class Toto {

	private String a = "" + System.currentTimeMillis();

	public String getA() {
		return a;
	}

}
