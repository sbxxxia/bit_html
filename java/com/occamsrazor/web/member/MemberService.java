package com.occamsrazor.web.member;

public interface MemberService {
	public void add(Member member);
	public Member[] list();
	public Member[] searchByName(String name);
	public Member[] searchByGender(String gender);
	public Member detail(String userid);
	public int count();
	public boolean login(Member member);
//	public int count(String name);
//	public Member login(Member member);
	public void update(Member member);
	public void delete(Member member);
}
