package com.white.daily.lang3;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date Created in 2021-11-26
 */
class StringUtilTest {

    @Test
    public void test1() {
        StopWatch stopWatch = new StopWatch();
        long start = stopWatch.getTime(TimeUnit.SECONDS);
        String join = StringUtils.join("a", "b", "c");
        System.out.println(join);
        long end = stopWatch.getTime(TimeUnit.SECONDS);
        System.out.println(end - start);
    }
}