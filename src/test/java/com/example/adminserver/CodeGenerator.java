package com.example.adminserver;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CodeGenerator {
    public static void main(String[] args) {

        // 代码生成
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/xdb", "root", "Noah.1225")
                .globalConfig(builder -> {
                    builder.author("Baci7") // 设置作者
                            // .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir() //禁止打开输出目录
                            .outputDir("C:\\Users\\10197\\Desktop\\WorkSpace\\item\\xdb\\admin-server\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.adminserver") // 设置父包名
                            .moduleName("sys") // 设置父包模块名
                            .entity("sys.entity") //设置entity包名
                            .other("sys.dto") // 设置dto包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "C:\\Users\\10197\\Desktop\\WorkSpace\\item\\xdb\\admin-server\\src\\main\\resources\\mapper\\sysMapper")); // 设置mapperXml生成路径

                })
                .strategyConfig(builder -> {
                    builder.addInclude("user"); // 需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();


//                .injectionConfig(consumer -> {
//                    Map<String, String> customFile = new HashMap<>();
//                    // DTO
//                    customFile.put("DTO.java", "/templates/entityDTO.java.ftl");
//                    consumer.customFile(customFile);
//                });
    }
}
