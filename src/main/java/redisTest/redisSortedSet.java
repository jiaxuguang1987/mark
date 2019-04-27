package redisTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class redisSortedSet {
	/***
	 * Jedis操作SortedSet集合数据
	 * **/
	@Test
	public void testSortedSet(){
		String host="192.168.115.130";
		Integer port=6379;
		//建立和redis数据库的链接
		Jedis jedis=new Jedis(host, port);
		
		//账号验证
		//jedis.auth("redis");
		
		//选择数据库
		//jedis.select(9);
		
		//添加set集合元素
		//jedis.zadd("dbkey", 10000, "马云");
		
		//创建Map集合
		Map<String,Double> map = new HashMap<>();
		map.put("liyanhong", 5000.0);
		map.put("liuqiangdong", 8000.0);
		map.put("leijun", 4000.0);
		
		//jedis.zadd("dbkey", map);
		
		//获得集合的长度
		Long len = jedis.zcard("dbkey");
		System.out.println("len="+len);
		
		//统计指定score区间内的元素个数
		Long zcount = jedis.zcount("dbkey", 5000.0,8000.0);
		System.out.println("zcount="+zcount);
		
		//给score添加一个增量
		//jedis.zincrby("dbkey", 8000.0 ,"leijun");
		
		//获得指定下标区间内的元素
		Set<String> zrange = jedis.zrange("dbkey", 0, 2);
		System.out.println("zrange="+zrange);
		
		//大----小
		Set<String> zrevrange = jedis.zrevrange("dbkey", 0, 2);
		System.out.println("zrevrange="+zrevrange);
		
		//获得集合中元素的排名
		Long zrank = jedis.zrank("dbkey", "马云");
		System.out.println("zrank="+zrank);
		
		//大----小
		Long zrevrank = jedis.zrevrank("dbkey","马云");
		System.out.println("zrevrank="+zrevrank);
		
		Double zscore = jedis.zscore("dbkey", "马云");
		System.out.println("zscore="+zscore);
	}
}
