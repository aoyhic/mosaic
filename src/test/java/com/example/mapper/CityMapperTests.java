package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTests {
	
	@Autowired
	CityMapper cityMapper;
	
	@Autowired
	CountryMapper countryMapper;
	
	@Test
	public void test00_confirmCityMapper() {
		System.out.println("cityMapper=" + cityMapper);
	}
	
	@Test
	public void test00_confirmCountryMapper() {
		System.out.println("countryMapper=" + countryMapper);
	}
	
	@Test
	public void test01_selectAll() {
		List<City> list = cityMapper.selectAll();
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test01_selectAllWithCountry() {
		List<City> list = cityMapper.selectAllWithCountry();
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPage() {
		Pagination paging = new Pagination();
		paging.setTotalItem(cityMapper.selectTotalCount());
		paging.setPageNo(1000);
		
		List<City> list = cityMapper.selectPage(paging);
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPageWithCountry() {
		Pagination paging = new Pagination();
		paging.setTotalItem(cityMapper.selectTotalCount());
		paging.setPageNo(2);
		
		List<City> list = cityMapper.selectPageWithCountry(paging);
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test03_selectById() {
		City city = cityMapper.selectById(4560000);
		
//		if (city == null) {
//			throw new NotFoundRuntimeException("City 정보가 없습니다");
//		}
		
		System.out.println("city = " + city);
	}
	
	@Test
	public void test03_selectByIdWithCountry() {
		City city = cityMapper.selectByIdWithCountry(10);
		
		if (city == null) {
			throw new NotFoundRuntimeException("City 정보가 없습니다");
		}
		
		System.out.println(city);
	}
	
	@Test
	public void test04_insert() {
		City city = new City();
		city.setName("database");
		//city.setCountryCode("XYZ");
		city.setCountryCode("KOR");
		
		//나라코드는 꼭 조회해봐야 함 
		//city를 입력하려면 컨트리코드가 있어야 넣을 수 있기 때문에 컨트리를 조회해보는 것. 만약 컨트리코드가 있다면 시티를 입력할 수 있고, 컨트리코드가 없으면 그냥 없는 것으로 끝남 
		//만약 null이면 밑의 것을 조회할 필요 없다. 
		Country country = countryMapper.selectByCode(city.getCountryCode());
		
		if (country == null) {
			System.out.println("error = " + "해당 Country Code가 없습니다.");
			return;
		}
		
		int cnt = cityMapper.insert(city);
		System.out.println(cityMapper.selectById(city.getId()));
		
	}
	
	@Test
	public void test05_updateById(){
		//있는 걸 조회함 
		City city = cityMapper.selectById(4106);
		//city.setId(4106);
		city.setName("LALALA");
		city.setCountryCode("KOR");
		
		//나라코드는 꼭 조회해봐야 함 
		//city를 입력하려면 컨트리코드가 있어야 넣을 수 있기 때문에 컨트리를 조회해보는 것. 만약 컨트리코드가 있다면 시티를 입력할 수 있고, 컨트리코드가 없으면 그냥 없는 것으로 끝남 
		//만약 null이면 밑의 것을 조회할 필요 없다. 
		Country country = countryMapper.selectByCode(city.getCountryCode());
		
		if (country == null) {
			System.out.println("error = " + "해당 Country Code가 없습니다.");
			return;
		}
		
		int cnt = cityMapper.updateById(city);
		System.out.println(cityMapper.selectById(city.getId()));
		
		
	}
	@Test
	public void test06_deleteById(){
		
		int id = 4104;
		int rtn = cityMapper.deleteById(id);
		System.out.println("rtn="+rtn);
	}

}









