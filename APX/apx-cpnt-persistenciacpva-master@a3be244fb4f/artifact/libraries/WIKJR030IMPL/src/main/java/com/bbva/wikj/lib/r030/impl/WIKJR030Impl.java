package com.bbva.wikj.lib.r030.impl;

import com.bbva.wikj.dto.evaluacion.evaluaciondos.EntradaDTO;
import com.bbva.wikj.dto.evaluacion.evaluaciondos.Instalments;
import com.bbva.wikj.dto.evaluacion.evaluaciondos.SalidaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * The WIKJR030Impl class...
 */
public class WIKJR030Impl extends WIKJR030Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(WIKJR030Impl.class);

	/**
	 * The execute method...
	 */
	//@Override
	//public void execute() {
	// TODO - Implementation of business logic
	//}
	@Override
	public SalidaDTO execute(EntradaDTO entradaDTO) {
		SalidaDTO salidaDTO = new SalidaDTO();
		salidaDTO.setAmount(generateAmount(entradaDTO));
		salidaDTO.setInterestTotal(generateInterest(entradaDTO));
		salidaDTO.setFrequency(entradaDTO.getFrequency());
		salidaDTO.setInstalments(generateDataList(entradaDTO));
		return salidaDTO;
	}

	public List<Instalments> generateDataList(EntradaDTO entradaDTO) {

		if (entradaDTO.getFrequency() == "A") {
			entradaDTO.setNumberInstalments(entradaDTO.getNumberInstalments()*12);
		}

		SalidaDTO salidaDTO = new SalidaDTO();
		List<Instalments> instalmentsList = new ArrayList<>();
		Instalments instalments = new Instalments();
		int amountVal = entradaDTO.getAmount();
		int interestVal = entradaDTO.getPercentageInterest();
		int numberInstalmentsVal= entradaDTO.getNumberInstalments();
		for(int i=0; i<=numberInstalmentsVal;i++) {
			instalments.setMonthlyAmount(amountVal / numberInstalmentsVal);
			instalments.setMonthlyInterest((amountVal * interestVal / 100) / numberInstalmentsVal);
			instalments.setTotalAmount((amountVal + (amountVal * interestVal) / 100) / numberInstalmentsVal);
			salidaDTO.setInstalments(instalmentsList);
			instalmentsList.add(instalments);
		}
		return instalmentsList;
	}
	public int generateAmount(EntradaDTO entradaDTO){
		int amountVal = entradaDTO.getAmount();
		int interestVal = entradaDTO.getPercentageInterest();
		int resultado = (amountVal + ((interestVal * amountVal) / 100));
		return resultado;
	}
	public int generateInterest(EntradaDTO entradaDTO) {
		int amountVal = entradaDTO.getAmount();
		int interestVal = entradaDTO.getPercentageInterest();
		int resultado = ((amountVal*interestVal)/100);
		return resultado;
	}
}
