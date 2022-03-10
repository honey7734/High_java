package kr.or.ddit.basic.stream;
/*
 	문제) D드라이브의 d_other폴더에 있는 '펭귄.jpg'파일을
 		 D드라이브의 d_other폴더에 있는 '연습용'폴더에
 		 '펭귄_복사본.jpg'파일로 복사하는 프로그램을 작성하시오
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
			
		File img = new File("d:/d_other/펭귄.jpg");
		File imgcopy = new File("d:/d_other/펭귄_복사본.jpg");

		try {
		FileInputStream fin = new FileInputStream(img);
		FileOutputStream fout = new FileOutputStream(imgcopy);
		
		int fileByte = 0; 
		// fis.read()가 -1 이면 파일을 다 읽은것
		while((fileByte = fin.read()) != -1) {
		    fout.write(fileByte);
		}
		
		fout.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
