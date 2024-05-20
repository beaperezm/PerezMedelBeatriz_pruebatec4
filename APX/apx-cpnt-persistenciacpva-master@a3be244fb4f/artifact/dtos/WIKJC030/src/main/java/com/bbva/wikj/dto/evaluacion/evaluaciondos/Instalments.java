package com.bbva.wikj.dto.evaluacion.evaluaciondos;

public class Instalments {
    private int monthlyInterest;
    private int monthlyAmount;
    private int totalAmount;

    public int getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(int monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    public int getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(int monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Instalments{" +
                "monthlyInterest=" + monthlyInterest +
                ", monthlyAmount=" + monthlyAmount +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
