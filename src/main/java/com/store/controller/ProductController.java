package com.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/product")
public class ProductController {

	@RequestMapping(value="/getByScanId/{scanId}")
	public ResponseEntity<String> getByScanId(@PathVariable Long scanId)
	{
		return new ResponseEntity<String>(scanId.toString(), HttpStatus.OK);
	}
	
}
