package com.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.User;

@RestController
public class KafkaController {

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "test-topic";

	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name) {

		template.send(topic, "Hi  " + name + "  Welcome to Kafka World !!!");
		return "Data Published !!!";

	}

	@GetMapping("/publishJson")
	public String publishMessage() {
		User user = new User(232, "Mukesh", new String[] { "Bangalore ", "BTM ", "House 90" });

		template.send(topic, user);
		return "Json Data Published !!!";

	}

}
