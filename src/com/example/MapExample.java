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

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author prja1015
 */
public class MapExample {

    public MapExample() {
    }

    public static void main(String[] args) {
        final List<String> rowColumns = new ArrayList<>();
        rowColumns.add("abc");
        rowColumns.add("pqr");
        rowColumns.add("xyz");
        final Map<Integer, String> row = new ConcurrentHashMap<>();
        int columnNumber = 0;
        for (String columnValue : rowColumns) {
            row.put(columnNumber++, columnValue);
        }
        System.out.println(row);
        row.computeIfPresent(0, (key, oldValue) -> "idk");
        row.computeIfPresent(1, (key, oldValue) -> "tldr");
        System.out.println(row);
        final Map<String, Object> column = new ConcurrentHashMap<>();
        System.out.println((Map) column.get("first"));
        final Map<String, Object> dueDateMap = (Map<String, Object>)null;
        if(dueDateMap instanceof Map)
            System.out.println("works");
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