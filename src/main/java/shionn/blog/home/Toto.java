package shionn.blog.home;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Toto {

	private String a = "" + System.currentTimeMillis();

	public String getA() {
		return a;
	}

}
