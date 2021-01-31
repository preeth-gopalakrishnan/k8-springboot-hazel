package com.example.k8springboothazel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;

@Configuration()
public class K8SpringbootHazelConfiguration {
	
	@Bean()
	public Config hazelCastCnfig(){
		Config config = new Config();
		config.setInstanceName("hazel-instance")
		.addMapConfig(new MapConfig().setName("hazel-map-configuration")
				.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizePolicy.FREE_HEAP_SIZE))
				.setEvictionPolicy(EvictionPolicy.LRU)
				.setTimeToLiveSeconds(3600));
	    JoinConfig joinConfig = config.getNetworkConfig().getJoin();
	    joinConfig.getMulticastConfig().setEnabled(false);
	    joinConfig.getKubernetesConfig().setEnabled(true);
		return config;
		
	}

}
