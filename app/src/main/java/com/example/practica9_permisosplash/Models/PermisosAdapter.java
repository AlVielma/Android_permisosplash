package com.example.practica9_permisosplash.Models;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica9_permisosplash.R;

import java.util.List;

public class PermisosAdapter extends RecyclerView.Adapter<PermisosAdapter.ViewHolder>{
    List<Permisos> lista;

    Activity activity;

    public PermisosAdapter(List<Permisos> lista, Activity activit){
        this.lista = lista;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PermisosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itempermiso,parent,false);
        ViewHolder v = new ViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull PermisosAdapter.ViewHolder holder, int position) {
        Permisos permiso = lista.get(position);
        holder.setData(permiso);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreper;
        Permisos pc;
        Switch switch1;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            nombreper = itemView.findViewById(R.id.nombreper);
            switch1 = itemView.findViewById(R.id.switch1);

            switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked==true) {
                    if (ContextCompat.checkSelfPermission(activity, pc.getNombre())
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(activity,
                                new String[] { pc.getNombre() },
                                1);
                    }

                }
                else {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                    intent.setData(uri);
                    activity.startActivity(intent);
                }
        });
        }

        public void setData(Permisos permiso) {
            nombreper.setText(permiso.getNombre());
            pc = permiso;
            switch1.setChecked(permiso.isGranted());
        }
    }
}
