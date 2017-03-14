package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.domain.Emp;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTests {

	 @Autowired
	 EmpMapper empMapper;
	 
	 @Autowired
	 DeptMapper deptMapper;
	
	 @Test
	 public void test01_confirmempMapper(){
		 System.out.println("empMapper="+empMapper);
	 }
	 
	 @Test
	 public void test01_selectAll(){
		 List<Emp> emps = empMapper.selectAll();
		 
		 for (Emp e : emps)
			 System.out.println(e);
	 }
	 @Test
	 public void test01_selectAllWithDept(){
		 List<Emp> emps = empMapper.selectAllWithDept();
		 
		 for (Emp e:emps)
			 System.out.println(e);
	 }
	 @Test
	 public void test02_selectPage(){
		 Pagination paging = new Pagination();
		 paging.setTotalItem(empMapper.selectToTalCount());
		 paging.setPageNo(1);
		 List<Emp> list = empMapper.selectPage(paging);
		 for (Emp e:list)
			 System.out.println(e);
	 }
	 @Test
	 public void test04_insert(){
		 Emp emp = new Emp();
		 emp.setEname("CAT");
		 emp.setDeptno(40);
		 
		 Dept dept = deptMapper.selectByDeptno(emp.getDeptno());
		 if(dept == null){
			 System.out.println("error="+"해당 deptno가 없으요");
			 return;
		 }
		 
		 int cnt = empMapper.insert(emp);
		 System.out.println(empMapper.selectByEmpno(emp.getEmpno()));
	 }
	  
}
