package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@Value("${property.file}")
	String value;
	

	
@GetMapping(value = "/index")
public String indexJsp() {
	
	return "index";
}
}
