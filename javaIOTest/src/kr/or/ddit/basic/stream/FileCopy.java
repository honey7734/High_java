package kr.or.ddit.basic.stream;
/*
 	문제) D드라이브의 d_other폴더에 있는 '펭귄.jpg'파일을
 		 D드라이브의 d_other폴더에 있는 '연습용'폴더에
 		 '펭귄_복사본.jpg'파일로 복사하는 프로그램을 작성하시오
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
			
		File img = new File("d:/d_other/펭귄.jpg");
		
		if(!img.exists()) {
			System.out.println(img.getName() + "파일이 없습니다");
			System.out.println("복사작업을 중단합니다.");
			return;
		}
		

		try {
			// 복사할 파일 스트림 객체 생성
			FileInputStream fin = new FileInputStream(img);
			BufferedInputStream bin = new BufferedInputStream(fin);
			
			// 복사될 파일 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("d:/d_other/펭귄_복사본.jpg");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			System.out.println("복사 시작...");
		int data = 0; 
//		// fis.read()가 -1 이면 파일을 다 읽은것
//		while((data = fin.read()) != -1) {
//		    fout.write(data);
//		}
//		fout.flush();
		
		while ((data = bin.read())!= -1) {
			bout.write(data);
		}
		bout.flush();
		
		//스트림 닫기
		bin.close();
		bout.close();
		
		System.out.println("복사 작업 끝...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 파일을 선택하여 선택한 파일을 반환하는 메서드
	public File getSelectFile(String option) {
		return null;
	}
}
