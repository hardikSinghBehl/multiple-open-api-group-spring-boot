package com.behl.agares.controller.nsfw;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.behl.agares.constant.Joke;
import com.behl.agares.service.JokeService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/nsfw")
@AllArgsConstructor
public class NotSafeForWorkJokeController {

	private final JokeService jokeService;

	@GetMapping(value = "/joke", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Returns NSFW Joke")
	public ResponseEntity<?> jokeRetreivalHandler() {
		return ResponseEntity.ok(jokeService.get(Joke.NSFW));
	}

}
