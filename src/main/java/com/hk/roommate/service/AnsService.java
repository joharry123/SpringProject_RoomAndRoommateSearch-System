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
import com.hk.roommate.daos.IAnsDao;
import com.hk.roommate.daos.LoginDao;
import com.hk.roommate.dtos.AnsDto;


@Service 
public class AnsService implements IAnsService {
	
	@Autowired
	private IAnsDao ansDao; 
	
	
    public List<AnsDto>  getAllList()
    {
        return ansDao.getAllList();
    }

    public boolean insertBoard(AnsDto dto)
    {
        return ansDao.insertBoard(dto); 
    }

    public boolean updateBoard(AnsDto dto)
    {
        return ansDao.updateBoard(dto);
    }

    public boolean deleteBoard(String seqs[]) 
    {
        return ansDao.deleteBoard(seqs);
    }

    public boolean readCount(int seq)
    {
        return ansDao.readCount(seq);
    }

    public boolean replyBoard(AnsDto dto)
    {
        int count = 0;
        ansDao.replyBoardUpdate(dto);
        count = ansDao.replyBoardInsert(dto);
        return count > 0;
    }

    public AnsDto getAnsBoard(int rm_seq)
    {
        return ansDao.getAnsBoard(rm_seq);
    }

}
