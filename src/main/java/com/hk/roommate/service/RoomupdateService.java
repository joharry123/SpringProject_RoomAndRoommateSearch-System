package com.hk.roommate.service;

import java.io.File;
import java.io.IOException;
import java.util.List;   
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.hk.roommate.daos.IRoomupdateDao;
import com.hk.roommate.daos.RoomupdateDao;
import com.hk.roommate.dtos.RoomupdateDto;
import com.hk.roommate.dtos.filedto;

@Service   
public class RoomupdateService implements IRoomupdateService {
	
	@Autowired
	private IRoomupdateDao roomupdatedao;

	@Override
	public boolean Roomupdate(RoomupdateDto dto) {
		// TODO Auto-generated method stub
		return roomupdatedao.Roomupdate(dto);
	}  
	
	@Override
	public List<RoomupdateDto> getRoomList() {
		// TODO Auto-generated method stub
		return roomupdatedao.getRoomList();
	}

	@Override
	public RoomupdateDto detailRoom(int seq) {
		// TODO Auto-generated method stub
		return roomupdatedao.detailRoom(seq);
	}

	@Override
	public boolean Rdel(int seq) {
		// TODO Auto-generated method stub
		return roomupdatedao.Rdel(seq);
	}

	@Override
	public List<RoomupdateDto> search(String searchValue) {
		// TODO Auto-generated method stub
		return roomupdatedao.search(searchValue); 
	}

	@Override
	public List<RoomupdateDto> RIroomlist(int[] iseq) {
		// TODO Auto-generated method stub
		  return roomupdatedao.RIroomlist(iseq);
	}



//	@Override
//	public RoomupdateDto detailRoom(int seq) {
//		// TODO Auto-generated method stub
//		return roomupdatedao.detailRoom(seq);
//	}  

  


}    