package com.bbva.wikj.lib.r030.impl;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.wikj.lib.r030.WIKJR030;

/**
 * This class automatically defines the libraries and utilities that it will use.
 */
public abstract class WIKJR030Abstract extends AbstractLibrary implements WIKJR030 {

	protected ApplicationConfigurationService applicationConfigurationService;


	/**
	* @param applicationConfigurationService the this.applicationConfigurationService to set
	*/
	public void setApplicationConfigurationService(ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}

}