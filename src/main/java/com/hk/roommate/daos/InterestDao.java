package com.hk.roommate.daos;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.roommate.dtos.AnsDto;
import com.hk.roommate.dtos.InterestDto;


@Repository
public class InterestDao implements IInterestDao{
	
	private String namespace="com.hk.roommate.";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	

	@Override 
    public boolean addinterest(InterestDto interestDto)
    {
        int count = 0;
        count = sqlSessionTemplate.insert(namespace+"addinterest",interestDto);
    	return count>0?true:false;
    }


	@Override
    public List<InterestDto> iroomlist(String id)
    {
        return sqlSessionTemplate.selectList(namespace+"getiRoomList",id);
    }

	
}