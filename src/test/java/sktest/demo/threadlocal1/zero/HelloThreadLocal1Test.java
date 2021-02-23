package sktest.demo.threadlocal1.zero;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.shaneking.ling.jackson.databind.OM3;
import org.shaneking.ling.zero.util.List0;
import org.shaneking.ling.zero.util.Map0;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

@Slf4j
public class HelloThreadLocal1Test {
  @Test
  void testForkJoinPool() {
    ThreadLocal<Map<String, String>> TL = new ThreadLocal<>();
    TL.set(Map0.newHashMap("TLK", "tlv"));

    InheritableThreadLocal<Map<String, String>> ITL = new InheritableThreadLocal<>();
    ITL.set(Map0.newHashMap("ITLK", "itlv"));

    IntStream.range(1, 100).boxed().parallel().forEach(i -> {
      log.info(OM3.lp(i, TL.get() == null ? null : TL.get().get("TLK"), ITL.get().get("ITLK")));
    });
    /*
2021-02-21 13:07:11.196 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":31}
2021-02-21 13:07:11.196 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":62}
2021-02-21 13:07:11.196 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":43}
2021-02-21 13:07:11.196 INFO  ForkJoinPool.commonPool-worker-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":13}
2021-02-21 13:07:11.212 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":32}
2021-02-21 13:07:11.217 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":63}
2021-02-21 13:07:11.215 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":44}
2021-02-21 13:07:11.222 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":45}
2021-02-21 13:07:11.223 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":46}
2021-02-21 13:07:11.222 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":64}
2021-02-21 13:07:11.229 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":65}
2021-02-21 13:07:11.232 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":66}
2021-02-21 13:07:11.232 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":47}
2021-02-21 13:07:11.235 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":67}
2021-02-21 13:07:11.238 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":33}
2021-02-21 13:07:11.238 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":68}
2021-02-21 13:07:11.241 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":69}
2021-02-21 13:07:11.241 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":48}
2021-02-21 13:07:11.242 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":49}
2021-02-21 13:07:11.239 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":34}
2021-02-21 13:07:11.242 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":37}
2021-02-21 13:07:11.243 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":35}
2021-02-21 13:07:11.243 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":38}
2021-02-21 13:07:11.244 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":39}
2021-02-21 13:07:11.244 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":40}
2021-02-21 13:07:11.244 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":36}
2021-02-21 13:07:11.245 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":41}
2021-02-21 13:07:11.245 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":25}
2021-02-21 13:07:11.246 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":42}
2021-02-21 13:07:11.246 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":26}
2021-02-21 13:07:11.246 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":7}
2021-02-21 13:07:11.247 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":27}
2021-02-21 13:07:11.247 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":8}
2021-02-21 13:07:11.247 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":28}
2021-02-21 13:07:11.247 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":9}
2021-02-21 13:07:11.248 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":29}
2021-02-21 13:07:11.249 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":30}
2021-02-21 13:07:11.249 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":10}
2021-02-21 13:07:11.250 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":19}
2021-02-21 13:07:11.250 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":11}
2021-02-21 13:07:11.250 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":12}
2021-02-21 13:07:11.250 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":20}
2021-02-21 13:07:11.251 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":1}
2021-02-21 13:07:11.242 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":70}
2021-02-21 13:07:11.251 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":21}
2021-02-21 13:07:11.252 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":2}
2021-02-21 13:07:11.252 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":3}
2021-02-21 13:07:11.252 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":4}
2021-02-21 13:07:11.253 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":5}
2021-02-21 13:07:11.253 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":6}
2021-02-21 13:07:11.254 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":87}
2021-02-21 13:07:11.254 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":88}
2021-02-21 13:07:11.254 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":89}
2021-02-21 13:07:11.255 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":90}
2021-02-21 13:07:11.255 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":91}
2021-02-21 13:07:11.256 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":92}
2021-02-21 13:07:11.256 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":93}
2021-02-21 13:07:11.256 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":94}
2021-02-21 13:07:11.257 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":95}
2021-02-21 13:07:11.257 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":96}
2021-02-21 13:07:11.258 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":97}
2021-02-21 13:07:11.258 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":98}
2021-02-21 13:07:11.258 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":99}
2021-02-21 13:07:11.259 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":81}
2021-02-21 13:07:11.259 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":22}
2021-02-21 13:07:11.261 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":71}
2021-02-21 13:07:11.262 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":82}
2021-02-21 13:07:11.262 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":23}
2021-02-21 13:07:11.262 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":72}
2021-02-21 13:07:11.262 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":24}
2021-02-21 13:07:11.263 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":73}
2021-02-21 13:07:11.263 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":75}
2021-02-21 13:07:11.263 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":74}
2021-02-21 13:07:11.263 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":76}
2021-02-21 13:07:11.264 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":56}
2021-02-21 13:07:11.264 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":77}
2021-02-21 13:07:11.265 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":78}
2021-02-21 13:07:11.265 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":83}
2021-02-21 13:07:11.265 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":57}
2021-02-21 13:07:11.265 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":79}
2021-02-21 13:07:11.265 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":84}
2021-02-21 13:07:11.266 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":80}
2021-02-21 13:07:11.266 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":85}
2021-02-21 13:07:11.265 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":58}
2021-02-21 13:07:11.266 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":50}
2021-02-21 13:07:11.267 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":51}
2021-02-21 13:07:11.267 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":59}
2021-02-21 13:07:11.267 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":52}
2021-02-21 13:07:11.268 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":53}
2021-02-21 13:07:11.268 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":54}
2021-02-21 13:07:11.268 INFO  ForkJoinPool.commonPool-worker-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":86}
2021-02-21 13:07:11.268 INFO  ForkJoinPool.commonPool-worker-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":55}
2021-02-21 13:07:11.268 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":60}
2021-02-21 13:07:11.269 INFO  main sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":["tlv","itlv"],"l":61}
2021-02-21 13:07:11.270 INFO  ForkJoinPool.commonPool-worker-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":14}
2021-02-21 13:07:11.270 INFO  ForkJoinPool.commonPool-worker-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":15}
2021-02-21 13:07:11.271 INFO  ForkJoinPool.commonPool-worker-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":16}
2021-02-21 13:07:11.271 INFO  ForkJoinPool.commonPool-worker-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":17}
2021-02-21 13:07:11.272 INFO  ForkJoinPool.commonPool-worker-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:24 - {"p":[null,"itlv"],"l":18}

     */
  }

  @Test
  void testThreadPool() throws ExecutionException, InterruptedException {
    ThreadLocal<Map<String, String>> TL = new ThreadLocal<>();
    TL.set(Map0.newHashMap("TLK", "tlv"));

    InheritableThreadLocal<Map<String, String>> ITL = new InheritableThreadLocal<>();
    ITL.set(Map0.newHashMap("ITLK", "itlv"));

    ExecutorService es = Executors.newFixedThreadPool(3);
    List<Future<?>> list = List0.newArrayList();
    for (int i = 0; i < 100; i++) {
      int fi = i;
      list.add(es.submit(() -> log.info(OM3.lp(fi, TL.get() == null ? null : TL.get().get("TLK"), ITL.get().get("ITLK")))));
    }
    for (Future<?> f : list) {
      f.get();
    }
    /*
2021-02-21 13:10:55.077 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":2}
2021-02-21 13:10:55.083 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":3}
2021-02-21 13:10:55.085 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":4}
2021-02-21 13:10:55.085 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":5}
2021-02-21 13:10:55.085 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":6}
2021-02-21 13:10:55.086 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":7}
2021-02-21 13:10:55.087 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":8}
2021-02-21 13:10:55.087 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":9}
2021-02-21 13:10:55.087 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":10}
2021-02-21 13:10:55.088 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":11}
2021-02-21 13:10:55.088 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":1}
2021-02-21 13:10:55.088 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":12}
2021-02-21 13:10:55.089 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":13}
2021-02-21 13:10:55.089 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":14}
2021-02-21 13:10:55.089 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":16}
2021-02-21 13:10:55.090 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":17}
2021-02-21 13:10:55.090 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":18}
2021-02-21 13:10:55.091 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":19}
2021-02-21 13:10:55.091 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":20}
2021-02-21 13:10:55.092 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":21}
2021-02-21 13:10:55.092 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":22}
2021-02-21 13:10:55.093 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":23}
2021-02-21 13:10:55.093 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":24}
2021-02-21 13:10:55.094 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":25}
2021-02-21 13:10:55.094 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":26}
2021-02-21 13:10:55.095 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":27}
2021-02-21 13:10:55.095 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":28}
2021-02-21 13:10:55.095 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":29}
2021-02-21 13:10:55.089 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":15}
2021-02-21 13:10:55.096 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":30}
2021-02-21 13:10:55.096 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":31}
2021-02-21 13:10:55.097 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":32}
2021-02-21 13:10:55.097 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":33}
2021-02-21 13:10:55.097 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":34}
2021-02-21 13:10:55.098 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":35}
2021-02-21 13:10:55.098 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":36}
2021-02-21 13:10:55.098 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":37}
2021-02-21 13:10:55.098 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":38}
2021-02-21 13:10:55.098 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":39}
2021-02-21 13:10:55.099 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":40}
2021-02-21 13:10:55.099 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":41}
2021-02-21 13:10:55.099 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":42}
2021-02-21 13:10:55.099 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":44}
2021-02-21 13:10:55.099 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":43}
2021-02-21 13:10:55.100 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":45}
2021-02-21 13:10:55.100 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":46}
2021-02-21 13:10:55.100 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":47}
2021-02-21 13:10:55.100 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":48}
2021-02-21 13:10:55.100 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":49}
2021-02-21 13:10:55.100 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":50}
2021-02-21 13:10:55.101 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":51}
2021-02-21 13:10:55.101 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":52}
2021-02-21 13:10:55.101 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":53}
2021-02-21 13:10:55.101 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":54}
2021-02-21 13:10:55.101 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":55}
2021-02-21 13:10:55.102 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":56}
2021-02-21 13:10:55.102 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":57}
2021-02-21 13:10:55.102 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":58}
2021-02-21 13:10:55.102 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":59}
2021-02-21 13:10:55.103 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":60}
2021-02-21 13:10:55.103 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":61}
2021-02-21 13:10:55.103 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":62}
2021-02-21 13:10:55.103 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":63}
2021-02-21 13:10:55.103 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":64}
2021-02-21 13:10:55.104 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":65}
2021-02-21 13:10:55.104 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":66}
2021-02-21 13:10:55.104 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":67}
2021-02-21 13:10:55.104 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":68}
2021-02-21 13:10:55.104 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":69}
2021-02-21 13:10:55.104 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":70}
2021-02-21 13:10:55.104 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":71}
2021-02-21 13:10:55.105 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":72}
2021-02-21 13:10:55.105 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":73}
2021-02-21 13:10:55.105 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":74}
2021-02-21 13:10:55.105 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":76}
2021-02-21 13:10:55.105 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":77}
2021-02-21 13:10:55.106 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":78}
2021-02-21 13:10:55.106 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":79}
2021-02-21 13:10:55.105 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":75}
2021-02-21 13:10:55.106 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":80}
2021-02-21 13:10:55.107 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":82}
2021-02-21 13:10:55.107 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":83}
2021-02-21 13:10:55.108 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":84}
2021-02-21 13:10:55.108 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":85}
2021-02-21 13:10:55.109 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":86}
2021-02-21 13:10:55.109 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":87}
2021-02-21 13:10:55.109 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":88}
2021-02-21 13:10:55.108 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":81}
2021-02-21 13:10:55.110 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":89}
2021-02-21 13:10:55.110 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":90}
2021-02-21 13:10:55.110 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":91}
2021-02-21 13:10:55.102 INFO  pool-1-thread-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":0}
2021-02-21 13:10:55.111 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":93}
2021-02-21 13:10:55.110 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":92}
2021-02-21 13:10:55.111 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":95}
2021-02-21 13:10:55.112 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":96}
2021-02-21 13:10:55.111 INFO  pool-1-thread-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":94}
2021-02-21 13:10:55.112 INFO  pool-1-thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":98}
2021-02-21 13:10:55.113 INFO  pool-1-thread-1 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":99}
2021-02-21 13:10:55.112 INFO  pool-1-thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:146 - {"p":[null,"itlv"],"l":97}

     */
  }

  @Test
  void testReference() throws InterruptedException {
    InheritableThreadLocal<Map<String, String>> ITL = new InheritableThreadLocal<>();
    ITL.set(Map0.newHashMap("ITLK", "itlv"));

    Thread t1 = new Thread(() -> {
      int i = 0;
      while (i < 10) {
        if (ITL.get() != null) {
          if (i % 2 == 0) {
            ITL.get().clear();
          } else {
            ITL.get().put("ITLK", "itlv" + System.currentTimeMillis());
          }
        }
        i++;
        try {
          Thread.sleep(1000 / 2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(() -> {
      int i = 0;
      while (i < 10) {
        if (ITL.get() != null) {
          log.info(OM3.lp(i, ITL.get().get("ITLK")));
          int fi = i;
          new Thread(() -> log.info(OM3.lp(fi, ITL.get().get("ITLK")))).start();
        }
        i++;
        try {
          Thread.sleep(1000 / 2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    t2.start();
    t1.start();

    Thread.sleep(10 * 1000);
    /*
2021-02-22 21:39:39.697 INFO  Thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:284 - {"p":["itlv"],"l":0}
2021-02-22 21:39:39.710 INFO  Thread-3 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:286 - {"p":["itlv1614001179568"],"l":0}
2021-02-22 21:39:40.215 INFO  Thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:284 - {"p":[null],"l":1}
2021-02-22 21:39:40.216 INFO  Thread-4 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:286 - {"p":[null],"l":1}
2021-02-22 21:39:40.722 INFO  Thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:284 - {"p":["itlv1614001180571"],"l":2}
2021-02-22 21:39:40.725 INFO  Thread-5 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:286 - {"p":["itlv1614001180571"],"l":2}
2021-02-22 21:39:41.229 INFO  Thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:284 - {"p":[null],"l":3}
2021-02-22 21:39:41.229 INFO  Thread-6 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:286 - {"p":[null],"l":3}
2021-02-22 21:39:41.729 INFO  Thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:284 - {"p":["itlv1614001181574"],"l":4}
2021-02-22 21:39:41.731 INFO  Thread-7 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:286 - {"p":["itlv1614001181574"],"l":4}
2021-02-22 21:39:42.231 INFO  Thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:284 - {"p":[null],"l":5}
2021-02-22 21:39:42.232 INFO  Thread-8 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:286 - {"p":[null],"l":5}
2021-02-22 21:39:42.733 INFO  Thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:284 - {"p":["itlv1614001182581"],"l":6}
2021-02-22 21:39:42.734 INFO  Thread-9 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:286 - {"p":["itlv1614001182581"],"l":6}
2021-02-22 21:39:43.235 INFO  Thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:284 - {"p":[null],"l":7}
2021-02-22 21:39:43.236 INFO  Thread-10 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:286 - {"p":[null],"l":7}
2021-02-22 21:39:43.737 INFO  Thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:284 - {"p":["itlv1614001183585"],"l":8}
2021-02-22 21:39:43.741 INFO  Thread-11 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:286 - {"p":["itlv1614001183585"],"l":8}
2021-02-22 21:39:44.244 INFO  Thread-2 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:284 - {"p":["itlv1614001183585"],"l":9}
2021-02-22 21:39:44.245 INFO  Thread-12 sktest.demo.threadlocal1.zero.HelloThreadLocal1Test:286 - {"p":["itlv1614001183585"],"l":9}

     */
  }
}
