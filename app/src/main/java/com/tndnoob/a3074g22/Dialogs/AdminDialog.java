package com.tndnoob.a3074g22.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.tndnoob.a3074g22.AdminPortalActivity;
import com.tndnoob.a3074g22.R;

public class AdminDialog {
    public void showDialog(Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.adminlogindialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextInputEditText code = dialog.findViewById(R.id.editTextCode);
        TextInputEditText password = dialog.findViewById(R.id.editTextPass);



        Button dialogBtn_Enter = dialog.findViewById(R.id.buttonEnter);
        dialogBtn_Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String eCode = code.getText().toString();
                String ePass = password.getText().toString();

                if(eCode.isEmpty() || ePass.isEmpty()){
                    Toast.makeText(activity.getApplicationContext(),"Fill required fields.",Toast.LENGTH_SHORT).show();
                }
                 if(eCode.equals("123") && ePass.equals("0")){
                    Intent i = new Intent(activity.getApplicationContext(), AdminPortalActivity.class);
                    activity.startActivity(i);
                    activity.finish();
                }
                else{
                    Toast.makeText(activity.getApplicationContext(), "wrong credentials.",Toast.LENGTH_SHORT).show();

                }
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
