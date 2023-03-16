package com.example.fitnessTracker.activities.Activities;

import static com.example.fitnessTracker.activities.Activities.MainActivity.USER_USERNAME_TAG;
import static com.example.fitnessTracker.activities.Activities.UserSettingsActivity.USER_AGE_TAG;
import static com.example.fitnessTracker.activities.Activities.UserSettingsActivity.USER_HEIGHT_TAG;
import static com.example.fitnessTracker.activities.Activities.UserSettingsActivity.USER_TARGET_WEIGHT_TAG;
import static com.example.fitnessTracker.activities.Activities.UserSettingsActivity.USER_WEIGHT_TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.OpenableColumns;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.core.Amplify;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.fitnessTracker.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class UserProfileActivity extends AppCompatActivity {
    private String s3ImageKey = "";
    public static final String TAG = "UserProfileActivity";
    ActivityResultLauncher<Intent> activityResultLauncher;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        activityResultLauncher = getImagePickingActivityResultLauncher();

        setUpAddImgBtn();
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

    public void setUpAddImgBtn() {
        // on click listener -> launch the img picking intent
        findViewById(R.id.UserProfileImagePicker).setOnClickListener(v -> {
            launchImageSelectionIntent();
        });
    }

    public void launchImageSelectionIntent(){
        // OnActivityResult
        Intent imageFilePickingIntent = new Intent(Intent.ACTION_GET_CONTENT);
        imageFilePickingIntent.setType("*/*");
        imageFilePickingIntent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{"image/jpeg", "image/png"});
        activityResultLauncher.launch(imageFilePickingIntent);
    }

    private ActivityResultLauncher<Intent> getImagePickingActivityResultLauncher(){
        ActivityResultLauncher<Intent> imagePickingActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Uri pickedImageFileUri = result.getData().getData();
                        try {
                            InputStream pickedImageInputStream = getContentResolver().openInputStream(pickedImageFileUri);
                            String pickedImageFileName = getFileNameFromUri(pickedImageFileUri);
                            Log.i(TAG, "Successfully got the image: " + pickedImageFileName);
                            uploadInputStreamToS3(pickedImageInputStream, pickedImageFileName, pickedImageFileUri);
                        } catch (FileNotFoundException fnfe) {
                            Log.e(TAG, "Could not get file from picker! " + fnfe);

                        }
                    }
                }
        );
        return imagePickingActivityResultLauncher;
    }

    public void uploadInputStreamToS3(InputStream pickedImageInputStream, String pickedImageFileName, Uri pickedImageFileUri){
        // upload to S3
        Amplify.Storage.uploadInputStream(
                pickedImageFileName,
                pickedImageInputStream,
                success -> {
                    Log.i(TAG, "SUCCESS! Uploaded file to S3! Filename is: " + success.getKey());
                    s3ImageKey = pickedImageFileName;
                    ImageView profileImageView = findViewById(R.id.UserProfileImagePicker);
                    InputStream pickedImageInputStreamCopy = null;
                    try {
                        pickedImageInputStreamCopy = getContentResolver().openInputStream(pickedImageFileUri);
                    } catch (FileNotFoundException fnfe) {
                        Log.e(TAG, "Could not get file stream from URI! " + fnfe.getMessage(), fnfe);
                    }
                    profileImageView.setImageBitmap(BitmapFactory.decodeStream(pickedImageInputStreamCopy));
                },
                failure -> Log.e(TAG, "FAILED to upload file to S3 with filename: " + pickedImageFileName + " with error: " + failure)
        );
    }

    @SuppressLint("Range")
    public String getFileNameFromUri(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
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