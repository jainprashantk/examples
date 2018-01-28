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

import org.mvel2.MVEL;

import java.util.*;

/**
 * @author prja1015
 */
public class MVELExample {

    public static void main(String[] args) {
        String operator = ">";
        List<Double> computedValue = new ArrayList<Double>();
        computedValue.add(new Double(50.0));
        computedValue.add(new Double(97.9));
        computedValue.add(new Double(68.9));

        Map<String, Object> input = new HashMap<String, Object>();
        input.put("actual_value", new Double(55.9));
        input.put("computed_value", computedValue);
        List output = null;

        if (operator.equals(">")) {
            output = (List) MVEL.eval("($ in computed_value if $ > actual_value)", input);
        } else {
            output = (List) MVEL.eval("($ in computed_value if $ < actual_value)", input);
        }
        System.out.println(output);
        Map vars = new HashMap();
        //vars.put("date", Instant.now().plus(3, ChronoUnit.DAYS).toString());
        vars.put("addToDate", "3");
        System.out.println(MVEL.eval("java.time.Instant.now().plus(addToDate, java.time.temporal.ChronoUnit.DAYS).toString()", vars));
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