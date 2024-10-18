package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author tangcs
 * @date since 2024-10-18
 */
@TableName("t_user")
@Data
public class DemoUser {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;
}
