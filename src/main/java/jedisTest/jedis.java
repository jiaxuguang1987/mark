package jedisTest;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class jedis {
	@Test
	public void testJedisSingle() {
		//创建一个jedis的对象。
		Jedis jedis = new Jedis("192.168.115.130", 6379);
		//调用jedis对象的方法，方法名称和redis的命令一致。
		jedis.set("key1", "jedis test");
		String string = jedis.get("key1");
		System.out.println(string);
		//关闭jedis。
		jedis.close();
	}
}
