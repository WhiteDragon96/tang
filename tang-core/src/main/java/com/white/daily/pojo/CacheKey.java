package com.white.daily.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import java.time.Duration;

/**
 * @author tcs
 * @date Created in 2021-10-22
 */
@Getter
@ToString
@AllArgsConstructor
public class CacheKey {
    /**
     * redis key
     */
    private final String key;
    /**
     * 超时时间 秒
     */
    @Nullable
    private Duration expire;

    public CacheKey(String key) {
        this.key = key;
    }

}