package com.example.listadeevaluadores.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listadeevaluadores.Modelo.Evaluado;
import com.example.listadeevaluadores.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterEvaluado extends RecyclerView.Adapter<AdapterEvaluado.ViewHolder> {
    private Context m_context;
    int refer;
    private List<Evaluado> milista;
    public AdapterEvaluado(Context context, List<Evaluado> lista,int refer){
        m_context=context;
        milista=lista;
        this.refer=refer;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(refer,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.Nombres.setText(milista.get(position).getNombres());
        holder.cargo.setText(milista.get(position).getCargo());
        holder.fechaInicio.setText(milista.get(position).getFechaInicio());
        holder.fechaFin.setText(milista.get(position).getFechaFin());
        holder.situacion.setText(milista.get(position).getSituacion());
        Glide.with(m_context).load(milista.get(position).getImgJPG()).placeholder
                (R.drawable.usuario).into(holder.imgJPG);
    }

    @Override
    public int getItemCount() {
        return milista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView Nombres;
        private TextView cargo;
        private TextView situacion;
        private TextView fechaInicio;
        private TextView fechaFin;
        private ImageView imgJPG;

        public ViewHolder(View itemView){
            super(itemView);
            Nombres = itemView.findViewById(R.id.lblNombre2);
            cargo= itemView.findViewById(R.id.lblArea2);
            situacion=itemView.findViewById(R.id.lblSituacion2);
            fechaInicio=itemView.findViewById(R.id.lblFechaInicio2);
            fechaFin=itemView.findViewById(R.id.lblFechaFin2);
            imgJPG = itemView.findViewById(R.id.imgUsr2);

    }
}

}
