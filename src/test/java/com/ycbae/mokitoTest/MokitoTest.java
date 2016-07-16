package com.ycbae.mokitoTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MokitoTest {
	Logger log = Logger.getLogger(this.getClass());

	@Mock
	Person p;

	@Test
	public void example() {
		Person p = mock(Person.class);
		assertTrue(p != null);
	}

	@Test
	public void example1() {
		MockitoAnnotations.initMocks(this);
		assertTrue(p != null);
	}

	@Test
	public void example2() {
		Person p = mock(Person.class);
		when(p.getName()).thenReturn("JDM");
		when(p.getAge()).thenReturn(20);
		assertTrue("JDM".equals(p.getName()));
		assertTrue(20 == p.getAge());
	}

	@SuppressWarnings("serial")
	@Test
	public void example3() {
		Person pp = mock(Person.class);
		when(pp.getList(anyString(), anyInt())).thenReturn(new ArrayList<String>() {
			{
				this.add("JDM");
				this.add("BLOG");
			}
		});

		List<String> list = pp.getList(eq("JDM"), anyInt());
		for (String item : list) {
			log.info(item);
		}

		when(pp.getList(eq("JDM"), anyInt()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void example4() {
		Person p = mock(Person.class);
		doThrow(new IllegalArgumentException()).when(p).setName(eq("JDM"));
		String name = "JDM";
		p.setName(name);
	}

	@Test
	public void example5() {
		Person p = mock(Person.class);
		doNothing().when(p).setAge(anyInt());
		p.setAge(20);
		verify(p).setAge(anyInt());
	}

	@Test
	public void example6() {
		Person p = mock(Person.class);
		String name = "JDM";
		p.setName(name);
		// n번 호출했는지 체크
		verify(p, times(1)).setName(any(String.class)); // success
		// 호출 안했는지 체크
		verify(p, never()).getName(); // success
		verify(p, never()).setName(eq("ETC")); // success
		// verify(p, never()).setName(eq("JDM")); // fail
		// 최소한 1번 이상 호출했는지 체크
		verify(p, atLeastOnce()).setName(any(String.class)); // success
		// 2번 이하 호출 했는지 체크
		verify(p, atMost(2)).setName(any(String.class)); // success
		// 2번 이상 호출 했는지 체크
		// verify(p, atLeast(2)).setName(any(String.class)); // fail
		// 지정된 시간(millis)안으로 메소드를 호출 했는지 체크
		verify(p, timeout(100)).setName(any(String.class)); // success
		// 지정된 시간(millis)안으로 1번 이상 메소드를 호출 했는지 체크
		verify(p, timeout(100).atLeast(1)).setName(any(String.class)); // success
	}
}
