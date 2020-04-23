yww-java-sdk
============
鱼尾纹webAPI接口java开发包  
项目地址：**https://github.com/wuGuangLei/yww-java-sdk**    
API文档地址：**https://docs.qq.com/doc/DZnVlU3BJRWR2aG9H**

## 前言

**这是本人第一个开发的SDK项目，本人也只是一个java菜鸟，有大佬看见有什么问题，希望能提出来，我会好好学习并加以改正**

**现在还有很多缺陷，只做了POST请求，GET请求没有测试，还有一部分的接口还没测试,下面会详细列出来的**

## 注意

1. 只测试了POST请求,GET请求没有测试
2. 有一部分没有测试的在接口方法列表中的备注中详细写明了,api文件中也有详细注解
3. 直接下载项目源码进行二次开发即可,源码也是demo可以直接运行
4. 记得要调整鱼尾纹的配置
   1. url:http://127.0.0.1/8867(url为服务器运行地址)
   2. ce:UTF-8(编码格式为utf-8)

## 涉及技术

- [spring-boot](https://github.com/spring-projects/spring-boot) 
- [fastjson](https://github.com/alibaba/fastjson)
- [okhttp](https://github.com/square/okhttp)

**非常感谢这些开源项目为我们提供了这么多便利，也衷心感谢在背后努力付出的开源开发者们！**

## 目录

>**[项目配置](#项目配置)**  
>**[事件类型](#事件类型)**  
>**[消息类型](#消息类型)**  
>**[来源类型](#来源类型)**  
>**[接口方法列表](#接口方法列表)**  
>**[学习交流](#学习交流)**  
>**[赞助](#赞助)**

----------

## 1. 项目配置

1. application.properties:
   1. server.port = 8867(设置项目运行的端口)
   2. server.undertow.url-chatset = urf-8(设置服务器默认编码为utf-8)
2. cn\noahcode\yww\utils\UrlUtil.java:
   1. private final static String ENCODE = "UTF-8";(url编码与转码的格式，要与设置中的请求一致)

## 2. 事件类型(RequestTypeEnum)

|    名称    |   事件名   | 事件ID |
| :--------: | :--------: | :----: |
|  载入插件  | INITIALIZE |   0    |
|  框架启动  |  STARTUP   |   1    |
|  框架关闭  |    EXIT    |   2    |
|  插件启用  |   ENABLE   |   3    |
|  插件禁用  |  DISABLE   |   4    |
|  变量设置  | SEMODIFYND |   6    |
|  私聊消息  |  PRIVATE   |   10   |
|  群聊消息  |   GROUP    |   20   |
| 公众号消息 |   PUBLIC   |   40   |
|  回调消息  |    SEND    |   30   |

## 3. 消息类型(MsgTypeEnum)

|   名称   |     类型     | 类型ID |
| :------: | :----------: | :----: |
|   文本   |     TEXT     |   1    |
|   图片   |     IMG      |   3    |
|   语音   |    VOICE     |   34   |
|   名片   |   BUSINESS   |   42   |
|   视频   |    MOVIE     |   43   |
| 动态表情 |    EMOJI     |   47   |
| 地理位置 |   POSITION   |   48   |
|   卡片   |     CARD     |   49   |
| 视频对话 | CONVERSATION |   53   |
| 系统消息 |    SYSTEM    | 10000  |

## 4. 来源类型(SourceTypeEnum)

|      名称      |      类型      | 类型ID |
| :------------: | :------------: | :----: |
|      邮箱      |     EMAIL      |   2    |
|      微信      |     WECHAT     |   3    |
|    朋友验证    | FRIEND_VERIFY  |   5    |
| 朋友验证可回复 | FRIEND_COMMENT |   7    |
|       QQ       |       QQ       |   12   |
|       群       |     GROUP      |   14   |
|     手机号     |     PHONE      |   15   |
|      朋友      |     FRIEND     |   16   |
|      名片      |    BUSINESS    |   17   |
|     摇一摇     |     SHAKE      |   22   |
|     漂流瓶     |     BOTTLE     |   25   |
|     二维码     |       QR       |   30   |

## 5. 接口方法列表

详细参数参考api文件:**cn\noahcode\yww\sdk\API.java**

|       名称       |          类型           |                                      备注                                       |
| :--------------: | :---------------------: | :-----------------------------------------------------------------------------: |
|   获取登录昵称   |      getLoginNick       |                                                                                 |
|   获取登录账号   |      getLoginYWid       |                                                                                 |
|   获取登录头像   |      getLoginHead       |                                                                                 |
|   发送好友消息   |     sendPrivateMsg      |                                                                                 |
|    置群员移除    |      sendGroupMsg       |                                                                                 |
|     置群退出     |      setGroupLeave      |                                                                                 |
|   添加运行日记   |         addLog          |                                                                                 |
|  获取群成员信息  |   getGroupMemberInfo    |                                                                                 |
|  获取群成员列表  |   getGroupMemberList    |                                                                                 |
|    获取群列表    |      getGroupList       |                                                                                 |
|   获取好友列表   |      getFriendList      |                                                                                 |
|  获取陌生人信息  |     getStrangerInfo     |                                                                                 |
|     发朋友圈     |       sendMoments       |                                                                                 |
| 发朋友圈(带图片) |      sendMomentsV2      |                                                                                 |
|    评论朋友圈    |       snsComment        |                                                                                 |
|  获取朋友圈详情  |     snsObjectDetail     |                                                                                 |
|    添加群成员    |    addChatRoomMember    |                                                                                 |
|     添加好友     |         addUser         |                                                                                 |
|    添加好友A     |        addUserA         |                                   未测试成功                                    |
|      创建群      |     createChatRoom      |                                  勿用,调用闪退                                  |
|     删除好友     |       deleteUser        |                                                                                 |
|   获取消息视频   |       getMsgVideo       |                                                                                 |
|     删除好友     |       deleteUser        |                                                                                 |
|   获取消息图片   |       getMsgImage       |                                                                                 |
|   获取消息语音   |       getMsgVoice       |                                                                                 |
| 获取自己的二维码 |      getUserQRCode      |                                                                                 |
|     群发消息     |       massMessage       |                                  勿用,调用闪退                                  |
|      打招呼      |        sayHello         |                            没报错吧, 没详细测试功能                             |
|    设置群公告    | setChatroomAnnouncement |                                     @所有人                                     |
|     设置群名     |     setChatroomName     |                                                                                 |
|     设置头像     |      setHeadImage       |                                    测试失败                                     |
|   设置用户备注   |      setUserRemark      |                                                                                 |
|  获取朋友圈动态  |       snsTimeLine       |                                                                                 |
|   取好友朋友圈   |       snsUserPage       |                                                                                 |
|   同意添加好友   |   sntFriendAddRequest   |                                     未测试                                      |
|     同意进群     |   setGroupAddRequest    |                                     未测试                                      |
|   查看附近的人   |     getPeopleNearby     |                                     未测试                                      |
|    操作朋友圈    |       snsObjectOp       |                                     未设置                                      |
|   登陆其他设备   |         PCLogin         |                                     未测试                                      |
|   登出其它设备   |         logOut          |                                                                                 |
|     接收转账     |    transferOperation    |                                     未测试                                      |
|     添加收藏     |       favAddItem        | 勿用!不会报错,但添加成功后会收藏夹不会显示,多一个红色提示框,显示版本过低!特别丑 |
|     删除收藏     |      favDeleteItem      |    勿用!要是手贱了用了上面的添加收藏内容,可以使用此方法来删除刚才创建的收藏     |
|   获取收藏详情   |       favGetItem        |                                                                                 |
|     添加标签     |     addContactLabel     |                                 勿用!感觉已弃用                                 |
|     修改标签     |     setContactLabel     |                                 勿用!感觉已弃用                                 |
|     删除标签     |   deleteContactLabel    |                                 勿用!感觉已弃用                                 |
|   获取标签列表   |   getContactLabelList   |                                也不知道获取的啥                                 |

## 学习交流

![qq](https://github.com/wuGuangLei/ityxb-tools/raw/master/img/qq.jpg)
![wechat](https://github.com/wuGuangLei/ityxb-tools/raw/master/img/wechat.png)

## 赞助

**微信扫一扫,请作者喝一杯咖啡?**

![reward](https://github.com/wuGuangLei/ityxb-tools/raw/master/img/reward.png)

License
-------
This is licensed under the GNU LGPL, version 2.1 or later.   
For details, see: http://creativecommons.org/licenses/LGPL/2.1/