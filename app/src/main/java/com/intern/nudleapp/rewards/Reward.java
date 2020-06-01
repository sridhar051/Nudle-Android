package com.intern.nudleapp.rewards;

public class Reward {

    private String status;
    private String nudle_cash;

    public Reward(String status, String nudle_cash) {
        this.status = status;
        this.nudle_cash = nudle_cash;
    }

    public String getStatus() {
        return status;
    }

    public String getNudle_cash() {
        return nudle_cash;
    }

}
