package com.bbva.wikj.lib.r001;

import com.bbva.wikj.dto.customerpruebafinal.CustomerIn;
import com.bbva.wikj.dto.customerpruebafinal.CustomerOut;

/**
 * The logic of this project is:
 *    1- Execute count -> if a nuip with the same number doesn´t appear in the database (= returns 0)
 *    2- Execute the insert -> if it´s correct
 *    3- Execute the select to fill the output
 if the executeCount doesn´t return 0 - the executeInsert won´t be executed
 if the executeCount returns 0 it goes to the executeInsert but if this one returns 0 the executeSelect  won´t be executed
 if the executeCount returns 0 it goes to the executeInsert, and if this one returns 1 the executeSelect  will be executed

 */
public interface WIKJR001 {

	int executeCount(String nuip);
	int executeInsert(CustomerIn customerIn);
	CustomerOut executeSelect(String id);

}
