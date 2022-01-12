package com.hk.roommate.daos;
  
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.hk.roommate.dtos.RoomupdateDto;  
import com.hk.roommate.dtos.filedto;
  
@Repository
public class RoomupdateDao implements IRoomupdateDao { 

	@Autowired  
	private SqlSessionTemplate sqlSessionTemplate; 

	private String namespace="com.hk.roommate.";

	@Override
	public boolean Roomupdate(RoomupdateDto dto) {
		// TODO Auto-generated method stub
		int count = 0;
		count=sqlSessionTemplate.insert(namespace+"updateroom", dto);
		return count>0?true:false;
	}
	 
	@Override 
	public List<RoomupdateDto> getRoomList() {
		return sqlSessionTemplate.selectList(namespace+"getRoomList");
	}

	public RoomupdateDto detailRoom(int seq) {  
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace+"detailRoom",seq);
	}

	@Override
	public boolean Rdel(int seq) {
		// TODO Auto-generated method stub
		int count = 0;
		count=sqlSessionTemplate.delete(namespace+"Rdel", seq);
		return count>0?true:false;
	}

	@Override
	public List<RoomupdateDto> search(String searchValue) {
		// TODO Auto-generated method stub
	   return sqlSessionTemplate.selectList(namespace+"search",searchValue);
	}

	@Override
	public List<RoomupdateDto> RIroomlist(int[] iseq) {
		// TODO Auto-generated method stub
		Map<String, int[]>map=new HashMap<String, int[]>();
        map.put("iseq", iseq);
        return sqlSessionTemplate.selectList(namespace+"RIlist",map);
	}   
	
 
}     


