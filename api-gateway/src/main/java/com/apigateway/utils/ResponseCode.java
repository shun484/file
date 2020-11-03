package com.apigateway.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResponseCode {
    public static String OK = "200";
    public static final String REQUEST_ERROR = "400";
    public static final String ERR_CODE_PARAMS_ERROR = "401";
    public static final String USER_IS_NOT_LOGIN = "402";
    public static final String TOKEN_ERROR = "403";
    public static final String VERIFY_SIGNATURE_ERROR = "405";
    public static final String NO_FONT_PERMISSION = "600";
    public static final String ERR_CODE_UNKNOW_ERROR = "500";
    public static final String USER_WAS_EXISTS = "008";
    public static String USER_NOT_EXISTS = "009";
    public static final String PASSWORDS_DO_NOT_MATCH = "011";
    public static final String ERR_CODE_TRANS_FAIL = "012";
    public static final String USERNAME_CAN_NOT_BE_EMPTY = "013";
    public static final String USERNAME_CAN_NOT_BE_RESET = "014";
    public static final String KEEPER_IN_WORKING = "015";
    public static final String IMG_CODE_TIMEOUT = "016";
    public static final String ERR_CODE_BLACKLIST = "041";
    public static final String ERR_CODE_PIN_ERROR = "055";
    public static final String ERR_CODE_USERNAME_PASSWORD_ERROR = "056";
    public static final String FORCE_LOGOUT = "057";
    public static final String MESSAGE_PUSH_FAILED = "063";
    public static final String MESSAGE_TEMPLATE_UPDATE_FAILED = "064";
    public static final String INSUFFICIENT_ACCOUNT_PERMISSIONS = "067";
    public static final String ERR_CODE_SYS_EXCEPTION = "096";
    public static String PARAM_INVALID = "102";
    public static String USER_NAME_EXISTS = "103";
    public static String USER_IS_NOT_ENABLED = "104";
    public static final String ERR_CODE_LOCAL_ERROR = "LE";
    public static final String ERR_CODE_READY_ERROR = "RE";
    public static Map<String, String> codeMap = new ConcurrentHashMap();

    public ResponseCode() {
    }

    static {
        codeMap.put("RE", "准备错误");
        codeMap.put("LE", "本地错误");
        codeMap.put("500", "内部错误");
        codeMap.put("402", "用户未登录");
        codeMap.put("401", "请求参数错误");
        codeMap.put("405", "验签失败");
        codeMap.put("403", "token错误");
        codeMap.put("400", "请求失败");
        codeMap.put("600", "无权限");
        codeMap.put(OK, "成功");
        codeMap.put(USER_IS_NOT_ENABLED, "用户已禁用");
        codeMap.put(USER_NAME_EXISTS, "用户名已存在");
        codeMap.put(PARAM_INVALID, "无效的请求参数/参数不能为空");
        codeMap.put("096", "系统异常");
        codeMap.put("055", "密码错误");
        codeMap.put("012", "交易失败");
        codeMap.put(USER_NOT_EXISTS, "用户不存在");
        codeMap.put("056", "用户名或密码错误");
        codeMap.put("008", "用户已注册");
        codeMap.put("057", "账户被冻结,请三十分钟后重新登录");
        codeMap.put("011", "两次输入的密码不一致");
        codeMap.put("013", "登陆用户名不能为空");
        codeMap.put("063", "信息推送失败");
        codeMap.put("014", "用户名不可修改");
        codeMap.put("064", "模板修改失败");
        codeMap.put("067", "账户权限不足");
        codeMap.put("015", "流程处理中");
        codeMap.put("016", "图形验证码过期,请重新验证");
    }
}
