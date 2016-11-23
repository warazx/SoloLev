package com.example.kringlan.sololev.model;

import com.example.kringlan.sololev.util.TimeConverter;

public class Order {
    private static int idCounter = 0;

    private int orderID;
    private long orderingDate;
    private Customer customer;
    private boolean isDelivered;
    private long deliveredDate;
    private long deliveredLong;
    private long deliveredLat;

    public Order(Customer customer) {
        this.orderID = idCounter;
        this.orderingDate = System.currentTimeMillis();
        this.customer = customer;
        this.isDelivered = false;
        idCounter++;
    }

    public Order(int orderID, long orderingDate, Customer customer, boolean isDelivered, long deliveredDate, long deliveredLong, long deliveredLat) {
        this.orderID = orderID;
        this.orderingDate = orderingDate;
        this.customer = customer;
        this.isDelivered = isDelivered;
        this.deliveredDate = deliveredDate;
        this.deliveredLong = deliveredLong;
        this.deliveredLat = deliveredLat;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Order.idCounter = idCounter;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderingDate() {
        return TimeConverter.toString(orderingDate);
    }

    public void setOrderingDate(long orderingDate) {
        this.orderingDate = orderingDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void deliver() {
        isDelivered = true;
        deliveredDate = System.currentTimeMillis();
        //TODO: Implement a method to get the current coordinates.
        deliveredLat = 666;
        deliveredLong = 666;
    }

    public long getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(long deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public long getDeliveredLong() {
        return deliveredLong;
    }

    public void setDeliveredLong(long deliveredLong) {
        this.deliveredLong = deliveredLong;
    }

    public long getDeliveredLat() {
        return deliveredLat;
    }

    public void setDeliveredLat(long deliveredLat) {
        this.deliveredLat = deliveredLat;
    }
}
