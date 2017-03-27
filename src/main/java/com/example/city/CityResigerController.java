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

import com.example.city.service.CityRegisterService;
import com.example.city.service.CitySearchService;
import com.example.domain.City;
import com.example.form.CityForm;
//컨트롤러만 특별한 클래스임. 웹이 요청하는대로 나와야하기 때문에 그럼. 서비스까지 다른 것들은 전부 자바 클래스임. 

@Controller
@RequestMapping("/city")
public class CityResigerController {

	static Log log = LogFactory.getLog(CityResigerController.class);
	
	@Autowired
	CitySearchService citySearchService;
	
	@Autowired
	CityRegisterService cityRegisterService;
	
	@GetMapping("/register")
	public String registerForm(CityForm cityForm){
		log.info("registerForm()");
		
		return "city/registerForm";
		//city 앞에 프리픽스 붙이고 registerForm뒤에 서픽스 붙여서 나타냄. 
	}
	//city/register로 들어오면 이쪽으로 오는 것임.
	//@Valid란 어노데이션 주면 자동으로 유효성검사해줌. 에러가 있는지 체크함. 
	@PostMapping("/register")
	public String register(@Valid CityForm cityForm, BindingResult errors){
		log.info("register("+ cityForm +")");
		System.out.println(cityForm);
		
		if(errors.hasErrors()){
			System.out.println(errors);
			//에러정보까지 같이 가져감. 에러를 통과하면 등록하면 됨. 
			return "city/registerForm";
		}
		//실제 나라가 있는지 없는지 체크함 
		cityRegisterService.register(cityForm, errors);
		if(errors.hasErrors()){
			System.out.println(errors);
			//에러정보까지 같이 가져감. 에러를 통과하면 등록하면 됨. 
			return "city/registerForm";
		}
		
		// 성공시 아이디 발급받아 리다이렉트함 
		return "redirect:/city/registerSuccess/" + cityForm.getId();
	}
	
	//그리고 리다이렉트되면 여기로 들어오는데 id를 갖고, 
	@GetMapping("/registerSuccess/{id}")
	public String registerSuccess(@PathVariable int id, Model model){
		City city = citySearchService.getCityById(id);
		model.addAttribute("city", city);		
		return "city/registerSuccess";
	}
	
}
