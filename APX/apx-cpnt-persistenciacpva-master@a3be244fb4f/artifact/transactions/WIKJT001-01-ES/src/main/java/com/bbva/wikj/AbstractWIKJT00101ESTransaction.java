package com.bbva.wikj;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.wikj.dto.customerpruebafinal.CustomerIn;
import com.bbva.wikj.dto.customerpruebafinal.CustomerOut;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractWIKJT00101ESTransaction extends AbstractTransaction {

	public AbstractWIKJT00101ESTransaction(){
	}


	/**
	 * Return value for input parameter customerIn
	 */
	protected CustomerIn getCustomerin(){
		return (CustomerIn)this.getParameter("customerIn");
	}

	/**
	 * Set value for CustomerOut output parameter customerOut
	 */
	protected void setCustomerout(final CustomerOut field){
		this.addParameter("customerOut", field);
	}
}
