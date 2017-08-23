package com.qx.mapper;

public interface VerifierMapper {

	//根据审核人id查询审核人名字
	public String findVerifierNameById(Integer id);
}
