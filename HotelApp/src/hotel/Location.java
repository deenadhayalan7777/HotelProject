package hotel;

public class Location {
private int x,y;

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

}
