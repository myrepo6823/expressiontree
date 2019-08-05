package com.expressiontree.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.expressiontree.services.ExpressionTreeService;

@ExtendWith(SpringExtension.class)
public class ExpressionTreeServiceImplTest {


	private ExpressionTreeService expressionTreeService = new ExpressionTreeServiceImpl();

	@Test
	public void testEval1() {

		int result = expressionTreeService.eval("10 + 2 * 6");
		assertEquals(22, result);
	}

	@Test
	public void testEval2() {

		int result = expressionTreeService.eval("(1+2) * (4 - 2)");
		assertEquals(6, result);
	}

	@Test
	public void testEval3() {

		int result = expressionTreeService.eval("1+2*3");
		assertEquals(7, result);
	}

}
