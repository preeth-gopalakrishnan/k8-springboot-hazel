package com.example.k8springboothazel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Component
public class CacheUtil {

	@Autowired()
	private HazelcastInstance instance;

	
	public String getCache(final String cacheName, final String key){
		IMap<String, String> imap = instance.getMap(cacheName);
		return imap.get(key);
	}

	public String putCache(final String cacheName, final String key, final String value){
		IMap<String, String> imap = instance.getMap(cacheName);
		return imap.put(key, value);
	}
}
