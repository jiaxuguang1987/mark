package redisTest;

import java.util.List;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class redisString {
	/**
	 * 测试string类型数据的操作
	 * redis 有什么命令，jedis就有什么方法
	 * **/
	@Test
	public void testString(){
		String host="192.168.115.130";
		Integer port=6379;
		//建立和redis数据库的链接
		Jedis jedis=new Jedis(host, port);
		
		//账号验证
		jedis.auth("redis");
		
		//选择数据库
		jedis.select(5);
		
		//添加字符串串数据
		jedis.set("name", "zhangsan");
		System.out.println(jedis.get("name"));
		//字符串追加
		jedis.append("name", "zhongguo");
		
		//一次性保存多个字符串
		jedis.mset("address","beijing","sex","男","phone","110");
		
		//一次性获得多个字符串
		 List<String> lts = jedis.mget("address","sex","phone");
		System.out.println("lts="+lts);
		
		//获得字符串长度
		Long len = jedis.strlen("sex");
		System.out.println("len="+len);
		
		//获得原来的值，重新设置值
		String sex = jedis.getSet("sex", "女");
		System.out.println("sex="+sex);
		//获得字符串
		String name = jedis.get("name");
		System.out.println("name="+name);
	}
}
