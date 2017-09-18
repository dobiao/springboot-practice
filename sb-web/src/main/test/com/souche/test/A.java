package com.souche.test;

/**
 * Created by dubiao on 2017/9/13.
 */
public class A {

    public static void main(String[] args) {
        itemVehicleVesselTaxCalc(18);
    }

    private static Long itemVehicleVesselTaxCalc(Integer displacement) {
        long annualTax;
        if (displacement <= 10) {
            annualTax = 180;
            System.out.println(annualTax);
            return annualTax;
        } else if (displacement <= 16) {
            annualTax = 300;
            System.out.println(annualTax);
        } else if (displacement <= 20) {
            annualTax = 360;
            System.out.println(annualTax);
        } else if (displacement <= 25) {
            annualTax = 660;
            System.out.println(annualTax);
        } else if (displacement <= 30) {
            annualTax = 1500;
            System.out.println(annualTax);
        } else if (displacement <= 40) {
            annualTax = 3000;
            System.out.println(annualTax);
        } else {
            annualTax = 4500;
            System.out.println(annualTax);
        }
        return annualTax * 100;
    }
}
