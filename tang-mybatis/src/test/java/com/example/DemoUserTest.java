package com.example;

import com.example.entity.DemoUser;
import com.example.mapper.DemoUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @author tangcs
 * @date since 2024-10-18
 */
@SpringBootTest
public class DemoUserTest {

    @Autowired
    private DemoUserMapper demoUserMapper;

    @Test
    public void whenSomeBusinessLogic_thenTrue() {
        DemoUser tangcs = demoUserMapper.selectByName("tangcs");
        System.out.println(tangcs);

    }
}
