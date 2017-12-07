package br.senai.sp.informatica.permissaogaleriafotos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.transform.stream.StreamSource;

import static android.R.attr.data;
import static android.R.attr.resizeMode;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "QuickNotesMainActivity";
    private ImageButton btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = (ImageButton)findViewById(R.id.btnCamera);

        final String TAG = "QuickNotesMainActivity";

        Log.d(TAG, "... ON CREATE ...");

    }

    //metodo para abrir a camera
    public void abrirCamera() {

        //Toast.makeText(getApplicationContext(), "... ABRIU CAMERA ... ",Toast.LENGTH_SHORT).show();

        try {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 123);
            Log.d(TAG, "... ABRIU CAMERA ... ");
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "... EXCEPTION: " + e + " ...");
        }finally {
            Log.d(TAG, "... FINALLY ...");
        }
    }

    //metodo que retorna caminho + nome da foto
    public File arquivoFoto() {

        File nomeArquivo = null;

        try {
            String dataHora = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File pastaArquivo = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            nomeArquivo = new File(pastaArquivo.getPath() + File.separator + "JPG_" + dataHora + ".jpg");

            Log.d(TAG, "... GEROU ARQUIVO: " + nomeArquivo + " ...");

        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "... EXCEPTION: " + e + " ...");
        } finally {

            Log.d(TAG, "... FINALLY ...");
        }

        //Toast.makeText(getApplicationContext(), "... GEROU ARQUIVO: " + nomeArquivo + " ...", Toast.LENGTH_LONG).show();

        return nomeArquivo;
    }

    public void verFotoTirada(){

        try {
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(arquivoFoto())));
            Log.d(TAG, "... VISUALIZA FOTO TIRADA ...");
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "... EXCEPTION: " + e + " ...");
        }finally {
            Log.d(TAG, "... FINALLY ...");
        }
        //Toast.makeText(getApplicationContext(), "... VISUALIZA FOTO TIRADA ...", Toast.LENGTH_SHORT).show();

    }

    public void salvarFoto() {
     try{
        Uri photoURI = FileProvider.getUriForFile(getBaseContext(),
                getBaseContext().getApplicationContext().getPackageName() +
                        ".provider", arquivoFoto());
        //Toast.makeText(getApplicationContext(), "... FOTO SALVA: " + photoURI, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "... FOTO SALVA: " + photoURI + "...");
    }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "... EXCEPTION: " + e + " ...");
        }finally {
            Log.d(TAG, "... FINALLY ...");
        }
    }

    public void onClickCamera(View view){

        //Toast.makeText(getApplicationContext(), "... on click camera ... ",Toast.LENGTH_SHORT).show();


        try{
            abrirCamera();
            Log.d(TAG, "... ONCLICKCAMERA ...");
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, "... EXCEPTION: " + e + " ...");
        }finally {
            Log.d(TAG, "... FINALLY ...");
        }
}


/*
        File picsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File imageFile = new File(picsDir, "foto.jpg");

        //MediaStore.ACTION_IMAGE_CAPTURE identifica a aplicação nativa de câmera
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //armazenada no caminho especificado
        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imageFile));

        //envia a intent para a plataforma, a qual vai abrir a aplicação da câmera
        startActivity(i);

        //para coinserir na memoria externa do dispositivo;
        //necessario inserir no AndroidManifest.xml
        //<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />


        //verificar demais permissoes caso manipular
        //<uses-feature android:name="android.hardware.camera" android:required="true" />
        //<uses-permission android:name="android.permission.CAMERA"/>
        //<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />


*/







    //metodo para verificar se usuario tirou ou nao a foto de acordo co resultado da tela
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //Toast.makeText(getApplicationContext(), "... RESULTADO DA CAMERA... ",Toast.LENGTH_SHORT).show();

        Log.d(TAG, "... ENTROU NO onActivityResult ...");

        try {

            Log.d(TAG, "... ENTROU NO TRY ...");

            if (requestCode == 123 && resultCode == Activity.RESULT_OK) {
                //Toast.makeText(getApplicationContext(), "... TIROU FOTO OK ...", Toast.LENGTH_SHORT).show();

                Log.d(TAG, "... TIROU FOTO OK ...");

                verFotoTirada();
                salvarFoto();



                // este é o bundle que fará com a a foto capturada seja armazenada em memoria
                Bundle bundle = data.getExtras();
                if(bundle != null){
                //Toast.makeText(getApplicationContext(), "... ENTROU BUNDLE != NULL ...", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "... ENTROU BUNDLE != NULL ...");
                //as linhas abaixo são feitas para a foto ir ditereto para o botao
                Bitmap img = (Bitmap) bundle.get("data");
                btnCamera.setImageBitmap(img);
                }


                //isto foram testes
                //takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI);
                //sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                //                         Uri.fromFile(img)));

            } else {
               Toast.makeText(getApplicationContext(), "... NAO TIROU FOTO ...", Toast.LENGTH_SHORT).show();
               Log.d(TAG, "... NAO TIROU FOTO ...");
            }


        }catch (Exception e){
                    e.printStackTrace();
                    Log.d(TAG, "... EXCEPTION: " + e + " ...");
        }finally {
                Toast.makeText(getApplicationContext(), "... EXCEPTION FINALLY ...", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "... EXCEPTION FINALLY ...");
                }




    }






}
