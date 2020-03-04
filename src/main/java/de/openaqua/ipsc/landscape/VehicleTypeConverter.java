package de.openaqua.ipsc.landscape;

import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class VehicleTypeConverter implements Converter<String, VehicleType> {

	@Override
	public VehicleType convert(String value) {
		return VehicleType.valueOf(value);
	}

}
