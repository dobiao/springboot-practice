package com.souche.test

import org.codehaus.groovy.runtime.InvokerHelper

public class GroovyTest {
    public static void main(String[] args) {
        try {
            Script shell;
            Binding bindings = new Binding();
            bindings.setProperty("baseFirstYearCost", 19992400);
            bindings.setProperty("prepaidAmount", 2030000);

            shell = new GroovyShell().parse("try{Double.valueOf(new BigDecimal(Math.max(800d,(Math.floor((baseFirstYearCost-prepaidAmount)/12/10000.0)*10000+9800))).setScale(0, BigDecimal.ROUND_HALF_UP))}catch(Exception e){e.printStackTrace();return null}");

            Object lilv = InvokerHelper.createScript(shell.getClass(), bindings).run();

            System.out.println(lilv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
