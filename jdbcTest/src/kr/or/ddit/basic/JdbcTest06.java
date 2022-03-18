package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtill;

/*
 	회원을 관리하는 프로그램을 작성하시오.
 	(MYMEMBER 테이블 이용)
 	
 	아래 메뉴의 기능을 모두 구현하시오(CRUD기능 구현하기)
 	
	메뉴예시)
	---------------------------
		== 작업 선택 ==
	  1. 자료 추가				--> insert (C)
	  2. 자료 수정				--> update (U)
 	  3. 자료 삭제				--> delete (D)
 	  4. 전체 자료 출력			--> select (R)
 	  0. 작업 끝
 	---------------------------
 	
 	조건)
 	1) 자료 추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력받는다)
 	2) 자료 삭제는 '회원ID'를 입력받아서 처리한다.
 	3) 자료 수정에서 '회원ID'는 변경되지 않는다.
 	
*/

public class JdbcTest06 {
	Scanner scan = new Scanner(System.in);
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		new JdbcTest06().start();
	}

	private void start() {
		while(true) {
			System.out.println("---------------------------");
			System.out.println("	== 작업 선택 ==");
			System.out.println("  1. 자료 추가");
			System.out.println("  2. 자료 수정");
			System.out.println("  3. 자료 삭제");
			System.out.println("  4. 전체 자료 출력");
			System.out.println("  0. 작업 끝");
			System.out.println("---------------------------");
			int input = scan.nextInt();
			
			switch (input) {
			case 1: insert(); break;
			case 2: update(); break;
			case 3: delete(); break;
			case 4: printAll(); break;
			case 0:
				System.out.println("프로그램이 종료됩니다");
				System.exit(0);

			default:
				System.out.println("잘못된 입력입니다");
				break;
			}
			
			
			
		}
	}

	private void printAll() {
		conn = DBUtill.getConnection();
		String sql = "select * from mymember";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("아이디 | 이름 | 비밀번호 | 전화번호 | 주소 ");
				System.out.println(rs.getString("mem_id") + " | " + rs.getString("mem_name") + " | " + rs.getString("mem_pass") + " | " 
								 + rs.getString("mem_tel") + " | " + rs.getString("mem_addr"));
			}
		} catch (SQLException e) {
		
		}
	}

	private void delete() {
		conn = DBUtill.getConnection();
		System.out.print("삭제할 아이디를 입력 > ");
		String id = scan.next();
		
		String sql = "delete from mymember where mem_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {}
	}

	private void update() {
		conn = DBUtill.getConnection();
		System.out.println("자료를 수정할 아이디를 입력해주세요");
		String id  = scan.next();
		
		String sql = "select count(*) cnt from mymember where mem_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt("cnt") == 0) {
					System.out.println("존재하지 않는 아이디입니다.");
					return;
				}
			}
		} catch (SQLException e) {}
		
		System.out.print("이름 입력 >");
		String name = scan.next();
		System.out.print("비밀번호 입력 >");
		String pw = scan.next();
		System.out.print("전화번호 입력 >");
		String tel = scan.next();
		System.out.print("주소 입력 >");
		String addr = scan.next();
		
		try {
			sql = "update mymember set "
					+ "MEM_NAME = ?, "
					+ "MEM_PASS = ?, "
					+ "MEM_TEL = ?, "
					+ "MEM_ADDR = ?"
					+ "where MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.setString(3, tel);
			pstmt.setString(4, addr);
			pstmt.setString(5, id);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("수정이 성공적으로 완료되었습니다");
			}else {
				System.out.println("수정실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException e){}
			if(stmt != null) try { stmt.close(); } catch(SQLException e){}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e){}
			if(conn != null) try {conn.close(); } catch(SQLException e){}
		}
		
		
		
	}

	private void insert() {
		conn = DBUtill.getConnection();
		String id = "";
		while(true) {
			System.out.print("아이디 입력 > ");
			id = scan.next();
			String sql = "select count(*) cnt from mymember where mem_id = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getInt("cnt") == 0) break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
		
			}
			
			
		
		}
		
		System.out.print("이름 입력 >");
		String name = scan.next();
		System.out.print("비밀번호 입력 >");
		String pw = scan.next();
		System.out.print("전화번호 입력 >");
		String tel = scan.next();
		System.out.print("주소 입력 >");
		String addr = scan.next();
		
		try {
			String sql = "insert into mymember values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pw);
			pstmt.setString(4, tel);
			pstmt.setString(5, addr);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("등록이 성공적으로 완료되었습니다");
			}else {
				System.out.println("등록실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch(SQLException e){}
			if(stmt != null) try { stmt.close(); } catch(SQLException e){}
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e){}
			if(conn != null) try {conn.close(); } catch(SQLException e){}
		}
		
	}

}
