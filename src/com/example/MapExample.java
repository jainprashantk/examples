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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;

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
        Collection dueDateColl = new ArrayList<>();
        dueDateColl.add(null);
        System.out.println(dueDateColl.stream().map(e -> e).collect(Collectors.toSet()));
        getOpportunitiesWithAccountDetails();
        getStreaming();
        finallyTest();
    }

    public static List<Map<String, Object>> getOpportunitiesWithAccountDetails() {
        final List<Map<String, Object>> opportunityResponseList = new ArrayList<>();
        final Map<String, Object> oppoResp = new HashMap<>();
        final Map<String, Object> oppoValue = new HashMap<>();
        oppoResp.put("VALUE", oppoValue);
        opportunityResponseList.add(oppoResp);
        final List<Map<String, Object>> opportunitiesWithAccountDetails = new ArrayList<>();
        opportunityResponseList.forEach(opportunityResponse -> {
            final Map<String, Object> opportunity = (Map<String, Object>) opportunityResponse.get("VALUE");
                prepareResponse(opportunity);
                opportunitiesWithAccountDetails.add(opportunityResponse);
        });
        System.out.println(opportunitiesWithAccountDetails);
        return opportunitiesWithAccountDetails;
    }

    private static void prepareResponse(final Map<String, Object> opportunity) {
        final Map<String, Object> account = new HashMap<>();
        account.put("BILLING_COUNTRY", "BILLING_COUNTRY");
        account.put("REGION", "REGION");
        opportunity.put("BILLING_COUNTRY", account.get("BILLING_COUNTRY"));
        opportunity.put("REGION", account.get("REGION"));
    }

    public static void getStreaming() {
        ArrayList<String> a = new ArrayList<String>();
        a.add("test");
        System.out.println(
        Stream.of(a.stream(), new ArrayList<String>().stream())
        .flatMap(identity())
        .sorted()
        .collect(toList()));
    }

    public static boolean finallyTest() {
        boolean flag = false;
        System.out.println("before try " + flag);
        try {
            flag = true;
            System.out.println("in try " + flag);
            return flag;
        }
        finally {
            flag = false;
            System.out.println("in finally " + flag);
        }
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