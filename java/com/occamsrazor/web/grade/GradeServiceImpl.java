package com.occamsrazor.web.grade;

import org.springframework.stereotype.Service;

import com.occamsrazor.web.util.Credit;

@Service
public class GradeServiceImpl implements GradeService {
	private Grade[] grades;
	private int count;
	
	public GradeServiceImpl() {
		grades = new Grade[5];
		count = 0;
	}
	
	@Override
	public void add(Grade grade) {
		grades[count] = grade;
		count++;
		
	}

	@Override
	public Grade[] list() {
		return grades;
	}

	@SuppressWarnings("static-access")
	@Override
	public Credit detail(String userid) {
		Credit credit = null;
		switch(avg(userid)/10) {
		case 10: case 9: credit = credit.A; break;
		case 8: credit = credit.B; break;
		case 7: credit = credit.C; break;
		case 6: credit = credit.D; break;
		case 5: credit = credit.E; break;
		default : credit = credit.F; break;
		}
		return credit;
	}


	private int avg(String userid) {
		return total(userid)/4;
	}

	private int total(String userid) {
		int total = 0;
		for(int i=0; i<count; i++) {
			if(userid.equals(grades[i].getUserid())) {
				total = Integer.parseInt(grades[i].getKor())
						+Integer.parseInt(grades[i].getEng())
						+Integer.parseInt(grades[i].getMath())
						+Integer.parseInt(grades[i].getJava());
			}
		}
		System.out.println("total score : "+total);
		return total;
	}

	@Override
	public int count() {
		return count;
	}

}
