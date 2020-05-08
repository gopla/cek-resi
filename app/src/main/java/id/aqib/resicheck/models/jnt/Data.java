
package id.aqib.resicheck.models.jnt;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("courier")
    @Expose
    private String courier;
    @SerializedName("waybill")
    @Expose
    private String waybill;
    @SerializedName("shipped")
    @Expose
    private String shipped;
    @SerializedName("received")
    @Expose
    private Received received;
    @SerializedName("tracking")
    @Expose
    private List<Tracking> tracking = null;

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getWaybill() {
        return waybill;
    }

    public void setWaybill(String waybill) {
        this.waybill = waybill;
    }

    public String getShipped() {
        return shipped;
    }

    public void setShipped(String shipped) {
        this.shipped = shipped;
    }

    public Received getReceived() {
        return received;
    }

    public void setReceived(Received received) {
        this.received = received;
    }

    public List<Tracking> getTracking() {
        return tracking;
    }

    public void setTracking(List<Tracking> tracking) {
        this.tracking = tracking;
    }

}
