package com.qx.utils;

public class UserMutate {
	private Integer id;  //id
	private String username; //用户名
	
	/*需转换*/
	private String submitDate; //提交日期
	
	/*需转换 "0"->身份证, "1"->护照, "2"->其他*/
	private String certiType; //证件类型
	
	/*需转换 0->未通过, 1->通过 */
	private String result;  //审核结果
	
	/*需要转换 审核人id-->审核人name*/
	private String vid;  //审核人id

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getCertiType() {
		return certiType;
	}

	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	@Override
	public String toString() {
		return "UserMutate [id=" + id + ", username=" + username + ", submitDate=" + submitDate + ", certiType="
				+ certiType + ", result=" + result + ", vid=" + vid + "]";
	}
}
