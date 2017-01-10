
import org.junit.Before;
import org.junit.Test;

import com.soap.entity.Packet;
import com.soap.entity.Route;
import com.soap.entity.User;
import com.soap.entity.UserRole;
import com.soap.repository.BaseRepository;
import com.soap.repository.UserRepository;
import com.soap.webservice.AdminWS;
import com.soap.webservice.impl.AdminWSImpl;

public class UserRepositoryTest {

	private BaseRepository bs = new BaseRepository();
	UserRepository ur = new UserRepository();
	AdminWS admws = new AdminWSImpl();
	User receiver;
	User sender;
	Packet packet;
	Route route;

	@Before
	public void saveUser() {
		receiver = new User("bog", UserRole.CLIENT, "1212");
		sender = new User("rox", UserRole.ADMIN, "1212");

	}

	@Test
	public void getUser() {
		// User rox = ur.getUserByUsername("rox");
		// User bog = ur.getUserByUsername("bog");
		// AdminWS adminWS = new AdminWSImpl();
		// Packet p = new Packet("packetmare", "taremare",
		// ur.getUserByUsername("bog"), ur.getUserByUsername("rox"),
		// "oras1", "oras2", false);
		// Route route = new Route("data", "oras3", bs.get(Packet.class, 1));
		// bs.save(route);
	}

}
