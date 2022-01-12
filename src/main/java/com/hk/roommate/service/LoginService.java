package com.hk.roommate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.roommate.daos.ILoginDao;
import com.hk.roommate.daos.LoginDao;
import com.hk.roommate.dtos.LoginDto;  

@Service  
public class LoginService implements ILoginService {
	 
	@Autowired
	private LoginDao loginDao;

	@Override
	public LoginDto getLogin(String id, String password) {
		// TODO Auto-generated method stub
		return loginDao.getLogin(id, password);
	}
 
	@Override
	public String idChk(String id) {
		// TODO Auto-generated method stub
		return loginDao.idChk(id);
	}
  
	@Override
	public boolean insertUser(LoginDto dto) {
		// TODO Auto-generated method stub
		return loginDao.insertUser(dto);
	}

	@Override
	public LoginDto getuserinfo(String id) {
		return loginDao.getuserinfo(id);
	}

	@Override
	public boolean updateUser(LoginDto dto) {
		// TODO Auto-generated method stub
		return loginDao.updateUser(dto); 
	}
	

	
}
    