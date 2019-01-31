package hotel;

public class Location {
private int x,y;
private int locationId;
private String name;

public Location(int locationId, String name,int x, int y) {
	
	this.x = x;
	this.y = y;
	this.locationId = locationId;
	this.name = name;
}

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}

public Location(int x, int y) {
	
	this.x = x;
	this.y = y;
}

public int getDistance(Location p)
{
   return Math.abs(p.getX()-x)+Math.abs(p.getY()-y);
  
}

public int getLocationId() {
	return locationId;
}

public void setLocationId(int locationId) {
	this.locationId = locationId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}
