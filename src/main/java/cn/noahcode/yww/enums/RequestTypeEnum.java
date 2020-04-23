package cn.noahcode.yww.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NoahCode
 * @date 2020/4/22
 * @description 事件类型
 */
public enum RequestTypeEnum {
    INITIALIZE(0, "载入插件"),
    STARTUP(1, "框架启动"),
    EXIT(2, "框架关闭"),
    ENABLE(3, "插件启用"),
    DISABLE(4, "插件禁用"),
    PRIVATE(10, "私聊消息"),
    GROUP(20, "群聊消息"),
    PUBLIC(40, "公众号消息"),
    SEND(30, "回调消息"),
    MODIFY(6, "变量设置");

    private Integer type;
    private String desc;

    public static Map<Integer, RequestTypeEnum> map = new HashMap<>();

    static {
        RequestTypeEnum[] enums = RequestTypeEnum.values();
        for (RequestTypeEnum e : enums){
            map.put(e.getType(), e);
        }
    }

    RequestTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public RequestTypeEnum getEnum(Integer type) {
        return map.get(type);
    }

    public Map getEnumMap() {
        return map;
    }
}
