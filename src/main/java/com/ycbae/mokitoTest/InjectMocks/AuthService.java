package com.ycbae.mokitoTest.InjectMocks;

public class AuthService {
	private AuthDao dao;

	// some code...
	public boolean isLogin(String id) {
		boolean isLogin = dao.isLogin(id);
		if (isLogin) {
			// some code...
		}
		return isLogin;
	}
}