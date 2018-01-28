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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author prja1015
 */
public class RegexExample {

    public static void main(String[] args) {
        final String PHONE = "^(\\(?\\+?[0-9]*\\)?)?[0-9\\- \\(\\)]*$";
        String phone = "+14160000001";
        String str = "searchstring";
        Pattern p = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        System.out.println("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        System.out.println(p.pattern());
        Pattern ph = Pattern.compile(Pattern.quote(phone));
        Matcher m = ph.matcher(phone);
        System.out.println(m.matches());
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