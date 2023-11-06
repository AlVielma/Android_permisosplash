package com.example.practica9_permisosplash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.practica9_permisosplash.Models.Permisos;
import com.example.practica9_permisosplash.Models.PermisosAdapter;

import java.util.ArrayList;
import java.util.List;

public class nopermisos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nopermisos);
        boolean cameraPermission = getIntent().getBooleanExtra("cameraPermission", false);
        boolean callPhonePermission = getIntent().getBooleanExtra("callPhonePermission", false);
        boolean readContactsPermission = getIntent().getBooleanExtra("readContactsPermission", false);
        List<Permisos> lista = new ArrayList<>();
        lista.add(new Permisos("android.permission.READ_CONTACTS", "Leer contactos", readContactsPermission));
        lista.add(new Permisos("android.permission.CALL_PHONE", "Realizar llamadas", callPhonePermission));
        lista.add(new Permisos("android.permission.CAMERA", "Acceso a la cámara", cameraPermission));
        PermisosAdapter adapter= new PermisosAdapter(lista,this);
        RecyclerView rc = findViewById(R.id.rcPermiso);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setHasFixedSize(true);

        boolean allPermissionsGranted = cameraPermission && callPhonePermission && readContactsPermission;


        if (allPermissionsGranted) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}