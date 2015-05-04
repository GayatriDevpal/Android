package com.example.gayatrid.homework1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import 	android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends ActionBarActivity {
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
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        num1 = intent.getStringExtra("num1");
        op1 = intent.getStringExtra("op1");
      //  op2 = intent.getStringExtra("op2");
        num2 = intent.getStringExtra("num2");
        display = intent.getStringExtra("display");
        isComputed = intent.getBooleanExtra("isComputed",false);
        singleValue = intent.getBooleanExtra("singleValue",false);
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

        if(op2==null)
        {
            op2="";
        }

        if(display==null)
        {
            display="";
        }

        if(op1.equals("pie"))
        {
           if(num1.equals(""))
            {
                num1 = Math.PI+"";
            }
            else
            {
               num2 = Math.PI+"";
            }
        }



        if(op1.equals("!"))
        {
            int factorial=1;
            if(!num1.equals(""))
            {
                for(int i=1;i<=Integer.parseInt(num1);i++)
                {
                     factorial=factorial*i;
                }
                num1=factorial+"";
                display=num1;
            }

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
        item2.setVisible(false);
        MenuItem   item1 = menu.findItem(R.id.activity_action2);
        item1.setVisible(true);
        invalidateOptionsMenu();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item.setVisible(false);
        invalidateOptionsMenu();
        switch (item.getItemId()) {
            case R.id.activity_action1:
                return true;
            case R.id.activity_action2:
                Intent intent = new Intent(MainActivity.this,Activity2.class);
                intent.putExtra("num1",num1);
                intent.putExtra("op1",op1);
                intent.putExtra("num2",num2);
                intent.putExtra("display",display);
                intent.putExtra("isComputed",isComputed);
                intent.putExtra("singleValue",singleValue);

                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void btnNum(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();

        if (op1.equals("")||isComputed) {
            num1 = num1 + buttonText;
            display = num1;
            Toast.makeText(this,"num1 Num1 "+num1,Toast.LENGTH_SHORT).show();
            TextView text1 = (TextView) findViewById(R.id.text);
            text1.setText(display);
        }

        else {
            num2 = num2 + buttonText;
            display = display + num2;
            Toast.makeText(this,"display Num2 "+display,Toast.LENGTH_SHORT).show();
            TextView text1 = (TextView) findViewById(R.id.text);
            text1.setText(display);
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

    public void btnOp1(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();

        if((!num1.equals(""))
                &&num2.equals(""))
        {
            display=display+""+buttonText;
            op1=buttonText;
            TextView text1 = (TextView) findViewById(R.id.text);
            text1.setText(display);
            isComputed=false;
        }
        else if(!num1.equals("")
                &&!num2.equals(""))
        {
            result();
            display=display+""+buttonText;
            op1=buttonText;
            TextView text1 = (TextView) findViewById(R.id.text);
            text1.setText(display);
            isComputed=false;
        }


//
//        if ( (op1 == null || op1.equals("") ||isOpSelected)&&
//                num1!=null || !num1.equals("")
//                &&(num2==null || num2.equals(""))
//                ) {
//            op1 = buttonText;
//            Toast.makeText(this,"op 1 btnop if : "+op1,Toast.LENGTH_LONG).show();
//            display = display + op1;
//            Toast.makeText(this,"op display btnop 1 if: "+display,Toast.LENGTH_LONG).show();
//            TextView text1 = (TextView) findViewById(R.id.text);
//            text1.setText(display);
//            isOpSelected=false;
//
//        }
//        else if( (op1 != null || !op1.equals("") )&&
//                (num2!=null || !num2.equals("") )) {
//
////            display = num1 + op1 + num2;
//            TextView text1 = (TextView) findViewById(R.id.text);
//            Toast.makeText(this,"if 2"+display,Toast.LENGTH_LONG).show();
//            result();
//  //          num1=display;
//            op1=buttonText;
//            display=display+op1;
//            text1.setText(display);
//        }
//
//        else {
//            Toast.makeText(this,"Invalid input",Toast.LENGTH_LONG).show();
//        }

//        if (op1 != null && !op1.equals("") && num2 != null && num2 != "") {
//            display = num1 + op1 + num2;
//            TextView text1 = (TextView) findViewById(R.id.text);
//            result();
//            num1=display;
//            display=display+op1;
//            text1.setText(display);
//        } else if (op1 == null || op1.equals("")) {
//            op1 = buttonText;
//            Toast.makeText(this,"op : "+op1,Toast.LENGTH_LONG).show();
//            display = num1 + op1;
//            Toast.makeText(this,"op display: "+display,Toast.LENGTH_LONG).show();
//            TextView text1 = (TextView) findViewById(R.id.text);
//            text1.setText(display);
//
//        } else {
//            Toast.makeText(this,"Invalid input",Toast.LENGTH_LONG).show();
//        }

    }

    public void btnEq(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        TextView text1 = (TextView) findViewById(R.id.text);
        result();
        num1=display;
        text1.setText(display);

    }

    public void result() {
        if(!num1.equals("")&&!num2.equals("")) {
            switch (op1) {
                case "+":
                    display = (Double.parseDouble(num1) + Double.parseDouble(num2)) + "";
                    break;
                case "-":
                    display = (Double.parseDouble(num1) - Double.parseDouble(num2)) + "";
                    break;
                case "*":
                    display = (Double.parseDouble(num1) * Double.parseDouble(num2)) + "";
                    break;
                case "/":
                    display = (Double.parseDouble(num1) / Double.parseDouble(num2)) + "";
                    break;
                case "%":
                    display = (Double.parseDouble(num1) % Double.parseDouble(num2)) + "";
                    break;
                case "^":
                    display = (Math.pow(Double.parseDouble(num1),Double.parseDouble(num2))) + "";
                    break;
                default:
                    break;
            }

            num2="";
            num1=display;
            isComputed=true;

        }




        resultSingleValue();
    }

    public void resultSingleValue() {
        if(!num1.equals("")&&singleValue) {

            switch (op1) {
                case "sin":
                    num1 = Math.sin(Double.parseDouble(num1))+"";
                    break;
                case "cos":
                    num1 = Math.cos(Double.parseDouble(num1))+"";
                    break;
                case "tan":
                    num1 = Math.tan(Double.parseDouble(num1))+"";
                    break;
                case "ln":
                    num1 = Math.log(Double.parseDouble(num1))+"";
                    break;
                case "log":
                    num1 = Math.log10(Double.parseDouble(num1))+"";
                    break;
                case "sqrt":
                    num1 = Math.sqrt(Double.parseDouble(num1))+"";
                    break;

                case "sin(":
                    num1 = Math.sin(Double.parseDouble(num1))+"";
                    break;
                case "cos(":
                    num1 = Math.cos(Double.parseDouble(num1))+"";
                    break;
                case "tan(":
                    num1 = Math.tan(Double.parseDouble(num1))+"";
                    break;
                case "ln(":
                    num1 = Math.log(Double.parseDouble(num1))+"";
                    break;
                case "log(":
                    num1 = Math.log10(Double.parseDouble(num1))+"";
                    break;
                case "sqrt(":
                    num1 = Math.sqrt(Double.parseDouble(num1))+"";
                    break;

                default:
                    break;
            }

            display=num1;
            isComputed=true;

        }

        else if(!num2.equals("")&&singleValue) {

            switch (op1) {
                case "sin":
                    num2 = Math.sin(Double.parseDouble(num2))+"";
                    break;
                case "cos":
                    num2 = Math.cos(Double.parseDouble(num2))+"";
                    break;
                case "tan":
                    num2 = Math.tan(Double.parseDouble(num2))+"";
                    break;
                case "ln":
                    num2 = Math.log(Double.parseDouble(num2))+"";
                    break;
                case "log":
                    num2 = Math.log10(Double.parseDouble(num2))+"";
                    break;
                case "sqrt":
                    num2 = Math.sqrt(Double.parseDouble(num2))+"";
                    break;

                case "sin(":
                    num2 = Math.sin(Double.parseDouble(num2))+"";
                    break;
                case "cos(":
                    num2 = Math.cos(Double.parseDouble(num2))+"";
                    break;
                case "tan(":
                    num2 = Math.tan(Double.parseDouble(num2))+"";
                    break;
                case "ln(":
                    num2 = Math.log(Double.parseDouble(num2))+"";
                    break;
                case "log(":
                    num2 = Math.log10(Double.parseDouble(num2))+"";
                    break;
                case "sqrt(":
                    num2 = Math.sqrt(Double.parseDouble(num2))+"";
                    break;

                default:
                    break;
            }
            display=num2;
            isComputed=true;

        }




    }

}
