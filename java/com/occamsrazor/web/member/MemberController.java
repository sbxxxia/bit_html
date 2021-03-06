package com.occamsrazor.web.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.occamsrazor.web.util.Messenger;

@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService memberService;
	
	@PostMapping("/join")
	public Messenger add(@RequestBody Member member) {
		int current = memberService.count();
		memberService.add(member);
//		int count = memberService.count();
//		Messenger result = null;
//		if(count == 1) {
//			result = Messenger.SUCCESS;
//		}else {
//			result = Messenger.FAIL;
//		}
		return (memberService.count() == (current+1))? Messenger.SUCCESS : Messenger.FAIL;
	}
	
	
	
	@PostMapping("/login")
	public Messenger login(@RequestBody Member member) {
		return (memberService.login(member))? Messenger.SUCCESS : Messenger.FAIL;
	}
	
	@GetMapping("/list")
	public Member[] list() {
		Member[] returnMembers = new Member[5];
		return returnMembers;
	}
	
	@GetMapping("/detail")
	public Member detail(@RequestBody String userid) {
		Member returnMember = new Member();
		return returnMember;
	}
	
	@GetMapping("/count")
	public int count() {
		int count = 0;
		return count;
	}
}
