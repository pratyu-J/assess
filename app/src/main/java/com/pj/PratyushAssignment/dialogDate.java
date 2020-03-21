package com.pj.PratyushAssignment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Calendar;

public class dialogDate extends AppCompatDialogFragment {

    private TextView stdate, enddate;
    private DatePickerDialog.OnDateSetListener mdateSetListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View fview = inflater.inflate(R.layout.layout_date_dialog, null);
        builder.setView(fview).setTitle("Select Date").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        stdate = fview.findViewById(R.id.startdate);
        enddate = fview.findViewById(R.id.enddate);

        stdate.setOnClickListener(view -> {

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(getActivity(),android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth, mdateSetListener, year, month, day);

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            dialog.show();

            mdateSetListener = (datePicker, i, i1, i2) -> {
                i1 = i1 + 1;
                String date = i2+"/" + i1+ "/" + i;
                stdate.setText(date);

            };


        });

        enddate.setOnClickListener(view -> {
            Calendar cal1 = Calendar.getInstance();
            int year1 = cal1.get(Calendar.YEAR);
            int month1 = cal1.get(Calendar.MONTH);
            int day1 = cal1.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog1 = new DatePickerDialog(getActivity(),android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth, mdateSetListener, year1, month1, day1);

            dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog1.show();

            mdateSetListener = (datePicker, i, i1, i2) -> {
                i1 = i1 + 1;
                String date1 = i2+"/" + i1+ "/" + i;
                enddate.setText(date1);
            };
        });

        return builder.create();
    }
}
