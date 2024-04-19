package net.musecom.spboard;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.musecom.spboard.service.SpGetContentService;
import net.musecom.spboard.service.SpGetListService;
import net.musecom.spboard.service.SpSetContentService;

@Controller
public class BbsController {
   
   @Autowired
   SpGetListService getList;
   
   @Autowired
   SpGetContentService getContent;
   
   //insert
   @Autowired
   SpSetContentService setContent;
   
   @RequestMapping("/list")
   public String list
         (@RequestParam(value="cpg", defaultValue="1") int cpg,
          @RequestParam(value="searchname", defaultValue="")String searchname,
          @RequestParam(value="searchvalue", defaultValue="")String searchvalue,
         Model model) {
      System.out.println("list() 실행됨");
      model.addAttribute("cpg" , cpg);
      model.addAttribute("searchname", searchname);
      model.addAttribute("searchvalue", searchvalue);
      getList.excute(model);
      return "list";
   }
   
   //request받음
   @RequestMapping("/contents")
   public String contents(HttpServletRequest request, HttpServletResponse response, Model model) {
   
      System.out.println("contents() 실행됨");
      
      //조회수 증가 판단
      boolean increaseHit = true;
      Cookie[] cookies = request.getCookies();
      if(cookies != null) {
         for(Cookie cookie : cookies) {
            if(cookie.getName().equals("addHit_" + request.getParameter("id")) && cookie.getValue().equals("hit")) {
               increaseHit = false;
               break;
            }
         }
      }

      
      if(increaseHit) {  //조회수 증가 로직
          model.addAttribute("increaseHit", true);
          Cookie hitCookie = new Cookie("addHit_"+request.getParameter("id"), "hit");
          hitCookie.setMaxAge(60*60); //1시간  24*60*60 하루
          hitCookie.setPath("/"); //모든 루트에서 쿠키가 유효 함.
          response.addCookie(hitCookie); //쿠키 저장
       }else {
          model.addAttribute("increaseHit", false);
       }

      
      model.addAttribute("req", request);
      getContent.excute(model); //모델에 받아서 겟컨텐트에 보냄
      return "contents";
   }
   
   @GetMapping("/write")
   public String write(Model model) {
   
      System.out.println("write() 실행됨");
      
      return "write";
   }
   
   @PostMapping("/write")
   public String writeok(HttpServletRequest request, HttpServletResponse response, Model model) {
	   
	   System.out.println("writeok() 실행됨");
	    model.addAttribute("request", request);  //mapper 확인
	    setContent.excute(model);  //dao 확인
	      //SpSetWriteService implement SpService 생성  
	   
	   return "redirect:list";
   }
   
   @GetMapping("/edit")
   public String edit(Model model) {
   
      System.out.println("edit() 실행됨");
      //mapper 확인
      //request.getParameter("id") 확인
      //SpGetContentService 실행해서 form 에서 값넣어줌      
      return "edit";
   }
   @PostMapping("/edit")
   public String editok(Model model) {
   
      System.out.println("edit() 실행됨");
      //mapper 확인
      //request값을 dto에 담아
      //SpSetEditService 실행해서  db에 값을 넣어줌 
      //parameter로 page를 갖고 있다가 
      //return "redirect:list?cpg="+cpg;"
      return "edit";
   }
}