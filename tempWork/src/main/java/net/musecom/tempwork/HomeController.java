package net.musecom.tempwork;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.musecom.tempwork.dao.StudentDao;
import net.musecom.tempwork.model.StudentDto;


@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   @Autowired
   private StudentDao studentDao;

   @RequestMapping("/")
   public String home(Locale locale, Model model) throws IOException {
      logger.info("Welcome home! The client locale is {}.", locale);
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);   
      String formattedDate = dateFormat.format(date);
      
      List<StudentDto> listStudent = studentDao.read();
      model.addAttribute("listStudent", listStudent);   
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
      
      List<StudentDto> listStudent = studentDao.read();
      if(msg != null) {
    	  model.addAttribute("msg", msg);
      }
      model.addAttribute("listStudent", listStudent);   
      model.addAttribute("serverTime", formattedDate );
      return "home";
   }
   
   @RequestMapping("insert")
   public String insert() {
      System.out.println("insert()실행");
      return "insert";
   }
   
   @RequestMapping(value="insertok", method=RequestMethod.POST)// 내용을 치면ㅇ ㅕ기로감
   public String insertok(
         @RequestParam("name") String name, 
         @RequestParam("email") String email,   //내용담음
         @RequestParam("course") String course, 
         Model model) 
   {
      System.out.println("insertOk()실행");
      
       StudentDto dto = new StudentDto(); // 크리에이터만듬
       dto.setStu_name(name);
       dto.setStu_email(email);
       dto.setStu_course(course);
       
       int rs = studentDao.create(dto);
       if(rs > 0) {
          model.addAttribute("msg", "새로운 학생을 추가했습니다.");
       }else {
          model.addAttribute("msg", "새로운 학생을 추가하는데 실패했습니다.");
       }
       
      return "redirect:list";
   }
   
}
