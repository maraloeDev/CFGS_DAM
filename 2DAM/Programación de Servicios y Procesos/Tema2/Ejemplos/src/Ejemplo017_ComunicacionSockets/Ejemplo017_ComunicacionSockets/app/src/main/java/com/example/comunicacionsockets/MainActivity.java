package com.example.comunicacionsockets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;

import com.example.comunicacionsockets.databinding.ActivityMainBinding;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);





        binding.bConectar.setOnClickListener(v -> {
            binding.bEnviar.setEnabled(true);
            try {
                Socket socket = new Socket("172.26.8.24", 4444);
                outputStream= socket.getOutputStream();
                objectOutputStream= new ObjectOutputStream(outputStream);
            }  catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        binding.bEnviar.setOnClickListener(v -> {
            try {
                Usuario usuario= new Usuario(binding.etDatoAEnviar.getText().toString());
                objectOutputStream.writeObject(usuario);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }
}