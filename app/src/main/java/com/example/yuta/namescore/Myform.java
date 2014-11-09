package com.example.yuta.namescore;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Myform extends Activity {

    //staticはclassの中
    public final static  String EXTRA_MYNAME = "com.example.yuta.namescore.MYNAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_myform);
        //これ以降に書く setContentView以下

        final EditText myEditText = (EditText) findViewById(R.id.myEditText);


        //CLICKしたとき
        Button button = (Button) findViewById(R.id.myButton);
         button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getScore(myEditText);
            }
        });

    }

    public void getScore(EditText myEditText) {
        String myName = myEditText.getText().toString().trim();
        if (myName.equals("")) {
            //エラー表示

            //1. seterror (EditTextの中に文字が浮かぶ)
            myEditText.setError("Please Enter Your Name");

            //2.Toast (下にダイアログが浮かぶ)
            //Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_LONG).show();

            //3. Dialog (真ん中にダイアログが浮かぶ)
        /*    AlertDialog.Builder alertDialogBuilder = new  AlertDialog.Builder(this);
            alertDialogBuilder
                        .setTitle("Error!")
                        .setMessage("Please Enter Your Name")
                        .setPositiveButton("OK",null);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            */
        }

        else {
        }
        //次の画面へ
        Intent intent = new Intent(this,MyResult.class);
        intent.putExtra(EXTRA_MYNAME,myName);
        startActivity(intent);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_myform, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
