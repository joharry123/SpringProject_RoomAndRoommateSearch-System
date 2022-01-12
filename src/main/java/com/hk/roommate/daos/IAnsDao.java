package com.hk.roommate.daos;

import java.util.List;
import com.hk.roommate.dtos.AnsDto;

public interface IAnsDao {

	public List<AnsDto> getAllList();

	public boolean insertBoard(AnsDto dto);

	public AnsDto getAnsBoard(int rm_seq);
  
	public boolean updateBoard(AnsDto dto);
  
	public boolean deleteBoard(String[] seqs);
	
	public boolean readCount(int seq);

	public int replyBoardUpdate(AnsDto dto);

	public int replyBoardInsert(AnsDto dto);
}
