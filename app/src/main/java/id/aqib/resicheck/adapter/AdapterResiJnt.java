package id.aqib.resicheck.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import id.aqib.resicheck.R;

public class AdapterResiJnt extends AbstractItem<AdapterResiJnt, AdapterResiJnt.ViewHolder> {

    String date;
    String desc;
    String status;

    public AdapterResiJnt(String date, String desc, String status) {
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
        return R.layout.item_resi_jnt;
    }

    public class ViewHolder extends FastAdapter.ViewHolder<AdapterResiJnt> {
        TextView tanggalJnt,deskripsiJnt,keadaanJnt;
        public ViewHolder(View itemView) {
            super(itemView);
            tanggalJnt = itemView.findViewById(R.id.tanggalJnt);
            deskripsiJnt = itemView.findViewById(R.id.deskripsiJnt);
            keadaanJnt = itemView.findViewById(R.id.keadaanJnt);

        }

        @Override
        public void bindView(AdapterResiJnt item, List<Object> payloads) {
            tanggalJnt.setText(item.date);
            deskripsiJnt.setText(item.desc);
            keadaanJnt.setText(item.status);
        }

        @Override
        public void unbindView(AdapterResiJnt item) {
            tanggalJnt.setText(null);
            deskripsiJnt.setText(null);
            keadaanJnt.setText(null);
        }
    }
}
