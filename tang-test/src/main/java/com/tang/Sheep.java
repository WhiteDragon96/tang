package com.tang;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author tcs
 * @date 2022-09-16  14:10
 */
public class Sheep {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor build = ExecutorBuilder.create().build();

        for (int i = 0; i < 10000; i++) {
            build.execute(Sheep::execute);
        }

        Thread.sleep(100000000);
    }

    public static void execute(){
        try {
            String t = HttpRequest.get("https://cat-match.easygame2021.com/sheep/v1/game/game_over?rank_score=1&rank_state=1&rank_time=547&rank_role=1&skin=1&mid=13&uid=75060429")
                    .header("T", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2OTQyNjk1MDksIm5iZiI6MTY2MzE2NzMwOSwiaWF0IjoxNjYzMTY1NTA5LCJqdGkiOiJDTTpjYXRfbWF0Y2g6bHQxMjM0NTYiLCJvcGVuX2lkIjoiIiwidWlkIjo0NTkwODcyOSwiZGVidWciOiIiLCJsYW5nIjoiIn0.6jHQGxxAcS79mNMOH4NwadVtm5MS6Uq5oOjypKKN1bI")
                    .timeout(2000)
                    .execute().body();
            System.out.println(t);
        } catch (HttpException e) {
            System.out.println(Thread.currentThread().getName()+" 执行失败");
        }
    }
}
