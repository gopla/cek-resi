
package id.aqib.resicheck.models;

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
    @SerializedName("service")
    @Expose
    private String service;
    @SerializedName("shipped")
    @Expose
    private Shipped shipped;
    @SerializedName("received")
    @Expose
    private Received received;
    @SerializedName("tracking")
    @Expose
    private List<Tracking> tracking = null;
    @SerializedName("status")
    @Expose
    private String status;

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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Shipped getShipped() {
        return shipped;
    }

    public void setShipped(Shipped shipped) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
