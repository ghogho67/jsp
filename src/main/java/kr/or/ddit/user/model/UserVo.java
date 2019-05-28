package kr.or.ddit.user.model;

import org.apache.ibatis.type.Alias;

@Alias("userVo")
public class UserVo {
	private String name;
	private String userId;
	private String alias;
	
	
	
	//커트롤 쉬프트 o
	public UserVo(String name, String userId, String alias) {
		super();
		this.name = name;
		this.userId = userId;
		this.alias = alias;
	}
	
	public UserVo(){
		
	}
	
	@Override
	public String toString() {
		return "UserVo [name=" + name + ", userId=" + userId + ", alias="
				+ alias + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAlais() {
		return alias;
	}
	public void setAlais(String alais) {
		this.alias = alais;
	}
	

}
