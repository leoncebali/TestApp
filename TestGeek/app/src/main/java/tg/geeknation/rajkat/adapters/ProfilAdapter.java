package tg.geeknation.rajkat.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import tg.geeknation.rajkat.models.Profil;
import tg.geeknation.rajkat.activities.R;

/**
 * Created by rajkat on 11/25/16.
 */
public class ProfilAdapter extends RecyclerView.Adapter<ProfilAdapter.ProfilHolder>{

    private Context context;
    private int selectedPosition = -1;
    private ArrayList<Profil> profils = new ArrayList<>();

    public ProfilAdapter(Context context, ArrayList<Profil> profils) {
        this.context = context;
        this.profils = profils;
    }

    @Override
    public ProfilHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_profil, parent, false);
        return new ProfilHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProfilHolder holder, int position) {

        Profil profil = profils.get(position);
        holder.notation.setImageResource(R.drawable.notation);
        holder.bag.setImageResource(R.drawable.ic_shop_black_24dp);
        holder.photo.setImageResource(profil.getPhoto());
        holder.competence.setText(profil.getCompetence());
        holder.nom.setText(profil.getNom());
    }

    @Override
    public int getItemCount() {
        return this.profils.size();
    }

    static class ProfilHolder extends RecyclerView.ViewHolder {

        private TextView nom, competence;
        private ImageView bag, notation;
        private CardView cardView;
        private CircleImageView photo;

        ProfilHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.profil_card);
            nom = (TextView) itemView.findViewById(R.id.item_nom);
            competence = (TextView) itemView.findViewById(R.id.item_competence);
            photo = (CircleImageView) itemView.findViewById(R.id.item_photo);
            bag = (ImageView) itemView.findViewById(R.id.item_bag);
            notation = (ImageView) itemView.findViewById(R.id.item_notation);
        }
    }
}
