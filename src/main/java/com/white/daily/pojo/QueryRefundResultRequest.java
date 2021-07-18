package com.white.daily.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author baiLong
 * @Date 2020/3/25 14:15
 **/
@EqualsAndHashCode(callSuper = false)
@Data
public class QueryRefundResultRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 券编码，必传
     */
    @JsonProperty(value = "coupon_id")
    @NotNull(message = "券编码不能为空")
    private String couponId;
    /**
     * 通用券退券流水号
     */
    @JsonProperty(value = "coupon_refund_record_id")
    @NotNull(message = "通用券退券流水号不能为空")
    private String couponRefundRecordId;
    /**
     * 发券渠道Id
     */
    @JsonProperty(value = "issue_channel_id")
    @NotBlank(message = "发券渠道id不能为空")
    private String issueCouponChannelId;
}
