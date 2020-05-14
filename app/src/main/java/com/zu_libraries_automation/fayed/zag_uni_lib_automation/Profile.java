package com.zu_libraries_automation.fayed.zag_uni_lib_automation;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    //capture photo from gallery
    ImageView profile_photo;
    private static int RESULT_LOAD_IMG = 1;

    //code capture photo from camera
    private static final int CAMERA_REQUEST = 1888;

    Button profile_btn_change_photo;
    Button profile_btn_save;
    EditText profile_edt_email;
    AutoCompleteTextView profile_AutoComTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_photo = (ImageView) findViewById(R.id.profile_photo);
        profile_btn_change_photo = (Button) findViewById(R.id.profile_btn_change_photo);
        profile_btn_save = (Button) findViewById(R.id.profile_btn_save);
        profile_AutoComTV = (AutoCompleteTextView) findViewById(R.id.profile_id_autoComTV);
        profile_edt_email = (EditText) findViewById(R.id.profile_id_edt_email);

        profile_btn_change_photo.setEnabled(false);
        profile_btn_save.setEnabled(false);
        profile_AutoComTV.setEnabled(false);
        profile_edt_email.setEnabled(false);

        if (!profile_btn_save.isEnabled() ) {
            Toast.makeText(getApplicationContext(), "We must click Edite from menu To Edite Yout data", Toast.LENGTH_SHORT).show();
        }
    }

    public void profileSaveBtn(View view) {

    }

    public void showPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.sub_menu_camera_gallery, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.upload_photo) {
                    // Create intent to Open Image applications like Gallery, Google Photos
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    // Start the Intent
                    startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
                    return true;
                }
                if (item.getItemId() == R.id.Take_photo) {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                    return true;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            //Code related with Gallery
            // Here we need to check if the activity that was triggers was the Image Gallery.
            // If it is the requestCode will match the LOAD_IMAGE_RESULTS value.
            // If the resultCode is RESULT_OK and there is some data we know that an image was picked.
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && data != null) {
                // Let's read picked image data - its URI
                Uri pickedImage = data.getData();
                // Let's read picked image path using content resolver
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
                cursor.moveToFirst();
                String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
                // At the end remember to close the cursor or you will end with the RuntimeException!
                cursor.close();
                // Do something with the bitmap
                profile_photo.setImageBitmap(bitmap);

            } else {
                Toast.makeText(this, "You haven't Capture Image", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

        //code related with Camera
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            profile_photo.setImageBitmap(photo);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile_menu_edite: {
                profile_btn_change_photo.setEnabled(true);
                profile_btn_save.setEnabled(true);
                profile_AutoComTV.setEnabled(true);
                profile_edt_email.setEnabled(true);
                break;
            }
            case R.id.profile_menu_change_pass: {

                break;
            }
            case R.id.profile_menu_logout: {
                Intent intent = new Intent(this, Log_In.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                this.finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}