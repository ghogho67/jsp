package kr.or.ddit.user.model;

public class UserVo {
	private String name;
	private String userId;
	private String alais;
	
	
	
	//커트롤 쉬프트 o
	public UserVo(String name, String userId, String alais) {
		super();
		this.name = name;
		this.userId = userId;
		this.alais = alais;
	}
	
	public UserVo(){
		
	}
	
	@Override
	public String toString() {
		return "UserVo [name=" + name + ", userId=" + userId + ", alais="
				+ alais + "]";
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
		return alais;
	}
	public void setAlais(String alais) {
		this.alais = alais;
	}
	

}
