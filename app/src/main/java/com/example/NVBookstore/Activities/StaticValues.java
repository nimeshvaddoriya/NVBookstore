package com.example.NVBookstore.Activities;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.core.content.ContextCompat;

import com.example.NVBookstore.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StaticValues {

    public static String APIKEY = "0cd281f4-ffb3-49a5-a190-c9f05b372292";
    public static String PRODUCT_URL = "http://www.dotcompreview.com/test2";
    private static AlertDialog alertDialog;
    List<String> list = new ArrayList<String>();
    public static boolean MandatoryField(EditText editText) {

        String mobile = editText.getText().toString().trim();

        if (mobile.isEmpty()) {
            editText.requestFocus();
            editText.setError("Mandatory Field");
            return false;
        } else {
            return true;
        }
    }
    public static boolean MandatoryField(TextInputEditText editText) {

        String mobile = editText.getText().toString().trim();

        if (mobile.isEmpty()) {
            editText.requestFocus();
            editText.setError("Mandatory Field");
            return false;
        } else {
            return true;
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    // Check Internet Connection //

    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            // connected to the internet
            if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {

                return true;

            } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                return true;
            }
        } else {
            // not connected to the internet
            return false;
        }

        return false;

    }
    // Check Internet Connection //
    // Check Is Network Working //
    public static boolean isInternetWorking(Context context) {
        boolean success = false;
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(1500);
            connection.connect();
            success = connection.getResponseCode() == 200;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }

    // Check Is Network Working //
    // Preference Manager Methods //

    public static void SavePreferences(String key, String value, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void RemovePreferences(String key, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    public static String GetPreferences(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

    // Preference Manager Methods //
    public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            Log.d("LOG_EXCEPTION", " : " + e.getMessage());
        }
    }

    public static boolean emailValidation(EditText editText) {

        String email = editText.getText().toString().trim();

        String expression = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(email);

        String expression1 = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";
        Pattern pattern1 = Pattern.compile(expression1);
        Matcher matcher1 = pattern1.matcher(email);

        if (email.isEmpty() || (!matcher.matches() && !matcher1.matches())) {
            editText.requestFocus();
            editText.setError("Enter correct e-mail address.");
            return false;
        } else {
            return true;
        }
    }

    public static boolean mobileValidation(EditText editText) {

        String mobile = editText.getText().toString().trim();

        if (mobile.isEmpty() || !(mobile.length() ==10)) {
            editText.requestFocus();
            editText.setError("Enter correct mobile number.");
            return false;
        } else {
            return true;
        }
    }

    public static void SaveUsername(String key, String value, Context context) {
        boolean b = false;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> set = new HashSet<String>();
//        try {
//            Set<String> set1 = sharedPreferences.getStringSet(key, null);
//            if (set1 != null)
//                set.addAll(set1);
//        } catch (Exception e) {
//            Log.d("Exception", " : " + e.getMessage());
//        }
//        set.add(value);
//        editor.putStringSet(key, set);
//        editor.commit();

        try {
            Set<String> set1 = sharedPreferences.getStringSet(key, null);
            if (set1 != null) {
                for (String s : set1) {
                    if (s.contains(value)) {
                        b = true;
                    }
                }
                set.addAll(set1);
            }
        } catch (Exception e) {
            Log.d("Exception", " : " + e.getMessage());
        }
        if (!b)
            set.add(value);
        editor.putStringSet(key, set);
        editor.commit();

    }

    public static Set<String> GetPreferencesSet(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getStringSet(key, null);
    }

    public static String GetPassword(String key, String value, Context context) {
        String PSWD = null;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> set = new HashSet<String>();
        try {
            Set<String> set1 = sharedPreferences.getStringSet(key, null);
            if (set1 != null)
                set.addAll(set1);
        } catch (Exception e) {
            Log.d("Exception", " : " + e.getMessage());
        }

        List<String> list = new ArrayList<String>(set);
        for (int i = 0; i < list.size(); i++) {
            String s[] = list.get(i).split("~~");
            if (s[0].equals(value)) {
                PSWD = s[1];
            }
        }
        return PSWD;
    }

    public static void RemoveUsername(String key, String value, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> set = new HashSet<String>();
        String Index = null;
        try {
            Set<String> set1 = sharedPreferences.getStringSet(key, null);
            if (set1 != null)
                set.addAll(set1);
        } catch (Exception e) {
            Log.d("Exception", " : " + e.getMessage());
        }

        List<String> list = new ArrayList<String>(set);

        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String s[] = list.get(i).split("~~");
                if (s[0].equals(value)) {
                    Index = "" + i;
                }
            }
            if (Index != null)
                list.remove(Integer.parseInt(Index));

        }
//        Set<String> set2 = new HashSet<String>();
//        set2.addAll(list);
        set.clear();
        set.addAll(list);
        editor.putStringSet(key, set);
        editor.commit();
    }

    public static boolean isnull(String isnull) {

        if (isnull == null || isnull.trim().length() == 0 || isnull.trim().equals("null")) {
            return false;
        }
        return true;
    }

    //Method to create Signal Action Dialog box//
    public static void SingleActionDialog(final Context context, String title, String message, String btnTxt, DialogInterface.OnClickListener positiveListener) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(btnTxt, positiveListener);

        // create alert dialog
        alertDialog = alertDialogBuilder.create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {

                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
            }
        });

        // show it
        alertDialog.show();
    }
    //Method to create Signal Action Dialog box//


    //Method to create DoubleAction Dialog box //
    public static void DoubleActionDialog(final Context context, String title, String message, String btnPosTxt, String btnNegTxt, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(btnPosTxt, positiveListener)
                .setNegativeButton(btnNegTxt, negativeListener);

        // create alert dialog
        alertDialog = alertDialogBuilder.create();

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {

                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
            }
        });

        // show it
        alertDialog.show();
    }
    //Method to create DoubleAction Dialog box //


    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        if (text.length() == 0) {
            editText.setError("Data required for this field.");
            return false;
        }
        return true;
    }

    public static boolean passwordsValidation(EditText editText_1, EditText editText_2) {
        String password_1 = editText_1.getText().toString().trim();
        String password_2 = editText_2.getText().toString().trim();

        if (!password_1.equals(password_2)) {
            editText_2.requestFocus();
            editText_2.setText("");
            editText_2.setError("Enter correct password.");
            return false;
        } else {
            return true;
        }
    }

}
