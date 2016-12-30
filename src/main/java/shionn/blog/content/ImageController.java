package shionn.blog.content;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImageController {

	@Autowired
	@Value("${img.source}")
	private String imgSourceFolder;

	@RequestMapping(path = { "wp-content/uploads/{img:.*}.png", "img/{img:.*}.png" }, method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public Object png(@PathParam("img") String imgName) {
		return null;
	}

	@RequestMapping(path = { "wp-content/uploads/{img:.*}.jpg", "img/{img:.*}.jpg" }, method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public Object jpeg(@PathParam("img") String imgName) {
		return null;
	}

}
