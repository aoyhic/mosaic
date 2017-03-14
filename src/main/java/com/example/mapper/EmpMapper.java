package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Emp;
import com.example.util.Pagination;

@Mapper
public interface EmpMapper {
	
	@Select("select count(*) from emp")
	int selectToTalCount();
	
	//전체조회. 1. 단순 쿼리는 어노테이션, 2. 복잡쿼리는 xml로 함. 그리고 Emp 모델을 사용하고 있는 것. 
	@Select("select * from emp")
	List<Emp> selectAll();
	
	//Dept를 받는 emp 전체 조회
	//지금 이 자리에 저 어노테이션을 쓸 수도 있는데 내용이 많아서 xml로 이용하는 것 
	List<Emp> selectAllWithDept();
	
	@Select({
		"select *",
		" from emp",
		" order by empno",
		" offset #{firstItem} rows",
		" fetch next #{itemsPerPage} rows only "	
	})
	List<Emp> selectPage(Pagination paging);
	
	@Select("select * from emp where empno=#{empno}")
	Emp selectByEmpno(int empno);
	Emp selectByEmpnoWithDept(int empno);
	
	int insert(Emp emp);
	int updateByEmpno(Emp emp);
	
	@Delete("delete from emp where empno=#{empno}")
	int deleteByEmpno(int empno);
}
