package kr.or.ddit.utill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtill {

	private static final Logger logger = LoggerFactory
			.getLogger(PartUtill.class);
	
	/**
	* Method : getFileName
	* 작성자 : PC21
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition에서 파일명을 반환한다.
	*/
	public static String getFileName(String contentDisposition) {
//		form-data; name="profile"; filename="sally.png" 이렇게 나오는데 이름을 다시한번 구분한다.
		String result[] = contentDisposition.split(";");
		String[] fileName = result[2].split("\"");
		
//		for (int i = 0; i < result.length; i++) {
//			logger.debug("result[] : {}", result[i]);
//		}
		
		
		return fileName[1];
	}

	/**
	* Method : getExt
	* 작성자 : PC21
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 : 파일명으로 부터 확장자를 받아오는 메서드
	*/
	public static String getExt(String fileName) {
		
	
		String[] file = fileName.split("\\.");
		if(file.length == 1){
			return "";
		}else{
			return "."+file[file.length-1];
		}
		
		
	}

}
