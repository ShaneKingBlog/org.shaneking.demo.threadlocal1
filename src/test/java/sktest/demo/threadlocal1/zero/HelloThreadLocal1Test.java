package sktest.demo.threadlocal1.zero;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.shaneking.ling.jackson.databind.OM3;
import org.shaneking.ling.zero.util.Map0;

import java.util.Map;
import java.util.stream.IntStream;

@Slf4j
public class HelloThreadLocal1Test {
  @Test
  void testThreadLocal1() {
    ThreadLocal<Map<String, String>> TL = new ThreadLocal<>();
    TL.set(Map0.newHashMap("TLK", "tlv"));

    InheritableThreadLocal<Map<String, String>> ITL = new InheritableThreadLocal<>();
    ITL.set(Map0.newHashMap("ITLK", "itlv"));

    IntStream.range(1, 100).boxed().parallel().forEach(i -> {
      log.info(OM3.lp(i, TL.get() == null ? null : TL.get().get("TLK"), ITL.get().get("ITLK")));
    });
  }
}
