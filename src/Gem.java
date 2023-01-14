import java.awt.Font;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{	
	private GemType type;
	private int points;

	public Gem() {
		switch ((int)(Math.random() * 3)) { // randomly assign a GemType
			case 0:
				type = GemType.GREEN;
				break;

			case 1:
				type = GemType.BLUE;
				break;

			case 2:
				type = GemType.ORANGE;
				break;
		}
		points = (int)(Math.random() * 11) * 5; // randomly assign a point value
	}

	public Gem(GemType color, int points) {
		this.type = color;
		this.points = points;
	}

	public GemType getType() {
		return type;
	}

	public int getPoints() {
		return points;
	}

	public void draw(double x, double y) {
		StdDraw.setPenColor(StdDraw.WHITE);

		StdDraw.picture(x, y, "gem_" + type.toString().toLowerCase() + ".png");
		StdDraw.text(x, y, "" + points);
	}
	
	public String toString() {
		return type + " " + points;
	}


	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 15;
		
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw((double) i / maxGems, 0.5);
		}
	}
}
