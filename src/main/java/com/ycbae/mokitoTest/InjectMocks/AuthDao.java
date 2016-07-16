package com.ycbae.mokitoTest.InjectMocks;

public class AuthDao {
	public boolean isLogin(String id) { // some code ...
		if(id.equals("user")){
			return true;
		}
		return false;
	}
}