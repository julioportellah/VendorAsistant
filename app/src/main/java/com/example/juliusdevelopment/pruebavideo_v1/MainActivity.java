package com.example.juliusdevelopment.pruebavideo_v1;

//import android.content.Context;
import android.net.Uri;
//import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import android.widget.Toast;
import android.widget.VideoView;
import android.widget.MediaController;

public class MainActivity extends ActionBarActivity {


    Button videoButton1, videoButton2, videoButton3;
    //Button registerButton;
    MediaController mdc1,mdc2;
    VideoView videoDeMuestra,videoDeMuestra2,videoDeMuestra3;

    //MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Definiendo botones y sus eventos
        videoButton1=(Button)findViewById(R.id.video_btn_1);
        videoButton2=(Button)findViewById(R.id.video_btn_2);
        videoButton3=(Button)findViewById(R.id.video_btn_3);

        videoButton1.setOnClickListener(centralHandler);
        videoButton2.setOnClickListener(centralHandler);
        videoButton3.setOnClickListener(centralHandler);
        //Fin de la definicion de botones

        videoDeMuestra=(VideoView) findViewById(R.id.videoView);
        videoDeMuestra2=(VideoView) findViewById(R.id.videoView);
        videoDeMuestra3=(VideoView) findViewById(R.id.videoView);


        String path1="android.resource://"+getPackageName()+"/"+R.raw.video_frecuencia_latina;
        //String path2="android.resource://"+getPackageName()+"/"+R.raw.video_globo;
        mdc1=new MediaController(this);
        mdc2=new MediaController(this);
        videoDeMuestra.setVideoURI(Uri.parse(path1));
        //videoDeMuestra.setVideoPath(path1);
        mdc1.setAnchorView(videoDeMuestra);
        videoDeMuestra.setMediaController(mdc1);
    }

    private String getFileName(int selector){
        String finalString="";
        switch (selector) {
            case 1:
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.video_frecuencia_latina;
                break;
            case 2:
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.video_globo;
                break;
            case 3:
                finalString = "android.resource://" + getPackageName() + "/" + R.raw.drone_construido;
                break;
        }
        return finalString;
    }

    private void playVideo(String path)
    {
        //String uriPath=path;
        Uri uri = Uri.parse(path);
        videoDeMuestra.setVideoURI(uri);
        videoDeMuestra.requestFocus();
        if(videoDeMuestra.isPlaying())
        {
            videoDeMuestra.stopPlayback();
        }
        videoDeMuestra.start();
    }

    View.OnClickListener centralHandler=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String videoString;
            switch (v.getId()){
                case R.id.video_btn_1:
                    videoString=getFileName(1);
                    playVideo(videoString);
                    break;
                    //playVideoTest(1);
                case R.id.video_btn_2:
                    videoString=getFileName(2);
                    playVideo(videoString);
                    break;
                    //playVideoTest(2);
                case R.id.video_btn_3:
                    videoString=getFileName(3);
                    playVideo(videoString);
                    break;
                    //playVideoTest(3);
            }
        }
    };



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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
