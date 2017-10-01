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

import com.opencsv.CSVReader;

import java.io.*;

/**
 * @author prja1015
 */
public class CSVExample {

    public CSVExample() {
    }

    public static void main(String[] args) throws IOException {
        byte[] byteBuffer = new byte[9000];
        try (
            FileInputStream fis = new FileInputStream("leads.csv");
            ByteArrayInputStream bais = new ByteArrayInputStream(byteBuffer);
            InputStreamReader isr = new InputStreamReader(bais);
            CSVReader reader = new CSVReader(isr)) {
            fis.read(byteBuffer);
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                try {
                    // nextLine[] is an array of values from the line
                    System.out.println(nextLine[0] + " " + nextLine[1] + " etc...");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
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