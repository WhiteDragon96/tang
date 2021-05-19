package com.white.daily.generate;

import com.white.daily.generate.entity.BladeCodeGenerator;

/**
 * 代码生成器
 *
 * @author tcs
 * @date Created in 2021-05-13
 */
class CodeGenerateTest {
    /**
     *驱动类
     */
    public static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    /**
     * 连接地址
     */
    public static String URL = "jdbc:mysql://47.114.105.19:3306/tcs?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
    /**
     * 用户名
     */
    public static String USER_NAME = "root";
    /**
     * 用户密码
     */
    public static String PASS_WORD = "T@ng12342234";
    /**
     * 代码生成的模块名
     */
    public static String CODE_NAME = "samples";
    /**
     * 代码所在服务名
     */
    public static String SERVICE_NAME = "mybatis-plus-samples";
    /**
     * 代码生成的包名
     */
    public static String PACKAGE_NAME = "com.baomidou.mybatisplus.samples.crud";
    /**
     * 前端代码生成所属系统 sword/saber
     */
    public static String SYSTEM_NAME = "saber";
    /**
     * 前端代码生成地址
     */
    public static String PACKAGE_WEB_DIR = "D:\\Develop\\WorkSpace\\samples";
    /**
     * 后端代码生成地址
     */
    public static String PACKAGE_API_DIR = "D:\\Develop\\WorkSpace\\samples";
    /**
     * 需要去掉的表前缀
     */
    public static String[] TABLE_PREFIX = {"blade_"};
    /**
     * 需要生成的表名(两者只能取其一)
     */
    public static String[] INCLUDE_TABLES = {"cnarea_2018"};
    /**
     * 需要排除的表名(两者只能取其一)
     */
    public static String[] EXCLUDE_TABLES = {};
    /**
     * 是否包含基础业务字段
     */
    public static Boolean HAS_SUPER_ENTITY = Boolean.FALSE;
    /**
     * 基础业务字段
     */
    public static String[] SUPER_ENTITY_COLUMNS = {"id", "create_time", "create_user", "create_dept", "update_time", "update_user", "status", "is_deleted"};

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        BladeCodeGenerator generator = new BladeCodeGenerator();

        generator.setDriverName(DRIVER_CLASS);
        generator.setUrl(URL);
        generator.setUsername(USER_NAME);
        generator.setPassword(PASS_WORD);

        generator.setCodeName(CODE_NAME);
        generator.setServiceName(SERVICE_NAME);
        generator.setSystemName(SYSTEM_NAME);
        generator.setPackageName(PACKAGE_NAME);
        generator.setPackageWebDir(PACKAGE_WEB_DIR);
        generator.setTablePrefix(TABLE_PREFIX);
        generator.setIncludeTables(INCLUDE_TABLES);
        generator.setExcludeTables(EXCLUDE_TABLES);
        generator.setHasSuperEntity(HAS_SUPER_ENTITY);
        generator.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
        generator.setPackageDir(PACKAGE_API_DIR);
        generator.run();
    }
}