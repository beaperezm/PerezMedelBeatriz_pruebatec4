package com.bbva.wikj;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.wikj.dto.evaluacion.evaluaciondos.SalidaDTO;
import com.bbva.wikj.lib.r030.WIKJR030;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 */
public class WIKJT03001COTransaction extends AbstractWIKJT03001COTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(WIKJT03001COTransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		WIKJR030 wikjr030 = (WIKJR030) getServiceLibrary(WIKJR030.class);
		SalidaDTO salidaDTO = wikjr030.execute(getData());
		if(getAdviceList().isEmpty()){
			setData(salidaDTO);
			this.setSeverity(Severity.OK);
		} else {
			this.setSeverity(Severity.ENR);
		}
	}

}
