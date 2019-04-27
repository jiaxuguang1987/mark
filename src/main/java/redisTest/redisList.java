package redisTest;

import java.util.List;

import org.junit.Test;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;

public class redisList {
	/**
	 * jedis操作List类型数据
	 * **/
	@Test
	public void testList(){
		String host="192.168.115.130";
		Integer port=6379;
		//建立和redis数据库的链接
		Jedis jedis=new Jedis(host, port);
		
		//账号验证
		//jedis.auth("redis");
		
		//选择数据库
		//jedis.select(6);
		
		//添加List集合数据
		jedis.lpush("dbkey", "zhangsan","lisi","王五");
		
		//获得list集合中元素
		/*String ele = jedis.lpop("dbkey");
		System.out.println("ele="+ele);*/
		
		//返回list集合中，指定下标处的元素
		String ele = jedis.lindex("dbkey", 1);
		System.out.println("ele="+ele);
		
		//返回集合的长度
		Long len = jedis.llen("dbkey");
		System.out.println("len="+len);
		
		//在指定的元素前或者后插入新元素
		jedis.linsert("dbkey", LIST_POSITION.BEFORE, "zhangsan", "wangwu");
		
		//返回指定下标区间内的元素
		List<String> lst = jedis.lrange("dbkey", 0, 2);
		System.out.println("lst="+lst);
		
		//修改元素
		jedis.lset("dbkey", 1, "wangliu");
		
		//保留指定区间内的元素，删除区间外的元素
		String ltrim = jedis.ltrim("dbkey", 0, 1);
		System.out.println("ltrim="+ltrim);
	}
}
