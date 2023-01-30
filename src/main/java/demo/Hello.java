package demo;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.time.Duration;
import java.util.Map;

public class Hello {

    public static void main(String[] args) throws InterruptedException {
        CacheManager cacheManager = CacheManagerBuilder
                .newCacheManagerBuilder().build();
        cacheManager.init();

        Cache<RequestInfo, ResponseInfo> squareNumberCache = cacheManager
                .createCache("requestCache", CacheConfigurationBuilder.newCacheConfigurationBuilder(
                        RequestInfo.class, ResponseInfo.class,
                        ResourcePoolsBuilder.heap(10)).withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(1))));

        squareNumberCache.put(new RequestInfo("http://test.com", Map.of("k1", "v1")), new ResponseInfo(200, "Hello"));
        System.out.println("### " + squareNumberCache.get(new RequestInfo("http://test.com", Map.of("k1", "v1"))));
        System.out.println("### " + squareNumberCache.get(new RequestInfo("http://test2.com", Map.of("k1", "v1"))));

        System.out.println("Sleep 2 seconds");
        Thread.sleep(2000);

        System.out.println("### " + squareNumberCache.get(new RequestInfo("http://test.com", Map.of("k1", "v1"))));

        cacheManager.close();
    }

}
