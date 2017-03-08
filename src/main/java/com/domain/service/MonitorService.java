package com.domain.service;

import com.domain.common.LogType;
import com.domain.model.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Bulat Saifutdinov on 2/27/2017.
 */
@Component
public class MonitorService {
    @Autowired
    private LogService logService;

    public LogInfo getLogDate() {
        // Read lines from log file
        List<String> lines = logService.readLines();

        // Get log information from log lines
        return getLogInfo(lines);
    }

    public LogInfo getLogInfo(List<String> data) {
        int infoCount = 0;
        int warningCount = 0;
        int errorCount = 0;

        for (String line : data) {
            LogType type = logService.getType(line);

            switch (type) {
                case INFO:
                    infoCount++;
                    break;
                case WARNING:
                    warningCount++;
                    break;
                case ERROR:
                    errorCount++;
                    break;
            }
        }

        return new LogInfo(infoCount, warningCount, errorCount);
    }
}
