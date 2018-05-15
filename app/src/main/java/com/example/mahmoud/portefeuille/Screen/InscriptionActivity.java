package com.example.mahmoud.portefeuille.Screen;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahmoud.portefeuille.Models.Personne;
import com.example.mahmoud.portefeuille.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.ajoutpersonne;
import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.connection;
import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.isValidEmail;
import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.verificationChampsNull;
import static com.example.mahmoud.portefeuille.Presenters.InscriptionPresenter.verificationPass;

public class InscriptionActivity extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE = 1;
    Personne p;
    @BindView(R.id.nom)
    TextView nom;
    @BindView(R.id.prenom)
    TextView prenom;
    @BindView(R.id.adresse)
    TextView adresse;
    @BindView(R.id.email)
    TextView email;
    @BindView(R.id.pass1)
    TextView pass1;
    @BindView(R.id.pass2)
    TextView pass2;
    @BindView(R.id.imageButton)
    ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        ButterKnife.bind(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();


            imageButton.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            setContentView(R.layout.activity_inscription);

        }


    }



    @OnClick(R.id.btnSingIn)
    public void inscription(){

        boolean connection=connection(getApplicationContext());
        boolean champs=verificationChampsNull(nom,prenom,adresse,email,pass1,pass2);
        boolean pass=verificationPass(pass1,pass2);
        CharSequence eemail=email.getText();
        boolean format=isValidEmail(eemail);
        //verifier l'existance d'une connection internet
        if (!connection){
            Toast.makeText(getApplicationContext(),"Pas de connection disponible",Toast.LENGTH_LONG).show();
        }
        //verifier si les champs sont vides
        if (!champs){
            Toast.makeText(getApplicationContext(),"Remplir tous les champs",Toast.LENGTH_LONG).show();
        }
        //verifier si pass1==pass2
        if (!pass){
            Toast.makeText(getApplicationContext(),"le premier mot de passe diffère du deuxième",Toast.LENGTH_LONG).show();
        }
        //verifier si le format email est valide
        if (!format){
            Toast.makeText(getApplicationContext(),"Revoir votre Email",Toast.LENGTH_LONG).show();
        }
        //envoie de la personne au serveur
        if (connection&&champs&&pass&&format){

            p=new Personne(0,nom.getText().toString(),prenom.getText().toString(),adresse.getText().toString(),email.getText().toString(),pass1.getText().toString(),imageButton.getDrawingCache());
            ajoutpersonne(p,this);
        }

    }
    @OnClick(R.id.imageButton)
    public void clickimg(View arg0 ){

        Intent i = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

}
