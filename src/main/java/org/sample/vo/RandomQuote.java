package org.sample.vo;

public class RandomQuote {

	private String type;
	private Value value;
	
	
	
	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Value getValue() {
		return value;
	}



	public void setValue(Value value) {
		this.value = value;
	}

@Override
public String toString() {
	String quote = this.type+this.value.getId() + this.value.getQuote();
	return quote;
}

	public class Value{
		String id;
		String quote;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getQuote() {
			return quote;
		}
		public void setQuote(String quote) {
			this.quote = quote;
		}
		
	}
}
