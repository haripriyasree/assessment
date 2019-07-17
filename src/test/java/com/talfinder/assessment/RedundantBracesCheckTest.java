package com.talfinder.assessment;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


    @RunWith(Parameterized.class)
    public class RedundantBracesCheckTest {
        String expression;
        boolean expected;

        public RedundantBracesCheckTest(String expression, boolean expected) {
            this.expression = expression;
            this.expected = expected;
        }
        @Parameterized.Parameters
        public static Collection<Object[]> parameters() {
            return Arrays.asList(new Object[][]{
                    {"{{a+b}}", true},
                    {"(a+b)", false},
                    {"{a+b}", false},
                    {"[[a+b+(c)]]",true},
                    {"a+b",false},
                    {"array+you",false},
                    {"[[g+k]]",true},
                    {"[a+y]",false}});
        }@Test
        public void checkRedundantBraces(){
            Assert.assertEquals("input:Equation as '"+ expression + "'", expected, RedundantBracesCheck.containsRedundantBraces(expression));
        }

    }
