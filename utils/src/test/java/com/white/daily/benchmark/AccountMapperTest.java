package com.white.daily.benchmark;

import com.white.daily.mock.entity.Account;
import com.white.daily.mock.mapper.AccountMapper;
import com.white.daily.thread.MyThreadPool;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tcs
 * @date Created in 2022-03-08
 */
@SpringBootTest
public class AccountMapperTest {
    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void testInsert(){
        for (int i = 1; i < 1000000; i++) {
            Account account = new Account(null, UUID.randomUUID().toString(), ThreadLocalRandom.current().nextDouble());
            accountMapper.insert(account);
        }
    }

    @Test
    public void testJInsert(){
        for (int i = 0; i < 5; i++) {
            CompletableFuture.runAsync(() ->{
                for (int i1 = 0; i1 < 100000; i1++) {
                    Account account = new Account(null, Thread.currentThread().getName(), ThreadLocalRandom.current().nextDouble());
                    accountMapper.insert(account);
                    try {
                        System.out.println(Thread.currentThread().getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("hello");
        }
        try {
            TimeUnit.MINUTES.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testInsert1(){
        for (int i = 1; i < 1000000; i++) {
            Account account = new Account(null, UUID.randomUUID().toString(), ThreadLocalRandom.current().nextDouble());
            accountMapper.insert(account);
        }
    }
}
