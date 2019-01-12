package com.nmsl.delayservice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
public class User {

    private String name;
    private String age;
    private String department;
    private String date;

    public void setDate(LocalDateTime ldate) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd00");
        String formattedDate = ldate.format(df);
        this.date = formattedDate;
    }
}
