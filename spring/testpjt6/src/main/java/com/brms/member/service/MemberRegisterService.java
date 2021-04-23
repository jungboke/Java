package com.brms.member.service;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() { }
	
	public void register(Member member) {
		memberDao.insert(member);
	}
}
