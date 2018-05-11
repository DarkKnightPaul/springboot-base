package top.huhuiyu.myspringboot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationHome;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.huhuiyu.myspringboot.entity.TbTest;
import top.huhuiyu.myspringboot.model.DemoModel;
import top.huhuiyu.myspringboot.service.DemoService;
import top.huhuiyu.myspringboot.util.ImageCode;
import top.huhuiyu.myspringboot.util.JsonMessage;

@RestController
public class DemoController {

  private static final Logger log = LoggerFactory.getLogger(DemoController.class);
  @Autowired
  private DemoService demoService;

  @RequestMapping("/")
  public String index() {
    return "我的SpringBoot演示!";
  }

  @RequestMapping("/demo/echo")
  @ResponseBody
  public JsonMessage echo(DemoModel model) {
    log.info("测试info");
    try {
      JsonMessage message = JsonMessage.getSuccessMessage("echo测试");
      message.getDataMap().put("test", model.getTest());
      message.getDataMap().put("page", model.getPage());
      log.debug("测试debug:" + (100 / model.getTest().getTid()));
      return message;
    } catch (Exception e) {
      return JsonMessage.getFailMessage(e);
    }
  }

  @RequestMapping("/demo/queryAll")
  @ResponseBody
  public JsonMessage queryAll(DemoModel model) {
    try {
      PageHelper.startPage(model.getPage().getPageNumber(), model.getPage().getPageSize());
      Page<TbTest> list = (Page<TbTest>) demoService.queryAll();
      JsonMessage message = JsonMessage.getSuccessMessage("查询成功");
      message.getDataMap().put("list", list);
      message.getDataMap().put("page", model.getPage().setPageInfo(list));
      return message;

    } catch (Exception e) {
      return JsonMessage.getFailMessage(e.getMessage());
    }
  }

  @RequestMapping("/demo/queryMapping")
  @ResponseBody
  public JsonMessage queryMapping(DemoModel model) {
    try {

      JsonMessage message = JsonMessage.getSuccessMessage("查询成功");
      message.getDataMap().put("list", demoService.queryMapping());
      return message;

    } catch (Exception e) {
      return JsonMessage.getFailMessage(e.getMessage());
    }
  }

  @RequestMapping("/demo/error")
  @ResponseBody
  public JsonMessage error(DemoModel model) {
    return JsonMessage.getSuccessMessage("获取tid：" + (model.getTest().getTid() / 100.1));
  }

  @RequestMapping("/demo/validate.jpg")
  public void validateCode(HttpServletResponse response) throws Exception {
    String code = ImageCode.makeCode(6);
    ImageIO.write(ImageCode.makeImage(code), "jpeg", response.getOutputStream());
  }

  private static final String UPLOAD = "/upload/";

  private static File getHomePath() {
    ApplicationHome home = new ApplicationHome(DemoController.class);
    File jarFile = home.getSource();
    return jarFile.getParentFile();
  }

  @RequestMapping("/demo/upload")
  @ResponseBody
  public JsonMessage upload(DemoModel model, MultipartFile file) throws Exception {
    if (file == null) {
      return JsonMessage.getFailMessage("请选择上传的文件");
    }
    JsonMessage message = JsonMessage.getSuccessMessage("上传成功");
    String filename = file.getOriginalFilename();
    File savefile = new File(getHomePath() + UPLOAD + filename);
    File savepath = savefile.getParentFile();
    if (!savepath.exists()) {
      savepath.mkdirs();
    }

    InputStream is = file.getInputStream();
    OutputStream os = new FileOutputStream(savefile);
    byte[] bytes = new byte[8 * 1024];
    int length = is.read(bytes);
    while (length > 0) {
      os.write(bytes, 0, length);
      os.flush();
      length = is.read(bytes);
    }
    os.close();
    is.close();

    message.putData("savepath", savefile.getAbsolutePath());
    message.putData("type", file.getContentType());
    message.putData("name", filename);
    message.putData("model", model);
    return message;
  }

}
