package com.hk.roommate.service;

import java.util.List;

import com.hk.roommate.dtos.InterestDto;

public interface IInterestService {

	public boolean addinterest(InterestDto interestDto);

	public List<InterestDto> iroomlist(String id);

} 
