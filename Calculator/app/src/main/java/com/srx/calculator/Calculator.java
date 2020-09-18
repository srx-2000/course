package com.srx.calculator;

/**
 * @author srx
 * @description
 * @create 2020-09-15 10:18:56
 */
public class Calculator {

    private String formula;
    private String result;

    public Calculator(String formula, String result) {
        this.formula = formula;
        this.result = result;
    }

    public String getFormula() {
        return formula;
    }

    public String getResult() {
        return result;
    }
}
