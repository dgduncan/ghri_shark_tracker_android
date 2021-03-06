package com.upperz.sharktracker.Activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.upperz.sharktracker.Classes.Animal;
import com.upperz.sharktracker.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class SplashActivity extends AppCompatActivity
{

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        queryAllAnimals();




        /*Query GAE to get latest locations*/
        //new EndpointsAsyncTask().execute();
    }

    private void queryAllAnimals()
    {

        progressDialog = new ProgressDialog(SplashActivity.this);
        progressDialog.setMessage("Loading animal locations ... ");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();

        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://104.197.207.240:8080/api/getAll", null, new JsonHttpResponseHandler() {

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject jsonObject)
            {
                Log.e("SplashActivity", String.valueOf(statusCode));

                new AlertDialog.Builder(SplashActivity.this)
                        .setTitle("Connection Error")
                        .setMessage("There seems to be an issue connecting to our backend," +
                                " we apologize for the issue and please try again later.")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {


                for (int index = 0; index < timeline.length(); index++)
                {

                    try
                    {
                        //Log.d("MAIN", String.valueOf(timeline.getJSONObject(index).getJSONObject("shark").getBoolean("recent")));
                        Animal animal = new Animal(timeline.getJSONObject(index));
                        MyApplication.animals.put(animal.name, animal);
                        MyApplication.sharks.add(animal);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


                progressDialog.dismiss();

                /*Start the activity to go to the tabbed activity*/
                Intent intent = new Intent(SplashActivity.this, MainTabbedActivity.class);
                startActivity(intent);

                /*finish() prevents the user from being able to back press back into the splash*/
                finish();

            }

            @Override
            public void onRetry(int retryNo) {
                Log.d("SplashActivity", "Retry attempt # " + String.valueOf(retryNo));
            }
        });

    }

    /**
     * Async task that creates a reference to my AnimalApi, queries for the latest locations, and
     * stores this data as a global variable
     */

    /*class EndpointsAsyncTask extends AsyncTask<Void, Void, AnimalCollection>
    {

        *//*Reference to AsyncTask used to stop task if timer goes over time*//*
        private EndpointsAsyncTask endpointsAsyncTask = this;

        *//*Reference to my Backend API*//*
        private MyApi myApiService = null;

        *//*Dialog to notify user about what is going on*//*
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute()
        {

            *//*Create progress dialog to notify user that application is loading*//*
            progressDialog = new ProgressDialog(SplashActivity.this);
            progressDialog.setMessage("Loading animal locations ... ");
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.show();


            *//*CountDownTimer to prevent the request from running for ever*//*
            new CountDownTimer(15000, 15000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    //TODO : Add onTick code to tell user what is going on

                }

                @Override
                public void onFinish()
                {
                    *//*Check if AsyncTask is actually still running*//*
                    if(endpointsAsyncTask.getStatus() == Status.RUNNING)
                    {
                        //Cancel task if still running
                        endpointsAsyncTask.cancel(true);

                        progressDialog.dismiss();

                        //Create an alert dialog asking user to retry
                        new AlertDialog.Builder(SplashActivity.this)
                                .setTitle("Connection Error")
                                .setMessage("There seems to be an issue connecting to our backend," +
                                        " would you like to retry?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        new EndpointsAsyncTask().execute();
                                    }
                                })
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();

                    }

                }
            }.start();

            super.onPreExecute();

        }

        @Override
        protected AnimalCollection doInBackground(Void ... params)
        {
            *//*Build API service*//*
            if(myApiService == null)
            {
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl("https://sharktracker-1142.appspot.com/_ah/api/");

                myApiService = builder.build();
            }

            *//*Attempt to get animals from API*//*
            try
            {
                return myApiService.getAllAnimals().execute();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                return null;
            }


        }

        @Override
        protected void onPostExecute(AnimalCollection result)
        {
            *//*Check if result is null to catch any network error*//*
            if(result != null)
            {
                //TODO : I don't like the way that this is done
                MyApplication.sharks = result.getItems();

                *//*Put animal references into the MyApplication*//*
                for(Animal animal : result.getItems())
                {
                    MyApplication.animals.put(animal.getName(), animal);
                }

                *//*Dismiss the dialog to tell user that everything is done*//*
                progressDialog.dismiss();

                *//*Start the activity to go to the tabbed activity*//*
                Intent intent = new Intent(SplashActivity.this, MainTabbedActivity.class);
                startActivity(intent);

                *//*finish() prevents the user from being able to back press back into the splash*//*
                finish();
            }

            else
            {
                *//*Build an Alert Dialog to tell user that a network has occured*//*
                new AlertDialog.Builder(SplashActivity.this)
                        .setTitle("Connection Error")
                        .setMessage("There seems to be an issue connecting to our backend," +
                                " please check your internet connection and try again.")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }
    }*/
}
