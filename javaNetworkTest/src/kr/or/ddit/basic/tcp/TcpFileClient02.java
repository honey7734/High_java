package kr.or.ddit.basic.tcp;

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFileChooser;

// Open Dialog를 이용하여 전송한 파일을 선택하여 서버로 전송한다.
// 이 때 파일 이름도 전송한다.

public class TcpFileClient02 {
	
	private Socket socket;
	private BufferedInputStream  bis;
	private BufferedOutputStream bos;
	
	private DataOutputStream dos;
	
	public void ClinetStart() {

		File selectedFile = getSelectFile("OPEN");
			
		try {
			socket = new Socket("localhost",7777);
			
			System.out.println("파일 전송 시작...");
			
			// 선택한 파일의 이름 전송하기
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(selectedFile.getName());
				
			bis = new BufferedInputStream(new FileInputStream(selectedFile));
			bos = new BufferedOutputStream(socket.getOutputStream());
				
			byte[] temp = new byte[1024];
			int len = 0;
				
			while((len = bis.read(temp)) > 0) {
				bos.write(temp, 0, len);
			}
			bos.flush();
			System.out.println("파일 전송 완료...");
				
		} catch (Exception e) {
			System.out.println("파일 전송 실패!!!");
			e.printStackTrace();
		}finally {
			if(bos != null) try{bos.close();}catch(IOException e) {}
			if(bis != null) try{bis.close();}catch(IOException e) {}
			if(socket != null) try{socket.close();}catch(IOException e) {}
		}
	}
	
	public static void main(String[] args) {
		new TcpFileClient02().ClinetStart();
	}
	
	// 파일을 선택하여 선택한 파일을 반환하는 메서드
	public File getSelectFile(String option) {
		JFileChooser chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(true);
		chooser.setCurrentDirectory(new File("d:/d_other"));
		
		int result;
		if("OPEN".equals(option)) {
			result = chooser.showOpenDialog(new Panel());
		}else if("SAVE".equals(option)) {
			result = chooser.showSaveDialog(new Panel());
		}else {
			System.out.println("option이 잘못되었습니다");
			return null;
		}
		
		File selectedFile = chooser.getSelectedFile();
		System.out.println("선택한 파일 : " + selectedFile.getAbsolutePath());
		return selectedFile;
	}
}
