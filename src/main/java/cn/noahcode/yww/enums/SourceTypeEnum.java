package cn.noahcode.yww.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NoahCode
 * @date 2020/4/23
 * @description
 */
public enum SourceTypeEnum {
    QQ(12, "QQ"),
    FRIEND(16, "朋友"),
    BUSINESS(17, "名片"),
    QR(30, "二维码"),
    FRIEND_VERIFY(5, "朋友验证"),
    FRIEND_COMMENT(7, "朋友验证可回复"),
    BOTTLE(25, "漂流瓶"),
    GROUP(14, "群"),
    PHONE(15, "手机号"),
    WECHAT(3, "微信"),
    SHAKE(22, "摇一摇"),
    EMAIL(2, "邮箱");

    private Integer type;
    private String desc;

    public static Map<Integer, SourceTypeEnum> map = new HashMap<>();

    static {
        SourceTypeEnum[] enums = SourceTypeEnum.values();
        for (SourceTypeEnum e : enums) {
            map.put(e.getType(), e);
        }
    }

    SourceTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public SourceTypeEnum getEnum(Integer type) {
        return map.get(type);
    }

    public Map getEnumMap() {
        return map;
    }
}
