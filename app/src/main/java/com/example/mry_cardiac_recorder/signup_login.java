package com.example.mry_cardiac_recorder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import com.example.cardiacrecorder.databinding.ActivitySignupLoginBinding;
import com.example.mry_cardiac_recorder.databinding.ActivitySignupLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class signup_login extends AppCompatActivity {

    ActivitySignupLoginBinding binding;
    FirebaseAuth firebaseauth;
    FirebaseFirestore firebasefirestore;

    ProgressDialog progressdialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding=ActivitySignupLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseauth=FirebaseAuth.getInstance();
        firebasefirestore=FirebaseFirestore.getInstance();

        progressdialog=new ProgressDialog(this);

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.fullname.getText().toString();
                String email= binding.email.getText().toString();
                String number = binding.number.getText().toString();
                String pass = binding.password.getText().toString();

                progressdialog.show();
                firebaseauth.createUserWithEmailAndPassword(email,pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                               startActivity(new Intent(signup_login.this,record.class));
                                progressdialog.cancel();

                                firebasefirestore.collection("User")
                                        .document(FirebaseAuth.getInstance().getUid())
                                        .set(new UserModel(name,number,email));

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(signup_login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                progressdialog.cancel();
                            }
                        });
            }
        });

        binding.login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup_login.this,login_signin.class));
            }
        });

    }
}