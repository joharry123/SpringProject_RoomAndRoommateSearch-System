package com.hk.roommate.daos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.hk.roommate.daos.LoginDao;
import com.hk.roommate.dtos.LoginDto;

@Repository  
public class LoginDao implements ILoginDao{         
   
   @Autowired
   private SqlSessionTemplate sqlSessionTemplate; 

   private String namespace="com.hk.roommate.";
    
   public LoginDto getLogin(String id, String password) {
         Map<String, String>map=new HashMap<>();
         map.put("id", id);
         map.put("password", password);          
         return sqlSessionTemplate.selectOne(namespace+"getLogin", map);
}
   
   
	public String idChk(String id) {
		return sqlSessionTemplate.selectOne(namespace+"idchk", id);
	}
 

	@Override
	public boolean insertUser(LoginDto dto) {
		int count=0;
		count=sqlSessionTemplate.insert(namespace+"insertUser", dto);
		return count>0?true:false;
	}


	public LoginDto getuserinfo(String id) {
		return sqlSessionTemplate.selectOne(namespace+"getuserinfo", id);
	}


	public boolean updateUser(LoginDto dto) {
		// TODO Auto-generated method stub
		int count=sqlSessionTemplate.update(namespace+"updateUser", dto);
		return count>0?true:false;
	}
	
	
}

	
		
