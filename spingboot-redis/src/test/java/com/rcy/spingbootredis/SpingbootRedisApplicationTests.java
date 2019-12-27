package com.rcy.spingbootredis;

import com.rcy.spingbootredis.util.RedisService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpingbootRedisApplicationTests {

	@Autowired
	private RedisService redisService;

	@Test
	public void contextLoads() {
        String set = redisService.set("123", "456");
        System.out.println(set);
    }
    @Test
    public  void getString(){
        String s = redisService.get("123");
        System.out.println(s);
    }
}
