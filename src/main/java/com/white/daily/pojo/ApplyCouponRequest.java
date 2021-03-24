package com.white.daily.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 购买优惠券参数
 *
 * @author hongfeng
 * @date 2020/3/11
 */
@Data
public class ApplyCouponRequest implements Serializable {
    private static final long serialVersionUID = -7985144940422789534L;
    /**
     * 用户ID
     */
    @JsonProperty("user_id")
    private String userId;

    /**
     * 用户归属机构
     */
    @JsonProperty("org_id")
    private String orgId;

    /**
     * 手机号
     */
    @JsonProperty("mobile_phone_num")
    private String mobilePhoneNum;

    /**
     * 发券方订单号
     */
    @JsonProperty("order_no")
    @NotBlank(message = "订单号不能为空")
    private String orderNo;

    /**
     * 券模板id
     */
    @JsonProperty("coupon_model_id")
    @NotBlank(message = "券模板id不能为空")
    private String couponModelId;

    /**
     * 发券渠道编码，用于买券是判断是否有资格发券：issue_channel_collection
     */
    @JsonProperty("issue_channel_id")
    @NotBlank(message = "发券渠道编码不能为空")
    private String issueChannelId;

    /**
     * 如果是绝对有效时间的券，不用传
     * 如果是相对有效时间，必传
     * 券有效期开始 yyyymmddhhmmss,
     */
    @JsonProperty("valid_from")
    private String validFrom;

    /**
     * 发券透传字段：透传券必传
     */
    @JsonProperty("transfer_data")
    private String transferData;


    /**
     * 是否已支付
     * 0-未支付  需要我们自己支付，走异步支付流程，一期暂不支持
     * 1-已支付  直接发券即可，走同步流程
     */
    @JsonProperty("is_pay")
    @NotNull(message = "是否已支付不能为空")
    private Integer isPay;

    /**
     * 支付参数 对接银联magpie时放开
     */
    @JsonProperty("pay_info")
    private String payInfo;

    /**
     * 预留字段，暂时放入open接入时的公共参数，
     * 作为请求方时，需要这些参数
     */
    @JsonProperty("ext_info")
    private String extInfo;
}
