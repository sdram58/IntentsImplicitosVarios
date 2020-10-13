package com.catata.intentsimplicitosvarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById (R.id.button1);
        button1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mestreacasa.gva.es/web/iesserraperenxisa/"));

                //Comprobamos de antemano que el Intent podrá ser gestionado de antemano sin hacer crash
                //También se podría poner un try/catch
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        Button button2 = (Button) findViewById (R.id.button2);
        button2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com"));
                startActivity(intent);
            }
        });
        Button button3 = (Button) findViewById (R.id.button3);
        button3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:39.4295152,-0.4660814?z=18"));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
        Button button4 = (Button) findViewById (R.id.button4);
        button4.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+961534567));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        /*
        * Es posible compartir información textual con cualquier aplicación, que manifieste a través de su pertinente intent-filter,
        *  que puede enviar información en texto plano (text/plain), o en HTML (text/html).
        * Con el siguiente código, podremos abrir la aplicación predeterminada de correo (u otras)
        * con la información mandada en el Intent.*/
        Button button5 = (Button) findViewById (R.id.button5);
        button5.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Probando");
                intent.putExtra(Intent.EXTRA_TEXT, "Esto es un texto de prueba");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"carlos.tarazona@iesserraperenxisa.com"});
                startActivity(intent);
            }
        });

        Button button6 = (Button) findViewById (R.id.button6);
        button6.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                //Necesitamos permisos en el manifest
                //<uses-feature android:name="android.hardware.camera" android:required="true" />
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });

        Button button7 = (Button) findViewById (R.id.button7);
        button7.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                //Necesitamos dar permiso en el manifest
                //<uses-permission android:name="com.android.alarm.permission.SET_ALARM" />
                Intent alarmaIntent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "message")
                        .putExtra(AlarmClock.EXTRA_HOUR, 0)
                        .putExtra(AlarmClock.EXTRA_MINUTES, 45);
                if (alarmaIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(alarmaIntent);
                }
            }
        });

        Button button8 = (Button) findViewById (R.id.button8);
        button8.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + 609000000));
                smsIntent.putExtra("sms_body", "Texto mensaje");
                if (smsIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(smsIntent);
                }
            }
        });

        //Con chooser
        Button button9 = (Button) findViewById (R.id.button9);
        button9.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mestreacasa.gva.es/web/iesserraperenxisa/"));

                Intent chooser = Intent.createChooser(intent, "Elige la app que quieres usar");

                //Comprobamos de antemano que el Intent podrá ser gestionado de antemano sin hacer crash
                //También se podría poner un try/catch
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });
    }
}