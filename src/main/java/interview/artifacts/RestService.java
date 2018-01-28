package interview.artifacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.interview.model.UserModel;

@RestController
public class RestService {

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/sign_in", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> signIn(@RequestBody UserModel name) {
		UserModel list = userRepository.findByAuth(name.email, name.password);
		if (list != null) {
			list.token = "jwt:token..";
			return new ResponseEntity<UserModel>(list, HttpStatus.OK);
		} else {
			UserModel baseResponse = new UserModel();
			baseResponse.message = "invaild auth";
			return new ResponseEntity<UserModel>(baseResponse,HttpStatus.BAD_REQUEST);
	
		}

	}

}
