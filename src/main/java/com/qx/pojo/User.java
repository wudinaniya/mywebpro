package com.qx.pojo;

import java.util.Date;

public class User {
	private Integer id;        //id
	private String username;   //用户名
	private Date submitDate;   //提交日期
	private String certiType;  //证件类型 //数据库中存的是字符串0,2,3
	private int result;        //审核结果  //数据库中存的是Integer类型 0或1
	private Integer vid;       //审核人id

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

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getCertiType() {
		return certiType;
	}

	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}
}
