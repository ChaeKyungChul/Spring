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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.musecom.tempwork.model.StudentDto;
import net.musecom.tempwork.service.StudentService;


@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   @Autowired
   private StudentService studentService;

   @RequestMapping("/")
   public String home(Locale locale, Model model) throws IOException {
      logger.info("Welcome home! The client locale is {}.", locale);
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);   
      String formattedDate = dateFormat.format(date);
      
      List<StudentDto> listStudent = studentService.getAllStudents();
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
      
      List<StudentDto> listStudent = studentService.getAllStudents();
      if(msg != null) {
    	  model.addAttribute("msg", msg);
      }
      model.addAttribute("listStudent", listStudent);   
      model.addAttribute("serverTime", formattedDate );
      return "home";
   }
   
   @RequestMapping("content")
   public String content(HttpServletRequest request, Model model) {
	   System.out.println("content()실행됨");
	   int id = Integer.parseInt(request.getParameter("id"));
	   StudentDto dto = studentService.getStudentById(id);
	   model.addAttribute("dto",dto);
	   return "content";
   }
   
   
   @RequestMapping("insert")
   public String insert() {
      System.out.println("insert()실행");
      return "insert";
   }
   
   /*
    * 
    * insertok(HttpServletrequest request, model model){
    *   String name = request.getParameter("name");
    *   String email = request.getParameter("email");
    *   ....
    * }
    * 
    * */
   
   @RequestMapping(value="insertok", method=RequestMethod.POST)
   public String insertok(
         @RequestParam("name") String name, 
         @RequestParam("email") String email,   
         @RequestParam("course") String course, 
         Model model) 
   {
      System.out.println("insertOk()실행");
      
       StudentDto dto = new StudentDto(); // 크리에이터만듬
       dto.setStu_name(name);
       dto.setStu_email(email);
       dto.setStu_course(course);
       
       int rs = studentService.addStudent(dto);
       if(rs > 0) {
          model.addAttribute("msg", "새로운 학생을 추가했습니다.");
       }else {
          model.addAttribute("msg", "새로운 학생을 추가하는데 실패했습니다.");
       }
       
      return "redirect:list";
   }
   @RequestMapping("update")
   public String update(HttpServletRequest request, Model model) {
	   System.out.println("update()실행됨");
	   int id = Integer.parseInt(request.getParameter("id"));
	   StudentDto dto = studentService.getStudentById(id);
	   model.addAttribute("dto",dto);
	   return "update";
   }
   
	@RequestMapping(value="updateok", method=RequestMethod.POST)
	 public String updateok(
	         @RequestParam("name") String name, 
	         @RequestParam("email") String email,   //내용담음
	         @RequestParam("course") String course,
	         @RequestParam("id") String id,
	         Model model) {
			 
		StudentDto dto = new StudentDto();
		dto.setStu_id(Integer.parseInt(id));
		dto.setStu_name(name);
		dto.setStu_email(email);
		dto.setStu_course(course);
		int rs = studentService.updateStudent(dto);
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
	   int rs = studentService.deleteStudent(id);
	    if(rs > 0) {
	          model.addAttribute("msg", "삭제했습니다.");
	       }else {
	          model.addAttribute("msg", "삭제에 실패했습니다..");
	       }
	
	   return "redirect:list";
   }
 }

