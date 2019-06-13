<%@tag import="java.util.List"%>
<%@tag import="kr.or.ddit.prod.model.ProdVo"%>
<%@tag import="kr.or.ddit.prod.service.ProdService"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="code" type="java.lang.String" required="true"%>

<%
// 	String code = (String)jspContext.getAttribute("code");//이것이 prod_lgu
// 	ProdService service = new ProdService();
// 	List<ProdVo> prodVoList = service.selectProd(code);
// 	request.setAttribute("prodVoList", prodVoList);
	ProdService service = new ProdService();
	request.setAttribute("prodVoList", service.selectProd(code));
%>

<select>
<c:forEach items="${prodVoList }" var="prod" >
	<option value="${prod.prod_id }">${prod.prod_name }</option>

</c:forEach>
</select>