package id.aqib.resicheck.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import id.aqib.resicheck.R;

public class AdapterResi extends AbstractItem<AdapterResi,AdapterResi.ViewHolder> {

    String date;
    String desc;
    String status;

    public AdapterResi(String date, String desc, String status) {
        this.date = date;
        this.desc = desc;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NonNull
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.rv_resi;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_resi;
    }

    public class ViewHolder extends FastAdapter.ViewHolder<AdapterResi> {
        TextView tanggal,deskripsi,keadaan;
        public ViewHolder(View itemView) {
            super(itemView);
            tanggal = itemView.findViewById(R.id.tanggal);
            deskripsi = itemView.findViewById(R.id.deskripsi);
            keadaan = itemView.findViewById(R.id.keadaan);

        }

        @Override
        public void bindView(AdapterResi item, List<Object> payloads) {
            tanggal.setText(item.date);
            deskripsi.setText(item.desc);
            keadaan.setText(item.status);
        }

        @Override
        public void unbindView(AdapterResi item) {
            tanggal.setText(null);
            deskripsi.setText(null);
            keadaan.setText(null);
        }
    }
}
