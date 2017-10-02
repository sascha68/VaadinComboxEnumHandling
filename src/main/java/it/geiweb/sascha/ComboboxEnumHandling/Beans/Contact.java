package it.geiweb.sascha.ComboboxEnumHandling.Beans;

import it.geiweb.sascha.ComboboxEnumHandling.Enum.EnumContactAction;

public class Contact {

	private String name;
	private EnumContactAction contactAction;
	private String contactValue;
	
	public Contact(String name, EnumContactAction contactAction, String contactValue) {
		super();
		this.name = name;
		this.contactAction = contactAction;
		this.contactValue = contactValue;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EnumContactAction getContactAction() {
		return contactAction;
	}
	public void setContactAction(EnumContactAction contactAction) {
		this.contactAction = contactAction;
	}
	public String getContactValue() {
		return contactValue;
	}
	public void setContactValue(String contactValue) {
		this.contactValue = contactValue;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
