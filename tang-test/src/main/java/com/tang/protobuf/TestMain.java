package com.tang.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author tcs
 * @date 2022-09-28  15:31
 */
public class TestMain {
    public static void main(String[] args) {
        TestProtobuf.testBuf.Builder builder = TestProtobuf.testBuf.newBuilder();
        builder.setId(1).setName("猴子哥哥").setAge(18);
        TestProtobuf.testBuf testBuf = builder.build();
        byte[] bytes = testBuf.toByteArray();
        System.out.println("serialize pb size=" + bytes.length);

        try {
            TestProtobuf.testBuf pojo = TestProtobuf.testBuf.parseFrom(bytes);
            System.out.println("unSerialize pb data:id=" + pojo.getId() + ",name=" + pojo.getName() + ",age=" + pojo.getAge());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }
}
