package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.Position;
import com.example.util.Pagination;

public interface PositionMapper {

	@Select("select count(*) from position")
	int selectTotalCount();
	
	@Select("select * from position")
	List<Position> selectAll();
	List<Position> selectAllWithPlayer();
	
	@Select({
		"select *",
		"from position",
		"order by pstno",
		"offset #{firstItem}-1 rows",
		" fetch next #{itemsPerPage} rows only"
	})
	List<Position> selectPage(Pagination paging);
	List<Position> selectPageWithPlayer(Pagination paging);
	
	@Select("select * from position where pstno=#{pstno}")
	Position selectByPstno(int pstno);
	Position selectByPstnoWithPlayer(int pstno);
	
	
}
