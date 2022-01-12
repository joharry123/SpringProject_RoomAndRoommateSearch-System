package com.hk.roommate.daos;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hk.roommate.dtos.RoomupdateDto;
import com.hk.roommate.dtos.filedto;

public interface IFileDao {  
	
	public boolean multiInsertFileInfo(HttpServletRequest request);
	
	public boolean insertFileInfo(filedto filedto);

	public List<filedto> getFileList();

	public filedto makedetailpage(int seq);

	public List<filedto> detailFile(int seq);

	public boolean Fdel(int seq);
 
	public List<filedto> searchFile(int[] r_seq);

	public List<filedto> FIlist(int[] iseq);   


  

}
