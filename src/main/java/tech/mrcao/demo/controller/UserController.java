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
import tech.mrcao.demo.model.Comment;
import tech.mrcao.demo.model.Message;
import tech.mrcao.demo.service.ArticleService;
import tech.mrcao.demo.service.CommentService;
import tech.mrcao.demo.service.MessageService;
import tech.mrcao.demo.utils.UUIDUtils;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {

    private static final String GUESTID = "394509bc34354ad99b2909ed0258efd1";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public ModelAndView  index(ModelAndView model){
        model.setViewName("index");
//        List<Map<String, Object>> artArray = new ArrayList<Map<String, Object>>();
//        List<Article> arr = articleService.findByCreateId("0e50744a33534d5881a382b86f84082d");
//        for(Article attr : arr) {
//            Map<String, Object> obj = new HashMap<String, Object>();
//            obj.put("title", attr.getTitle());
//            obj.put("content",attr.getSummary());
//            obj.put("updateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(attr.getUpdateTime()));
//            obj.put("showPic", "<img src=\""+attr.getPictureContent() + "\" alt=\"\">");
////            obj.put("showPic", attr.getPictureContent());
//            artArray.add(obj);
//        };
//        model.addObject("thEach", artArray);
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
    public ModelAndView message(ModelAndView model){
        model.setViewName("message");
        List<Map<String, Object>> artArray = new ArrayList<Map<String, Object>>();
        List<Message> arr = messageService.findAllMsg();
        for(Message attr : arr) {
            Map<String, Object> obj = new HashMap<String, Object>();
            obj.put("photoUrl", "images/info-img.png");
            obj.put("nickName", "guest");
            obj.put("likeNum", "5万");
            obj.put("msgContent", attr.getMessageContent());
            artArray.add(obj);
        };
        model.addObject("thEach", artArray);
        return model;
    }

//    @GetMapping("/comment.html")
//    public String comment(){
//        return "comment";
//    }

    @GetMapping("/details.html")
    public ModelAndView details(ModelAndView model){
        model.setViewName("details");

        Article article = articleService.findByArticleID("4dfc7937f4794c7793527aa9c23e778b");
        model.addObject("title", article.getTitle());
        model.addObject("updateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getUpdateTime()));
        model.addObject("content", article.getContent());
        model.addObject("showPic", "<img src=\""+article.getPictureContent() + "\" alt=\"\">");
        model.addObject("readTimes", "10000");
        model.addObject("likeTimes", "999");

        List<Map<String, Object>> artArray = new ArrayList<Map<String, Object>>();
        List<Comment> arr = commentService.findAllMsg();
        for(Comment attr : arr) {
            Map<String, Object> obj = new HashMap<String, Object>();
            obj.put("photoUrl", "images/info-img.png");
            obj.put("nickName", "guest");
            obj.put("likeNum", "5万");
            obj.put("msgContent", attr.getCommentContent());
            artArray.add(obj);
        };
        model.addObject("thEach", artArray);
        return model;
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

    @PostMapping(value = "/message", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ModelAndView messageSubmit(@RequestParam(value = "msgContent") String messageContent, ModelAndView model){
        messageService.insertMsgContent(GUESTID, messageContent);

        model.setViewName("message.html");
        List<Map<String, Object>> artArray = new ArrayList<Map<String, Object>>();
        List<Message> arr = messageService.findAllMsg();
        for(Message attr : arr) {
            Map<String, Object> obj = new HashMap<String, Object>();
            obj.put("photoUrl", "images/info-img.png");
            obj.put("nickName", "guest");
            obj.put("likeNum", "5万");
            obj.put("msgContent", attr.getMessageContent());
            artArray.add(obj);
        };
        model.addObject("thEach", artArray);
        return model;
    }

    @PostMapping(value = "/comment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ModelAndView commentSubmit(@RequestParam(value = "commentContent") String commentContent, ModelAndView model){
        commentService.insertMsgContent(GUESTID, "4dfc7937f4794c7793527aa9c23e778b", commentContent);

        model.setViewName("details.html");

        Article article = articleService.findByArticleID("4dfc7937f4794c7793527aa9c23e778b");
        model.addObject("title", article.getTitle());
        model.addObject("updateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getUpdateTime()));
        model.addObject("content", article.getContent());
        model.addObject("showPic", "<img src=\""+article.getPictureContent() + "\" alt=\"\">");
        model.addObject("readTimes", "10000");
        model.addObject("likeTimes", "999");

        List<Map<String, Object>> artArray = new ArrayList<Map<String, Object>>();
        List<Comment> arr = commentService.findAllMsg();
        for(Comment attr : arr) {
            Map<String, Object> obj = new HashMap<String, Object>();
            obj.put("photoUrl", "images/info-img.png");
            obj.put("nickName", "guest");
            obj.put("likeNum", "5万");
            obj.put("msgContent", attr.getCommentContent());
            artArray.add(obj);
        };
        model.addObject("thEach", artArray);

        return model;
    }
}