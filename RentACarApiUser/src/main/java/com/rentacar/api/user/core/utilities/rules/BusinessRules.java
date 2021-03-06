package com.rentacar.api.user.core.utilities.rules;

import com.rentacar.api.user.core.utilities.result.Result;

public class BusinessRules {
	public static Result run(Result... logics) {

		for (var logic : logics) {
			if (!logic.isSuccess()) {
				return logic;
			}
		}
		return null;
	}
}
