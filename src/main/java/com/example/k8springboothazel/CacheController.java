package com.example.k8springboothazel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

	@Autowired
	private CacheUtil cacheUtil;

	@RequestMapping(value = "/put/{key}/{value}", method = RequestMethod.GET)
	public void put(@PathVariable final String key, @PathVariable final String value) {
		cacheUtil.putCache("mycache", key, value);
	}

	@RequestMapping(value = "/get/{key}", method = RequestMethod.GET)
	public void get(@PathVariable final String key) {
		cacheUtil.getCache("mycache", key);
	}
}
