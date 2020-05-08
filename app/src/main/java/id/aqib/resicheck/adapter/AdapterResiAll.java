package id.aqib.resicheck.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import id.aqib.resicheck.R;

public class AdapterResiAll extends AbstractItem<AdapterResiAll,AdapterResiAll.ViewHolder> {

    String date;
    String desc;

    public AdapterResiAll(String date, String desc) {
        this.date = date;
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @NonNull
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder((v));
    }

    @Override
    public int getType() {
        return R.id.rv_resi;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_resi_all;
    }

    public class ViewHolder extends FastAdapter.ViewHolder<AdapterResiAll>{
        TextView tanggalAll,deskripsiAll;
        public ViewHolder(View itemView) {
            super(itemView);
            tanggalAll = itemView.findViewById(R.id.tanggalAll);
            deskripsiAll = itemView.findViewById(R.id.deskripsiAll);
        }

        @Override
        public void bindView(AdapterResiAll item, List<Object> payloads) {
            tanggalAll.setText(item.date);
            deskripsiAll.setText(item.desc);
        }

        @Override
        public void unbindView(AdapterResiAll item) {
            tanggalAll.setText(null);
            deskripsiAll.setText(null);
        }
    }
}
