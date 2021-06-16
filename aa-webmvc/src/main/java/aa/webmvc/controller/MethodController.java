package aa.webmvc.controller;

import org.springframework.web.bind.annotation.*;

/**
 * RequestMappingHandler
 */
@RestController
@RequestMapping("/methodController")
public class MethodController {

	@GetMapping("/method1")
	public String demo() {
		System.out.println("methodController/method1");
		return "index";
	}

	@GetMapping("/method2/{id}")
	@ResponseBody
	public String demo2(@PathVariable("id") Integer id) {
		System.out.println("methodController/method2");
		return "index:" + id;
	}

	@GetMapping("/method3/{age}")
	@ResponseBody
	public String demo3(@PathVariable("age") Integer age) {
		System.out.println("methodController/method3");
		return "age:" + age;
	}
}
