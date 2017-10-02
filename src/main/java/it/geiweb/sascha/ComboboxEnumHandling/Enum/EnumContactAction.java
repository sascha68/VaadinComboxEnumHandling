package it.geiweb.sascha.ComboboxEnumHandling.Enum;

public enum EnumContactAction {
	MAIL				("MAIL"),
	PHONE 			("PHONE"),
	TWITTER			("TWITTER"),

	BLANK			("")
;
	private String _value;
	
	private EnumContactAction(String value){
		this._value 			= value;
	}
	
	public String getValue() {

		return this._value;
	}
	
	public static String getCaption( EnumContactAction input ) {
		
		switch (input){
			case MAIL:
				return "Email address";
			case PHONE:
				return "Telephone number";
			case TWITTER:
				return "Twitter account";
			default:
				return "";
		}
	}
	
}
