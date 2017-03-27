package com.example.city.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.mapper.CityMapper;
import com.example.mapper.CountryMapper;

//수정 
//service 를 써줘야 다른 곳에서 이 클래스를 사용할 수 있음. 
@Service
public class CityModifyService {

	@Autowired
	CityMapper cityMapper;
	
	@Autowired
	CountryMapper countryMapper;
	//City city에서 유효성 검사 함 
	public void modify(City city, BindingResult errors){
		if(city.getCountryCode()!= null){
			 Country country = countryMapper.selectByCode(city.getCountryCode());
			 if(country == null)
				 errors.reject("InvalidCountryCode","유효한 Country Code가 아닙니다.");
		 }
		 
		 if(!errors.hasErrors())
			 cityMapper.updateById(city);
	}
	
}
