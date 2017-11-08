package com.souche.test;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by dubiao on 2017/9/13.
 */
public class IfelseTest {

    public static void main(String[] args) {


        List<Long> ll = Lists.newArrayList(1L, 2L, 3L, 4L, 5L);

        Long t = -1L;

        for (Long l : ll) {
            if (l == 2L || l == 3L || l == 4L) {
                l = 2 * l;


                if (t == -1L)

                {

                    t = l;

                }


            }

        }


        System.out.println(t);


        //itemVehicleVesselTaxCalc(18);
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
