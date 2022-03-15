package kr.or.ddit.basic.tcp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7777);
		System.out.println("파일전송 대기중입니다.");
		System.out.println();
		
		Socket socket = server.accept();
		
		System.out.println("연결완료");
		
		File file = new File("d://d_other/down/펭귄_전송본.jpg");
		InputStream in = socket.getInputStream();        
        FileOutputStream fout = new FileOutputStream(file);

        System.out.println("다운 시작...");
        int data = 0;
        while ((data = in.read())!= -1) {
			fout.write(data);
		}
        System.out.println("다운 완료...");

        fout.close();
        in.close();
		
	}

}
