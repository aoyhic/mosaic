package com.example.dept;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DeptSearchControllerTests {
	
	@LocalServerPort
	int port;
	
	@Autowired
	TestRestTemplate rest;
	
	@Test
	public void test00_port(){
		System.out.println("port="+port);
	}
	
	@Test
	public void test00_testRestTemplate(){
		System.out.println("rest="+rest);
	}
	
	@Test
	public void test01_getListAll(){
		String html = rest.getForObject("/dept/list", String.class);
		System.out.println(html);
	}
	
	@Test
	public void test02_getPage(){
		String html = rest.getForObject("/dept/page/1", String.class);
		System.out.println(html);
	}
	
	@Test
	public void test03_getItem(){
		String html = rest.getForObject("/dept/item/20", String.class);
		System.out.println(html);
	}
	
	

}
