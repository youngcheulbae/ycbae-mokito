package com.ycbae.mokitoTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MokitoTest {
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
		when(p.getList(anyString(), anyInt())).thenReturn(new ArrayList<String>() {
			{
				this.add("JDM");
				this.add("BLOG");
			}
		});
		when(p.getList(eq("JDM"), anyInt()));
	}
}
