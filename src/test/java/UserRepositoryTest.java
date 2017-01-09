
import org.junit.Before;
import org.junit.Test;

import com.soap.entity.Packet;
import com.soap.entity.Route;
import com.soap.entity.User;
import com.soap.entity.UserRole;
import com.soap.repository.BaseRepository;
import com.soap.repository.UserRepository;
import com.soap.webservice.impl.UserWSImpl;

public class UserRepositoryTest {

	UserWSImpl userws = new UserWSImpl();
	private BaseRepository bs = new BaseRepository();
	UserRepository ur = new UserRepository();
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
		// packet = new Packet("Navigator", "Auto android", rox, bog, "Cluj",
		// "Timisoara", false);
		// Route route = new Route("12.24.1222", "Cina", bs.get(Packet.class,
		// 1));
		// bs.save(route);

		for (Packet p : userws.getAllPackets("bog")) {
			System.out.println(p.getDescription());
		}
	}

}
