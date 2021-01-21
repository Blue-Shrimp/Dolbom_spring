package com.dolbom.controller.facility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dolbom.service.FacilityService;

@Controller
@RequestMapping("/customer/facility/")
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list() {
		return "customer/facility/list";
	}

}
