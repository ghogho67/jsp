package kr.or.ddit.calculator;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


public class CalculatorTest {

	@Test
	public void empty_test() {
		
		//3.문자열이 공백이거나, null이면 0을 리턴 : "", null ==> 0
		/***Given***/
		Calculator cal = new Calculator();
		String text = "";
		
		/***When***/
		int result = cal.calculate(text);
		/***Then***/
		assertEquals(0, result);
	}
	
	@Test
	public void null_test() {
		
		//3.문자열이 공백이거나, null이면 0을 리턴 : "", null ==> 0
		/***Given***/
		Calculator cal = new Calculator();
		String text = null;
		
		/***When***/
		int result = cal.calculate(text);
		/***Then***/
		assertEquals(0, result);
	}
	
	
	
	//2.구분자는 두가지가 가능 : "," , ":"   ex) "1,5:10,20"  ==> 36
	@Test
	public void defaultseperatorTest(){
		/***Given***/
		Calculator cal = new Calculator();
		String text = "1,5:10,20";

		/***When***/
		int result = cal.calculate(text);
		
		/***Then***/
		assertEquals(36, result);

	}
	
	//4.문자열 시작이 "//"과 "\n" 통해 커스텀 구분자를 지정할 수 있다.
	@Test
	public void customSeperatorTest(){
		/***Given***/
		Calculator cal = new Calculator();
		String text ="//;\n1;5;10;20";

		/***When***/
		int result = cal.calculate(text);
		/***Then***/
		assertEquals(36, result);

	}
	
	
	@Test
	public void regexpCaptureTest(){
		/***Given***/
		String text ="//;\n1;5;10;20";

		/***When***/
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text); // .은 하나이상의 문자가 올꺼다 , *모든것
		m.find(); // 매칭 되는지 찾는거 매칭 한번해야된다.
		String customSeperator = m.group(1); // 
		String textNumbers = m.group(2);
		
		/***Then***/
		assertEquals(";", customSeperator);
		assertEquals("1;5;10;20", textNumbers);

	}
	
	
	
	//5.숫자 구분자는 커스텀 구분자와, 기본 구분자 두가지를 섞어 사용할 수 있다.
		// "//;\n1;5;10:20" => 36
	@Test
	public void custom_default_seperationTest(){
		/***Given***/
		Calculator cal = new Calculator();
		String text = "//.\n1.5;10:20";

		/***When***/
		int result = cal.calculate(text);

		/***Then***/
		assertEquals(36, result);
	}
	
	//test가 끝나고 중복되는 부분이있는지, 간략하게 가능한지 고려하여 다시 한번 봐야한다.
	
	
	
	
	

}
