package com.srx.calculator;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author srx
 * @description
 * @create 2020-09-15 13:46:00
 */
public class InitComponent {

    private Activity activity;

    public static Button cleared;
    public static Button delete;
    public static Button change;
    public static Button point;

    public static Button percentage;
    public static Button division;
    public static Button multiplication;
    public static Button minus;
    public static Button add;
    public static Button equal;
    public static Button tan;
    public static Button cos;
    public static Button sin;
    public static Button part;

    public static Button nine;
    public static Button eight;
    public static Button seven;
    public static Button six;
    public static Button five;
    public static Button four;
    public static Button three;
    public static Button two;
    public static Button one;
    public static Button zero;

    public static TextView formula;
    public static TextView result;

    private int focusSignId;
    private String focusSign;
    private String perString;
    private String resultNum;
    private String firstNum;
    private int signCount;


    public void initComponent() {
        delete = activity.findViewById(R.id.delete);
        cleared = activity.findViewById(R.id.cleared);
        change = activity.findViewById(R.id.change);
        point = activity.findViewById(R.id.point);
        percentage = activity.findViewById(R.id.percentage);
        division = activity.findViewById(R.id.division);
        multiplication = activity.findViewById(R.id.multiplication);
        minus = activity.findViewById(R.id.minus);
        add = activity.findViewById(R.id.add);
        equal = activity.findViewById(R.id.equal);
        tan=activity.findViewById(R.id.tan);
        cos=activity.findViewById(R.id.cos);
        sin=activity.findViewById(R.id.sin);
        part=activity.findViewById(R.id.part);
        nine = activity.findViewById(R.id.nine);
        eight = activity.findViewById(R.id.eight);
        seven = activity.findViewById(R.id.seven);
        six = activity.findViewById(R.id.six);
        five = activity.findViewById(R.id.five);
        four = activity.findViewById(R.id.four);
        two = activity.findViewById(R.id.two);
        three = activity.findViewById(R.id.three);
        one = activity.findViewById(R.id.one);
        zero = activity.findViewById(R.id.zero);
        formula = activity.findViewById(R.id.formula);
        result = activity.findViewById(R.id.answer);
        formula.setText("0");
        result.setText("0");
        perString = "0";
        resultNum = "0";
        focusSignId = 0;
        focusSign = "";
        signCount = 0;
    }

    public InitComponent(Activity activity) {
        this.activity = activity;
    }


    public void initRecyclerView(List<Calculator> list, Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = new RecyclerView(context);
        CalculatorAdapter adapter = new CalculatorAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private boolean isLastSign(String expression) {
        String[] split = expression.split("");
        List<String> list = Arrays.asList(split);
        String s = list.get(list.size() - 1);
        if (s.equals("×") || s.equals("+") || s.equals("-") || s.equals("÷") || s.equals(".")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isLastPoint(String expression) {
        String[] split = expression.split("");
        List<String> list = Arrays.asList(split);
        String s = list.get(list.size() - 1);
        if (s.equals("."))
            return true;
        else
            return false;
    }


    private String tan(String number){
        if (focusSignId == R.id.tan) {
            Double integer = Double.parseDouble(number);
            focusSignId = 0;
            return Math.tan(integer) + "";
        } else
            return number;
    }

    private String cos(String number){
        if (focusSignId == R.id.cos) {
            Double integer = Double.parseDouble(number);
            focusSignId = 0;
            return Math.cos(integer) + "";
        } else
            return number;
    }
    private String sin(String number){
        if (focusSignId == R.id.tan) {
            Double integer = Double.parseDouble(number);
            focusSignId = 0;
            return Math.sin(integer) + "";
        } else
            return number;
    }
    private String part(String number){
        if (focusSignId == R.id.tan) {
            Double integer = Double.parseDouble(number);
            focusSignId = 0;
            return (1/integer) + "";
        } else
            return number;
    }
    private String percentage(String number) {
        if (focusSignId == R.id.percentage) {
            Double integer = Double.parseDouble(number);
            focusSignId = 0;
            return integer / 100 + "";
        } else
            return number;
    }

    public String calculator(String firstNumber, String secondNumber) {
        String resultNumber = firstNumber;
        if (focusSign == "" || secondNumber == "") {
            return resultNumber;
        } else {
            double first = Double.parseDouble(firstNumber);
            double second = Double.parseDouble(secondNumber);
            switch (focusSignId) {
                case R.id.minus:
                    resultNumber = (first - second) + "";
                    break;
                case R.id.add:
                    resultNumber = (first + second) + "";
                    break;
                case R.id.multiplication:
                    resultNumber = (first * second) + "";
                    break;
                case R.id.division:
                    if (second == 0)
                        resultNumber = "不可以除以0";
                    else {
                        resultNumber = (first / second) + "";
                    }
                    break;
                case R.id.point:
                    if (isContainPoint(firstNumber))
                        resultNumber = firstNumber + secondNumber.charAt(secondNumber.length() - 1);
                    else
                        resultNumber = firstNumber + "." + secondNumber;
                    break;
            }
            return resultNumber;
        }
    }


    private int getIndex(String formula) {
        if (focusSign != "") {
            return formula.lastIndexOf(focusSign);
        } else {
            return formula.length() - 1;
        }
    }

    public void setSignCount() {
        signCount++;
    }

    public boolean isContainPoint(String number) {
        String[] split = number.split("");
        List<String> list = Arrays.asList(split);
        return list.contains(".");
    }

    public void commonNumSet(String num) {
        perString = formula.getText().toString();
        if (perString.equals("0")) {
            formula.setText(num);
            perString = num;
            resultNum = num;
        } else {
            perString += num;
            formula.setText(perString);
            firstNum = perString.substring(0, getIndex(perString));
            if (getIndex(perString) == perString.length() - 1) {
                resultNum = firstNum + num;
            } else {
                if (signCount > 1) {
                    resultNum = result.getText().toString();
                } else
                    resultNum = firstNum;
            }
        }
        String substringString = perString.substring(getIndex(perString) + 1, perString.length());
        result.setText(calculator(resultNum, substringString));
    }

    public void setText(Button button) {
        switch (button.getId()) {
            case R.id.zero:
                perString = formula.getText().toString();
                if (perString.equals("0")) {
                    formula.setText("0");
                    result.setText("0");
                } else {
                    commonNumSet("0");
                }
                break;
            case R.id.one:
                commonNumSet("1");
                break;
            case R.id.two:
                commonNumSet("2");
                break;
            case R.id.three:
                commonNumSet("3");
                break;
            case R.id.four:
                commonNumSet("4");
                break;
            case R.id.five:
                commonNumSet("5");
                break;
            case R.id.six:
                commonNumSet("6");
                break;
            case R.id.seven:
                commonNumSet("7");
                break;
            case R.id.eight:
                commonNumSet("8");
                break;
            case R.id.nine:
                commonNumSet("9");
                break;
            case R.id.multiplication:
                perString = formula.getText().toString();
                if (!isLastSign(perString)) {
                    focusSignId = R.id.multiplication;
                    focusSign = "×";
                    setSignCount();
                    formula.setText(perString + "×");
                } else if (isLastSign(perString) && isLastPoint(perString))
                    formula.setText(perString + "×");
                else
                    formula.setText(perString);
                break;
            case R.id.division:
                perString = formula.getText().toString();
                if (!isLastSign(perString)) {
                    focusSignId = R.id.division;
                    focusSign = "÷";
                    setSignCount();
                    formula.setText(perString + "÷");
                } else if (isLastSign(perString) && isLastPoint(perString)) {
                    formula.setText(perString + "÷");
                } else
                    formula.setText(perString);
                break;
            case R.id.add:
                perString = formula.getText().toString();
                if (!isLastSign(perString)) {
                    focusSignId = R.id.add;
                    focusSign = "+";
                    setSignCount();
                    formula.setText(perString + "+");
                } else if (isLastSign(perString) && isLastPoint(perString)) {
                    formula.setText(perString + "+");
                } else
                    formula.setText(perString);
                break;
            case R.id.minus:
                perString = formula.getText().toString();
                if (!isLastSign(perString)) {
                    focusSignId = R.id.minus;
                    focusSign = "-";
                    setSignCount();
                    formula.setText(perString + "-");
                } else if (isLastSign(perString) && isLastPoint(perString)) {
                    formula.setText(perString + "-");
                } else
                    formula.setText(perString);
                break;
            case R.id.percentage:
                perString = formula.getText().toString();
                resultNum = result.getText().toString();
                focusSignId = R.id.percentage;
                result.setText(percentage(resultNum));
                break;
            case R.id.point:
                perString = formula.getText().toString();
                resultNum = result.getText().toString();
                if (!isLastSign(perString)) {
                    focusSignId = R.id.point;
                    focusSign = ".";
                    formula.setText(perString + ".");
                } else {
                    formula.setText(perString);
                }
                break;
            case R.id.delete:
                perString = formula.getText().toString();
                resultNum = result.getText().toString();
                if (perString != "0") {
                    if (isLastSign(perString)) {
                        focusSignId = 0;
                        focusSign = "";
                        formula.setText(perString.substring(0, perString.length() - 1));
                    } else {
                        if (perString.length() >= 2) {
                            formula.setText(perString.substring(0, perString.length() - 1));
                            String newNum = resultNum.substring(0, perString.length() - 1);
                            result.setText(newNum);
                        } else {
                            formula.setText("0");
                            result.setText("0");
                        }
                    }
                } else {
                    focusSignId = 0;
                    focusSign = "";
                    formula.setText("0");
                    result.setText("0");
                }
                break;
            case R.id.cleared:
                perString = formula.getText().toString();
                resultNum = result.getText().toString();
                focusSignId = 0;
                focusSign = "";
                signCount = 0;
                formula.setText("0");
                result.setText("0");
                break;
            case R.id.tan:
                perString = formula.getText().toString();
                resultNum = result.getText().toString();
                focusSignId = R.id.tan;
                result.setText(tan(resultNum));
                break;
            case R.id.cos:
                perString = formula.getText().toString();
                resultNum = result.getText().toString();
                focusSignId = R.id.cos;
                result.setText(cos(resultNum));
                break;
            case R.id.sin:
                perString = formula.getText().toString();
                resultNum = result.getText().toString();
                focusSignId = R.id.sin;
                result.setText(sin(resultNum));
                break;
            case R.id.part:
                perString = formula.getText().toString();
                resultNum = result.getText().toString();
                focusSignId = R.id.part;
                result.setText(part(resultNum));
                break;
        }
    }

}
