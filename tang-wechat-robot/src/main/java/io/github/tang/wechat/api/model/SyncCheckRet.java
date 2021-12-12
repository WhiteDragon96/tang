package io.github.tang.wechat.api.model;

import io.github.tang.wechat.api.enums.RetCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 心跳检查返回
 *
 * @author tangcs
 * @date 2018/1/20
 */
@Data
@AllArgsConstructor
public class SyncCheckRet {

    private RetCode retCode;
    private int     selector;

}
