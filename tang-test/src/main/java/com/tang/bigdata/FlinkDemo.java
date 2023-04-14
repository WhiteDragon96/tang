package com.tang.bigdata;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;
import org.springframework.data.repository.init.ResourceReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * @author tcs
 * @date 2023/03/22  15:50
 */
public class FlinkDemo {
    public static void main(String[] args) throws Exception {
        // 获取执行环境
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // 读取本地文件，并将每一行拆分成单词
        DataSet<String> text = env.readTextFile("C:\\Users\\neu\\OneDrive\\笔记\\不背单词.txt")
                .flatMap(new FlatMapFunction<String, String>() {
                    @Override
                    public void flatMap(String value, Collector<String> out) {
                        for (String word : value.split("\\s")) {
                            out.collect(word);
                        }
                    }
                });

        // 统计每个单词的出现次数
        DataSet<Tuple2<String, Integer>> counts =
                text.map(word -> new Tuple2<>(word, 1))
                        .groupBy(0)
                        .sum(1);

        // 打印统计结果
        counts.print();
    }
}
