package com.example.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.domain.City;

//City를 상속받아 city에 있는 걸 가져옴. 유효성 검사는 그렇게 함. city의 number, char등을 보고 어노테이션을 따로 정함. 
public class CityForm extends City{
	//cityForm에 city를 변환처리해서 사용할 수 있도록 city를 이 안에 넣어주는 것 
	//나 자신에다가 city에서 가져와서 넣어주는 것 
	public void setCity(City city){
		super.setId(city.getId());
		super.setName(city.getName());
		super.setCountryCode(city.getCountryCode());
		super.setDistrict(city.getDistrict());
		super.setPopulation(city.getPopulation());
	}
	@NotNull
	@Size(max=35)
	@Override
	public String getName() {
		
		return super.getName();
	}

	@Override
	public void setName(String name) {
		if(name.equals(""))
			name=null;
		super.setName(name);
	}
	
	@Size(max=3)
	@Override
	public String getCountryCode() {
		// TODO Auto-generated method stub
		return super.getCountryCode();
	}

	@Override
	public void setCountryCode(String countryCode) {
		if(countryCode.equals(""))
			countryCode=null;
		super.setCountryCode(countryCode);
	}
	@Size(max=20)
	@Override
	public String getDistrict() {
		// TODO Auto-generated method stub
		return super.getDistrict();
	}
	
	@Override
	public void setDistrict(String district) {
		if(district.equals(""))
			district = null;
		super.setDistrict(district);
	}
	//정수부 11자리, 소수부는 없음 
	@Digits(integer=11, fraction=0)
	@Override
	public BigDecimal getPopulation() {
		// TODO Auto-generated method stub
		return super.getPopulation();
	}

	@Override
	public void setPopulation(BigDecimal population) {
		// TODO Auto-generated method stub
		super.setPopulation(population);
	}

}
