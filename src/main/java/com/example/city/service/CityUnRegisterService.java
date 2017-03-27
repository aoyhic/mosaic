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
public class CityUnRegisterService {

	@Autowired
	CityMapper cityMapper;
	
	
	public void unRegister(int id){
		cityMapper.deleteById(id);
	}
	
}
