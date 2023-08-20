package com.example.adminserver.sys.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("wine")
@Data
public class Wine {
    private int id;
    private String number;
    private String name;
    private String location;
    private String year;
    private String breed;
    private String temperature;
    private String type;
    private String color;
    private String overBarrel;
    private String odor;
    private String acidity;
    private String tannins;
    private String wineBody;
    private String time;
    private String score;
}
