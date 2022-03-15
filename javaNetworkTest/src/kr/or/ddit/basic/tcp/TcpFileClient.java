package kr.or.ddit.basic.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpFileClient {

	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("localhost",7777);
		System.out.println("서버에 연결되었습니다...");
		System.out.println();
		
		File file = new File("d://d_other/펭귄.jpg");
		
		OutputStream out = socket.getOutputStream();
        FileInputStream fin = new FileInputStream(file);
        System.out.println("파일전송시작...");
        
        int data = 0;
        while ((data = fin.read())!= -1) {
			out.write(data);
		}
		
        System.out.println("파일전송완료...");
        fin.close();
        out.close();
		
		
	}

}
