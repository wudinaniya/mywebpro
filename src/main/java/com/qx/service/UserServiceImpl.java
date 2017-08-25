package com.qx.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qx.mapper.UserMapper;
import com.qx.mapper.VerifierMapper;
import com.qx.pojo.User;
import com.qx.utils.MyBeanUtils;
import com.qx.utils.MyConvert;
import com.qx.utils.UserMutate;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private VerifierMapper verifierMapper;
	
	@Override
	public List<UserMutate> findAll() throws Exception{
		//从数据库中查询出所有用户
		List<User> users = userMapper.findAll();
		//设置转换器
		//Date--->String
		MyConvert<Date, String> submitDateConvert=new MyConvert<Date, String>() {

			@Override
			public String convert(Date source) {
				// TODO Auto-generated method stub
				if (source!=null) {  //此处可不判空,因为数据库中要求,此项非空,对于没要求非空的必须判空
					SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
					return simpleDateFormat.format(source);
				}
				return "";
			}
		};
		
		//String--->String 即 0-->身份证,1-->护照,2-->其他
		MyConvert<String, String> certiTypeConvert=new MyConvert<String, String>() {
			
			@Override
			public String convert(String source) {
				// TODO Auto-generated method stub
				switch (source) {
				case "0":
					return "身份证";
				case "1":
					return "护照";
				case "2":
					return "其他";
				default:
					break;
				}
				return "";
			}
		};
		
		//Integer--->String 即 0-->未通过, 1-->通过
		MyConvert<Integer, String> resultConvert=new MyConvert<Integer, String>() {
			
			@Override
			public String convert(Integer source) {
				// TODO Auto-generated method stub
				switch (source) {
				case 0:
					return "未通过";
				case 1:
					return "通过";
				default:
					break;
				}
				return "";
			}
		};
		
		//Integer--->String 即 审核人id--->审核人姓名
		MyConvert<Integer, String> vidConvert=new MyConvert<Integer, String>() {
			
			@Override
			public String convert(Integer source) {
				// TODO Auto-generated method stub
				String name = verifierMapper.findVerifierNameById(source);
				return name;
			}
		};
		
		//必须以属性名作为key
		MyBeanUtils.addConvert("submitDate",submitDateConvert);
		MyBeanUtils.addConvert("certiType", certiTypeConvert);
		MyBeanUtils.addConvert("result", resultConvert);
		MyBeanUtils.addConvert("vid", vidConvert);
		
		try {
			//批处理
			List<UserMutate> userMutates=MyBeanUtils.populateBean(users, UserMutate.class);
			System.out.println(userMutates);
			return userMutates;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
