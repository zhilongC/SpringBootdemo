package tech.mrcao.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.mrcao.demo.beans.ArticleThObj;
import tech.mrcao.demo.model.Article;
import tech.mrcao.demo.service.ArticleService;
import tech.mrcao.demo.utils.UUIDUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);;
    @Autowired
    private ArticleService articleService;
    @GetMapping("/")
    public ModelAndView  index(ModelAndView model){
        model.setViewName("index");
        List<Map<String, Object>> artArray = new ArrayList<Map<String, Object>>();
        List<Article> arr = articleService.findByCreateId("0e50744a33534d5881a382b86f84082d");
        for(Article attr : arr) {
            Map<String, Object> obj = new HashMap<String, Object>();
            obj.put("title", attr.getTitle());
            obj.put("content",attr.getSummary());
            obj.put("updateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(attr.getUpdateTime()));
            obj.put("showPic", "<img src=\""+attr.getPictureContent() + "\" alt=\"\">");
            artArray.add(obj);
        }
        model.addObject("thEach", artArray);
        return model;
    }

    @GetMapping("/about.html")
    public String about()
    {
        return "about";
    }

    @GetMapping("/index.html")
    public ModelAndView toindex(ModelAndView model)
    {
        return index(model);
    }

    @GetMapping("/message.html")
    public String message(){
        return "message";
    }

    @GetMapping("/comment.html")
    public String comment(){
        return "comment";
    }

    @GetMapping("/details.html")
    public String details(){
        return "details";
    }

    @GetMapping("/error")
    public String to404(){
        return "404";
    }

    @GetMapping(value = "/msg", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String getData(@RequestParam("json") String json) {
        LOGGER.debug("[@@@@@getData->request@@@@@]json: {}", json);
        return json;
    }
}