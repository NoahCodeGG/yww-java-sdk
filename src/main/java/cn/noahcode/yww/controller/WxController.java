package cn.noahcode.yww.controller;

import cn.noahcode.yww.Service.DispatchService;
import cn.noahcode.yww.enums.RequestTypeEnum;
import cn.noahcode.yww.model.Msg;
import cn.noahcode.yww.sdk.API;
import cn.noahcode.yww.utils.UrlUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NoahCode
 * @date 2020/4/22
 * @description
 */
@RestController
public class WxController {

    @Autowired
    private DispatchService dispatchService;

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String wxMsg(@RequestBody JSONObject jsonObject) {
        Msg msg = new Msg();
        msg.setType((Integer) jsonObject.get("Type"));
        RequestTypeEnum requestTypeEnum = RequestTypeEnum.map.get(msg.getType());
        switch (requestTypeEnum) {
            case INITIALIZE:
                msg.TOKEN = (String) jsonObject.get("Tonken");
                break;
            case PRIVATE:
                msg.setSubType((Integer) jsonObject.get("SubType"));
                msg.setFromUser((String) jsonObject.get("Fromuser"));
                msg.setMsgText(UrlUtil.getURLDecoderString((String) jsonObject.get("MsgText")));
                msg.setMsg(UrlUtil.getURLDecoderString((String) jsonObject.get("Msg")));
                msg.setWxId((String) jsonObject.get("WXID"));
                dispatchService.dispatch(msg);
                break;
            default:
                API.addLog(msg.TOKEN, msg.getType(), "处理成功", "事件类型处理成功");
        }
        return null;
    }

}
