package kr.or.ddit.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.utill.PartUtill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize = 1024*1024) // maxFileSize = 3메가 maxnRequestSize = *15 하면 15메가
public class FileUploadServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadServlet.class);
	
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자아이디 userId , profile 파라미터를 확인
				String userId = request.getParameter("userId");
				String profile = request.getParameter("profile");
				
				logger.debug("userId : {}", userId);
				logger.debug("profile : {}", profile);

				Part part =request.getPart("profile"); // fileUploadForm input에 적은 프로파일 을 적으면된다. 반환값을 part 이다.
				//part.getsize , write, getName을 써볼것이다.
				logger.debug("part.getSize() : {} ", part.getSize());
				
//				logger.debug("part.getContentType() : {}", part.getContentType());
//				logger.debug("part.getName : {}" , part.getName()); //파라미터 이름을 보내줌
//				Collection<String> headerNames = part.getHeaderNames();
//				for(String header : headerNames){
//					logger.debug("{}  : {}" ,header, part.getHeaderNames()); 경로 이름을 위해 필요하다.
//				}
				
				
				//파일이 존재 할 때만 파일을 정해진 위치에 기록한다.
				if(part.getSize() > 0){
					
					String contentDisposition = part.getHeader("content-disposition");
					String fileName = PartUtill.getFileName(contentDisposition);
					String ext = PartUtill.getExt(fileName);
					
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
						part.delete();
					}
				}
				
	}

}
