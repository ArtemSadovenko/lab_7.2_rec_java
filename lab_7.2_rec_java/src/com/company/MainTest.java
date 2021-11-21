package com.company;

import org.junit.Assert;

import static com.company.Main.max;
import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Test
    public void TestMax() {
        int k = 2;
        int n = 2;
        int[][] a = new int[k][n];
        a[0][0] = 1;
        a[0][1] = 2;
        a[1][0] = 3;
        a[1][1] = 1;

        int real = max(a, 2, 1, 0, 0, 0);
        int expected = 0;
        Assert.assertEquals(real, expected);
    }
}