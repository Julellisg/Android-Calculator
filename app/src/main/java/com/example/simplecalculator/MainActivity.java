/*
Name: Julian Ellis Geronimo
Professor: Earl Foxwell
Course: Mobile Computing

I have implemented the decimal (.) key which can be used to calculate expressions containing decimals,
instead of only outputting results that are decimals.
I have implemented Formula Entry which can be toggled by a button named "FRM" on the calculator app, and will
solve expressions following order of operations. Pressing the Basic Entry button named "BSC" will toggle back to
solving expressions from a left-to-right fashion.
Errors that occur (e.g. dividing by 0) will result in "NaN". The external library used to implement formula entry
below uses "NaN" to output errors, so for consistency basic entry also outputs the errors as "NaN"

This calculator app is programed to fit onto a "Nexus 4" VD, API 23

Citations:
"MXParser" (library) which uses JDK 11  |  Download URL: https://mathparser.org/
- The usage of this library gives access to the Expression object.
- The Expression object contains a function calculate() which accepts a String which I use to process
the current (String) expression typed out so far.
- This function returns a value that is the result of the expression done using order of operations (BEDMAS).
 */

package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import org.mariuszgromada.math.mxparser.Expression;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView input;
    private TextView output;
    private int mode = 0;       // 0: Basic Entry (default)       1: Formula Entry

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // These two textviews will be used to edit text directly.
        input = findViewById(R.id.inputView);
        output = findViewById(R.id.outputView);
    }

    // Takes the current string of the input textview, and appends whatever input is in the parameter.
    public void updateText(String opr) {
        String str = input.getText().toString();
        input.setText(String.format("%s%s", str, opr));
    }

    // Mode Buttons
    // My reason for adding the if statement is because I want to avoid spamming the screen if a particular mode is being displayed already.
    // The Toast will only ever display a message when it is switching modes.
    public void basicClick(View view) {
        if(!(mode == 0)) {
            mode = 0;
            Toast.makeText(MainActivity.this, "MODE: Basic Entry", Toast.LENGTH_SHORT).show();
        }
    }

    public void formulaClick(View view) {
        if(!(mode == 1)) {
            mode = 1;
            Toast.makeText(MainActivity.this, "MODE: Formula Entry", Toast.LENGTH_SHORT).show();
        }
    }

    // Operands
    public void zeroClick(View view) {
        updateText(getResources().getString(R.string.zero));

        String str = input.getText().toString();
        if(!readExpression(str))
            return;

        if(mode == 0)
            output.setText(String.valueOf(basicCalculate(str)));
        else if(mode == 1) {
            Expression exp = new Expression(str);
            output.setText(String.valueOf(exp.calculate()));
        }
    }
    public void oneClick(View view) {
        updateText(getResources().getString(R.string.one));

        String str = input.getText().toString();
        if(!readExpression(str))
            return;

        if(mode == 0)
            output.setText(String.valueOf(basicCalculate(str)));
        else if(mode == 1) {
            Expression exp = new Expression(str);
            Toast.makeText(MainActivity.this, String.valueOf(exp.calculate()), Toast.LENGTH_SHORT).show();
            output.setText(String.valueOf(exp.calculate()));
        }
    }
    public void twoClick(View view) {
        updateText(getResources().getString(R.string.two));

        String str = input.getText().toString();
        if(!readExpression(str))
            return;

        if(mode == 0)
            output.setText(String.valueOf(basicCalculate(str)));
        else if(mode == 1) {
            Expression exp = new Expression(str);
            output.setText(String.valueOf(exp.calculate()));
        }
    }
    public void threeClick(View view) {
        updateText(getResources().getString(R.string.three));

        String str = input.getText().toString();
        if(!readExpression(str))
            return;

        if(mode == 0)
            output.setText(String.valueOf(basicCalculate(str)));
        else if(mode == 1) {
            Expression exp = new Expression(str);
            output.setText(String.valueOf(exp.calculate()));
        }
    }
    public void fourClick(View view) {
        updateText(getResources().getString(R.string.four));

        String str = input.getText().toString();
        if(!readExpression(str))
            return;

        if(mode == 0)
            output.setText(String.valueOf(basicCalculate(str)));
        else if(mode == 1) {
            Expression exp = new Expression(str);
            output.setText(String.valueOf(exp.calculate()));
        }
    }
    public void fiveClick(View view) {
        updateText(getResources().getString(R.string.five));

        String str = input.getText().toString();
        if(!readExpression(str))
            return;

        if(mode == 0)
            output.setText(String.valueOf(basicCalculate(str)));
        else if(mode == 1) {
            Expression exp = new Expression(str);
            output.setText(String.valueOf(exp.calculate()));
        }
    }
    public void sixClick(View view) {
        updateText(getResources().getString(R.string.six));

        String str = input.getText().toString();
        if(!readExpression(str))
            return;

        if(mode == 0)
            output.setText(String.valueOf(basicCalculate(str)));
        else if(mode == 1) {
            Expression exp = new Expression(str);
            output.setText(String.valueOf(exp.calculate()));
        }
    }
    public void sevenClick(View view) {
        updateText(getResources().getString(R.string.seven));

        String str = input.getText().toString();
        if(!readExpression(str))
            return;

        if(mode == 0)
            output.setText(String.valueOf(basicCalculate(str)));
        else if(mode == 1) {
            Expression exp = new Expression(str);
            output.setText(String.valueOf(exp.calculate()));
        }
    }
    public void eightClick(View view) {
        updateText(getResources().getString(R.string.eight));

        String str = input.getText().toString();
        if(!readExpression(str))
            return;

        if(mode == 0)
            output.setText(String.valueOf(basicCalculate(str)));
        else if(mode == 1) {
            Expression exp = new Expression(str);
            output.setText(String.valueOf(exp.calculate()));
        }
    }
    public void nineClick(View view) {
        updateText(getResources().getString(R.string.nine));

        String str = input.getText().toString();
        if(!readExpression(str))
            return;

        if(mode == 0)
            output.setText(String.valueOf(basicCalculate(str)));
        else if(mode == 1) {
            Expression exp = new Expression(str);
            output.setText(String.valueOf(exp.calculate()));
        }
    }

    // Operator Functions
    // To understand these operator functions, it works to see every false scenario possible and use it in a boolean statement:
    // If the string is empty, we cannot input any operators.
    // If the string isn't empty, there exists some operands and operators and we can check if we're allowed to insert/replace an operator.
    //      If the most recent input is an operator (that isn't the same), then replace that current one with the operator button we pressed.
    //      If the most recent input is an operand, then we can insert an operator.
    // If we are in basic entry (mode = 0), then perform a calculation on current expression whenever one of these operators is pressed.
    public void divideClick(View view) {
        String str = input.getText().toString();
        char[] expression = str.toCharArray();

        if(str.isEmpty())
            return;

        if(expression[expression.length-1] == '+' || expression[expression.length-1] == '*' || expression[expression.length-1] == '-') {
            str = str.substring(0, str.length() - 1);     // deletes last character (rightmost-side)
            input.setText(str);
            updateText("/");
//                if (mode == 0)
//                    output.setText(Double.toString(basicCalculation(str)));
        }
        else if(Character.isDigit(expression[expression.length-1])) {
            updateText("/");
//                if (mode == 0)
//                    output.setText(Double.toString(basicCalculation(str)));
        }
    }

    public void multiplyClick(View view) {
        String str = input.getText().toString();
        char[] expression = str.toCharArray();

        if(str.isEmpty())
            return;

        if(expression[expression.length-1] == '/' || expression[expression.length-1] == '+' || expression[expression.length-1] == '-') {
            str = str.substring(0, str.length() - 1);     // deletes last character (rightmost-side)
            input.setText(str);
            updateText("*");
//                if (mode == 0)
//                    output.setText(Double.toString(basicCalculation(str)));
        }
        else if(Character.isDigit(expression[expression.length-1])) {
            updateText("*");
//                if (mode == 0)
//                    output.setText(Double.toString(basicCalculation(str)));
        }
    }

    public void subtractClick(View view) {
        String str = input.getText().toString();
        char[] expression = str.toCharArray();

        if(str.isEmpty())
            return;

        if(expression[expression.length-1] == '/' || expression[expression.length-1] == '*' || expression[expression.length-1] == '+') {
            str = str.substring(0, str.length() - 1);     // deletes last character (rightmost-side)
            input.setText(str);
            updateText("-");
//                if (mode == 0)
//                    output.setText(Double.toString(basicCalculation(str)));
        }
        else if(Character.isDigit(expression[expression.length-1])) {
            updateText("-");
//                if (mode == 0)
//                    output.setText(Double.toString(basicCalculation(str)));
        }
    }

    public void addClick(View view) {
        String str = input.getText().toString();
        char[] expression = str.toCharArray();

        // not empty string
        if(str.isEmpty())
            return;

        if(expression[expression.length-1] == '/' || expression[expression.length-1] == '*' || expression[expression.length-1] == '-') {    // replaces found operator
            str = str.substring(0, str.length() - 1);     // deletes last character (rightmost-side)
            input.setText(str);
            updateText("+");
//                if (mode == 0)
//                    output.setText(Double.toString(basicCalculation(str)));
        }
        else if(Character.isDigit(expression[expression.length-1])) {   // adding operator next to a digit
            updateText("+");
//                if (mode == 0)
//                    output.setText(Double.toString(basicCalculation(str)));
        }
    }

    // Equals Function
    // Checks if current expression is empty. If it is, then don't do anything. If it isn't then:
    //      If the most recent input is an operator, return an error since it can't be calculated.
    //      If we are in basic entry:
    //          If the most recent input is an operand, then we can calculate current expression.
    //          Else we ignore it.
    //      Else If we are in formula entry:
    //          Solve current expression using order of operations (MXParser).
    public void equalClick(View view) {
        String str = input.getText().toString();    // gets current input
        char[] expression = str.toCharArray();
        String result;

        if(!str.isEmpty()) {
            if(findOperator(expression[expression.length-1])) {     // if operator is first when pressing equals
                output.setText("NaN");
                return;
            }
            if (mode == 0) {
                if(Character.isDigit(expression[expression.length-1])) {
                    result = Double.toString(basicCalculate(str));
                    if(result == "Infinity")
                        output.setText("NaN");
                    else {
                        input.setText(result);
                        output.setText("");
                    }
                }
                else {
                    output.setText("");
                }
            }
            else if(mode == 1)
                formulaCalculate(str);
        }
    }

    // Point Click Function
    // If string is empty, or if most recent input is an operator
    //      We are clear to enter "0." (used for better readability)
    // Else
    //      Check and verify if current operand in expression already has a decimal, if not we can place ".".
    public void pointClick(View view) {
        String str = input.getText().toString();
        char[] expression = str.toCharArray();
        int pointState = 0; // 0: no decimal found      1: decimal found

        if(str.isEmpty() || findOperator(expression[expression.length-1])) {    // if string is empty, or last input was an operator
            updateText("0.");
        } else {    // should only output "." from here
            for(int i = expression.length-1; i > 0; i--) {
                if(findOperator(expression[i])) break;
                if(expression[i] == '.') {
                    pointState = 1;
                }
            }
            if(pointState == 0) updateText(".");
        }
    }

    // Clear both input and output textviews
    public void allclearClick(View view) {
        input.setText("");
        output.setText("");
    }

    // Acts as the Correct button. Reads current expression and deletes most recent input by taking a substring of the expression.
    public void backspaceClick(View view) {
        String str = input.getText().toString();    // gets current input

        if(!str.isEmpty()) {                              // incase input is empty, it wont crash when backspacing
            str = str.substring(0, str.length() - 1);     // deletes last character (rightmost-side)
            output.setText("");
        }

        input.setText(str);
    }

    // Boolean function to find if one of the four arithmetic operators is present.
    public Boolean findOperator(char c) {
        if(c=='+' || c=='-' || c=='*' || c=='/')
            return true;    // one of those operators is found

        return false;
    }

    // Calculation Functions
    // Function specifically used for basic entry and calculating after pressing an operator. Has very similar structure to equalClick().
    public double basicCalculate(String str) {
        // needed variables
        List<Double> operands = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        boolean lastWasOperator= false;

        // operators : only arithmetic symbols (+, -, *, /)
        // opernads : numbers, decimals, and a special case for negative numbers
        // special case for negative numbers: (1) first character in math expression is '-', (2) after an operator is read, another operator is read right after which is also '-' symbol
        for(int i = 0; i < str.length(); i++) {  // iterate through the entire expression
            char pos = str.charAt(i);    // in this loop

            // very first character in expression should be treated as a negative instead
            if((i == 0 && pos == '-') || (lastWasOperator && pos == '-')) {
                sb.append(pos);
            }
            // checks if there is a number or decimal
            else if(Character.isDigit(pos) || pos == '.') {
                sb.append(pos);
                lastWasOperator = false;
            }
            else if(pos == '+' || pos == '-' || pos == '*' || pos == '/') {
                // since we arrive at an operand, that indicates we are done reading through a number
                operands.add(Double.parseDouble(sb.toString()));
                sb.delete(0, sb.length());  // clears the whole buffer

                operators.add(Character.toString(pos));
                lastWasOperator = true;
            }
        }
        operands.add(Double.parseDouble(sb.toString()));    // if were reading an expression that ends with a number, we never get to add it to the List, so this last step is necessary

        // actually calculate the expression
        double result = operands.get(0);
        for(int i = 0; i < operators.size(); i++) { // iterating through all operators
            String operator = operators.get(i);     // get current operator
            double operands2 = operands.get(i+1);   // we start from i+1=1 since the number of operators
            switch(operator) {
                case "+":
                    result += operands2;
                    break;
                case "-":
                    result -= operands2;
                    break;
                case "*":
                    result *= operands2;
                    break;
                case "/":
                    result /= operands2;
                    break;
            }
        }

        return result;
    }

    public void formulaCalculate(String str) {
        Expression exp = new Expression(str);
        input.setText(String.valueOf(exp.calculate()));
        output.setText("");
    }

    public boolean readExpression(String str) {
        // needed variables
        List<Double> operands = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        boolean lastWasOperator= false;

        // operators : only arithmetic symbols (+, -, *, /)
        // opernads : numbers, decimals, and a special case for negative numbers
        // special case for negative numbers: (1) first character in math expression is '-', (2) after an operator is read, another operator is read right after which is also '-' symbol
        for(int i = 0; i < str.length(); i++) {  // iterate through the entire expression
            char pos = str.charAt(i);    // in this loop

            // very first character in expression should be treated as a negative instead
            if((i == 0 && pos == '-') || (lastWasOperator && pos == '-')) {
                sb.append(pos);
            }
            // checks if there is a number or decimal
            else if(Character.isDigit(pos) || pos == '.') {
                sb.append(pos);
                lastWasOperator = false;
            }
            else if(pos == '+' || pos == '-' || pos == '*' || pos == '/') {
                // since we arrive at an operand, that indicates we are done reading through a number
                operands.add(Double.parseDouble(sb.toString()));
                sb.delete(0, sb.length());  // clears the whole buffer

                operators.add(Character.toString(pos));
                lastWasOperator = true;
            }
        }
        operands.add(Double.parseDouble(sb.toString()));    // if were reading an expression that ends with a number, we never get to add it to the List, so this last step is necessary

        boolean tf = (operands.size() >= 1 && operators.size() >= 1);
        return tf;
    }
}