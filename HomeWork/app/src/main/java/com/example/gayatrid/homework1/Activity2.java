package com.example.gayatrid.homework1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Activity2 extends ActionBarActivity {

    String num1 = "";

    String op1 = "";
    String op2 = "";
    String num2 = "";
    String display = "";
    boolean isComputed=false;
    boolean singleValue=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Intent intent = getIntent();
        num1 = intent.getStringExtra("num1");
        op1 = intent.getStringExtra("op1");
        num2 = intent.getStringExtra("num2");
        display = intent.getStringExtra("display");
        isComputed = intent.getBooleanExtra("isComputed", false);
        singleValue = intent.getBooleanExtra("singleValue",false);
       // op2= intent.getStringExtra("op2");
        if(num1==null)
        {
            num1="";
        }
        if(num2==null)
        {
            num2="";
        }
        if(op1==null)
        {
            op1="";
        }
        if(display==null)
        {
            display="";
        }

        TextView text1 = (TextView) findViewById(R.id.text);
        text1.setText(display);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem   item2 = menu.findItem(R.id.activity_action1);
        item2.setVisible(true);
        MenuItem   item1 = menu.findItem(R.id.activity_action2);
        item1.setVisible(false);
        invalidateOptionsMenu();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item.setVisible(false);
        invalidateOptionsMenu();
        switch (item.getItemId()) {
            case R.id.activity_action1:
                Intent intent = new Intent(Activity2.this,MainActivity.class);
                intent.putExtra("num1",num1);
                intent.putExtra("op1",op1);
               // intent.putExtra("op2",op2);
                intent.putExtra("num2",num2);
                intent.putExtra("display",display);
                intent.putExtra("isComputed",isComputed);
                intent.putExtra("singleValue",singleValue    );

                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                return true;
            case R.id.activity_action2:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void btnOp(View v) {
        int length = display.length();
        if (length > 0) {
            display = display.substring(0, length - 1);
            if(!num2.equals("")&&num2.length()>0)
            {
                num2=num2.substring(0,num2.length()-1);
            }
            else if(!op1.equals("")&&!isComputed)
            {
                op1="";
            }
            else if(!num1.equals("")&&num1.length()>0)
            {
                num1=num1.substring(0,num1.length()-1);
            }
        }
        TextView text1 = (TextView) findViewById(R.id.text);
        text1.setText(display);
    }

    public void btnOp2(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        singleValue=false;

        isComputed=false;
        switch (buttonText)
        {
            case "sin":singleValue=true;
                isComputed  =true;
                op1=buttonText;
                break;
            case "cos":singleValue=true;
                isComputed  =true;
                op1=buttonText;
                break;
            case "tan":singleValue=true;
                isComputed  =true;
                op1=buttonText;
                break;
            case "ln":singleValue=true;
                isComputed  =true;
                op1=buttonText;
                break;
            case "log":singleValue=true;
                isComputed  =true;
                op1=buttonText;
                break;
            case "e":singleValue=true;
                isComputed  =true;
                op1=buttonText;
                break;
            case "(":op1=op1+"(";
                singleValue=true;
            case ")":resultSingleValue();
                singleValue=true;
                break;
            default:
                break;

        }


        if(!buttonText.equals(")") && !buttonText.equals("("))
        {
            op1=buttonText;
        }

        if(!buttonText.equals(")")) {
            display = display + op1;
        }



        TextView text1 = (TextView) findViewById(R.id.text);
        text1.setText(display);


    }

    public void resultSingleValue() {
        if (!num1.equals("") && singleValue) {

            switch (op1) {
                case "sin(":
                    num1 = Math.sin(Double.parseDouble(num1)) + "";
                    break;
                case "cos(":
                    num1 = Math.cos(Double.parseDouble(num1)) + "";
                    break;
                case "tan(":
                    num1 = Math.tan(Double.parseDouble(num1)) + "";
                    break;
                case "ln(":
                    num1 = Math.log(Double.parseDouble(num1)) + "";
                    break;
                case "log(":
                    num1 = Math.log10(Double.parseDouble(num1)) + "";
                    break;
                case "sqrt(":
                    num1 = Math.sqrt(Double.parseDouble(num1)) + "";
                    break;

                default:
                    break;
            }

            display = num1;
            isComputed = true;

        } else if (!num2.equals("") && singleValue) {

            switch (op1) {
                case "sin(":
                    num2 = Math.sin(Double.parseDouble(num2)) + "";
                    break;
                case "cos(":
                    num2 = Math.cos(Double.parseDouble(num2)) + "";
                    break;
                case "tan(":
                    num2 = Math.tan(Double.parseDouble(num2)) + "";
                    break;
                case "ln(":
                    num2 = Math.log(Double.parseDouble(num2)) + "";
                    break;
                case "log(":
                    num2 = Math.log10(Double.parseDouble(num2)) + "";
                    break;
                case "sqrt(":
                    num2 = Math.sqrt(Double.parseDouble(num2)) + "";
                    break;

                default:
                    break;
            }
            display = num2;
            isComputed = true;

        }


    }



    }
