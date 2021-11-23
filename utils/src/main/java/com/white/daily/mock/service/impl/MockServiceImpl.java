package com.white.daily.mock.service.impl;

import com.white.daily.mock.service.MockService;
import org.springframework.stereotype.Service;

/**
 * @author tcs
 * @date Created in 2021-03-05
 */
@Service
public class MockServiceImpl implements MockService {

    /**
     * 发送邮件
     */
    @Override
    public void sendEmail() {
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
