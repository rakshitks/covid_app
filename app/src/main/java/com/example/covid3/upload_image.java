package com.example.covid3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class upload_image extends AppCompatActivity {
    Button ch,up;
    ImageView img;
    StorageReference mStorageRef;
    private StorageTask uploadTask;
    public Uri imprateek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        mStorageRef= FirebaseStorage.getInstance().getReference("images");
        ch=(Button)findViewById(R.id.button);
        up=(Button)findViewById(R.id.button2);
        setTitle("Upload Screenshots of Fake News");
        img=(ImageView)findViewById((R.id.imageView));
        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileChooser();
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uploadTask!= null && uploadTask.isInProgress())
                {
                    Toast.makeText(getApplicationContext(),"Upload in progress",Toast.LENGTH_LONG);
                }
                else {
                    Fileuploder();
                }
            }
        });
    }
    private String getExtention(Uri uri)
    {
        ContentResolver cr=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));



    }
    private void Fileuploder()
    {
        StorageReference Ref=mStorageRef.child(System.currentTimeMillis()+","+getExtention(imprateek));

        uploadTask=Ref.putFile(imprateek)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        // Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        Toast.makeText(upload_image.this,"Image uploaded succesfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(upload_image.this,"Upload failed try again",Toast.LENGTH_LONG).show();
                        // ...
                    }
                });

    }
    private void FileChooser()
    {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            imprateek=data.getData();
            img.setImageURI(imprateek);


        }
    }
}