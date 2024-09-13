package Assignment2.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication

@RestController

public class Assignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}


	@GetMapping("/random")
	public Object randomNum() {
try {
		String url = "http://numbersapi.com/random/year?json";
	RestTemplate restTemplate = new RestTemplate();
	ObjectMapper mapper = new ObjectMapper();

	String jsonListResponse = restTemplate.getForObject(url, String.class);
	JsonNode root = mapper.readTree(jsonListResponse);

	Number numbFact = new Number(root.get("text").asText(), root.get("number").asInt(), root.get("type").asText());
	return numbFact;

} catch (Exception e) {
    throw new RuntimeException(e);
}
    }



}


