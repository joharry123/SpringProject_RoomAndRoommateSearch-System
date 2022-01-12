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

import com.hk.roommate.daos.IFileDao;
import com.hk.roommate.dtos.filedto;

@Service  
public class FileService implements IFileService {
	
	@Autowired
	private IFileDao filedao; 
	

	@Transactional
	@Override
	public boolean multiInsertFileInfo(HttpServletRequest request) {
		MultipartHttpServletRequest multi=(MultipartHttpServletRequest)request;
		

		List<MultipartFile> multiFiles=multi.getFiles("filename");
		System.out.println("사진등록:"+multiFiles.size());
		boolean isS=false;
		for (MultipartFile multiFile : multiFiles) {
  
			String originName=multiFile.getOriginalFilename();
	
			String createUUID=UUID.randomUUID().toString().replaceAll("-","");
			String storeName=createUUID+originName.substring(originName.lastIndexOf("."));
		
			int fileSize=(int)multiFile.getSize();
			
		
			String path=request.getSession().getServletContext().getRealPath("upload");
			System.out.println("파일주소 : "+path);
			
			File f=new File(path+"/"+storeName);
			

			try {
				multiFile.transferTo(f);
	
				isS=filedao.insertFileInfo(
						        new filedto(0,originName,storeName,fileSize,null,null));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return isS;
	}

	

	@Override  
	public boolean insertFileInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		MultipartHttpServletRequest multi=(MultipartHttpServletRequest)request;
		MultipartFile multiFile=multi.getFile("filename");
		String originName=multiFile.getOriginalFilename();
	
		String createUUID=UUID.randomUUID().toString().replaceAll("-","");
		String storeName=createUUID+originName.substring(originName.lastIndexOf("."));
	
		int fileSize=(int)multiFile.getSize();
		

		String path=request.getSession().getServletContext().getRealPath("upload");
		System.out.println("�뙆�씪���옣寃쎈줈: "+path);
		
		File f=new File(path+"/"+storeName);
		boolean isS=false;
		

		try {
			multiFile.transferTo(f); 
		
			isS=filedao.insertFileInfo(
					        new filedto(0,originName,storeName,fileSize,null,null));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return isS;
	}


	@Override
	public List<filedto> getFileList() {  
		// TODO Auto-generated method stub
		return filedao.getFileList(); 
}

 
  
	@Override
	public filedto makedetailpage(int seq) {
		// TODO Auto-generated method stub
		return filedao.makedetailpage(seq);
	}



	@Override
	public List<filedto> detailFile(int seq) {
		// TODO Auto-generated method stub
		return filedao.detailFile(seq);
	}



	@Override
	public boolean Fdel(int seq) {
		// TODO Auto-generated method stub
		return filedao.Fdel(seq);
	}



	@Override
	public List<filedto> searchFile(int[] r_seq) {
		// TODO Auto-generated method stub
		return filedao.searchFile(r_seq);
	}



	@Override
	public List<filedto> FIlist(int[] iseq) {
		// TODO Auto-generated method stub
		 return filedao.FIlist(iseq);
	}

}	
