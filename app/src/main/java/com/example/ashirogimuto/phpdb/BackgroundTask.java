package com.example.ashirogimuto.phpdb;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Ashirogi Muto on 4/29/2016.
 */
public class BackgroundTask extends AsyncTask <String, Void, String> {
    AlertDialog ad;
    Context ctx;

    BackgroundTask(Context ctx)
    {
        this.ctx = ctx;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ad = new AlertDialog.Builder(ctx).create();
        ad.setTitle("Login Successful");
    }

    @Override
    protected String doInBackground(String... params) {

        String regURL = "http://10.0.2.2/webapp/register.php";
        String logURL = "http://10.0.2.2/webapp/login.php";
        String method = params[0];
        if(method.equals("register"))
        {
            String name = params[1];
            String uname = params[2];
            String upass = params[3];
            try {
                URL reg_url = new URL(regURL);
                HttpURLConnection htc = (HttpURLConnection)reg_url.openConnection();
                htc.setRequestMethod("POST");
                htc.setDoOutput(true);
                OutputStream os = htc.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data = URLEncoder.encode("user","UTF-8") + "=" +URLEncoder.encode(name,"UTF-8")+ "&" +
                        URLEncoder.encode("username","UTF-8") + "=" +URLEncoder.encode(uname,"UTF-8")+ "&" +
                        URLEncoder.encode("userpass","UTF-8") + "=" +URLEncoder.encode(upass,"UTF-8");
                bw.write(data);
                bw.flush();
                bw.close();
                os.close();
                InputStream is = htc.getInputStream();
                is.close();
                return "Registration Successful";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else if(method.equals("login"))
        {
            String lName = params[0];
            String lPass = params[1];
            try {
                URL log_url = new URL(logURL);
                HttpURLConnection htc = (HttpURLConnection) log_url.openConnection();
                htc.setRequestMethod("POST");
                htc.setDoOutput(true);
                htc.setDoInput(true);
                OutputStream OS = htc.getOutputStream();
                BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data = URLEncoder.encode("logName","UTF-8")+"="+URLEncoder.encode("lName","UTF-8")+"&"+
                        URLEncoder.encode("logPass","UTF-8")+"="+URLEncoder.encode("lPass","UTF-8");
                BW.write(data);
                BW.flush();
                BW.close();
                OS.close();
                InputStream IS =  htc.getInputStream();
               BufferedReader BR = new BufferedReader((new InputStreamReader(IS,"iso-8859-1")));
                String response = "";
                String line = "";
                while ((line = BR.readLine()) != null)
                {
                    response+=line;
                }
                BR.close();
                IS.close();
                htc.disconnect();
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    protected void onPostExecute(String result) {
        if(result.equals("Registration Successful"))
        {
            Toast.makeText(ctx,result, Toast.LENGTH_LONG).show();
        }
        else
        {
            ad.setMessage(result);
            ad.show();
        }

    }
}
