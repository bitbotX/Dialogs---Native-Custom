package com.example.dialogs_pickers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private EditText mUserMail=null,mUserPassword=null;
    private ConstraintLayout mLayout=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout=(ConstraintLayout)findViewById(R.id.main_layout);
        mUserMail=(EditText)findViewById(R.id.username);
        mUserPassword=(EditText)findViewById(R.id.password);
    }

    public void showAlert(View view) {
        AlertDialog.Builder mAlert=new AlertDialog.Builder(MainActivity.this);
        mAlert.setTitle("Native Android Alert Dialog")
                .setMessage(R.string.user_change_color)
                .setPositiveButton(R.string.change, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,R.string.user_continue,Toast.LENGTH_SHORT).show();
                        mLayout.setBackgroundColor(Color.RED);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,R.string.cancel,Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    public void showCustomAlert(View view) {
        AlertDialog.Builder mCustomBuilder=new AlertDialog.Builder(MainActivity.this);
        LayoutInflater mCustomInflator=getLayoutInflater();
        mCustomBuilder.setView(mCustomInflator.inflate(R.layout.custom_alert,null))
                .setPositiveButton(R.string.user_login, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(mUserMail!=null && mUserPassword!=null){
                            Toast.makeText(MainActivity.this,R.string.user_login_successful,Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this,R.string.enter_valid_details,Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton(R.string.cancel_login, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,R.string.user_login_cancelled,Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}
