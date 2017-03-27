package com.example.city.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.mapper.CityMapper;
import com.example.mapper.CountryMapper;

@Service
public class CityRegisterService {

	 @Autowired
	 CityMapper cityMapper;
	 
	 @Autowired
	 CountryMapper countryMapper;
	 
	 public void register(City city, BindingResult errors){
		 
		 //널이면 조회할 필요없으니, 널이 아닐 때만 조회함. null이 아닐 때(입력이 되었을때) 컨트리코드에 있는지 조회해봄 
		 if(city.getCountryCode()!= null){
			 Country country = countryMapper.selectByCode(city.getCountryCode());
			 if(country == null)
				 errors.reject("InvalidCountryCode","유효한 Country Code가 아닙니다.");
		 }
		 
		 if(!errors.hasErrors())
			 cityMapper.insert(city);
	 }
	 
	 
}
