package com.behl.agares.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.behl.agares.constant.Joke;

@Service
public class JokeService {

	private final String NSFW_JOKE = "Tiger Woods goes to Japan for a golf tournament. The night before, he hires a prostitute. As they are having sex, the prostitute is shouting, \"Hoshimoto!\" Tiger doesn't know any Japanese, but he figures she is saying she is satisfied.\n"
			+ "The next day at the tournament, on the 18th hole, Tiger makes a hole-in-one. The crowd starts cheering for him, but he can't thank them because he doesn't know Japanese except for what the prostitute said. So he blurts out, \"Hoshimoto!\"\n"
			+ "The crowd becomes confused by what he just said. So one of his Japanese friends walks up to him and says, \"What do you mean wrong hole?\"";
	private final String SFW_JOKE = "Nothing ruins a Friday more than an understanding that today is Tuesday.";

	public JSONObject get(final Joke joke) {
		final var response = new JSONObject();
		response.put("joke", Joke.NSFW.equals(joke) ? NSFW_JOKE : SFW_JOKE);
		return response;
	}

}
