package kr.or.ddit.basic;


import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.vo.LprodVO;

/*
	Lprod테이블에 새로운 데이터를 추가하기

	lprod_gu와 lprod_nm은 직접 입력받아서 처리하고,
	lprod_id는 현재의 lpord_id중에서 제일 큰 값보다 1크게 한다.

	그리고 lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.

	(SQL문이 저장되는 xml문서의 파일명 :jdbc.xml)
*/
public class JdbcToIbatisTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);
			
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/sqlMapConfig.xml");
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();	// 스트림 닫기
			
			int max = (int) smc.queryForObject("lprod2.maxId");
			
			
			String gu = "";
			while(true) {
				System.out.print("상품분류코드 입력 : ");
				gu = scan.nextLine();
				
				int count = (int) smc.queryForObject("lprod2.selectGu", gu);
				if(count > 0) {
					System.out.println("입력된 상품분류코드 " + gu + "는 이미 등록된 코드입니다.");
					System.out.println("다시 입력하세요");
				}else {
					break;
				}
				
			};
			
			
			System.out.print("상품분류명 입력 : ");
			String nm = scan.nextLine();
			
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(max+1);
			lvo.setLprod_gu(gu);
			lvo.setLprod_nm(nm);
			
			Object obj = smc.insert("lprod2.insertLprod",lvo);
			
			if(obj == null) {
				System.out.println("등록 성공~");
			}else {
				System.out.println("등록 실패");
			}
			
			
			System.out.println();
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
