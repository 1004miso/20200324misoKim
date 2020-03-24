package member.controller;

import java.util.Scanner;

import member.model.vo.Member;

public class MemberManager {
	private static Member[] m = new Member[10];
	private static int ctn = 0; //ȸ���� üũ�� ����
	private Scanner sc = new Scanner(System.in);
	//������
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
		System.out.println("�Է��� �Ϸ�Ǿ����ϴ�. ���� �޴��� ���ư��ϴ�.");
		return;

	}

	public void searchId(){
		System.out.print("�˻��� ���̵� �Է��ϼ��� :");
		String userId = sc.next();
		for(int i = 0; i < ctn ; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.println("�ش� �迭�� m[" + (i) + "] �迭�Դϴ�.");
				printOne(m[i]);
				return;	
			}
			
		}
		System.out.println("�˻��� ȸ�� ������ �������� �ʽ��ϴ�.");
		return;

	}
	public void searchName() {
		System.out.print("�˻��� �̸��� �Է��ϼ��� :");
		String userName = sc.next();
		for(int i = 0; i < ctn ; i++) {
			if(m[i].getUserName().equals(userName)) {
				System.out.println("�ش� �迭�� m[" + (i) + "] �迭�Դϴ�.");
				printOne(m[i]);
				return;	
			}
			
		}
		System.out.println("�˻��� ȸ�� ������ �������� �ʽ��ϴ�.");
		return;
	}
	public void searchEmail() {

		System.out.print("�˻��� �̸����� �Է��ϼ��� :");
		String email = sc.next();
		for(int i = 0; i < ctn ; i++) {
			if(m[i].getEmail().equals(email)) {
				System.out.println("�ش� �迭�� m[" + (i) + "] �迭�Դϴ�.");
				printOne(m[i]);
				return;	
			}
			
		}
		System.out.println("�˻��� ȸ�� ������ �������� �ʽ��ϴ�.");
		return;
	}

	public void updatePwd(){
		System.out.print("������ ȸ���� ���̵� �Է��ϼ��� : ");
		String userId = sc.next();
		for(int i = 0; i < m.length ; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.print("������ ��й�ȣ �Է� : ");
				String userPwd = sc.next();		
				m[i].setUserPwd(userPwd);
				System.out.println("�н����� ������ �Ϸ�Ǿ����ϴ�");
				return;
			}
		}
		System.out.println("������ ȸ���� �������� �ʽ��ϴ�.");
	}
	public void updateName(){

		System.out.print("������ ȸ���� ���̵� �Է��ϼ��� : ");
		String userId = sc.next();
		for(int i = 0; i < m.length ; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.print("������ �̸� �Է� : ");
				String userName = sc.next();		
				m[i].setUserName(userName);
				System.out.println("�̸� ������ �Ϸ�Ǿ����ϴ�");
				return;
			}
		}
		System.out.println("������ ȸ���� �������� �ʽ��ϴ�.");



	}
	public void updateEmail(){
		System.out.print("������ ȸ���� ���̵� �Է��ϼ��� : ");
		String userId = sc.next();
		for(int i = 0; i < m.length ; i++) {
			if(m[i].getUserId().equals(userId)) {
				System.out.print("������ �̸��� �Է� : ");
				String email = sc.next();		
				m[i].setEmail(email);
				System.out.println("�̸��� ������ �Ϸ�Ǿ����ϴ�");
				return;
			}
		}
		System.out.println("������ ȸ���� �������� �ʽ��ϴ�.");



	}



	public void deleteOne(){
		System.out.print("Ż���� ȸ���� ���̵� �Է��ϼ��� : ");
		String userId = sc.next();
		for(int i = 0; i < m.length ; i++) {
			if(m[i].getUserId().equals(userId)) {
				for(int j = i + 1; j < ctn; j++) {
					m[j-1] = m[j];
				}
				ctn--;
			}else {
				System.out.println("������ ȸ�� ������ �������� �ʽ��ϴ�.");
			}
		}

	}


	//0~ctn������ ��� �ε����� ��� setter�� �̿��Ͽ� �ʱⰪ���� �����ϰ�
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

	//�ݺ����� �̿��Ͽ� ctn������ ��� �ε����� ��ü ������ getter�� ���� ��½�Ű�� �޼ҵ�
	public void printAllMember() {
		for(int i = 0; i < ctn; i++) {
			System.out.println("id : " + m[i].getUserId()+", pwd : " + m[i].getUserPwd() + ", name : "+ m[i].getUserName()+", age : " + m[i].getAge()+", gender : " + m[i].getGender()+", email : " + m[i].getEmail());
		}
	}
	//��½�ų Member��ü�� ���޹޾�, �ش� ��ü�� getter�� �̿��Ͽ� ���޹��� ��ü ������ �����
	public void printOne(Member m){
		System.out.println("id : " + m.getUserId()+", pwd : " + m.getUserPwd() + ",name : " + m.getUserName() +", age : " + m.getAge() + ", gender : " + m.getGender() +", email : " + m.getEmail());
		
	}
}
