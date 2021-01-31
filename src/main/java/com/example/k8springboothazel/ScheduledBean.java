package com.example.k8springboothazel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Component
public class ScheduledBean {

	@Autowired
	private HazelcastInstance cacheInstance;

	@Scheduled(fixedDelay = 5000)
	public void hello() {
		IMap<String, String> imap = cacheInstance.getMap("mycache");
		imap.keySet().stream().forEach(key -> {
			System.out.println("key: " + imap.get(key));
		});
	}

}
