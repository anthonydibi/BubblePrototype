package com.example.bubbleprototype.data.availability;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.bubbleprototype.data.todo.TodoActivity;
import com.example.bubbleprototype.home.HomeActivity;

public class SaveDialog extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Your availability has been saved!")
                .setMessage("Do you have the correct availability recorded?\n" +
                        "If you would like to edit your availability, click EDIT.\n" +
                        "Otherwise, click SAVE.")
                .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Activity currentActivity = getActivity();
                        currentActivity.finish();
                    }
                })
                .setNegativeButton("EDIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        return builder.create();
    }
}
