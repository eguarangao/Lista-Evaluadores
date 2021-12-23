package com.example.listadeevaluadores.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listadeevaluadores.Modelo.Evaluador;
import com.example.listadeevaluadores.R;

import java.util.ArrayList;

public class AdapterEvaluador extends RecyclerView.Adapter<AdapterEvaluador.ViewHolder> implements View.OnClickListener {

    private Context m_context;
    private ArrayList<Evaluador> milista;
    private View.OnClickListener lister;

    public AdapterEvaluador(Context context, ArrayList<Evaluador> lista) {
        m_context = context;
        milista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(m_context);
        View vista = inflater.inflate(R.layout.items, null);
        vista.setOnClickListener(this);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       /*
        Evaluador a = milista.get(position);
        String imgJPG =  a.getImgJPG();
        holder.imgJPG.set
      ListaLibrosUteq actual = milista.get(position);
      String urlImg=actual.getCover();
      String issue_id =actual.getIssue_id();
      String volume = actual.getVolume();
      String number = actual.getNumber();
      String year = actual.getYear();
      String date_published = actual.getDate_published();
      String title = actual.getTitle();
      String doi= actual.getDoi();
      holder.Tissue_id.setText(issue_id);
      holder.Tvolume.setText(volume);
      holder.Tnumber.setText(number);
      holder.Tyear.setText(year);
      holder.Tdate_published.setText(date_published);
      holder.Ttitle.setText(title);
      holder.Tdoi.setText(doi);
      Picasso.with(m_context).load(urlImg).into(holder.Tcover);
*/

        /**/
        holder.Tnombre.setText("NOMBRE: " + milista.get(position).getNombres());
        holder.Tarea.setText(" Area: " + milista.get(position).getArea());
        holder.Tid.setText(" Id: " + milista.get(position).getIdevaluador());
        // Picasso.with(m_context).load(milista.get(position).getImgJPG().toString()).fit().centerInside().into(holder.Tcover);
        Glide.with(m_context).load(milista.get(position).getImgjpg()).placeholder
                (R.drawable.usuario).into(holder.imgJPG);

    }

    @Override
    public int getItemCount() {
        return milista.size();
    }

    @Override
    public void onClick(View v) {
        if(lister!=null){
            lister.onClick(v);
        }

    }
    public void setOnClickListener(View.OnClickListener lister){
        this.lister=lister;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgJPG;
        public TextView Tnombre;
        public TextView Tarea;
        public TextView Tid;


        //public TextView Tcover;
        public ViewHolder(View itemView) {
            super(itemView);
            imgJPG = itemView.findViewById(R.id.imgUsr2);
            Tnombre = itemView.findViewById(R.id.lblNombre2);
            Tarea = itemView.findViewById(R.id.lblArea2);
            Tid = itemView.findViewById(R.id.lblFechaInicio2);

        }



         }

}
