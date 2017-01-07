import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.soap.Application;
import com.soap.entity.Packet;
import com.soap.entity.User;
import com.soap.entity.UserRole;
import com.soap.repository.PacketRepository;
import com.soap.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PacketRepository packetRepository;

	User receiver;
	User sender;
	Packet packet;

	@Before
	public void saveUser() {
		receiver = new User("Laura", UserRole.ADMIN, "parola", new ArrayList<>(), new ArrayList<>());
		sender = new User("Bogdan", UserRole.ADMIN, "parola", new ArrayList<>(), new ArrayList<>());
		packet = new Packet();
		packet.setDescription("ALIBABABABA");
		packet.setDestinationCity("Cluj");
		packet.setPackName("UnTelefon");

		packet.setSenderCity("Bucharest");
		packet.setTracking(true);

		receiver = userRepository.save(receiver);
		sender = userRepository.save(sender);

		packet.setReceiver(receiver);
		packet.setSender(sender);

		packet = packetRepository.save(packet);
	}

	@Test
	public void getUser() {
		User userica = userRepository.findUserByUsername("Laura");
		assertEquals("parola", userica.getPassword());

	}
}
