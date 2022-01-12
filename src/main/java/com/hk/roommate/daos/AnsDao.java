package com.hk.roommate.daos;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.roommate.dtos.AnsDto;
  
@Repository
public class AnsDao implements IAnsDao{
	
	private String namespace="com.hk.roommate.";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<AnsDto> getAllList() {
		return sqlSessionTemplate.selectList(namespace+"roommatelist");
	}
	
	@Override
	public AnsDto getAnsBoard(int rm_seq) {
		return sqlSessionTemplate.selectOne(namespace+"detailboard",rm_seq);
	}
 
	@Override
	public boolean insertBoard(AnsDto dto) {
		int count=sqlSessionTemplate.insert(namespace+"insertrmboard", dto);
		return count>0?true:false;
	}
	  
	@Override
	public boolean updateBoard(AnsDto dto) {
		int count=sqlSessionTemplate.update(namespace+"updateboard", dto);
		return count>0?true:false;
	} 
	

	@Override
	public boolean deleteBoard(String[] seqs) {
		Map<String, String[]>map=new HashMap<>();
		map.put("seqs", seqs);
		System.out.println("map:"+seqs[0]);
		int count=sqlSessionTemplate.update(namespace+"delboard", map);
		return count>0?true:false;
	}
	

	@Override
	public boolean readCount(int seq) {
		int count=sqlSessionTemplate.update(namespace+"readcount", seq);
		return count>0?true:false;
	}
	
	

//	@Override
//	public AnsDto getAnsBoard(int seq) {
//		Map<String, Integer>map=new HashMap<String, Integer>();
//		map.put("seq", seq);
//		return sqlSessionTemplate.selectOne(namespace+"boardlist",map);
//	}


	@Override
	public int replyBoardUpdate(AnsDto dto) {
		return sqlSessionTemplate.update(namespace+"replyupdate", dto);
	}
	
	@Override
	public int replyBoardInsert(AnsDto dto) {
		return sqlSessionTemplate.insert(namespace+"replyinsert", dto);
	}

}
