package wikisearch;

public class ArticleNode {

	/*	//THIS IS AN EXAMPLE GETTER AND SETTER
	private String myField; //"private" means access to this is restricted
	public String getMyField()
	{
	     //include validation, logic, logging or whatever you like here
	    return this.myField;
	}
	public void setMyField(String value)
	{
	     //include more logic
	     this.myField = value;
	}*/
	
	private String title;
	public String getTitle()
	{
		return this.title;
	}
	public void setTitle(String value)
	{
		this.title = value;
	}
	
	private int distance;
	public int getDistance()
	{
		return this.distance;
	}
	public void setDistance(int value)
	{
		this.distance = value;
	}
	
	private String predecessor;
	public String getPredecessor()
	{
		return this.predecessor;
	}
	public void setPredecessor(String value)
	{
		this.predecessor = value;
	}
	
	private String color = "White";
	public String getColor()
	{
		return this.color;
	}
	public void setColor()
	{
		if (color == "White")
		{
			color = "Gray";
		} 
		else if (color == "Gray")
		{
			color = "Black";
		}
		
	}
}
