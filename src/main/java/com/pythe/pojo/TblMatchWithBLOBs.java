package com.pythe.pojo;

public class TblMatchWithBLOBs extends TblMatch {
    private String content;

    private String viewLog;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getViewLog() {
        return viewLog;
    }

    public void setViewLog(String viewLog) {
        this.viewLog = viewLog == null ? null : viewLog.trim();
    }
}