package com.bbva.wikj;

import com.bbva.wikj.dto.customerpruebafinal.CustomerIn;
import com.bbva.wikj.dto.customerpruebafinal.CustomerOut;
import com.bbva.wikj.lib.r001.WIKJR001;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WIKJT00101ESTransaction extends AbstractWIKJT00101ESTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(WIKJT00101ESTransaction.class);

	@Override
	public void execute() {
		WIKJR001 wikjr001 = this.getServiceLibrary(WIKJR001.class);
		CustomerIn customerIn = this.getCustomerin();
		int result = wikjr001.executeInsert(customerIn);
		if(result == 0){
			setCustomerout(null);
		} else {
			CustomerOut customerOut = wikjr001.executeSelect(customerIn.getId());
			setCustomerout(customerOut);
		}

	}

}
