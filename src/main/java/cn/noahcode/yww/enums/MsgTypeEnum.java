package cn.noahcode.yww.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NoahCode
 * @date 2020/4/22
 * @description 消息类型
 */
public enum MsgTypeEnum {
    TEXT(1, "文本"),
    IMG(3, "图片"),
    VOICE(34, "语音"),
    BUSINESS(42, "名片"),
    MOVIE(43, "视频"),
    EMOJI(47, "动态表情"),
    POSITION(48, "地理位置"),
    CARD(49, "卡片分享"),
    CONVERSATION(53, "视频对话"),
    SYSTEM(10000, "系统消息");

    private Integer type;
    private String desc;

    public static Map<Integer, MsgTypeEnum> map = new HashMap<>();

    static {
        MsgTypeEnum[] enums = MsgTypeEnum.values();
        for (MsgTypeEnum e : enums){
            map.put(e.getType(), e);
        }
    }

    MsgTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public MsgTypeEnum getEnum(Integer type) {
        return map.get(type);
    }

    public Map getEnumMap() {
        return map;
    }
}
