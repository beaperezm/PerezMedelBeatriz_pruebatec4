package com.bbva.wikj;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.wikj.dto.evaluacion.evaluaciondos.EntradaDTO;
import com.bbva.wikj.dto.evaluacion.evaluaciondos.SalidaDTO;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractWIKJT03001COTransaction extends AbstractTransaction {

	public AbstractWIKJT03001COTransaction(){
	}
	protected EntradaDTO getData(){ return (EntradaDTO)getParameter("data"); }
	protected void setData(final SalidaDTO field) {this.addParameter("data",field);}
}
