package com.app.activities.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class DailyActivityController {
	  @GetMapping(value = "/get/name")
	  public String getUserMenu() {
		  return "Surya";
	  }
}
