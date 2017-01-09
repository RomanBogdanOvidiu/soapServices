import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.soap.Application;
import com.soap.entity.Packet;
import com.soap.entity.Route;
import com.soap.entity.User;
import com.soap.entity.UserRole;
import com.soap.repository.PacketRepository;
import com.soap.repository.RouteRepository;
import com.soap.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PacketRepository packetRepository;

	@Autowired
	private RouteRepository routeRepository;

	User receiver;
	User sender;
	Packet packet;
	Route route;

	@Before
	public void saveUser() {
		// route = new ArrayList<>();
		receiver = new User("Laura", UserRole.ADMIN, "parola");
		sender = new User("Bogdan", UserRole.ADMIN, "parola");

		receiver = userRepository.save(receiver);
		sender = userRepository.save(sender);

	}

	@Test
	public void getUser() {

		packet = new Packet("Creioane", "Foarte colorate", sender, receiver, "Cluj", "Floresti", false);
		packet = packetRepository.save(packet);

		route = new Route("12.01.2016", "Manastru", packet);
		route = routeRepository.save(route);

		packet.getPackRoute().add(route);
		packet = packetRepository.save(packet);
	}
}
