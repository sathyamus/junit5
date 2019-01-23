package com.snsystems;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class PlatformTest {

    @BeforeAll
    static void setup(){
        System.out.println("@BeforeAll executed");
    }
    
	@BeforeEach
	public void setupThis() {
		System.out.println("method will be run before each test method in the test class");
	}
	
	@AfterEach	
	public void tearThis() {
		System.out.println("method will be run after each test method in the test class");
	}
	
	@AfterAll
    static void tear(){
        System.out.println("@AfterAll executed");
    }
	
	@Test
	@Tag("DEV")
	@RepeatedTest(3)
	public void test_DEV() {
		assertThat(true).isEqualTo(true);
		System.out.println("Test Impl");
	}
	
	@Test
	@Tag("PROD")
	@Disabled // equivalent to JUnit 4’s @Ignored annotation.
	public void test_PROD() {
		assertThat(true).isEqualTo(true);
		System.out.println("Test Impl");
	}	

	
	@Test
	public void testOnDevEnv() {
		System.setProperty("ENV", "DEV");
		Assertions.assertEquals("DEV", System.getProperty("ENV"));
		
		Assumptions.assumeTrue("DEV".equalsIgnoreCase(System.getProperty("ENV")));
		System.out.println("testOnDevEnv");
	}
	
	@Test
	public void testOnProdEnv() {
		System.setProperty("ENV", "PROD");
		Assertions.assertNotEquals("DEV", System.getProperty("ENV"));
		
		Assumptions.assumeTrue("DEV".equalsIgnoreCase(System.getProperty("ENV")));
		System.out.println("testOnProdEnv");
	}
	
}
