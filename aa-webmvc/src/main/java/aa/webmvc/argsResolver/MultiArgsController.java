package aa.webmvc.argsResolver;

import org.springframework.web.bind.annotation.*;

/**
 * @author slk
 */
@RestController
public class MultiArgsController {

	@GetMapping("/pathVariable/{id}")
	public String pathVariableResolver(@PathVariable("id") Integer id) {
		return "pathVariableResolver" + id;
	}

	@PostMapping("/requestBody")
	public LoginTo pathVariableResolver(@RequestBody LoginTo loginTo) {
		return loginTo;
	}

	@GetMapping("/self")
	public String selfResolver(@SetUserId Integer id) {
		return id.toString();
	}
}
