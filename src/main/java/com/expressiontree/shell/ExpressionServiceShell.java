package com.expressiontree.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.expressiontree.services.ExpressionTreeService;

@ShellComponent
public class ExpressionServiceShell {

	@Autowired
	private ExpressionTreeService expressionTreeService;

	@ShellMethod( value="Evaluate an Expression")
	public int evaluate(String expStr) {

		return expressionTreeService.eval(expStr);
	}

}
