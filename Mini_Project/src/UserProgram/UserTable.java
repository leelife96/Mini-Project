package UserProgram;

import java.util.ArrayList;
import java.util.List;

public class UserTable {
	List<User> userList;
	int no; // 자동증가할 번호
	
	// 생성자(필드 초기화)
	UserTable () {
		userList = new ArrayList<>();
		no = 1;
	}
	/*
	 * 번호, 아이디, 비밀번호, 이름 입력
	 * User 객체에 담아 리턴
	 */
	public User getUser(int no, String id, String pwd, String name) {
//		return new User(no, id, pwd, name);
		User user = new User(no, name, name, name);
		user.setNo(no);
		user.setId(id);
		user.setPwd(pwd);
		user.setName(name);
		return user;
	}
	
	/*
	 * 아이디, 비밀번호, 이름 입력
	 * 현재 list에서 아이디가 존재하는지 여부 체크
	 * 
	 */
	public boolean insert(String id, String pwd, String name) {
		if (findUser(id) != null) return false;
		return userList.add(getUser(no++, id, pwd, name));
	}
	
	public User findUser(String id) {
		for (int i=0; i<userList.size(); i++) {
			if (id.equals(userList.get(i).getId())) {
				return userList.get(i);
			}
		}
		return null;
	}
	
	public boolean update(String id, String name, String pwd) {
		User user = findUser(id);
		if (user == null) {
			return false;
		} else {
			user.setName(name);
			user.setPwd(pwd);
			return true;
		}
	}
	
	
}
