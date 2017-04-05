package shionn.blog.adm.completion;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import shionn.blog.db.dao.adm.CategoryAdmDao;
import shionn.blog.db.dbo.Category;

@RestController
@RequestScope
public class CompletionController {
	@Autowired
	private SqlSession session;
	@Autowired
	@Value("${img.source}")
	private String imgSourceFolder;

	@RequestMapping(value = "/adm/autocomplete/cat", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<Category> categoryAutoComplete(@RequestParam("term") String term) {
		return session.getMapper(CategoryAdmDao.class).find("%" + term + "%");
	}

	@RequestMapping(value = "/adm/autocomplete/img", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public String[] categoryAutoImg(@RequestParam("term") String term) {
		return new File(imgSourceFolder).list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.contains(term) && name.contains(".");
			}
		});
	}

}
