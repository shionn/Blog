package shionn.blog.logger;


import org.slf4j.Logger;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
@Configuration
public class LoggerFactory {

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST)
	public Logger logger(InjectionPoint point) {
		return logger(point.getMember().getDeclaringClass());
	}

	public Logger logger(Class<?> clazz) {
		return org.slf4j.LoggerFactory.getLogger(clazz.getName());
	}

}
