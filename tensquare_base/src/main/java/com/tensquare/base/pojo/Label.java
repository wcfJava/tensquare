package com.tensquare.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: Label
 * @Description: 标签实体类
 * @Author: wangcunfu
 * @Date: 2019/11/25 22:19
 * @Version: v1.0 文件初始创建
 */
@Entity
@Table(name = "tab_label")
@Data
public class Label {
    @Id
    private String id;
    private String labelName;
    private String state;
    private Integer count;
    private Integer fans;
    private String recommend;
}
