package com.example.city;

//insert하는 로직 


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.city.service.CitySearchService;
import com.example.city.service.CityUnRegisterService;
import com.example.domain.City;


@Controller
@RequestMapping("/city")
public class CityUnRegisterController {

	static Log log = LogFactory.getLog(CityUnRegisterController.class);
	
	@Autowired
	CitySearchService citySearchService;
	
	@Autowired
	CityUnRegisterService cityUnRegisterService;
	
	//삭제요청이 들어옴 폼에서 삭제해주세요~~~함 
	@GetMapping("/unregister/{id}")
	public String unregisterForm(@PathVariable int id, Model model){
		log.info("unregisterForm("+id+")");
		City city = citySearchService.getCityById(id);
		model.addAttribute("city",city);
		
		return "city/unregisterForm";
	}
	//실제 삭제는 여기서 함 
	@PostMapping("/unregister/{id}")
	public String unregister(@PathVariable int id, Integer pageNo){
		log.info("unregister("+ id +")");
		
		cityUnRegisterService.unRegister(id);
		
		// 성공시 아이디 발급받아 리다이렉트처리하여 id를 넘겨줌  
		return "redirect:/city/unregisterSuccess/" + id +"?pageNo="+pageNo;
	}
	
	//그리고 리다이렉트되면 여기로 들어오는데 id를 갖고, 
	@GetMapping("/unregisterSuccess/{id}")
	public String unregisterSuccess(@PathVariable int id, Model model){
		model.addAttribute("id", id);
		return "city/unregisterSuccess";
	}
	
}
