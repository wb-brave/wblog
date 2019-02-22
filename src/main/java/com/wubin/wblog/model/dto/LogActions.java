package com.wubin.wblog.model.dto;

/**
 * @author wubin
 * @Description 日志表的action字段
 * @project sell
 * @package com.wubin.wblog.model.dto
 * @email wubin326@qq.com
 * @date 2019/02/18
 * Modification History:
 * Date              Author           Version              Description
 * ----------------------------------------------------------------------
 * 2019/02/18        wubin            0.0.1
 */
public enum LogActions {

    LOGIN("登录后台"), UP_PWD("修改密码"), UP_INFO("修改个人信息"),
    DEL_ARTICLE("删除文章"), DEL_PAGE("删除页面"), SYS_BACKUP("系统备份"),
    SYS_SETTING("保存系统设置"), INIT_SITE("初始化站点");

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    LogActions(String action) {
        this.action = action;
    }
}

