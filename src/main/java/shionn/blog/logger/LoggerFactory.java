package shionn.blog.logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
public class LoggerFactory {

	@Produces
	public Logger logger(InjectionPoint point) {
		return logger(point.getMember().getDeclaringClass());
	}

	public Logger logger(Class<?> clazz) {
		return org.slf4j.LoggerFactory.getLogger(clazz.getName());
	}

}
