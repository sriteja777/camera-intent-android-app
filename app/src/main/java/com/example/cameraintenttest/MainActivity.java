package com.example.cameraintenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//
//import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
//import android.accessibilityservice.AccessibilityButtonController;


//import com.airbnb.lottie.Lottie;
//import com.bumptech.glide.Glide;
//import com.facebook.stetho.Stetho;
//import com.github.florent37.expansionpanel.ExpansionHeader;
//import com.github.florent37.mylittlecanvas.CanvasHelper;
//import com.github.mikephil.charting.animation.ChartAnimator;
//import com.google.android.exoplayer2.ExoPlayer;
//import com.jakewharton.threetenabp.AndroidThreeTen;
//import com.squareup.moshi.Moshi;
//import com.squareup.picasso.Picasso;
//
//import org.greenrobot.eventbus.EventBus;
//import org.parceler.ParcelerRuntimeException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//import butterknife.ButterKnife;
//import icepick.Icepick;
//import io.objectbox.Box;
//import io.reactivex.rxjava3.core.Flowable;
//import io.reactivex.rxjava3.
//import pub.devrel.easypermissions.EasyPermissions;
//import leakcanary.LeakCanary;
//import pub.devrel.easypermissions.EasyPermissions;
//import retrofit2.Retrofit;

//import android.support.v4.app.FragmentActivity;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 101;
    private ImageView mImageView;
//    ChartAnimator
//    Flowable
    String imageFilePath;
//    LeakCanary
    Uri fileUri;
//    ExoPlayer
//    ButterKnife
//    Lottie
//    Stetho
    boolean temp = true;
//    ExpansionHeader
//    Retrofit
//        Moshi
//    EventBus
    private File createImageFile() throws IOException {
//        Moshi
//        Icepick
        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + "_";
        File storageDir =
                getFilesDir();
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
//        Retrofit
        imageFilePath = image.getAbsolutePath();
        return image;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.imageView);

    }

    public void openIntent(AppCompatActivity ma) {
        String nf = "nsdsdgsg";
//        CanvasHelper
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (temp) {
//            Log.d("ll", nf);
//            return;
//        }
            ma.startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);

    }

    public void openCamera(View view) {
//        ParcelerRuntimeException
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        MainActivity cont  = this;
//        openIntent(this);

        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Log.e("error", ex.toString());
            }
            if (photoFile != null) {
                Uri photoUri = FileProvider.getUriForFile(this, "com.example.cameraintenttest.fileprovider", photoFile);
                fileUri = photoUri;
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                Log.d("extra", cameraIntent.getExtras().get(MediaStore.EXTRA_OUTPUT).toString());
                startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
            } else {
                Log.e("error", "photo null");
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        Context t = this;
//        this = t;
//        Picasso
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if (data == null) {
                Log.d("path", "path is null");
                Log.d("path", imageFilePath);

                mImageView.setImageBitmap(BitmapFactory.decodeFile(imageFilePath));
                return;
            } else {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                mImageView.setImageBitmap(imageBitmap);
            }
        }
                int a, b,c, d,e, f, g, h, i, j, k, l;
        a= b= c= d= e= f= g= h= i = j = k = l= 10;
        System.out.println(a+b+c+d+e+f+g+h+i+j+k+l);
    }


}