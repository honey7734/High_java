package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setNum(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setNum(1);
		p2.setName("홍길동");
		
		Person p3 = p1;
		
		System.out.println(p1 == p2);  //false
		System.out.println(p1 == p3);  //true
		
		
		/*
		 * JVM
		 * 메소드 영역 - 클래스정보(Static)
		 *    클래스 정보가 디스켓에서 읽어서 저장
		 *    메서드가 뭐가있고 멤버변수가 뭐가 있고 등등 정보가 저장
		 *    ┌class EqualsHashCodeTest-------┐
		 *    │  main 메서드
		 * 	  └───────────────────────────────┘
		 * 콜스택 영억
		 *    main메서드 영역이 만들어짐
		 *    main메서드에 정의 된 변수들이 들어간다
		 *    ┌ main 메서드 영역─────────────────────────────┐
		 *    	Person <<< 다시 Person 클래스를 메서드 영역에 넣음 
		 *      p1 = new << 메서드 영역의 정보에 따라 힙영역에 저장
		 		p1 = 100번지
		 	  	setNum  => 메서드는 호출할때 만들어지고 작업이끝나면 없어진다
		 	  	getNum
		 	  	  :
		 	  	  
		 	  	p2 =  new ... > p2 = 200번지
		 	  	
		 	  	p3 = 100번지
		 	  	  
		 	  └───────────────────────────────────────────┘	
		 		
		 * 힙 영역
		 * 	┌ p1(100번지) ────────────────┐
		 *    1 홍길동 
		 *    set
		 *    get
		 *  └────────────────────────────┘
		 * 	┌ p2(200번지) ────────────────┐
		 *    1 홍길동
		 *    set
		 *    get
		 *  └────────────────────────────┘
		 *  
		 *  p1 == p2 --> 100번지 == 200번지 : false
		 *  p1 == p3 --> 100번지 == 100번지 : true
		 */
		
		System.out.println(p1.equals(p2));  //false
		//equals라는 메서드가 정의되어있지않은데 어떻게 사용할 수 있을까 ?
		//class는 상속을 아무것도 안받은 것처럼 되어있지만 사실 Object class를 상속받고 있다 equals라는 메서드는 Object에 이미 정의되어있는 메서드이다.
		//equals는 ==으로 비교되어 있는데 String 은 equals를 오버라이딩해서 true가 되는 것!
		
		HashSet<Person> testSet = new HashSet<Person>();
		
		testSet.add(p1);
		testSet.add(p3);
		
		System.out.println("Set의 size : " + testSet.size());  // 1개
		
		testSet.add(p2);
		System.out.println("Set의 size : " + testSet.size());  // 2개  --> 1개
		
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		System.out.println("p3 : " + p3.hashCode());
		
		/*
		 *  - equals() ==> 두 객체의 내용이 같은지 검사하는 메서드
		 *  - hashCode() ==> 두 객체의 동일성을 검사하는 메서드
		 */
		
		
	}

}

class Person{
	private int num;
	private String name;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj) {  // 참조값(주소값)이 같은지 검사
//			return true;
//		}
//		
//		if(obj == null) {
//			return false;
//		}
//		
//		// 같은 유형의 클래스인지 검사
//		if(this.getClass() != obj.getClass()) {
//			return false;
//		}
//		
//		// 매개변수값을 현재 객체 유형으로 형변환 한다.
//		Person that = (Person) obj;
//		
//		if(this.name == null && that.name != null) {
//			return false;
//		}
//		
//		if(this.num == that.num && this.name == that.name) {
//			return true;
//		}
//		
//		if(this.num == that.num && this.name.equals(that.name)) {
//			return true;
//		}
//		
//		return false;
//	}
	
	//alt+shift+s > Generate hashCode()&equals()
	@Override
	public int hashCode() {
		return Objects.hash(name, num);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name) && num == other.num;
	}
}