package UserProgram;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		UserTable ut = new UserTable();
		
		while (flag) {
			System.out.println("1.회원등록 | 2.회원목록 | 3.회원상세 | 4.회원수정 | 5.종료");
			System.out.print("입력]");
			String val = scan.nextLine();
			if ("1".equals(val)) {
				System.out.println("[회원등록]");
				System.out.print("아이디:");
				String id = scan.nextLine();
				System.out.print("비밀번호:");
				String pwd = scan.nextLine();
				System.out.print("이름:");
				String name = scan.nextLine();
				
				if (ut.insert(id, pwd, name)) {
					System.out.println("회원등록 성공");
				} else {
					System.out.println("중복된 아이디입니다.");
				}
			} else if ("2".equals(val)) {
				System.out.println("[회원목록]");
				System.out.println("번호\t아이디\t비밀번호\t이름");
				for (int i=0; i<ut.userList.size(); i++) {
					User u = ut.userList.get(i);
					System.out.println(u.getNo()+"\t"+u.getId()+"\t"+u.getPwd()+"\t"+u.getName());
				}
			} else if ("3".equals(val)) {
				System.out.println("[회원상세]");
				System.out.print("아이디:");
				String id = scan.nextLine();
				User u = ut.findUser(id);
				if (u == null) {
					System.out.println("해당 아이디가 존재하지 않습니다.");
				} else {
					System.out.println("번호 : "+u.getNo());
					System.out.println("아이디 : "+u.getId());
					System.out.println("이름 : "+u.getName());
					System.out.println("비밀번호 : "+u.getPwd());
				}
			} else if ("4".equals(val)) {
				System.out.println("[회원수정]");
				System.out.print("아이디:");
				String id = scan.nextLine();
				System.out.print("비밀번호:");
				String pwd = scan.nextLine();
				System.out.print("이름:");
				String name = scan.nextLine();
				
				if (ut.update(id, name, pwd)) {
					System.out.println("정상적으로 수정되었습니다.");
				} else {
					System.out.println("해당 아이디가 존재하지 않습니다.");
				}
			} else if ("5".equals(val)) {
				System.out.println("종료");
				flag = false;
			}
		}
	}

}