package net.musecom.spboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.musecom.spboard.service.SpGetListService;

@Controller
public class BbsController {
   
   @Autowired
   SpGetListService getList;
   
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
   
   
   @RequestMapping("/contents")
   public String contents(Model model) {
   
      System.out.println("contents() 실행됨");
      
      return "contents";
   }
   
   @RequestMapping("/write")
   public String write(Model model) {
   
      System.out.println("write() 실행됨");
      
      return "write";
   }
   
   @RequestMapping("/edit")
   public String edit(Model model) {
   
      System.out.println("edit() 실행됨");
      
      return "edit";
   }
}