package com.hk.roommate.daos;

import java.util.List;

import com.hk.roommate.dtos.InterestDto;

public interface IInterestDao { 

	public boolean addinterest(InterestDto interestDto);

	public List<InterestDto> iroomlist(String id);
 
}
