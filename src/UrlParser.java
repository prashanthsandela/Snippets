import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class UrlParser {
	String htmldata;

	UrlParser() {
	}

	public String getTagData(String htmldata, String requiredTag) {
		Document doc = Jsoup.parse(htmldata);
		return doc.select(requiredTag).text();
	}
}
