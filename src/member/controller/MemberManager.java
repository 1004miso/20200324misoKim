package member.controller;

import java.util.Scanner;

import member.model.vo.Member;

public class MemberManager {
	private static Member[] m = new Member[10];
	private static int ctn = 0; //ȸ���� üũ�� ����
	private Scanner sc = new Scanner(System.in);
	//������
	public MemberManager() {}
	
	int i = 0;
	
	public void insertMember(){
		//int i = 0; �ε��� ��� ���°� �´�����..
		System.out.println("userId : ");
		String userId = sc.next();
		System.out.println("userPwd : ");
		String userPwd = sc.next();
		System.out.println("userName : ");
		String userName = sc.next();
		System.out.println("age : ");
		int age = sc.nextInt();
		System.out.println("gender : ");
		char gender = sc.next().charAt(0);
		System.out.println("email : ");
		String email = sc.next();
		m[i] = new Member(userId, userPwd, userName, age, gender, email);
		i++;
		ctn++;
		System.out.println("�Է��� �Ϸ�Ǿ����ϴ�. ���� �޴��� ���ư��ϴ�.");
		return;
		
	}
	public void printAllMember() {}
	public void searchId(){}
	public void searchName() {}
	public void searchEmail() {}
	
	public void updatePwd(){}
	public void updateName(){}
	public void updateEmail(){}
	public void deleteOne(){}
	public void deleteAll(){}
	
}
