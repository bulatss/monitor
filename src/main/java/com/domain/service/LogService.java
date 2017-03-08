package com.domain.service;

import com.domain.common.LogType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Bulat Saifutdinov on 2/27/2017.
 */
@Service
public class LogService {
    // The last position in file. The next process will start from this position
    private int position = 0;

    @Value("${file.path}")
    private String path;

    @Value("${file.line.delimiter}")
    private String delimiter;

    public List<String> readLines() {
        List<String> result = new ArrayList<String>();
        try (Stream<String> lines = Files.lines(Paths.get(getPath()))) {
            lines.skip(getPosition()).forEach(line -> result.add(line));
        } catch (IOException e) {
            e.getMessage();
        }
        // Save processed position
        setPosition(getPosition() + result.size());

        return result;
    }

    public LogType getType(String logLine) {
        LogType type = LogType.UNKNOWN;

        String[] tokens = logLine.split(getDelimiter());
        if (tokens.length > 2) {
            try {
                // 2016-09-20 16:23:11,994 INFO Some other info message
                // The tokens[2] - INFO
                type = LogType.valueOf(tokens[2]);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Log Type");
            }
        }

        return type;
    }

    public String getPath() {
        return path;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
