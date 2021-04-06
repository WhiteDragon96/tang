package com.white.daily.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tcs
 * @date Created in 2021-04-02
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private	Integer	id;
    private	String	username;
    private	Integer	age;
}
