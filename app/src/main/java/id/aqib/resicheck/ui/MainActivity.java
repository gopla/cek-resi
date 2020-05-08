package id.aqib.resicheck.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import id.aqib.resicheck.R;
import id.aqib.resicheck.adapter.AdapterResiAll;
import id.aqib.resicheck.adapter.AdapterResiJnt;
import id.aqib.resicheck.helper.ApiInterface;
import id.aqib.resicheck.helper.ServiceGenerator;
import id.aqib.resicheck.models.ApiError;
import id.aqib.resicheck.models.ErrorUtils;
import id.aqib.resicheck.models.TrackResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String key = "47f819afa406f61817ae3603508f0f98935ecd5c5ef3b5bfcd5a699489bb9a18";
    String awb, kurir;
    List spinnerFill = new ArrayList();
    List tracking = new ArrayList();

    ItemAdapter itemAdapter = new ItemAdapter();
    FastAdapter fastAdapter = FastAdapter.with(itemAdapter);

    View rView;
    Spinner sp_kurir;
    EditText et_awb;
    TextView nama_penerima, status_paket, tanggal_kirim, service_paket, nama_pengirim;
    RecyclerView rv_tarck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_kurir = findViewById(R.id.sp_kurir);
        rView = findViewById(android.R.id.content).getRootView();
        et_awb = findViewById(R.id.noResi);
        nama_penerima = findViewById(R.id.namaPenerima);
        status_paket = findViewById(R.id.descPenerima);
        tanggal_kirim = findViewById(R.id.tanggalKirim);
        service_paket = findViewById(R.id.servicePaket);
        nama_pengirim = findViewById(R.id.namaPengirim);
        rv_tarck = findViewById(R.id.rv_resi);

        fillSpinner();
    }

    void fillSpinner(){
        spinnerFill.add("JNE");
        spinnerFill.add("J&T");
        spinnerFill.add("AnterAja");
        spinnerFill.add("Wahana");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerFill);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_kurir.setAdapter(adapter);
    }

    String selectedCourirer(){
        String courier = sp_kurir.getSelectedItem().toString();
        switch (courier){
            case "JNE":
                courier = "jne";
                break;
            case "J&T":
                courier = "jnt";
                break;
            case "POS Indonesia":
                courier = "pos";
                break;
            case "SiCepat":
                courier = "sicepat";
                break;
            case "TiKi":
                courier = "tiki";
                break;
            case "AnterAja":
                courier = "anteraja";
                break;
            case "Wahana":
                courier = "wahana";
                break;
            case "Ninja Express":
                courier = "ninja";
                break;
            case "Lion":
                courier = "lion";
                break;
            case "Lazada Express":
                courier = "lek";
                break;
        }

        return courier;
    }

    public void handleRequest(View view) {
        awb = et_awb.getText().toString();
        itemAdapter.clear();
        tracking.clear();
        if (selectedCourirer().equals("jnt")){
            ApiInterface service = ServiceGenerator.createService(ApiInterface.class);
            Call<id.aqib.resicheck.models.jnt.TrackResponse> call = service.getPacketJnt(awb,key,selectedCourirer());
            call.enqueue(new Callback<id.aqib.resicheck.models.jnt.TrackResponse>() {
                @Override
                public void onResponse(Call<id.aqib.resicheck.models.jnt.TrackResponse> call, Response<id.aqib.resicheck.models.jnt.TrackResponse> response) {
                    if (response.isSuccessful()){
                        status_paket.setText("Status \t: " + response.body().getData().getReceived().getStatus());
                        nama_penerima.setText("Penerima \t: " + response.body().getData().getReceived().getName() +"\n"+ response.body().getData().getReceived().getDesc() +"\n"+ response.body().getData().getReceived());
                        nama_pengirim.setText("Pengirim \t: -");
                        tanggal_kirim.setText("Tanggal Kirim \t: " + response.body().getData().getShipped());
                        service_paket.setText("Jenis Service \t: " + response.body().getData().getCourier());

                        for (int i = 0; i < response.body().getData().getTracking().size(); i++){
                            tracking.add(new AdapterResiJnt(response.body().getData().getTracking().get(i).getDate(),response.body().getData().getTracking().get(i).getDesc(), response.body().getData().getTracking().get(i).getStatus()));
                        }

                        itemAdapter.add(tracking);
                        rv_tarck.setAdapter(fastAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        rv_tarck.setLayoutManager(layoutManager);

                    }else{
                        ApiError error = ErrorUtils.parseError(response);
                        setResponse(error.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<id.aqib.resicheck.models.jnt.TrackResponse> call, Throwable t) {
                    setResponse(t.toString());
                }
            });

        }else{
            ApiInterface service = ServiceGenerator.createService(ApiInterface.class);
            Call<TrackResponse> call = service.getPacket(awb,key,selectedCourirer());
            call.enqueue(new Callback<TrackResponse>() {
                @Override
                public void onResponse(Call<TrackResponse> call, Response<TrackResponse> response) {
                    if (response.isSuccessful()){
                        status_paket.setText("Status \t: " + response.body().getData().getStatus());
                        nama_penerima.setText("Penerima \t: " + response.body().getData().getReceived().getName() +"\n"+ response.body().getData().getReceived().getAddr() +"\n"+ response.body().getData().getReceived().getCity());
                        nama_pengirim.setText("Pengirim \t: " + response.body().getData().getShipped().getName() +"\n"+ response.body().getData().getShipped().getAddr() +"\n"+ response.body().getData().getShipped().getCity());
                        tanggal_kirim.setText("Tanggal Kirim \t: " + response.body().getData().getShipped().getDate());
                        service_paket.setText("Jenis Service \t: " + response.body().getData().getService());

                        for (int i = 0; i < response.body().getData().getTracking().size(); i++){
                            tracking.add(new AdapterResiAll(response.body().getData().getTracking().get(i).getDate(), response.body().getData().getTracking().get(i).getDesc()));
                        }

                        itemAdapter.add(tracking);
                        rv_tarck.setAdapter(fastAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                        rv_tarck.setLayoutManager(layoutManager);
                    }else{
                        ApiError error = ErrorUtils.parseError(response);
                        setResponse(error.getMessage());
                    }
                }

                @Override
                public void onFailure(Call<TrackResponse> call, Throwable t) {
                    setResponse(t.toString());
                }
            });
        }
    }

    void setResponse(String m){
        Snackbar.make(rView,m, BaseTransientBottomBar.LENGTH_LONG).show();
    }
}
