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

import java.time.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author prja1015
 */
public class TimezoneExample {

    public TimezoneExample() {
    }

    public static void main(String[] args) {
        TimezoneDisplay display = new TimezoneDisplay();

        System.out.println("Time zones in UTC:");
        List<String> utc = display.getTimeZoneList(OffsetBase.UTC);
        utc.forEach(System.out::println);

        System.out.println("Time zones in GMT:");
        List<String> gmt = display.getTimeZoneList(OffsetBase.GMT);
        gmt.forEach(System.out::println);
    }

    private static class TimezoneDisplay {

        public List<String> getTimeZoneList(OffsetBase base) {

            LocalDateTime now = LocalDateTime.now();
            return ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId::of)
                .sorted(new ZoneComparator())
                .map(id -> String.format(
                    "(%s%s) %s",
                    base, getOffset(now, id), id.getId()))
                .collect(Collectors.toList());
        }

        private String getOffset(LocalDateTime dateTime, ZoneId id) {
            return dateTime
                .atZone(id)
                .getOffset()
                .getId()
                .replace("Z", "+00:00");
        }
    }

    private enum OffsetBase {
        GMT, UTC
    }

    private static class ZoneComparator implements Comparator<ZoneId> {

        @Override
        public int compare(ZoneId zoneId1, ZoneId zoneId2) {
            LocalDateTime now = LocalDateTime.now();
            ZoneOffset offset1 = now.atZone(zoneId1).getOffset();
            ZoneOffset offset2 = now.atZone(zoneId2).getOffset();

            return offset2.compareTo(offset1);
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