package com.shalom.mycalc;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Node;

import java.text.DecimalFormat;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView Number;
    private double keepNum1 = 0;
    private double keepNum2 = 0;
    private String keepChar = "";
    private double sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPointer();
    }

    private void setPointer() {
        Number = findViewById(R.id.Number);
    }

    @Override
    public void onClick(View view) {
        StringBuilder sb = new StringBuilder();
        sb.append(Number.getText().toString());
        System.out.println("here" + sb.toString());
        switch (view.getId()) {
            case R.id.num1:
                sb.append("1");
                System.out.println("here1");
                break;
            case R.id.num2:
                sb.append("2");
                break;
            case R.id.num3:
                sb.append("3");
                break;
            case R.id.num4:
                sb.append("4");
                break;
            case R.id.num5:
                sb.append("5");
                break;
            case R.id.num6:
                sb.append("6");
                break;
            case R.id.num7:
                sb.append("7");
                break;
            case R.id.num8:
                sb.append("8");
                break;
            case R.id.num9:
                sb.append("9");
                break;
            case R.id.num0:
                sb.append("0");
                break;
            case R.id.divide:
                sb.replace(0, sb.length() + 1, opr("/", sb).toString());
                break;
            case R.id.doubl:
                sb.replace(0, sb.length() + 1, opr("*", sb).toString());
                keepChar = "\\*";
                break;
            case R.id.minus:
                sb.replace(0, sb.length() + 1, opr("-", sb).toString());
                break;
            case R.id.plus:
                sb.replace(0, sb.length() + 1, opr("+", sb).toString());
                keepChar = "\\+";
                break;
            case R.id.clr:
                keepNum1 = 0;
                keepChar = "";
                sb.delete(0, sb.length());
                break;
            case R.id.point:
                sb.append(".");
                break;
            case R.id.equl:
                calculate(sb);
                DecimalFormat df = new DecimalFormat("0.###");
                sb.delete(0, sb.length());
                sb.append(df.format(sum));
                sum = 0;
                break;
        }
        Number.setText(sb.toString());

    }


    public StringBuilder opr(String opr, StringBuilder sb) {
            if (keepChar != "") {
                String str = sb.toString().split(keepChar)[0];
                sb.replace(0, sb.length(), str);
            }
            keepNum1 = parseDouble(sb.toString());
            keepChar = opr;
            sb.append(opr);
            return sb;
    }


    public void calculate(StringBuilder sb) {
        System.out.println(keepChar);
        String num2 = sb.toString().split(keepChar)[1];
        keepNum2 = parseDouble(num2);
        switch (keepChar) {
            case "/":
                if (keepNum1 == 0) {
                    Number.setText("can't divide by 0");
                    break;
                }
                sum = keepNum1 / keepNum2;
                break;
            case "\\*":
                sum = keepNum1 * keepNum2;
                break;
            case "-":
                sum = keepNum1 - keepNum2;
                break;
            case "\\+":
                sum = keepNum1 + keepNum2;
                break;
        }
        keepNum1 = 0;
        keepNum2 = 0;
        keepChar = "";
    }
}


