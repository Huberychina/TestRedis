import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
 
public class RedisListJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        System.out.println(jedis.lpop("site-list"));
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
        
        
        // get keys 
     // 获取数据并输出
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
        }
        
    }
}