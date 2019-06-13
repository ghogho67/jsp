package kr.or.ddit.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.utill.PartUtill;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test1234")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize = 1024*1024) // maxFileSize = 3메가 maxnRequestSize = *15 하면 15메가
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(Test.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> filenm = new ArrayList<String>();
		List<String> filePath = new ArrayList<String>();
		
		Collection<Part> parts = request.getParts();
		for(Part part : parts){
			if(part.getName().equals("profile") && part.getSize() > 0){
				
				String contentDisposition = part.getHeader("content-disposition");
				
				logger.debug("contentDisposition : {}", contentDisposition);
				
				String file = PartUtill.getFileName(contentDisposition);
				filenm.add(file);
				logger.debug("fileName : {}", file);
				
				String ext = PartUtill.getExt(file);
				logger.debug("ext : {}", ext);
				
				//년도에 해당하는 폴더가 있는지, 년도안에 월에 해당하는 폴더가있는지 
				Date dt = new Date();
				SimpleDateFormat yyyyMmSdf = new SimpleDateFormat("yyyyMM"); 
				String yyyyMm = yyyyMmSdf.format(dt);
				String yyyy = yyyyMm.substring(0,4);
				String mm= yyyyMm.substring(4);
				
				
				String uploadpath = PartUtill.getUploadPath();
				File uploadFolder = new File(uploadpath);
					if(uploadFolder.exists()){
						//파일 디스크에 쓰기 / UUID.randomUUID 이름값을 중복이 안되게 임의의 값으로 출력한다.
						part.write( uploadpath +"\\"+ UUID.randomUUID() + ext);  // 경로를 써준다.
						String path = uploadpath +"\\"+ UUID.randomUUID() + ext;
						filePath.add(path);
						part.delete();
					}
				}
		}
		logger.debug("filenm : {}" , filenm);
		logger.debug("filePath : {}" , filePath);
		
	}

}
