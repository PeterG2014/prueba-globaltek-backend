package com.globaltek.springboot.backend.apirest.constants;

public enum EnumConstantsApi {
	ST_HEADERS("application/json"),
	ST_MESSAGE_QUESTION_OK("Pregunta Creada"),
	ST_ERROR_CODE_200("200"),
	ST_DESCRIPTION_CODE_200("Exitoso"),
	ST_MESSAGE_JSON("message"),
	ST_ERROR_JSON("error"),
	ST_FACTURAS_JSON("facturas"),
	
	ST_ERROR_CODE_400("400"),
	ST_DESCRIPTION_CODE_400("Error en la formacion de la solicitud"),
	
	ST_ERROR_CODE_404("404"),
	ST_DESCRIPTION_CODE_404("Solicitud no encontrada")
	;
  
	private String stValue;
	
	private EnumConstantsApi(String stValue) {
		this.stValue = stValue;
	}
	
	public String getValue() {
		return this.stValue;
	}
}
