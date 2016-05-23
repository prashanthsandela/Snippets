import java.io.IOException;
import java.net.MalformedURLException;

public class DomainAvailability {

	private String domain;
	private boolean isAvailable;

	DomainAvailability() {
	}

	DomainAvailability(String domain) throws MalformedURLException, IOException {
		this.domain = domain;
		this.isAvailable = checkAvailability(domain);
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	private boolean checkAvailability(String domain) throws MalformedURLException, IOException {

		String data = new UrlData("http://who.is/whois/name_search/desikilkilli.com/").getData();
		data = new UrlParser().getTagData(data, "div[class=labelclass smallishfont lineheight24]");
		String req = data.split(" ")[0];

		if (req.equals("Available")) {
			return true;
		}

		return false;
	}

}
