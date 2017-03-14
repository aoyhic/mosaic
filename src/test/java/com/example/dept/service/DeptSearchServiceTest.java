package com.example.dept.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptSearchServiceTest {

	@Autowired
	DeptSearchService service;
	
	@Test
	public void test00_confirm_test(){
		System.out.println("service"+service);
	}
	@Test
	public void test01_getListAll(){
		List<Dept> list=service.getListAll();
		for(Dept d:list)
			System.out.println(d);
	}
	@Test
	public void test01_getListAll_withEmp(){
		List<Dept> list=service.getListAll(true);
		for(Dept d:list)
			System.out.println(d);
	}
	@Test
	public void test02_getPage(){
		Map<String, Object> map = service.getPage(1);
		System.out.println(map.get("depts"));
		System.out.println(map.get("paging"));
	}
	@Test
	public void test02_getPage_withEmp(){
		Map<String, Object> map = service.getPage(1, true);
		List<Dept> list = (List<Dept>)map.get("depts");
		for(Dept d:list)
			System.out.println(d);
		System.out.println(map.get("paging"));
	}
	@Test
	public void test03_getDeptByDeptno(){
		Dept d = service.getDeptByDeptno(30);
		System.out.println(d);
	}
	
	@Test
	public void test03_getDeptByDeptno_withEmp(){
		Dept d = service.getDeptByDeptno(20, true);
		System.out.println(d);
	}
}
