package com.example.auth18;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



/**
 * Created by Anastasiia Mudarisova on 29.09.17.
 */

public class ProductsDataModel {

    @SerializedName("prdName")
    @Expose
    private String name;
    @SerializedName("prdAmount")
    @Expose
    private Float amount;
    @SerializedName("prdPrice")
    @Expose
    private Float price;
    @SerializedName("prdType")
    @Expose
    private String type;
    private Float totalAmount;



    public ProductsDataModel() {
        this.name = "какая то дичь";
        this.amount = 0.358f;
        this.price = 49.50f;

    }

    public String getName() {
        return name;
    }

    public Float getAmount() {
        return amount;
    }

    public Float getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Float getTotalAmount() {
        return price * amount;
    }
}
