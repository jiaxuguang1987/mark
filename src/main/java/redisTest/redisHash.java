package redisTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class redisHash {
	/**
	 * 操作Hash类型的数据
	 * */
	@Test
	public void testHash(){
		String host="192.168.115.130";
		Integer port=6379;
		//建立和redis数据库的链接
		Jedis jedis=new Jedis(host, port);
		
		//账号验证
		//jedis.auth("redis");
		
		//选择数据库
		jedis.select(7);
		
		//添加Hash类型的数据
		jedis.hset("dbkey", "name", "手机");
		jedis.hset("dbkey", "brand", "华为");
		jedis.hset("dbkey", "address", "北京");
		
		//创建Map集合
		/*Map<String,String> hash = new HashMap<>();
		hash.put("price", "12000");
		hash.put("网段", "CDMA");*/
		//jedis.hmset("dbkey", hash);
		
		//获得map集合中的一个数据
		/*String value = jedis.hget("dbkey", "name");
		System.out.println("value="+value);*/
		
		/*Map<String, String> map = jedis.hgetAll("dbkey");
		for(Entry<String,String> e:map.entrySet()){
			System.out.println(e.getKey()+"---------"+e.getValue());
		}*/
		
		//判断mAP集合是否存在某个 key
		/*Boolean flag = jedis.hexists("dbkey", "name");
		System.out.println("flag="+flag);
		*/
		//获得map集合的所有key
		/*Set<String> kys = jedis.hkeys("dbkey");
		System.out.println("kys="+kys);
		*/
		//获得map集合的所有value
		List<String> lst = jedis.hvals("dbkey");
		System.out.println("lst="+lst);
	}
}
