package jedisTest;

import java.io.IOException;
import java.util.HashSet;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class jedisCluster {
	@Test
	public void testJedisCluster() throws IOException {
		HashSet<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.115.135", 7001));
		nodes.add(new HostAndPort("192.168.115.135", 7002));
		nodes.add(new HostAndPort("192.168.115.135", 7003));
		nodes.add(new HostAndPort("192.168.115.135", 7004));
		nodes.add(new HostAndPort("192.168.115.135", 7005));
		nodes.add(new HostAndPort("192.168.115.135", 7006));
		
		JedisCluster cluster = new JedisCluster(nodes);
		
		cluster.set("key1", "1000");
		String string = cluster.get("key1");
		System.out.println(string);
		
		cluster.close();
	}
}
