package id.ac.poliban.mi.vc.aprian.syifaapp;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {
    private final Context mContext;
    private final List<String> mList;

    public ClubAdapter(Context mContext, List<String>mList){

        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_item, parent, false);
        return new  ViewHolder(convertview, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvItem.setTextContent(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        Text tvItem;
        private final ClubAdapter mAdapter;

        public ViewHolder(@NonNull View itemView, ClubAdapter mAdapter) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
            this.mAdapter = mAdapter;

            itemView.setOnClickListener(this::onItemClicked);
            itemView.setOnLongClickListener(this::onItemLongClicked);
        }


        private boolean onItemLongClicked(View view) {
            int position = getLayoutPosition();
            String item = mAdapter.mList.get(position);
            new AlertDialog.Builder(mAdapter.mContext)
                    .setTitle("Delete Confirmation")
                    .setMessage(String.format("Hapus data %s", item))
                    .setNegativeButton("Cancel", null)
                    .setPositiveButton("Yes", (dialogInterface, i) -> {
                        mAdapter.mList.remove(item);
                        mAdapter.notifyDataSetChanged();
                    } )
                    .show();
           return true;
        }

        private void onItemClicked(View view) {
            int position = getLayoutPosition();
            String item = mAdapter.mList.get(position);
            item = String.format("%s terkena clicked!", item);
            Snackbar.make(view,item, Snackbar.LENGTH_LONG).show();
        }

    }

}
