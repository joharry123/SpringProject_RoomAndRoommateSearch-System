package com.hk.roommate.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hk.roommate.dtos.RoomupdateDto;
import com.hk.roommate.dtos.filedto;

public interface IRoomupdateService {

	public boolean Roomupdate(RoomupdateDto dto);

	public List<RoomupdateDto> getRoomList();

	public RoomupdateDto detailRoom(int seq);

	public boolean Rdel(int seq);

	public List<RoomupdateDto> search(String searchValue);

	public List<RoomupdateDto> RIroomlist(int[] iseq); 
 
  



}  
    