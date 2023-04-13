package com.bsva.dcqs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcqsServiceController 
{
@RequestMapping("/")
public String hello() 
{
return "Hello javaTpoint";
}
}
