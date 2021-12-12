package io.github.tang.wechat.api.service.impl;

import io.github.tang.wechat.api.response.JsonResponse;
import io.github.tang.wechat.api.service.BotService;
import org.springframework.stereotype.Service;

@Service
public class BotServiceImpl implements BotService {


    @Override
    public void saveGroupUser(JsonResponse jsonResponse) {
        System.out.println("保存群成员-======" + jsonResponse);
    }
}
