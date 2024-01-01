package demo.dao;

import demo.api.dto.RegistrationData;
import demo.model.User;

public interface UserDAO {
	User createUser(RegistrationData data);

	User readUser(int id);

	User readUser(String userName);
}
