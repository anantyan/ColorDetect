package com.example.colordetect.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment {

    Calendar C;
    int Y, M, D;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        C = Calendar.getInstance();
        Y = C.get(Calendar.YEAR);
        M = C.get(Calendar.MONTH);
        D = C.get(Calendar.DATE);
        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), Y,  M, D);
    }
}
