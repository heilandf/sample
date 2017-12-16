package android.diegol.com.diegoteapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fheiland on 12/15/17.
 */

public class EntityAdapter extends RecyclerView.Adapter<EntityAdapter.ViewHolder> {

    private List<Entity> entities;

    public EntityAdapter(List<Entity> entities) {
        this.entities = entities;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Entity item = entities.get(position);
        holder.entityName.setText(item.getName());
        holder.entityLastName.setText(item.getLastName());
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView entityName;
        TextView entityLastName;
        public ViewHolder(View itemView) {
            super(itemView);
            entityName = itemView.findViewById(R.id.name_text);
            entityLastName = itemView.findViewById(R.id.lastname_text);
        }
    }
}
