import org.json.JSONArray;

/**
 * Used for paring XML.
 * You have to add JRE Library org.json
 * Download link: https://code.google.com/p/quick-json/
 * @author Prashanth Sandela
 * @External_Jars quick-json-parser.
 *
 */
public class Json_Parser {
	public static void main(String args[])
	{
		String url = "http://spudsusa.x10host.com/spuds/product?build_your_own=0&product_id=1";
		String data = General.br_toString(General.readurl(url));
		
		JSONArray root = new JSONArray(data);
		
		for(int i = 0; i < root.length(); i++)
		{
			String product_id = root.getJSONObject(i).getString("id");
			String product_name = root.getJSONObject(i).getString("product_name");
			String image_path = root.getJSONObject(i).getString("image_path");
			String free_toppings = root.getJSONObject(i).getString("free_toppings");
			JSONArray category = (JSONArray) root.getJSONObject(i).get("category");
			
			for(int j = 0; j < category.length(); j++)
			{
				String category_name = category.getJSONObject(i).getString("category_name");
				String max_toppings = category.getJSONObject(i).getString("max_count");
				
				JSONArray toppings = (JSONArray) category.getJSONObject(i).get("toppings");
				
				for(int k = 0; k < toppings.length(); k++)
				{
					String topping_id = toppings.getJSONObject(k).getString("id");
					String topping_name = toppings.getJSONObject(k).getString("name");
					String cost = toppings.getJSONObject(k).getString("cost");
				}
				
			}
			
			System.out.println(product_id);
		}
	}
}
