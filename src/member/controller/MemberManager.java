package member.controller;

import java.util.Scanner;

import member.model.vo.Member;

public class MemberManager {
	private static Member[] m = new Member[10];
	private static int ctn = 0; //회원수 체크용 변수
	private Scanner sc = new Scanner(System.in);
	//생성자
	public MemberManager() {}



	public void insertMember(){
		
		
		System.out.print("userId : ");
		String userId = sc.next();
		System.out.print("userPwd : ");
		String userPwd = sc.next();
		System.out.print("userName : ");
		String userName = sc.next();
		System.out.print("age : ");
		int age = sc.nextInt();
		System.out.print("gender : ");
		char gender = sc.next().charAt(0);
		System.out.print("email : ");
		String email = sc.next();
		m[ctn] = new Member(userId,userPwd,userName,age,gender,email);
		ctn++;
		System.out.println("입력이 완료되었습니다. 메인 메뉴로 돌아갑니다.");
		return;

	}

	public void searchId(){
		System.out.print("검색할 아이디를 입력하세요 :");
		String userId = sc.next();
		for(int i = 0; i < ctn ; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.println("해당 배열은 m[" + (i) + "] 배열입니다.");
				printOne(m[i]);
				return;	
			}
			
		}
		System.out.println("검색한 회원 정보가 존재하지 않습니다.");
		return;

	}
	public void searchName() {
		System.out.print("검색할 이름을 입력하세요 :");
		String userName = sc.next();
		for(int i = 0; i < ctn ; i++) {
			if(m[i].getUserName().equals(userName)) {
				System.out.println("해당 배열은 m[" + (i) + "] 배열입니다.");
				printOne(m[i]);
				return;	
			}
			
		}
		System.out.println("검색한 회원 정보가 존재하지 않습니다.");
		return;
	}
	public void searchEmail() {

		System.out.print("검색할 이메일을 입력하세요 :");
		String email = sc.next();
		for(int i = 0; i < ctn ; i++) {
			if(m[i].getEmail().equals(email)) {
				System.out.println("해당 배열은 m[" + (i) + "] 배열입니다.");
				printOne(m[i]);
				return;	
			}
			
		}
		System.out.println("검색한 회원 정보가 존재하지 않습니다.");
		return;
	}

	public void updatePwd(){
		System.out.print("수정할 회원의 아이디를 입력하세요 : ");
		String userId = sc.next();
		for(int i = 0; i < m.length ; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.print("변경할 비밀번호 입력 : ");
				String userPwd = sc.next();		
				m[i].setUserPwd(userPwd);
				System.out.println("패스워드 수정이 완료되었습니다");
				return;
			}
		}
		System.out.println("수정할 회원이 존재하지 않습니다.");
	}
	public void updateName(){

		System.out.print("수정할 회원의 아이디를 입력하세요 : ");
		String userId = sc.next();
		for(int i = 0; i < m.length ; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.print("변경할 이름 입력 : ");
				String userName = sc.next();		
				m[i].setUserName(userName);
				System.out.println("이름 수정이 완료되었습니다");
				return;
			}
		}
		System.out.println("수정할 회원이 존재하지 않습니다.");



	}
	public void updateEmail(){
		System.out.print("수정할 회원의 아이디를 입력하세요 : ");
		String userId = sc.next();
		for(int i = 0; i < m.length ; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.print("변경할 이메일 입력 : ");
				String email = sc.next();		
				m[i].setEmail(email);
				System.out.println("이메일 수정이 완료되었습니다");
				return;
			}
		}
		System.out.println("수정할 회원이 존재하지 않습니다.");



	}



	public void deleteOne(){
		System.out.print("탈퇴할 회원의 아이디를 입력하세요 : ");
		String userId = sc.next();
		for(int i = 0; i < m.length ; i++) {
			if(m[i].getUserId().equals(userId)) {
				for(int j = i + 1; j < ctn; j++) {
					m[j-1] = m[j];
				}
				ctn--;
			}else {
				System.out.println("삭제할 회원 정보가 존재하지 않습니다.");
			}
		}

	}


	//0~ctn까지의 모든 인덱스의 모든 setter를 이용하여 초기값으로 변경하고
	public void deleteAll(){
		for(int i = 0; i < ctn; i++) {
			m[i].setUserId(null);
			m[i].setUserPwd(null);
			m[i].setUserName(null);
			m[i].setAge(0);
			m[i].setGender(' ');
			m[i].setEmail(null);	
		}
		ctn = 0;
	}

	//반복문을 이용하여 ctn까지의 모든 인덱스의 객체 정보를 getter를 통해 출력시키는 메소드
	public void printAllMember() {
		for(int i = 0; i < ctn; i++) {
			System.out.println("id : " + m[i].getUserId()+", pwd : " + m[i].getUserPwd() + ", name : "+ m[i].getUserName()+", age : " + m[i].getAge()+", gender : " + m[i].getGender()+", email : " + m[i].getEmail());
		}
	}
	//출력시킬 Member객체를 전달받아, 해당 객체의 getter를 이용하여 전달받은 객체 정보를 출력함
	public void printOne(Member m){
		System.out.println("id : " + m.getUserId()+", pwd : " + m.getUserPwd() + ",name : " + m.getUserName() +", age : " + m.getAge() + ", gender : " + m.getGender() +", email : " + m.getEmail());
		
	}
}
