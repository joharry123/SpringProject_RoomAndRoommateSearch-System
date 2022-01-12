package com.hk.roommate.service;



import com.hk.roommate.dtos.LoginDto;  
 


public interface ILoginService {
	
	public LoginDto getLogin(String id, String password);

	public String idChk(String id);

	public boolean insertUser(LoginDto dto);

	public LoginDto getuserinfo(String id);

	public boolean updateUser(LoginDto dto);

	
  
}      
