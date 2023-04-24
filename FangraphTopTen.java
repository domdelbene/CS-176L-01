import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FangraphTopTen {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Player> p2022 = new ArrayList<Player>();
		ArrayList<Player> p2021 = new ArrayList<Player>();
		ArrayList<Player> p2020 = new ArrayList<Player>();
		ArrayList<Player> totalPlayers = new ArrayList<Player>();
		ArrayList<Player> playersWith3Years = new ArrayList<Player>();
		ArrayList<Player> topPlayers = new ArrayList<Player>();
		String nameRow;
		String numRow;
		String nameAltRow;
		String numAltRow;
		int amountToDivideAvg;
		int index;
		int count;
		double min;
		
		Document doc = Jsoup.connect("https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2022&month=0&season1=2022&ind=0&page=2_130").timeout(6000).get();
		Elements body = doc.select("tbody");
		for(int i = 0; i < body.select("tr.rgRow").size(); i++) {
			nameRow = body.select("tr.rgRow").get(i).getElementsByTag("a").first().text();
			numRow = body.select("tr.rgRow").get(i).getElementsByTag("td").first().text();
			p2022.add(new Player(nameRow, Integer.parseInt(numRow)));
			nameAltRow = body.select("tr.rgAltRow").get(i).getElementsByTag("a").first().text();
			numAltRow = body.select("tr.rgAltRow").get(i).getElementsByTag("td").first().text();
			p2022.add(new Player(nameAltRow, Integer.parseInt(numAltRow)));
		}
		
		doc = Jsoup.connect("https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2021&month=0&season1=2021&ind=0&page=5_132").timeout(6000).get();
		body = doc.select("tbody");
		for(int i = 0; i < body.select("tr.rgRow").size(); i++) {
			nameRow = body.select("tr.rgRow").get(i).getElementsByTag("a").first().text();
			numRow = body.select("tr.rgRow").get(i).getElementsByTag("td").first().text();
			p2021.add(new Player(nameRow, Integer.parseInt(numRow)));
			nameAltRow = body.select("tr.rgAltRow").get(i).getElementsByTag("a").first().text();
			numAltRow = body.select("tr.rgAltRow").get(i).getElementsByTag("td").first().text();
			p2021.add(new Player(nameAltRow, Integer.parseInt(numAltRow)));
		}
		
		doc = Jsoup.connect("https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=y&type=8&season=2020&month=0&season1=2020&ind=0&page=5_142").timeout(6000).get();
		body = doc.select("tbody");
		for(int i = 0; i < body.select("tr.rgRow").size(); i++) {
			nameRow = body.select("tr.rgRow").get(i).getElementsByTag("a").first().text();
			numRow = body.select("tr.rgRow").get(i).getElementsByTag("td").first().text();
			p2020.add(new Player(nameRow, Integer.parseInt(numRow)));
			nameAltRow = body.select("tr.rgAltRow").get(i).getElementsByTag("a").first().text();
			numAltRow = body.select("tr.rgAltRow").get(i).getElementsByTag("td").first().text();
			p2020.add(new Player(nameAltRow, Integer.parseInt(numAltRow)));
		}
		//These loops are adding all the Player objects to the totalPlayers array
		//Adding a new object allows the zeroNumber() method to work due to the method making the numbers zero in all the arrays in this class
		//Making the number zero allows upcoming loops to calculate the total from p2020, p2021, and p2022
		for(Player e : p2020) { 
			totalPlayers.add(new Player(e.getName(), 0));
		}
		for(Player e : p2021) {
			totalPlayers.add(new Player(e.getName(), 0));
		}
		for(Player e : p2022) {
			totalPlayers.add(new Player(e.getName(), 0));
		}
		//These nested loops deletes repeated names and calculates the amount to divide the average
		for(int i = 0; i < totalPlayers.size(); i++) {
			String name = totalPlayers.get(i).getName();
			amountToDivideAvg = 1;
			for(int j = i + 1; j < totalPlayers.size()-1; j++) {
				if(name.equals(totalPlayers.get(j).getName())) {
					totalPlayers.remove(j);
					amountToDivideAvg++;
				}
			}
			totalPlayers.get(i).setQuantity(amountToDivideAvg);
		}
		//This loop will go through the totalPlayers array and find players with less than 3 appearances and add them to a new array (Removing from an arraylist is difficult)
		for(int i = 0; i < totalPlayers.size(); i++) {
			if(totalPlayers.get(i).getQuantity() == 3) {
				playersWith3Years.add(totalPlayers.get(i));
			}
		}
		//These nested loops total all the numbers for the different years
		for(int i = 0; i < playersWith3Years.size(); i++) {
			for(int x = 0; x < p2020.size(); x++) {
				if(playersWith3Years.get(i).getName().equals(p2020.get(x).getName())) {
					playersWith3Years.get(i).addTotal(p2020.get(x).getNumber());
				}
			}
			for(int y = 0; y < p2021.size(); y++) {
				if(playersWith3Years.get(i).getName().equals(p2021.get(y).getName())) {
					playersWith3Years.get(i).addTotal(p2021.get(y).getNumber());
				}
			}
			for(int z = 0; z < p2022.size(); z++) {
				if(playersWith3Years.get(i).getName().equals(p2022.get(z).getName())) {
					playersWith3Years.get(i).addTotal(p2022.get(z).getNumber());
				}
			}
		}
		//This loop calculates the average
		for(Player e : playersWith3Years) {
			e.calcAverage();
		}
		//These loops find the minimum values 10 times and adds them to the topPlayers array
		for(int i = 0; i < 10; i++) {
			min = playersWith3Years.get(0).getAverage();
			index = 0;
			for(int j = 0; j < playersWith3Years.size(); j++) {
				if(playersWith3Years.get(j).getAverage() < min) {
					min = playersWith3Years.get(j).getAverage();
					index = j;
				}
			}
			topPlayers.add(playersWith3Years.get(index));
			playersWith3Years.remove(index);
		}
		count = 1;
		for(Player e : topPlayers) {
			System.out.print(count + ". " + e.getName() + "\t");
			System.out.printf("Avg: %.1f\n", e.getAverage());
			count++;
		}
	}

}
