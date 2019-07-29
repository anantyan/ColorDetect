package com.example.colordetect.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.colordetect.R;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {

    Button __btn_main;
    JavaCameraView __JCV;
    BaseLoaderCallback __BLC;
    Mat mat1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (OpenCVLoader.initDebug()) {
            Toast.makeText(getApplicationContext(), "Camera Loaded", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Camera not Loaded!", Toast.LENGTH_LONG).show();
        }

        __JCV = (JavaCameraView) findViewById(R.id._photo_main);
        __JCV.setVisibility(SurfaceView.VISIBLE);
        __JCV.setCameraIndex(0); //0 untuk camera rear
        __JCV.setCvCameraViewListener(this);

        __BLC = new BaseLoaderCallback(this) {
            @Override
            public void onManagerConnected(int status) {
                switch (status) {
                    case BaseLoaderCallback.SUCCESS:
                        __JCV.enableView();
                        break;
                    default:
                        super.onManagerConnected(status);
                        break;
                }
            }
        };

        __btn_main = (Button) findViewById(R.id._btn_main);
        __btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                startActivity(intent);
            }
        });
    }

    //==============================================================================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id._action_lihat_data) {
            Intent intent = new Intent(getApplicationContext(), DataActivity.class);
            startActivity(intent);
        } else if (id == R.id._action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //==============================================================================================
    @Override
    public void onCameraViewStarted(int width, int height) {
        mat1 = new Mat(width, height, CvType.CV_8UC4);
    }

    @Override
    public void onCameraViewStopped() {
        mat1.release();
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        mat1 = inputFrame.rgba();
        return mat1;
    }

    //==============================================================================================

    @Override
    protected void onPause() {
        super.onPause();
        if (__JCV != null) {
            __JCV.disableView();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (OpenCVLoader.initDebug()) {
            __BLC.onManagerConnected(BaseLoaderCallback.SUCCESS);
        } else {
            Toast.makeText(getApplicationContext(), "Punya masalah pada OpenCV!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (__JCV != null) {
            __JCV.disableView();
        }
    }
}
