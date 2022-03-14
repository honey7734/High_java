package kr.or.ddit.basic.tcp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXexample {

	public static void main(String[] args) throws Exception {
		File file = new File("d://d_other/example.xml");
		
		//1. parser factory 생성
		SAXParserFactory factory =  SAXParserFactory.newInstance();
		
		//2. parser 생성
		SAXParser parser = factory.newSAXParser();
			
		//3. event handler 생성
		PeopleSaxHandler handler = new PeopleSaxHandler();
			
		//4. parser 호출/실행시 event handler 할당
		parser.parse(file, handler);
		
		
		// 출력하기
		List<Person> list = handler.getPersonList();
		
		for(Person p:list) {
			System.out.println(p);
		}
		
	}

}

class Person{
	private String name;
	private int age;
	private String tel;
	private String addr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "이름 :" + name + ", 나이 : " + age + ", 전화번호 : " + tel + ", 주소 : " + addr;
	}
}

class PeopleSaxHandler extends DefaultHandler{
	// 파싱한 Person객체를 널을 리스트
	private List<Person> personList;
	
	// 파싱한 Person 객체
	private Person person;
	
	//character 메소드에서 저장할 문자열 변수
	private String str;

	public PeopleSaxHandler() {
		personList = new ArrayList<Person>();
	}
	
	// 시작태그를 만났을 때 발생하는 이벤트 - startElement()
	public void startElement(String uri, String localName, String name, Attributes att) {
		if(name.equals("Person")) {
			person = new Person();
			personList.add(person);
		}
	}
	
	// 끝 태그를 만났을 때 발생하는 이벤트 - endElement()
	public void endElement(String uri, String localName, String name) {
		if(name.equals("age")) {
			person.setAge(Integer.parseInt(str));
		}else if(name.equals("name")) {
			person.setName(str);
		}else if(name.equals("tel")) {
			person.setTel(str);
		}else if(name.equals("addr")) {
			person.setAddr(str);
		}
	}
	
	// 태그와 태그 사이의 내용을 처리 - characters()
	public void characters(char[] ch, int start, int length) {
		str = new String(ch,start,length);
	}
	
	
	public List<Person> getPersonList(){
		return personList;
	}
	public void setPersonList(List<Person> personList) {
		this.personList=personList;
	}
	
}