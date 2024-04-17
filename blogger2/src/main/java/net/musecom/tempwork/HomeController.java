package net.musecom.tempwork;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.musecom.tempwork.dao.BloggerDao;
import net.musecom.tempwork.model.BloggerDto;


@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   @Autowired
   private BloggerDao bloggerDao;

   @RequestMapping("/")
   public String home(Locale locale, Model model) throws IOException {
      logger.info("Welcome home! The client locale is {}.", locale);
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);   
      String formattedDate = dateFormat.format(date);
      
      List<BloggerDto> listboard = bloggerDao.read();
      model.addAttribute("listboard", listboard);   
      model.addAttribute("serverTime", formattedDate );
      return "home";
   }
   

   @RequestMapping("list")
   public String list(Locale locale, 
		              Model model, 
		              @RequestParam(value="msg", required=false) String msg)  //담음msg
		        throws IOException {
      logger.info("Welcome home! The client locale is {}.", locale);
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);   
      String formattedDate = dateFormat.format(date);
      
      List<BloggerDto> listboard = bloggerDao.read();
      if(msg != null) {
    	  model.addAttribute("msg", msg);
      }
      model.addAttribute("listboard", listboard);   
      model.addAttribute("serverTime", formattedDate );
      return "home";
   }
   
   @RequestMapping("content")
   public String content(HttpServletRequest request, Model model) {
	   System.out.println("content()실행됨");
	   int id = Integer.parseInt(request.getParameter("id"));
	   BloggerDto dto = bloggerDao.findStudentById(id);
	   model.addAttribute("dto",dto);
	   return "content";
   }
   
   
   @RequestMapping("insert")
   public String insert() {
      System.out.println("insert()실행");
      return "insert";
   }
   
  
 
   
   @RequestMapping(value="insertok", method=RequestMethod.POST)// 내용을 치면ㅇ ㅕ기로감
   public String insertok(
         @RequestParam("title") String title, 
         @RequestParam("content") String content,   //내용담음
        
         Model model) 
   {
      System.out.println("insertOk()실행");
      
       BloggerDto dto = new BloggerDto(); // 크리에이터만듬
       dto.setTitle(title);
       dto.setContent(content);
      
       
       int rs = bloggerDao.create(dto);
       if(rs > 0) {
          model.addAttribute("msg", "새로운 글을추가했습니다.");
       }else {
          model.addAttribute("msg", "새로운 글추가하는데 실패했습니다.");
       }
       
      return "redirect:list";
   }
   @RequestMapping("update")
   public String update(HttpServletRequest request, Model model) {
	   System.out.println("update()실행됨");
	   int id = Integer.parseInt(request.getParameter("id"));
	   BloggerDto dto = bloggerDao.findStudentById(id);
	   model.addAttribute("dto",dto);
	   return "update";
   }
   
	@RequestMapping(value="updateok", method=RequestMethod.POST)
	 public String updateok(
			 
			  @RequestParam("id") String id,
			  @RequestParam("title") String title, 
		      @RequestParam("content") String content,   //내용담음
		    
	         
	         Model model) {
			 
		BloggerDto dto = new BloggerDto();
		   dto.setId(Integer.parseInt(id));
	       dto.setTitle(title);
	       dto.setContent(content);
	       
	       
		int rs = bloggerDao.update(dto);
	     if(rs > 0) {
		          model.addAttribute("msg", "수정햇씁니다.");
		       }else {
		          model.addAttribute("msg", "수정에 실패했슴니다.");
		       }
		
		return "redirect:list";
	}
	
   @RequestMapping("delete")
   public String delete(HttpServletRequest request, Model model) {
	   System.out.println("delete()완료");
	   int id = Integer.parseInt(request.getParameter("id"));
	   int rs = bloggerDao.delete(id);
	    if(rs > 0) {
	          model.addAttribute("msg", "삭제했습니다.");
	       }else {
	          model.addAttribute("msg", "삭제에 실패했습니다..");
	       }
	
	   return "redirect:list";
   }
   
 		
   }
   

 

