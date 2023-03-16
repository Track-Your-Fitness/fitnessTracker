package com.example.fitnessTracker.activities.Activities;
import static com.example.fitnessTracker.activities.Activities.UserSettingsActivity.USER_NAME_TAG;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.core.Amplify;
import com.example.fitnessTracker.R;
import com.example.fitnessTracker.activities.AuthActivites.LoginActivity;
import com.example.fitnessTracker.activities.UserWorkout.SelectedCategoryActivity;
import com.example.fitnessTracker.activities.UserWorkout.SelectedWorkoutActivity;
import com.example.fitnessTracker.activities.UserWorkout.UserWorkoutActivity;
import com.example.fitnessTracker.activities.UserWorkout.WorkOutCategoryActivity;
//package com.example.testrapidapi;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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
import com.google.android.material.bottomnavigation.BottomNavigationView;

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
    static final String NAME_TAG = "name";

//    Spinner bodyPartSpinner;
//    Spinner equipmentUsedSpinner;


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


//        ImageView settingsButton = (ImageView) findViewById(R.id.MainActivitySettingsImg);
//        settingsButton.setOnClickListener(v -> {
////            String userInput = ((EditText)findViewById(R.id.)).getText().toString();
//            Intent goToUserSettingsIntent = new Intent(this, UserSettingsActivity.class);
////            goToUserSettingsIntent.putExtra(, userInput);
//            startActivity(goToUserSettingsIntent);
//        });

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

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.bottom_home:
                    return true;

                case R.id.bottom_userPage:
                    startActivity(new Intent(getApplicationContext(), UserProfileActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_userworkout:
                    startActivity(new Intent(getApplicationContext(), UserWorkoutActivity.class ));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_workOutCategory:
                    startActivity(new Intent(getApplicationContext(), WorkOutCategoryActivity.class ));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_settings:
                    startActivity(new Intent(getApplicationContext(), UserSettingsActivity.class ));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
            }
            return false;
        });

    }




    private void apiRequesterWithHeaders(){
        RequestQueue queue = Volley.newRequestQueue(this);
        //do not need this (only used this to explain its from field variable).
        String url = "https://exercises2.p.rapidapi.com/"; //TODO: need to add a meaningful request otherwise this will return the whole dom!
        String apiKey = "205fe69fc7msh9938514ab2ba523p1bca7cjsnc28159e1568b";
        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    // response
//                    Log.d("Response", response);
//                    final TextView textView = (TextView) findViewById(R.id.apiTextView);
//                    textView.setText(response);
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

    public void setUpSpinners (){
//        bodyPartSpinner.setAdapter(new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_spinner_item,
//
//        ));

    }


    /**
     * Method that will use rapidapi to get content. log.d will show what is being extracted when running program.
     * @throws NullPointerException if url is null.
     */
    private void apiRequesterWithHeaders() {
        // run the API request in a background thread
        new Thread(() -> {
            OkHttpClient client = new OkHttpClient();
            String apiUrl = "https://exercises2.p.rapidapi.com/?bodyPart=chest";
            String apiKey ="205fe69fc7msh9938514ab2ba523p1bca7cjsnc28159e1568b";// <"replace me with yourAPI key" >

            Request request = new Request.Builder()
                    .url(apiUrl)
                    .get()
                    .addHeader("X-RapidAPI-Key", apiKey)
                    .addHeader("X-RapidAPI-Host", "exercises2.p.rapidapi.com")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String responseBody = response.body().string();
                System.out.println(response);
                //parsing data from here

                // update the UI on the main thread
                runOnUiThread(() -> {
                    final TextView textView = findViewById(R.id.apiTextView);
                    textView.setText(responseBody);
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

//            final TextView textView = (TextView) findViewById(R.id.apiTextView);
//            textView.setText(fitnessString);
        }, error -> Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show());

        queue.add(request);
    }


        }).start();
    }



    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String userName = preferences.getString(USER_USERNAME_TAG, "no username");
        ((TextView)findViewById(R.id.MainUsernameDisplay)).setText(userName);
    }

public void intentButtons() {

    public void renderButtons() {


}}
        if (authUser != null) {
            logoutButton.setVisibility(View.VISIBLE);
        } else {
            logoutButton.setVisibility(View.INVISIBLE);
        }
    }

public void intentButtons() {

    final String[] username = {preferences.getString(USER_NAME_TAG, "no username")};

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

