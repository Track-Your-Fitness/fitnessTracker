package com.example.fitnessTracker.activities.Activities;

import static com.example.fitnessTracker.activities.Activities.MainActivity.USER_USERNAME_TAG;
import static com.example.fitnessTracker.activities.Activities.UserSettingsActivity.USER_AGE_TAG;
import static com.example.fitnessTracker.activities.Activities.UserSettingsActivity.USER_HEIGHT_TAG;
import static com.example.fitnessTracker.activities.Activities.UserSettingsActivity.USER_TARGET_WEIGHT_TAG;
import static com.example.fitnessTracker.activities.Activities.UserSettingsActivity.USER_WEIGHT_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.fitnessTracker.R;

import org.json.JSONException;
import org.json.JSONObject;


public class UserProfileActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        renderQuotes();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String userName = preferences.getString(USER_USERNAME_TAG, "");
        ((TextView)findViewById(R.id.UserProfileTextViewName)).setText(userName);

        String userAge = preferences.getString(USER_AGE_TAG, "");
        ((TextView)findViewById(R.id.UserProfileTextViewAge)).setText(userAge);

        String userWeight = preferences.getString(USER_WEIGHT_TAG, "");
        ((TextView)findViewById(R.id.UserProfileTextViewWeight)).setText(userWeight);

        String userHeight = preferences.getString(USER_HEIGHT_TAG, "");
        ((TextView)findViewById(R.id.UserProfileTextViewHeight)).setText(userHeight);

        String userTargetWeight = preferences.getString(USER_TARGET_WEIGHT_TAG , "");
        ((TextView)findViewById(R.id.UserProfileTargetWeight)).setText(userTargetWeight);
    }
    private void renderQuotes(){


        // https://www.youtube.com/watch?v=xPi-z3nOcn8
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://zenquotes.io/api/quotes";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            String quote = "";
            try {
//                textView.setText("Response is: " + response.getJSONObject(0));
                JSONObject allQuoteData = response.getJSONObject(0);
                quote = " \" " + allQuoteData.getString("q") + "\"\n " + " - " + allQuoteData.getString("a");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            final TextView textView = findViewById(R.id.UserProfileTextViewInspirationalQuote);
            textView.setText(quote);
        }, error -> Toast.makeText(UserProfileActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show());

        queue.add(request);
    }
}