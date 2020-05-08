
package id.aqib.resicheck.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shipped {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("addr")
    @Expose
    private String addr;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("date")
    @Expose
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
