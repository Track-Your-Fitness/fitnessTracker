package com.example.fitnessTracker.activities.Activities;
import static com.example.fitnessTracker.activities.Activities.UserSettingsActivity.USER_NAME_TAG;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.core.Amplify;
import com.example.fitnessTracker.R;
import com.example.fitnessTracker.activities.AuthActivites.LoginActivity;
import com.example.fitnessTracker.activities.UserWorkout.SelectedCategoryActivity;
import com.example.fitnessTracker.activities.UserWorkout.UserWorkoutActivity;
import com.example.fitnessTracker.activities.UserWorkout.WorkOutCategoryActivity;
//package com.example.testrapidapi;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    AuthUser authUser;
    Button logoutButton;
    //extracts from local.properties, else "".


    public static final String TAG = "mainActivity";
    public static final String USER_INPUT_EXTRA_TAG = "userInput";
    public static final String USER_USERNAME_TAG = "userName";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        apiRequesterWithHeaders();

        logoutButton = findViewById(R.id.MainActivityLogoOutBtn);

        intentButtons();

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        ImageView settingsButton = (ImageView) findViewById(R.id.MainActivitySettingsImg);
        settingsButton.setOnClickListener(v -> {
//            String userInput = ((EditText)findViewById(R.id.)).getText().toString();
            Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
//            goToUserSettingsIntent.putExtra(, userInput);
            startActivity(goToUserSettingsIntent);
        });

        File exampleFile = new File(getApplicationContext().getFilesDir(), "ExampleKey");

//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(exampleFile));
//            writer.append("Example file contents");
//            writer.close();
//        } catch (Exception exception) {
//            Log.e("MyAmplifyApp", "Upload failed", exception);
//        }
//
//        Amplify.Storage.uploadFile(
//                "ExampleKey",
//                exampleFile,
//                success -> Log.i(TAG, "Successfully uploaded: " + success.getKey()),
//                failure -> Log.e(TAG, "Upload failed", failure)
//        );

    }



    private void apiRequesterWithHeaders(){
        RequestQueue queue = Volley.newRequestQueue(this);
        //do not need this (only used this to explain its from field variable).
        String url = "https://exercises2.p.rapidapi.com/"; //TODO: need to add a meaningful request otherwise this will return the whole dom!
        String apiKey = "205fe69fc7msh9938514ab2ba523p1bca7cjsnc28159e1568b";
        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    // response
                    Log.d("Response", response);
                    final TextView textView = (TextView) findViewById(R.id.apiTextView);
                    textView.setText(response);
                },
                error -> {
                    Log.d("ERROR","error => "+error.toString());
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("X-RapidAPI-Key", "0c2becdfa7mshb9a3c113775cbdep163e0djsn8543d4ba6d1a");
                params.put("X-RapidAPI-Host", "exercises2.p.rapidapi.com");

                return params;
            }
        };
        queue.add(getRequest);
        return;
    }

    /**
     * uses zenquotes to extract random quotes.
     * @throws JSONException if response is null.
     */
    private void  apiRequesterWithoutHeaders(){


        // https://www.youtube.com/watch?v=xPi-z3nOcn8
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://exercises2.p.rapidapi.com/";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            String fitnessString = "";
            try {
//                textView.setText("Response is: " + response.getJSONObject(0));
                JSONObject allFitnessData = response.getJSONObject(0);
                fitnessString = " \" " + allFitnessData.getString("q") + "\"\n " + " - " + allFitnessData.getString("a");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            final TextView textView = (TextView) findViewById(R.id.apiTextView);
            textView.setText(fitnessString);
        }, error -> Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show());

        queue.add(request);
    }


    /**
     * Extracts api key from local.properties.
     * @return string - api value from local.properties otherwise empty string.
     */



    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String userName = preferences.getString(USER_USERNAME_TAG, "no username");
        ((TextView)findViewById(R.id.MainUsernameDisplay)).setText(userName);
    }


    public void renderButtons() {

        if (authUser != null) {
            logoutButton.setVisibility(View.VISIBLE);
        } else {
            logoutButton.setVisibility(View.INVISIBLE);
        }
    }

public void intentButtons() {

    final String[] username = {preferences.getString(USER_NAME_TAG, "no username")};

    ImageView userProfileButton = (ImageView) findViewById(R.id.MainActivityUserProfileBtn);
    userProfileButton.setOnClickListener(v -> {
        Intent goToUserProfileIntent = new Intent(this, UserProfileActivity.class);
        startActivity(goToUserProfileIntent);
    });
    ImageView selectWorkoutButton = (ImageView) findViewById(R.id.SelectWorkoutButton);
    selectWorkoutButton.setOnClickListener(v -> {
        Intent goToSelectWorkoutIntent = new Intent(this, WorkOutCategoryActivity.class);
        startActivity(goToSelectWorkoutIntent);
    });
    ImageView userPastWorkoutsButton = (ImageView) findViewById(R.id.MainActivityYourWorkoutBttn);
    userPastWorkoutsButton.setOnClickListener(v -> {
        Intent goToUserWorkoutIntent = new Intent(this, UserWorkoutActivity.class);
        startActivity(goToUserWorkoutIntent);
    });
    ImageView userSettingsButton = (ImageView) findViewById(R.id.MainActivitySettingsImg);
    userSettingsButton.setOnClickListener(v -> {
        Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
        startActivity(goToUserSettingsIntent);
    });

    Amplify.Auth.getCurrentUser(
            success -> {
                Log.i(TAG, "Got Current User");
                username[0] = success.getUsername();
            },
            failure -> {
            }
    );

    logoutButton.setOnClickListener(v -> Amplify.Auth.signOut(
            success -> {
                Log.i(TAG, "User successfully logged out.");
                authUser = null;
                runOnUiThread(this::renderButtons);
                Intent goToLoginActivityIntent = new Intent(this, LoginActivity.class);
                startActivity(goToLoginActivityIntent);
            }
    ));
}

}