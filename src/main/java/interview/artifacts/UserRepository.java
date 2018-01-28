package interview.artifacts;
import com.interview.model.UserModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends MongoRepository<UserModel, String> {
	
    @Query("{'$and' : [{'email' :?0 }, {'password' : ?1}]}")
	UserModel findByAuth(@Param("email") String email,@Param("password") String password);
}
