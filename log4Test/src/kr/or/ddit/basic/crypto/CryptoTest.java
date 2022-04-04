package kr.or.ddit.basic.crypto;

import kr.or.ddit.util.CryptoUtill;

public class CryptoTest {

	public static void main(String[] args) throws Exception {
		String plainText = "Hello, World! 가나다라 1234 %^&*_+";
		String key = "a1b2c3d4e5f6g7h8"; // 암호화에 사용하는 키값 설정(16자리로한다)
		
		System.out.println("단방향 암호화 연습...");
		String result = CryptoUtill.sha512(plainText);
		
		System.out.println("원본 데이터   : " + plainText);
		System.out.println("SHA-512방식 : " + result);
		System.out.println();
		
		result = CryptoUtill.sha256(plainText);
		System.out.println("원본 데이터   : " + plainText);
		System.out.println("SHA-256방식 : " + result);
		System.out.println();
		
		result = CryptoUtill.md5(plainText);
		System.out.println("원본 데이터   : " + plainText);
		System.out.println("MD5방식     : " + result);
		System.out.println();
		System.out.println("------------------------------");
		
		System.out.println("양방향 암호화 연습 (AES256방식)");
		String encrptedStr = CryptoUtill.encryptoAES256(plainText, key);
		System.out.println("원본 데이터     : " + plainText);
		System.out.println("AES-256 암호화 : " + encrptedStr);
		
		String decryptedStr = CryptoUtill.decryptoAES256(encrptedStr, key);
		System.out.println("AES-256 복호화 : " + decryptedStr);
		
	}

}
