package shionn.blog.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {

	@Autowired
	@Value("${img.source}")
	private String imgSourceFolder;

	@ResponseBody
	@RequestMapping(path = { "wp-content/uploads/{img:.*}.png",
			"img/{img:.*}.png" }, method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] png(@PathVariable("img") String imgName, @RequestParam(name = "w", defaultValue = "0") int w,
			@RequestParam(name = "h", defaultValue = "0") int h,
			@RequestParam(name = "crop", defaultValue = "false") boolean crop)
			throws IOException, IM4JavaException, InterruptedException {
		return read(imgName, w, h, crop, ".png");
	}

	@ResponseBody
	@RequestMapping(path = { "wp-content/uploads/{img:.*}.jpg",
			"img/{img:.*}.jpg" }, method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] jpeg(@PathVariable("img") String imgName, @RequestParam(name = "w", defaultValue = "0") int w,
			@RequestParam(name = "h", defaultValue = "0") int h,
			@RequestParam(name = "crop", defaultValue = "false") boolean crop)
			throws IOException, InterruptedException, IM4JavaException {
		return read(imgName, w, h, crop, ".jpg");
	}

	@ResponseBody
	@RequestMapping(path = { "wp-content/uploads/{img:.*}.bmp",
			"img/{img:.*}.bmp" }, method = RequestMethod.GET, produces = "image/bmp")
	public byte[] bmp(@PathVariable("img") String imgName, @RequestParam(name = "w", defaultValue = "0") int w,
			@RequestParam(name = "h", defaultValue = "0") int h,
			@RequestParam(name = "crop", defaultValue = "false") boolean crop)
			throws IOException, InterruptedException, IM4JavaException {
		return read(imgName, w, h, crop, ".bmp");
	}

	private byte[] read(String imgName, int w, int h, boolean crop, String ext)
			throws IOException, InterruptedException, IM4JavaException, FileNotFoundException {
		String wanted = imgSourceFolder + imgName + ext;
		if (w > 0 && h > 0) {
			wanted = imgSourceFolder + imgName + "-" + w + "-" + h + (crop ? "-crop" : "") + ext;
			if (!new File(wanted).exists()) {
				IMOperation op = new IMOperation();
				op.addImage(imgSourceFolder + imgName + ext);
				if (crop) {
					op.resize(w, h, "^").gravity("center").extent(w, h);
				} else {
					op.resize(w, h);
				}
				op.addImage(wanted);
				new ConvertCmd().run(op);
			}
		}
		try (FileInputStream is = new FileInputStream(new File(wanted))) {
			return IOUtils.toByteArray(is);
		}
	}

}
