package com.expressiontree.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expressiontree.services.ExpressionTreeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/expressiontree")
@Api(value="Expression Tree API")
public class ExpressionController {
	
	@Autowired
	private ExpressionTreeService expressionTreeService ;
	
	private static final Logger log = LoggerFactory.getLogger(ExpressionController.class);


	@ApiOperation(value = "View a list of available employees", response = Integer.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully Evaluated"),
		    @ApiResponse(code = 500, message = "Internal Error Happend while processing your request")
		})
	@GetMapping("/evaluate")
	public int evaluateExp(@RequestParam("expression") String expStr) {
	
		log.info("Request Received for Evaluate : {}" , expStr);
		
		return expressionTreeService.eval(expStr);
	}

}
