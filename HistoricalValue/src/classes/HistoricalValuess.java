package classes;

public class HistoricalValuess {
	
	private String Who;
	private String Where;
	private String When;
	
	public HistoricalValuess(String [] args) {
		this.Who = args[0];
		this.When = args[1];
		//String[] words = args[1].split(" ");
		//this.name = null;
		//if(words.length > 0) this.name = words[0];
	}

	public String getWho() {
		return Who;
	}

	public void setWho(String who) {
		Who = who;
	}

	public String getWhere() {
		return Where;
	}

	public void setWhere(String where) {
		Where = where;
	}

	public String getWhen() {
		return When;
	}

	public void setWhen(String when) {
		When = when;
	}
	

}