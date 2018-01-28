package com.interview.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "actors")
public class UserModel extends BaseResponse {


	@Id
	public String id;
	public String firstName;
	public String lastName;
	public String password;
	public String email;
	public String mobileNo;
	public String token;



	
}
