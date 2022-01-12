package com.hk.roommate.daos;

import com.hk.roommate.dtos.*; 
 
public interface ILoginDao {
	
	public LoginDto getLogin(String id, String password);

	public String idChk(String id);

	public boolean insertUser(LoginDto dto);

	


}
    