package com.example.form;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CityFormTests {

	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirmValidator(){
		System.out.println("validator="+validator);
	}
	
	@Test
	public void test01_getName(){
		CityForm cityform = new CityForm();
		
		cityform.setName("DeaHo");
		BindingResult errors = new BeanPropertyBindingResult(cityform, "cityform");
				//빈 프로퍼티의 유효성검사를 해서 에러정보를 담고있는 게 errors
				//cityform이 에러확인 대상 
		
		validator.validate(cityform, errors); //cityform을 에러검사해서 에러정보는 errors에 넣어달라고 하는 것.		
		if(errors.hasErrors()){
			System.out.println("errors"+errors);
			return;
		}
		System.out.println("cityform은 유효함 ");
	}
	
	@Test
	public void test02_getCountryCode(){
		CityForm cityform = new CityForm();
		cityform.setName("Deaho");
		cityform.setCountryCode("Korea");
		cityform.setDistrict("rrrrrrrrrrrrrrrrrrrrrrrrr");
		BindingResult errors = new BeanPropertyBindingResult(cityform, "cityform");
		validator.validate(cityform, errors);
		
		if(errors.hasErrors()){
			System.out.println("errors="+errors);
			return;
		}
		System.out.println("cityform은 유효함");
	}
}
