package cn.noahcode.yww.sdk;

import cn.noahcode.yww.utils.HttpUtil;
import cn.noahcode.yww.utils.UrlUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * @author NoahCode
 * @date 2020/4/22
 * @description
 */
public class API {
    private final static String API_URL = "http://127.0.0.1:8866/";

    /**
     * @param token token
     * @return java.lang.String
     * @description 获取登录昵称
     * @author NoahCode
     * @date 2020/4/22
     */
    public static String getLoginNick(String token) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        return HttpUtil.post(API_URL + "GetLoginNick", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @return java.lang.String
     * @description 获取登录账号
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getLoginYWid(String token) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        return HttpUtil.post(API_URL + "GetLoginYWid", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @return java.lang.String
     * @description 获取登录头像
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getLoginHead(String token) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        return HttpUtil.post(API_URL + "GetLoginHead", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param wxId  接收者wxId
     * @param msg   消息内容
     * @return java.lang.String
     * @description 发送好友消息
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String sendPrivateMsg(String token, String wxId, String msg) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        map.put("Msg", UrlUtil.getURLEncoderString(msg));
        return HttpUtil.post(API_URL + "SendPrivateMsg", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param fgId  群ID(如:12345678912@chatroom)
     * @param msg   消息内容
     * @param at    目标wxId(为空就不)
     * @return java.lang.String
     * @description 发送群消息
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String sendGroupMsg(String token, String fgId, String msg, String[] at) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Token", token);
        map.put("FGID", UrlUtil.getURLEncoderString(fgId));
        map.put("Msg", UrlUtil.getURLEncoderString(msg));
        map.put("AT", at);
        return HttpUtil.post(API_URL + "SendGroupMsg", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param fgId  群ID(如:12345678912@chatroom)
     * @param wxId  目标wxId
     * @return java.lang.String
     * @description 置群员移除
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String setGroupKick(String token, String fgId, String wxId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("FGID", UrlUtil.getURLEncoderString(fgId));
        map.put("WXID", wxId);
        return HttpUtil.post(API_URL + "SetGroupKick", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param fgId  群ID(如:12345678912@chatroom)
     * @return java.lang.String
     * @description 置群退出
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String setGroupLeave(String token, String fgId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("FGID", UrlUtil.getURLEncoderString(fgId));
        return HttpUtil.post(API_URL + "SetGroupLeave", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param type  日志类型(0-7)
     * @param title 标题
     * @param text  内容
     * @return java.lang.String
     * @description 添加运行日记
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String addLog(String token, Integer type, String title, String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Type", type.toString());
        map.put("Title", UrlUtil.getURLEncoderString(title));
        map.put("Text", UrlUtil.getURLEncoderString(text));
        return HttpUtil.post(API_URL + "AddLog", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param fgId  群ID(如:12345678912@chatroom)
     * @param wxId  目标wxId
     * @return java.lang.String
     * @description 获取群成员信息
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getGroupMemberInfo(String token, String fgId, String wxId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("FGID", fgId);
        map.put("WXID", wxId);
        return HttpUtil.post(API_URL + "GetGroupMemberInfo", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param fgId  群ID(如:12345678912@chatroom)
     * @return java.lang.String
     * @description 获取群成员列表
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getGroupMemberList(String token, String fgId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("FGID", fgId);
        return HttpUtil.post(API_URL + "GetGroupMemberList", JSONObject.toJSONString(map));
    }

    /**
     * @param token
     * @return java.lang.String
     * @description 获取群列表
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getGroupList(String token) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        return HttpUtil.post(API_URL + "GetGroupList", JSONObject.toJSONString(map));
    }

    /**
     * @param token
     * @return java.lang.String
     * @description 获取好友列表
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getFriendList(String token) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        return HttpUtil.post(API_URL + "GetFriendsList", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param wxId  目标wxId
     * @return java.lang.String
     * @description 获取陌生人信息
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getStrangerInfo(String token, String wxId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        return HttpUtil.post(API_URL + "GetStrangerInfo", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param text  朋友圈内容
     * @return java.lang.String
     * @description 发朋友圈
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String sendMoments(String token, String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Text", UrlUtil.getURLEncoderString(text));
        return HttpUtil.post(API_URL + "SendMoments", JSONObject.toJSONString(map));
    }

    /**
     * @param token     token
     * @param text      朋友圈内容
     * @param imageFile 图片路径(绝对路径)
     * @return java.lang.String
     * @description 发朋友圈(带图片)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String sendMomentsV2(String token, String text, String imageFile) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Text", UrlUtil.getURLEncoderString(text));
        map.put("ImageFile", imageFile);
        return HttpUtil.post(API_URL + "SendMomentsV2", JSONObject.toJSONString(map));
    }

    /**
     * @param token   token
     * @param wxId    机器人wxId
     * @param id      朋友圈id
     * @param text    评论/回复内容
     * @param comment 评论为空/0|回复为回复消息的id
     * @return java.lang.String
     * @description 评论朋友圈
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String snsComment(String token, String wxId, String id, String text, Integer comment) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        map.put("ID", id);
        map.put("Text", UrlUtil.getURLEncoderString(text));
        map.put("Commen", comment.toString());
        return HttpUtil.post(API_URL + "SnsComment", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param id    朋友圈id
     * @return java.lang.String
     * @description 获取朋友圈详情
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String snsObjectDetail(String token, String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("ID", id);
        return HttpUtil.post(API_URL + "SnsObjectDetail", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param fgId  群id(如:12345678912@chatroom)
     * @param wxId  目标wxId
     * @return java.lang.String
     * @description 添加群成员
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String addChatRoomMember(String token, String fgId, String wxId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("FGID", fgId);
        map.put("WXID", wxId);
        return HttpUtil.post(API_URL + "AddChatRoomMember", JSONObject.toJSONString(map));
    }

    /**
     * @param token  token
     * @param wxId   目标wxId(非wxid_abcdefg1234567)
     * @param text   验证内容
     * @param source 添加来源(枚举SourceEnum)
     * @return java.lang.String
     * @description 添加好友
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String addUser(String token, String wxId, String text, Integer source) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        map.put("text", text);
        map.put("Source", source.toString());
        return HttpUtil.post(API_URL + "AddUser", JSONObject.toJSONString(map));
    }

    /**
     * @param token  token
     * @param v1     v1(可为空)
     * @param v2     v2(可为空)
     * @param text   验证内容
     * @param source 添加来源(枚举SourceEnum)
     * @return java.lang.String
     * @description 添加好友A (!!!!未测试成功!!!!)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String addUserA(String token, String wxId, String v1, String v2, String text, Integer source) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        map.put("v1", UrlUtil.getURLEncoderString(v1));
        map.put("v2", UrlUtil.getURLEncoderString(v2));
        map.put("Text", UrlUtil.getURLEncoderString(text));
        map.put("Source", source.toString());
        return HttpUtil.post(API_URL + "AddUserA", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param wxId  目标wxId(至少两个，用\r\n分割)
     * @return java.lang.String
     * @description 创建群 (!!!勿用,调用闪退!!!)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String createChatRoom(String token, String wxId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        return HttpUtil.post(API_URL + "CreateChatRoom", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param wxId  目标wxId
     * @return java.lang.String
     * @description 删除好友
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String deleteUser(String token, String wxId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        return HttpUtil.post(API_URL + "DeleteUser", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param msg   MsgText(原消息的MsgText)
     * @return java.lang.String
     * @description 获取消息视频
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getMsgVideo(String token, String msg) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Msg", msg);
        return HttpUtil.post(API_URL + "GetMsgVideo", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param msg   MsgText(原消息的MsgText)
     * @return java.lang.String
     * @description 获取消息图片
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getMsgImage(String token, String msg) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Msg", msg);
        return HttpUtil.post(API_URL + "GetMsgImage", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param msg   MsgText(原消息的MsgText)
     * @return java.lang.String
     * @description 获取消息语音
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getMsgVoice(String token, String msg) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Msg", msg);
        return HttpUtil.post(API_URL + "GetMsgVoice", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param wxId  机器人的wxId
     * @return java.lang.String
     * @description 获取自己的二维码
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getUserQRCode(String token, String wxId) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        return HttpUtil.post(API_URL + "GetUserQRCode", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param wxId  目标wxId(用\r\n分割)
     * @param msg   消息内容
     * @return java.lang.String
     * @description 群发消息 ((!!!勿用,调用闪退!!!))
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String massMessage(String token, String wxId, String msg) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        map.put("Msg", UrlUtil.getURLEncoderString(msg));
        return HttpUtil.post(API_URL + "MassMessage", JSONObject.toJSONString(map));
    }

    /**
     * @param token    token
     * @param stranger 目标wxId
     * @param msg      消息内容
     * @return java.lang.String
     * @description 打招呼(没报错吧, 没详细测试功能)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String sayHello(String token, String stranger, String msg) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Stranger", stranger);
        map.put("Msg", UrlUtil.getURLEncoderString(msg));
        return HttpUtil.post(API_URL + "SayHello", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param fgId  群id(如:12345678912@chatroom)
     * @param text  公告内容
     * @return java.lang.String
     * @description 设置群公告 (@所有人吧)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String setChatroomAnnouncement(String token, String fgId, String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("FGID", fgId);
        map.put("Text", UrlUtil.getURLEncoderString(text));
        return HttpUtil.post(API_URL + "SetChatroomAnnouncement", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param fgId  群id(如:12345678912@chatroom)
     * @param text  群名
     * @return java.lang.String
     * @description 设置群名
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String setChatroomName(String token, String fgId, String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("FGID", fgId);
        map.put("Text", UrlUtil.getURLEncoderString(text));
        return HttpUtil.post(API_URL + "SetChatroomName", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param text  图片路径(绝对路径)
     * @return java.lang.String
     * @description 设置头像 (!!!测试失效!!!)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String setHeadImage(String token, String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Text", text);
        return HttpUtil.post(API_URL + "SetHeadImage", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param wxId  目标id
     * @param text  备注内容
     * @return java.lang.String
     * @description 设置用户备注
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String setUserRemark(String token, String wxId, String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        map.put("Text", UrlUtil.getURLEncoderString(text));
        return HttpUtil.post(API_URL + "SetUserRemark", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param id    机器人wxId
     * @return java.lang.String
     * @description 获取朋友圈动态
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String snsTimeLine(String token, String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("ID", id);
        return HttpUtil.post(API_URL + "SnsTimeLine", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param wxId  目标wxId
     * @param id    朋友圈id(可为空)
     * @return java.lang.String
     * @description 取好友朋友圈
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String snsUserPage(String token, String wxId, String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        map.put("ID", id);
        return HttpUtil.post(API_URL + "SnsUserPage", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param wxId  申请人wxId
     * @param v1    v1
     * @param v2    v2
     * @return java.lang.String
     * @description 同意添加好友(未测试)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String sntFriendAddRequest(String token, String wxId, String v1, String v2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        map.put("V1", v1);
        map.put("V2", v2);
        return HttpUtil.post(API_URL + "SetFriendAddRequest", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param msg   MsgText(原消息的MsgText)
     * @return java.lang.String
     * @description 同意进群(未测试)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String setGroupAddRequest(String token, String msg) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Msg", msg);
        return HttpUtil.post(API_URL + "SetGroupAddRequest", JSONObject.toJSONString(map));
    }

    /**
     * @param token     token
     * @param longItude 经度
     * @param latItude  纬度
     * @return java.lang.String
     * @description 查看附近的人(未测试)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getPeopleNearby(String token, Float longItude, Float latItude) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("LongItude", longItude.toString());
        map.put("LatItude", latItude.toString());
        return HttpUtil.post(API_URL + "GetPeopleNearby", JSONObject.toJSONString(map));
    }

    /**
     * @param token   token
     * @param id      朋友圈id
     * @param type    操作类型 1:删除 4:删除评论 5:取消赞
     * @param comment 当操作操作类型为4时，指定评论ID
     * @return java.lang.String
     * @description 操作朋友圈(未测试)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String snsObjectOp(String token, String id, Integer type, Integer comment) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("ID", id);
        map.put("Type", type.toString());
        map.put("_ID", comment.toString());
        return HttpUtil.post(API_URL + "SnsObjectOp", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param QR    二维码图片B64编码(参数只需要提供其中一个,另一个为空文本即可)
     * @param url   二维码解码后的地址(如果提供了二维码此条无效),此参数设置为:jx 即可解析二维码,返回解析结果
     * @return java.lang.String
     * @description 登陆其他设备(未测试)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String PCLogin(String token, String QR, String url) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("QR", QR);
        map.put("URL", url);
        return HttpUtil.post(API_URL + "PClogin", JSONObject.toJSONString(map));
    }

    /**
     * @param token
     * @return java.lang.String
     * @description 登出其它设备
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String logOut(String token) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        return HttpUtil.post(API_URL + "Logout", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param msg   MsgText(原消息的MsgText)
     * @return java.lang.String
     * @description 接收转账(未测试)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String transferOperation(String token, String msg) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Msg", msg);
        return HttpUtil.post(API_URL + "TransferOperation", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param text  收藏内容
     * @return java.lang.String
     * @description 添加收藏 (!!!勿用!不会报错,但添加成功后会收藏夹不会显示,多一个红色提示框,显示版本过低!特别丑!!!)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String favAddItem(String token, String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Text", UrlUtil.getURLEncoderString(text));
        return HttpUtil.post(API_URL + "FavAddItem", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param id    收藏id
     * @return java.lang.String
     * @description 删除收藏 (!!!勿用!要是手贱了用了上面的添加收藏内容,可以使用此方法来删除刚才创建的收藏!!!)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String favDeleteItem(String token, String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("ID", id);
        return HttpUtil.post(API_URL + "FavDeleteItem", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param id    收藏id
     * @return java.lang.String
     * @description 获取收藏详情
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String favGetItem(String token, String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("ID", id);
        return HttpUtil.post(API_URL + "FavGetItem", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param key   key (不知道是啥,可为空)
     * @return java.lang.String
     * @description 返回收藏详情吧(稍微分析了一下)
     * flag=1:被删了 flag=0:存在的
     * type=3:语音 type=18:文本 (我就这两个,懒得再加其他的测试了)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String favSync(String token, String key) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Key", UrlUtil.getURLEncoderString(key));
        return HttpUtil.post(API_URL + "FavSync", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param text  标签内容
     * @return java.lang.String
     * @description 添加标签 (!!!勿用!已弃用!!!!)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String addContactLabel(String token, String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("Text", UrlUtil.getURLEncoderString(text));
        return HttpUtil.post(API_URL + "AddContactLabel", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param wxId  目标wxId
     * @param id    标签id
     * @return java.lang.String
     * @description 修改标签 (!!!未测试,感觉已弃用!!!)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String setContactLabel(String token, String wxId, String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("WXID", wxId);
        map.put("ID", id);
        return HttpUtil.post(API_URL + "SetContactLabel", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @param id    标签id
     * @return java.lang.String
     * @description 删除标签 (!!!未测试,感觉已弃用!!!)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String deleteContactLabel(String token, String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        map.put("ID", id);
        return HttpUtil.post(API_URL + "DeleteContactLabel", JSONObject.toJSONString(map));
    }

    /**
     * @param token token
     * @return java.lang.String
     * @description 获取标签列表 (!!!也不知道获取的啥！！！)
     * @author NoahCode
     * @date 2020/4/23
     */
    public static String getContactLabelList(String token) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Token", token);
        return HttpUtil.post(API_URL + "GetContactLabelList", JSONObject.toJSONString(map));
    }

}
