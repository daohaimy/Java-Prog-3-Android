package com.example.ab05;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private final int breite = 800;
    private final int hoehe = 800;
    private final int textsize = 50;

    private Canvas canvas = new Canvas();
    private Paint paint;
    private Bitmap bitmap;
    private ImageView imageView;
    private Timer timer = new Timer();

    private final int grenzeLinks = 30;
    private final int grenzeRechts = 770;
    private final int grenzeOben = 550;
    private final int grenzeUnten = 770;
    private final int ballRadius = 20;
    private float ballX = 100f;
    private float ballY = 700f;
    private float velociteX = 0.3f;
    private float velociteY = 4.5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.bitmap = Bitmap.createBitmap(this.breite, this.hoehe,
                Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        this.imageView = new ImageView(this);
        this.imageView.setImageBitmap(this.bitmap);
        this.paint = new Paint();
        setContentView(imageView);

        this.canvas.drawColor(Color.argb(255, 0, 0, 255));
        this.paint.setTextSize(textsize);
        this.halloWelt();
        this.halloNachbarn();
        this.zeichneSmiley(200);

        this.timer.schedule(
                new TimerTask(){
                    @Override
                    public void run() {
                        derSpringendePunkt();
                    }
                }
                ,0,17 );
    }

    private void halloWelt() {
        String text = "Hallo Welt!";
        float textWidth = this.paint.measureText(text);
        this.paint.setColor(Color.WHITE);
        this.canvas.drawText(text, breite /2 - textWidth/2, 100,
                this.paint);
    }

    private void textZentrieren(String text, int y){
        float textWidth = this.paint.measureText(text);
        this.paint.setColor(Color.WHITE);
        this.canvas.drawText(text,breite/2-textWidth/2,y,this.paint);
    }

    private void halloNachbarn(){
        String text = "Hallo Kevin und Yasemin!";
        textZentrieren(text,150);
    }
    public void zeichneSmiley(int radius){
        this.paint.setColor(Color.GREEN);
        canvas.drawOval(breite/2-radius, hoehe/2-hoehe/10, breite/2+radius,hoehe/2+hoehe/8, this.paint);
        canvas.drawCircle(breite/2-100,hoehe/2-50,radius/3,this.paint);
        canvas.drawCircle(breite/2+100,hoehe/2-50,radius/3,this.paint);
        this.paint.setColor(Color.rgb(0,0,0));
        canvas.drawCircle(breite/2-110,hoehe/2-70, (radius/6),  this.paint);
        canvas.drawCircle(breite/2+110,hoehe/2-70, (radius/6),  this.paint);
        canvas.drawCircle(breite/2,hoehe/2,radius/4,this.paint);
        //this.paint.setColor(Color.rgb(245, 208, 152));
        this.paint.setColor(Color.GREEN);
        canvas.drawCircle(breite/2,hoehe/2-10,radius/4,this.paint);
        this.paint.setColor(Color.WHITE);
        canvas.drawCircle(breite/2-100,hoehe/2-70, (radius/20),  this.paint);
        canvas.drawCircle(breite/2+100,hoehe/2-70, (radius/20),  this.paint);
        this.paint.setColor(Color.rgb(255, 163, 163));
        canvas.drawCircle(breite/2-130,hoehe/2, (radius/10),this.paint);
        canvas.drawCircle(breite/2+130,hoehe/2, (radius/10),this.paint);

        /*
        this.paint.setColor(Color.rgb(245, 208, 152));
        canvas.drawCircle(breite/2, hoehe/2,radius,this.paint);
        this.paint.setColor(Color.BLACK);
        canvas.drawCircle(breite/2,hoehe/2, (radius/7),  this.paint);
        canvas.drawCircle(breite,breite, (radius/7),  this.paint);
        canvas.drawCircle(breite/2, (float) (hoehe/1.6),radius/4,this.paint);
        this.paint.setColor(Color.rgb(245, 208, 152));
        canvas.drawCircle(breite/2, (float) (hoehe/1.65),radius/4,this.paint);*/
    }


    private void derSpringendePunkt(){
        this.paint.setColor(Color.BLUE);
        canvas.drawCircle(this.ballX,this.ballY,ballRadius+1,this.paint);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.i("MainActivity", LocalDateTime.now()
                    + ": der springende Punkt");
        }
        this.paint.setColor(Color.RED);
        this.ballX += this.velociteX;
        this.ballY += this.velociteY;
        if(this.ballX <= this.grenzeLinks || this.ballX >= this.grenzeRechts){
            this.velociteX = this.velociteX * (-1);
        }
        if(this.ballY <= this.grenzeOben || this.ballY >= this.grenzeUnten){
            this.velociteY = this.velociteY * (-1);
        }
        canvas.drawCircle(this.ballX,this.ballY,ballRadius,this.paint);
        this.imageView.postInvalidate();
    }
}