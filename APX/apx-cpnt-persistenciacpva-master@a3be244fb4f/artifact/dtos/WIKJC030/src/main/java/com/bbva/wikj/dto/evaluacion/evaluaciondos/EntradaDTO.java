package com.bbva.wikj.dto.evaluacion.evaluaciondos;

import java.io.Serializable;

/**
 * The EntradaDTO class...
 */
public class EntradaDTO implements Serializable {
	private static final long serialVersionUID = 2931699728946643245L;

	private int amount;
	private String frequency;
	private int percentageInterest;
	private int numberInstalments;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public int getPercentageInterest() {
		return percentageInterest;
	}

	public void setPercentageInterest(int percentageInterest) {
		this.percentageInterest = percentageInterest;
	}

	public int getNumberInstalments() {
		return numberInstalments;
	}

	public void setNumberInstalments(int numberInstalments) {
		this.numberInstalments = numberInstalments;
	}

	@Override
	public String toString() {
		return "EntradaDTO{" +
				"amount=" + amount +
				", frequency='" + frequency + '\'' +
				", percentageInterest=" + percentageInterest +
				", numberInstalments=" + numberInstalments +
				'}';
	}
}

