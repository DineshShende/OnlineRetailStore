package com.store.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.AddProductRequest;
import com.store.dto.DetailedBillResponse;
import com.store.entity.Bill;
import com.store.service.BillDetailsService;

@RestController
@RequestMapping(value = "/bill")
public class BillDetailsController {
	
	@Autowired
	BillDetailsService billDetailsService;
	
	@RequestMapping(value = "/init")
    public ResponseEntity<Bill> intializeBill() {
		Bill bill=billDetailsService.intializeBill();
		
		return new ResponseEntity<Bill>(bill,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addProduct",method=RequestMethod.POST)
    public ResponseEntity<DetailedBillResponse> addProduct(@RequestBody @Valid AddProductRequest addProductRequest,BindingResult bindingResult) {

		if(bindingResult.hasErrors())
			return new ResponseEntity<DetailedBillResponse>(HttpStatus.NOT_ACCEPTABLE);
    	    		
		try{
			DetailedBillResponse detailedBillResponse=billDetailsService.handleAddProductRequest(addProductRequest);
			return new ResponseEntity<DetailedBillResponse>(detailedBillResponse, HttpStatus.OK);
		}catch (ResourceNotFoundException exception) {
			return new ResponseEntity<DetailedBillResponse>(HttpStatus.NOT_FOUND);
		}
    	
        
    }

}
