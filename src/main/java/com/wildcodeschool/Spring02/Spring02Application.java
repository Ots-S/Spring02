package com.wildcodeschool.Spring02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class Spring02Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring02Application.class, args);
    }


    @RequestMapping("/doctor/{number}")
    @ResponseBody
    public String doctor(@PathVariable int number) {
        if (number == 9) {
			return "number: " + number + " name : Christopher Eccleston";
		}
        if (number == 10) {
			return "number: " + number + " name : David Tennant";
		}
        if (number == 11) {
			return "number: " + number + " name : Matt Smith";

		}
        if (number == 12) {
			return "number: " + number + " name : Peter Capaldi";
		}
        if (number == 13) {
			return "number: " + number + " name : Jodie Whittaker";
		}
		if (number > 0 && number < 9) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "303 See Other.");
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number );
		}
    }
}


