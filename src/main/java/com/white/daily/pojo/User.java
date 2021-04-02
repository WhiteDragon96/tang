package com.white.daily.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tcs
 * @date Created in 2021-04-02
 */
@Data
public class User implements Serializable {

    private final int serialVersionUID = 1;

    private	Integer	id;
    private	String	username;
    private	Integer	age;
}
