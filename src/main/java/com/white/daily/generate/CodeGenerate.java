package com.white.daily.generate;

import com.white.daily.generate.entity.BladeCodeGenerator;
import com.white.daily.generate.entity.Code;
import com.white.daily.generate.entity.Datasource;
import com.white.daily.util.Func;

/**
 * @author tcs
 * @date Created in 2021-05-13
 */
public class CodeGenerate {

    public static void main(String[] args) {
        Code code = new Code();
        code.setServiceName("blade-demo");
        code.setCodeName("通知公告");
        code.setTableName("account");
        code.setTablePrefix("");
        code.setPkName("id");
        code.setBaseMode(1);
        code.setWrapMode(1);
        code.setPackageName("org.springblade.desktop");
        code.setApiPath("D:\\Develop\\WorkSpace\\account");
        code.setWebPath("D:\\Develop\\WorkSpace\\account");

        Datasource datasource = new Datasource();
        datasource.setName("mysql");
        datasource.setDriverClass("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/tcs?characterEncoding=utf8&serverTimezone=UTC&useSSL=false");
        datasource.setUsername("root");
        datasource.setPassword("123456");

        BladeCodeGenerator generator = new BladeCodeGenerator();

        generator.setDriverName(datasource.getDriverClass());
        generator.setUrl(datasource.getUrl());
        generator.setUsername(datasource.getUsername());
        generator.setPassword(datasource.getPassword());
        // 设置基础配置
        generator.setSystemName("saber");
        generator.setCodeName(code.getCodeName());
        generator.setServiceName(code.getServiceName());
        generator.setPackageName(code.getPackageName());
        generator.setPackageDir(code.getApiPath());
        generator.setPackageWebDir(code.getWebPath());
        generator.setTablePrefix(Func.toStrArray(code.getTablePrefix()));
        generator.setIncludeTables(Func.toStrArray(code.getTableName()));
        // 设置是否继承基础业务字段
        generator.setHasSuperEntity(code.getBaseMode() == 2);
        // 设置是否开启包装器模式
        generator.setHasWrapper(code.getWrapMode() == 2);

        generator.run();
    }
}
