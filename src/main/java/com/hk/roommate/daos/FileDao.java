package com.hk.roommate.daos;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.roommate.dtos.filedto;

@Repository
public class FileDao implements IFileDao {
	
	@Autowired  
	private SqlSessionTemplate sqlSessionTemplate; 

	private String namespace="com.hk.roommate.";


	@Override
	public boolean multiInsertFileInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertFileInfo(filedto filedto) {
		int count = 0;
		count=sqlSessionTemplate.insert(namespace+"insertFileInfo", filedto);
		return count>0?true:false;
	}
	 

	@Override
	public List<filedto> getFileList() {
		return sqlSessionTemplate.selectList(namespace+"getFileList");
	}

	@Override
	public filedto makedetailpage(int seq) {
	
		return null;
	}


	@Override
	public List<filedto> detailFile(int seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"detailFile", seq);
	}

	@Override
	public boolean Fdel(int seq) {
		// TODO Auto-generated method stub
		int count = 0;
		count=sqlSessionTemplate.insert(namespace+"Fdel", seq);
		return count>0?true:false;
	}

	@Override
	public List<filedto> searchFile(int[] r_seq) {
		Map<String, int[]>map=new HashMap<String, int[]>();
		map.put("r_seq", r_seq);
		return sqlSessionTemplate.selectList(namespace+"searchFile", map); 
	}
 
	@Override
	public List<filedto> FIlist(int[] iseq) {
		// TODO Auto-generated method stub
		Map<String, int[]>map=new HashMap<String, int[]>();
		map.put("iseq", iseq);
		return sqlSessionTemplate.selectList(namespace+"FIlist", map); 
	}
  
}
