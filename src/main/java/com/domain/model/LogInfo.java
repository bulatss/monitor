package com.domain.model;

import java.util.Date;

/**
 * Created by Bulat Saifutdinov on 2/27/2017.
 */
public class LogInfo {
    private Date date;
    private int infoCount;
    private int warningCount;
    private int errorCount;

    public LogInfo() {
    }

    public LogInfo(int infoCount, int warningCount, int errorCount) {
        this.date = new Date();
        this.infoCount = infoCount;
        this.warningCount = warningCount;
        this.errorCount = errorCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getInfoCount() {
        return infoCount;
    }

    public void setInfoCount(int infoCount) {
        this.infoCount = infoCount;
    }

    public int getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(int warningCount) {
        this.warningCount = warningCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }
}
