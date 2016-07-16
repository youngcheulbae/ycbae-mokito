package com.ycbae.mokitoTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ycbae.mokitoTest.InjectMocks.AuthDao;
import com.ycbae.mokitoTest.InjectMocks.AuthService;

public class InjectMocksTest {
	@Mock
	AuthDao dao;

	/**
	 * @Spy로 선언된 목 객체는 목 메소드stub를 별도로 만들지 않는다면 실제 메소드가 호출된다.
	 */
	// @Spy
	// AuthDao dao;

	@InjectMocks
	AuthService service;

	@Test
	public void example() {
		MockitoAnnotations.initMocks(this);
		when(dao.isLogin(eq("JDM"))).thenReturn(true);
		assertTrue(service.isLogin("JDM") == true);
		assertTrue(service.isLogin("ETC") == false);
		assertTrue(service.isLogin("user") == false);
	}
}
