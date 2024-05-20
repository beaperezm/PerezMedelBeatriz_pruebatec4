package com.bbva.wikj.lib.r001.impl;

import com.bbva.wikj.dto.customerpruebafinal.CustomerIn;
import com.bbva.wikj.dto.customerpruebafinal.CustomerOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * executeCount => receives the nuip and returns the count number

 * executeInsert => receives the customerIn and returns -> 1 if everything is correct, or -> 0 if it´s not correct
                    Insert the data using jdbc and with 'update' method

 * executeSelect => receives the id and returns the customerOut
                    With the id it makes a request to the database to return an object (customerOut) with the data recorded in that ID
 */
public class WIKJR001Impl extends WIKJR001Abstract {
	private static final Logger LOGGER = LoggerFactory.getLogger(WIKJR001Impl.class);

	@Override
	public int executeCount(String nuip) {
        return this.jdbcUtils.queryForInt("query.count", nuip);
	}

	@Override
	public int executeInsert(CustomerIn customerIn) {
		Map<String,Object> args = new HashMap<>();
		if(executeCount(customerIn.getNuip()) != 0) {
			return 0;
		}
		args.put("id", customerIn.getId());
		args.put("nuip", customerIn.getNuip());
		args.put("full_name", customerIn.getFullName());
		args.put("phone", customerIn.getPhone());
		args.put("address", customerIn.getAddress());
		return this.jdbcUtils.update("query.insert",args);
	}

	@Override
	public CustomerOut executeSelect(String id) {
		Map<String,Object> result = this.jdbcUtils.queryForMap("query.select",id);
		CustomerOut customerOut = new CustomerOut();
		customerOut.setId(String.valueOf(result.get("id")));
		customerOut.setNuip(String.valueOf(result.get("nuip")));
		customerOut.setFullName(String.valueOf(result.get("full_name")));
		customerOut.setPhone(String.valueOf(result.get("phone")));
		customerOut.setAddress(String.valueOf(result.get("address")));
		return customerOut;
	}
}
