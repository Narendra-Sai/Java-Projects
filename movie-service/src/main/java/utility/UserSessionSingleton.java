package utility;

import java.util.HashMap;
import java.util.Map;

public class UserSessionSingleton {

	private static UserSessionSingleton instance;
	private static Map<String, UserSession> userInstances = new HashMap<String, UserSession>();

	private UserSessionSingleton() {
	}

	public static UserSessionSingleton getInstance() {
		if (instance == null) {
			instance = new UserSessionSingleton();
		}
		return instance;
	}

	public void setuser(String userid, UserSession user) {
		userInstances.put(userid, user);

	}

	public UserSession getuser(String userid) {

		if (userInstances.containsKey(userid)) {
			return userInstances.get(userid);
		}
		return null;
	}

}