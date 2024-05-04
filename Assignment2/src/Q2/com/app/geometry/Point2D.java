package Q2.com.app.geometry;

public class Point2D {
   private int x;
   private int y;
     
   public Point2D() {
	   this(1,1);
   }
   
    public Point2D(int x, int y) {
     	super();
	    this.x = x;
	    this.y = y;
}   //p1.calulateDistance(p2)
    public double calculateDistance(Point2D p)
    {
    	//√((x2 – x1)² + (y2 – y1)²)
    	return (Math.sqrt(Math.pow((Math.abs(p.x-this.x)), 2)+Math.pow((Math.abs(p.y-this.y)), 2)));
    }

	@Override
	public boolean equals(Object obj) {
		
		Point2D other = (Point2D) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "Point2D [X-Axis =" + x + ", Y-Axis=" + y + "]";
	}
   
	
   
}
