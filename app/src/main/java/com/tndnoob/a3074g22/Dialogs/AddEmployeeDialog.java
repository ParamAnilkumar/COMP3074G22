package com.tndnoob.a3074g22.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tndnoob.a3074g22.R;

public class AddEmployeeDialog {

    public interface EmployeeAddedListener {
        void onEmployeeAdded(String employeeName);
    }

    private EmployeeAddedListener listener;

    public void setEmployeeAddedListener(EmployeeAddedListener listener) {
        this.listener = listener;
    }

    public void showDialog(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.add_employee_dialog);  // Ensure the layout is for adding employees
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        EditText inputEmployee = dialog.findViewById(R.id.employee_name_input); // Change ID to match employee input field

        Button dialogBtn_Enter = dialog.findViewById(R.id.button_add);
        Button dialogBtn_cancel = dialog.findViewById(R.id.button_cancel);

        dialogBtn_Enter.setOnClickListener(v -> {
            String inputEmployeeString = inputEmployee.getText().toString();

            if (inputEmployeeString.isEmpty()) {
                Toast.makeText(activity.getApplicationContext(), "Fill required fields.", Toast.LENGTH_SHORT).show();
            } else {
                if (listener != null) {
                    listener.onEmployeeAdded(inputEmployeeString);  // Use employee-related method
                }
                dialog.dismiss();
            }
        });

        dialogBtn_cancel.setOnClickListener(v -> {
            Toast.makeText(activity.getApplicationContext(), "Canceled.", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        dialog.show();
    }
}
