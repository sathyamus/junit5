package com.snsystems;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class ArithmeticServiceTest {

	@Test
	@DisplayName("addition")
	public void test(TestInfo testInfo) {
		ArithmeticService arithmeticService = new ArithmeticService();
		assertThat(arithmeticService.add(1, 1)).isEqualTo(2);
	}

}
