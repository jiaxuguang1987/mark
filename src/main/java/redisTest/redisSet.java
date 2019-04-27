package redisTest;

import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class redisSet {
	/****
	 * jedis操作Set集合数据
	 */
	@Test
	public void testSet(){
		String host="192.168.115.130";
		Integer port=6379;
		//建立和redis数据库的链接
		Jedis jedis=new Jedis(host, port);
		
		//账号验证
		//jedis.auth("redis");
		
		//选择数据库
		//jedis.select(8);
		
		//添加set集合元素
		jedis.sadd("dbkey", "zhangsan","lisi","wangwu");
		
		//jedis.sadd("dbkey1", "zhangsan","lisi","马云");
		
		//获得set集合数据
		Set<String> mems = jedis.smembers("dbkey");
		System.out.println("mems="+mems);
		
		//获得set集合的长度
		Long len = jedis.scard("dbkey");
		System.out.println("len="+len);
		
		//判断set集合中是否存在某个元素
		Boolean flag = jedis.sismember("dbkey", "wangwu");
		System.out.println("flag="+flag);
		
		//获得指定的set集合的差集
		Set<String> sdiff = jedis.sdiff("dbkey","dbkey1");
		System.out.println("sdiff="+sdiff);
		
		jedis.sdiffstore("dbkey2", "dbkey1","dbkey");
		
		//获得指定的set集合的交集
		Set<String> sinter = jedis.sinter("dbkey","dbkey1");
		System.out.println("sinter="+sinter);
		
		//获得指定的set集合的并集
		Set<String> sunion = jedis.sunion("dbkey","dbkey1");
		System.out.println("sunion="+sunion);
		
		//产生一个随机的元素
		//jedis.spop("dbkey")
		String ms = jedis.srandmember("dbkey");
		System.out.println("ms="+ms);
		
		//移动元素
		jedis.smove("dbkey", "dbkey2", "wangwu");
		
		//删除元素
		jedis.srem("dbkey2", "wangwu");
	}
}
