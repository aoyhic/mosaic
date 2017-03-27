package com.example.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.domain.Player;
import com.example.util.Pagination;

public interface PlayerMapper {

	@Select("select count(*) from player")
	int selectTotalCount();
	
	@Select("select * from player")
	List<Player> selectAll();
	List<Player> selectAllWithPosition();
	@Select({
		"select *",
		"from player",
		"order by playerno",
		"offset #{firstItem} -1 rows",
		"fetch next #{itemsPerPage} rows only"		
	})
	List<Player> selectPage(Pagination paging);
	List<Player> selectPageWithPosition(Pagination paging);
	
	@Select("select * from player where playerno=#{playerno}")
	Player selectByPlayerno();
	Player selectByPlayernoWithPosition(int playerno);
	
	
}
