package springapp;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@PostMapping("/login")
	@CrossOrigin
	public int Login(String email, String mdp) throws SQLException {
		Client c = new Client();
		c.setEmail(email);
		c.setMdp(mdp);		
		return c.Login();
	}

	@PostMapping("/updateDemande")
	@CrossOrigin
	public int RechargerCompte (int idClient) throws Exception{
		Client cl = new Client();
		cl.setIdClient(idClient);
		return cl.RechargerCompte();

	}

	@PostMapping("/inscription")
	@CrossOrigin
	public int Inscrisption() throws Exception{
		Client c = new Client();
		return c.Inscrisption();
	}

}