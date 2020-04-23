package cn.noahcode.yww.model;

import lombok.Data;

/**
 * @author NoahCode
 * @date 2020/4/23
 * @description
 */
@Data
public class Msg {
    public static String TOKEN;
    private Integer type;
    private Integer subType;
    private String function;
    private String wxId;
    private String fromUser;
    private String fromGroup;
    private String msg;
    private String msgText;
}
