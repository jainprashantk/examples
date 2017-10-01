/*
 * This software is the confidential information and copyrighted work of
 * NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
 * is only distributed under the terms of a separate license agreement
 * with NetCracker.
 * Use of the software is governed by the terms of the license agreement.
 * Any use of this software not in accordance with the license agreement
 * is expressly prohibited by law, and may result in severe civil
 * and criminal penalties.
 * 
 * Copyright (c) 1995-2017 NetCracker Technology Corp.
 * 
 * All Rights Reserved.
 * 
 */

package com.example;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author prja1015
 */
public class DateExample {

    public DateExample() {
    }

    public static void main(String[] args) {
        final String time = "2017-05-25T00:01:05.030Z";
        System.out.println(Instant.parse(time));
        System.out.println(Instant.now().minus(5, ChronoUnit.DAYS).truncatedTo(ChronoUnit.DAYS));
        System.out.println(Date.from(Instant.parse(time)));
        System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
        System.out.println(Instant
            .parse(DateTimeFormatter.ISO_LOCAL_DATE.format(DateTimeFormatter.ofPattern("dd.MM.yyyy").parse("04.08.2017"))
                + "T00:00:00Z"));
        System.out.println(Instant.parse("2017-04-01" + "T00:00:00Z"));
        System.out.println(new Date().toInstant().truncatedTo(ChronoUnit.DAYS));
    }

}

/*
 * WITHOUT LIMITING THE FOREGOING, COPYING, REPRODUCTION, REDISTRIBUTION,
 * REVERSE ENGINEERING, DISASSEMBLY, DECOMPILATION OR MODIFICATION OF THE
 * SOFTWARE IS EXPRESSLY PROHIBITED, UNLESS SUCH COPYING, REPRODUCTION,
 * REDISTRIBUTION, REVERSE ENGINEERING, DISASSEMBLY, DECOMPILATION OR
 * MODIFICATION IS EXPRESSLY PERMITTED BY THE LICENSE AGREEMENT WITH NETCRACKER.
 * 
 * THIS SOFTWARE IS WARRANTED, IF AT ALL, ONLY AS EXPRESSLY PROVIDED IN THE
 * TERMS OF THE LICENSE AGREEMENT, EXCEPT AS WARRANTED IN THE LICENSE AGREEMENT,
 * NETCRACKER HEREBY DISCLAIMS ALL WARRANTIES AND CONDITIONS WITH REGARD TO THE
 * SOFTWARE, WHETHER EXPRESS, IMPLIED OR STATUTORY, INCLUDING WITHOUT LIMITATION
 * ALL WARRANTIES AND CONDITIONS OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, TITLE AND NON-INFRINGEMENT.
 * 
 * Copyright (c) 1995-2017 NetCracker Technology Corp.
 * 
 * All Rights Reserved.
 */