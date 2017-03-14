package com.example.dept;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dept.service.DeptSearchService;

@Controller
@RequestMapping("/dept")
public class DeptSearchController {

	 @Autowired
	 DeptSearchService deptSearchService;
	 
	 @GetMapping("list")
	 public String getList(Model model){
	
	 }
}
