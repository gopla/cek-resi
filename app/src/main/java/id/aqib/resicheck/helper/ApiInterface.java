package id.aqib.resicheck.helper;

import id.aqib.resicheck.models.TrackResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("cekresi")
    Call<TrackResponse> getPacket(@Query("awb") String awb, @Query("api_key") String key, @Query("courier") String courier);

    @GET("cekresi")
    Call<id.aqib.resicheck.models.jnt.TrackResponse> getPacketJnt(@Query("awb") String awb, @Query("api_key") String key, @Query("courier") String courier);
}
