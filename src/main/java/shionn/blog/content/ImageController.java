package shionn.blog.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {

	@Autowired
	@Value("${img.source}")
	private String imgSourceFolder;

	@ResponseBody
	@RequestMapping(path = { "wp-content/uploads/{img:.*}.png", "img/{img:.*}.png" }, method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] png(@PathVariable("img") String imgName) throws IOException {
		try (FileInputStream is = new FileInputStream(new File(imgSourceFolder + imgName + ".png"))) {
			return IOUtils.toByteArray(is);
		}
	}

	@RequestMapping(path = { "wp-content/uploads/{img:.*}.jpg", "img/{img:.*}.jpg" }, method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public Object jpeg(@PathVariable("img") String imgName) {
		return null;
	}

}
