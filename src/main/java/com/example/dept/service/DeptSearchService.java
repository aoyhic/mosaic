package com.example.dept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Dept;
import com.example.mapper.DeptMapper;
import com.example.util.Pagination;

@Service
public class DeptSearchService {

		@Autowired
		DeptMapper deptMapper;
		
		public List<Dept> getListAll(){
			return getListAll(false);
		}
		
		public List<Dept> getListAll(boolean withEmp){
			List<Dept> list = null;
			
			if(withEmp)
					list= deptMapper.selectAllWithEmp();
			else
					list=deptMapper.selectAll();
			return list;
		}
		
		public Map<String, Object> getPage(int pageNo){
			return getPage(pageNo, false);
		}
		
		public Map<String, Object> getPage(int pageNo, boolean withEmp){
			Pagination paging = new Pagination();
			paging.setTotalItem(deptMapper.selectToTalCount());
			paging.setPageNo(pageNo);
			
			List<Dept> list = null;
			if(withEmp)
				list = deptMapper.selectPageWithEmp(paging);
			else
				list = deptMapper.selectPage(paging);
			
			Map<String, Object> map = new HashMap<>();
			map.put("depts", list);
			map.put("paging", paging);
			
			return map;
		}
		
		public Dept getDeptByDeptno(int deptno){
			return getDeptByDeptno(deptno, false);
			}
		
		public Dept getDeptByDeptno(int deptno, boolean withEmp){
			Dept d = null;
			if(withEmp) 
				d = deptMapper.selectByDeptnoWithEmp(deptno);
			else
				d = deptMapper.selectByDeptno(deptno);
			return d;
		}
}
