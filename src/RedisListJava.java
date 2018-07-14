import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
 
public class RedisListJava {
    public static void main(String[] args) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        //�洢���ݵ��б���
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        System.out.println(jedis.lpop("site-list"));
        // ��ȡ�洢�����ݲ����
        List<String> list = jedis.lrange("site-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("�б���Ϊ: "+list.get(i));
        }
        
        
        // get keys 
     // ��ȡ���ݲ����
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
        }
        
    }
}