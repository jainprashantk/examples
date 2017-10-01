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

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

import ch.maxant.rules.*;

/**
 * @author prja1015
 */
public class RuleExample {

    public RuleExample() {
    }

    public static void main(String[] args) throws DuplicateNameException, CompileException, ParseException {

        Stream<Rule> streamOfRules = getStreamOfRules();

        // to pass in a stream, we need to use a different Engine
        Java8Engine e = new Java8Engine(streamOfRules, true);

        // to use a lambda, construct a SamAction and pass it a lambda.
        IAction<MyInput, BigDecimal> action1
            = new SamAction<MyInput, BigDecimal>("outcome1", i -> new BigDecimal("100.0"));
        IAction<MyInput, BigDecimal> action2
            = new SamAction<MyInput, BigDecimal>("outcome2", i -> new BigDecimal("101.0"));
        List<IAction<MyInput, BigDecimal>> actions = Arrays.asList(action1, action2);

        //MyInput input = new MyInput();
        Map<String, Person> input = new HashMap<>();
        Person p1 = new Person("ant", 16);
        Person p2 = new Person("clare", 19);
        //input.setP1(p1);
        //input.setP2(p2);
        input.put("p1", p1);
        input.put("p2", p2);

        try {
            //BigDecimal price = e.executeBestAction(input, actions.stream());
            //System.out.println(price);
            System.out.println(e.getBestOutcome(input));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static Stream<Rule> getStreamOfRules() {
        Rule rule1 = new Rule("R1", "input.p1.name == \"ant\" && input.p1.age == 16", "outcome1", 0,
            "ch.maxant.produkte", "Spezi Regel für Familie Kutschera");
        Rule rule2 = new Rule("R2", "input.p2.name == \"clare\" && input.p2.age == 19", "outcome2", 1, "ch.maxant.produkte", "Default Regel");
        List<Rule> rules = Arrays.asList(rule1, rule2);
        return rules.stream();
    }

    public static final class Person {

        private String name;
        private Integer age;

        public Person(int age) {
            this.age = age;
        }

        public Person(String name) {
            this.name = name;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    public static final class MyInput {

        private Person p1;
        private Person p2;

        public Person getP1() {
            return p1;
        }

        public void setP1(Person p1) {
            this.p1 = p1;
        }

        public Person getP2() {
            return p2;
        }

        public void setP2(Person p2) {
            this.p2 = p2;
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