package com.example.city.service;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.form.CityForm;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CityRegisterServiceTests {

	 @Autowired
	 CitySearchService citySearchService;
	
	 @Autowired
	 CityRegisterService cityRegisterService;
	 
	 @Autowired
	 Validator validator;
	 
	 @Test
	 public void test00_confirmCitySearchService() {
			System.out.println("citySearchService=" + citySearchService);
		}
	 
	 @Test
	 public void test00_confirmCityRegisterService(){
		 System.out.println("cityRegisterService="+cityRegisterService);
	 }
	 
	 @Test
	 public void test00_confirmValidator(){
		 System.out.println("validator="+validator);
	 }
		
	@Test
	public void test01_register(){
		CityForm cityForm = new CityForm();
		BindingResult errors = new BeanPropertyBindingResult(cityForm, "cityForm");
		
		cityForm.setName("xxx");
		cityForm.setCountryCode("XYZ");
		
		//레지스터하기 전에 유효성 검사하는 것. 다른 곳에 없는데 레지스터에 있음. 시티폼부터 생김. 
		validator.validate(cityForm, errors);
		if (errors.hasErrors()){
			System.out.println("errors="+errors);
			return;
		}
		//시티정보, 에러정보를 넘겨서 에러체크함. 
		cityRegisterService.register(cityForm, errors);
		if(errors.hasErrors()){
			System.out.println("errors"+errors);
			return;
		}
		System.out.println("city="+citySearchService.getCityById(cityForm.getId()));
			
	}
		
		
	 
	
}
