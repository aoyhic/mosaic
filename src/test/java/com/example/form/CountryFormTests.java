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
public class CountryFormTests {

	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirmValidator(){
		System.out.println("validator="+validator);
	}
	
	@Test
	public void test01_getCode(){
		CountryForm countryform = new CountryForm();
		countryform.setCode("xyss");
		countryform.setName("database");
		BindingResult errors = new BeanPropertyBindingResult(countryform, "countryform");
				//빈 프로퍼티의 유효성검사를 해서 에러정보를 담고있는 게 errors
				
		
		validator.validate(countryform, errors); 
		if(errors.hasErrors()){
			System.out.println("errors"+errors);
			return;
		}
		System.out.println("countryform은 유효함 ");
	}
	
	
}
