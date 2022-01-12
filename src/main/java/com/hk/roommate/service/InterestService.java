package com.hk.roommate.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;  

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hk.roommate.daos.AnsDao;
import com.hk.roommate.daos.IInterestDao;
import com.hk.roommate.daos.LoginDao;
import com.hk.roommate.dtos.AnsDto;
import com.hk.roommate.dtos.InterestDto;


@Service 
public class InterestService implements IInterestService {
	
	@Autowired
	private IInterestDao  interestDao;
	
		@Override
		public boolean addinterest(InterestDto interestDto)
		    {
		        return interestDao.addinterest(interestDto);
		    }
	 
	  
		@Override
	    public List<InterestDto> iroomlist(String id)
		    {
		        return interestDao.iroomlist(id);
		    }

}
