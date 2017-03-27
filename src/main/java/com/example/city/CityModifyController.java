package com.example.city;

//insert하는 로직 
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.city.service.CityModifyService;
import com.example.city.service.CityRegisterService;
import com.example.city.service.CitySearchService;
import com.example.domain.City;
import com.example.form.CityForm;

@Controller
@RequestMapping("/city")
public class CityModifyController {

	static Log log = LogFactory.getLog(CityModifyController.class);
	
	@Autowired
	CitySearchService citySearchService;
	
	@Autowired
	CityModifyService cityModifyService;
	
	//url과 메소드를 매핑
	@GetMapping("/modify/{id}")
	public String modifyForm(CityForm cityForm,@PathVariable int id){
		log.info("modifyForm("+id+")");
		City city = citySearchService.getCityById(id);
		cityForm.setCity(city); //cityForm에 city를 넣어줌
		
		return "city/modifyForm";
	}
	//city/register로 들어오면 이쪽으로 오는 것임.
	//@Valid란 어노데이션 주면 자동으로 유효성검사해줌. 에러가 있는지 체크함. 
	@PostMapping("/modify")
	public String modify(@Valid CityForm cityForm, BindingResult errors, Integer pageNo){
		log.info("modify("+ cityForm +")");
		log.info("page ="+pageNo);
		System.out.println(cityForm);
		
		if(errors.hasErrors()){
			System.out.println(errors);
			//에러정보까지 같이 가져감. 에러를 통과하면 등록하면 됨. 
			return "city/modifyForm";
		}
		//실제 나라가 있는지 없는지 체크함. 있으면 업데이트하고 없으면 에러났다고 알림. 
		cityModifyService.modify(cityForm, errors);
		
		//그래서 위에 한 처리를 확인하려고 errors로 확인하는 것 
		if(errors.hasErrors()){
			System.out.println(errors);
			//에러정보까지 같이 가져감. 에러를 통과하면 등록하면 됨. 
			return "city/modifyForm";
		}
		
		// 성공시 아이디 발급받아 리다이렉트처리하여 id를 넘겨줌  
		return "redirect:/city/modifySuccess/" + cityForm.getId() +"?pageNo="+pageNo;
	}
	
	//그리고 리다이렉트되면 여기로 들어오는데 id를 갖고, 
	@GetMapping("/modifySuccess/{id}")
	public String registerSuccess(@PathVariable int id, Model model){
		City city = citySearchService.getCityById(id);
		model.addAttribute("city", city);		
		return "city/modifySuccess";
	}
	
}
