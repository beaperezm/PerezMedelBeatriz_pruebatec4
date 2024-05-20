package com.bbva.wikj.dto.evaluacion.evaluaciondos;

import java.util.List;

public class SalidaDTO {
    private int amount;
    private int interestTotal;
    private String frequency;
    private List<Instalments> instalments;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getInterestTotal() {
        return interestTotal;
    }

    public void setInterestTotal(int interestTotal) {
        this.interestTotal = interestTotal;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public List<Instalments> getInstalments() {
        return instalments;
    }

    public void setInstalments(List<Instalments> instalments) {
        this.instalments = instalments;
    }

    @Override
    public String toString() {
        return "SalidaDTO{" +
                "amount=" + amount +
                ", interestTotal=" + interestTotal +
                ", frequency='" + frequency + '\'' +
                ", instalments=" + instalments +
                '}';
    }
}
