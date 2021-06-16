package aa.webmvc.argsResolver;

import lombok.Data;

import java.io.Serializable;

/**
 * @author slk
 */
@Data
public class LoginTo implements Serializable {
	private String username;
	private String password;
}
