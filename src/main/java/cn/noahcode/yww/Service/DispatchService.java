package cn.noahcode.yww.Service;

import cn.noahcode.yww.enums.MsgTypeEnum;
import cn.noahcode.yww.model.Msg;
import cn.noahcode.yww.sdk.API;
import org.springframework.stereotype.Service;

/**
 * @author NoahCode
 * @date 2020/4/23
 * @description
 */
@Service
public class DispatchService {

    public void dispatch(Msg msg) {
        MsgTypeEnum msgTypeEnum = MsgTypeEnum.map.get(msg.getSubType());
        switch (msgTypeEnum) {
            case TEXT:
                API.sendPrivateMsg(msg.TOKEN, msg.getFromUser(), "Hello");
                break;
            default:
                API.addLog(msg.TOKEN, msg.getType(), "处理完成", "消息类型处理完成");
        }
    }

}
