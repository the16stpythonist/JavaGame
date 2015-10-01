package bin;


public class Vertex {

	public double x;
	public double y;
	
	public Vertex(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	
	public String toString(){
		return "("+x+","+y+")";
		}
	
	public double length() {
		return Math.sqrt(x*x+y*y);
	 }
	
	public Vertex skalarMult(double s){
		return new Vertex(x*s, y*s);
	}
	
	public void skalarMultiMod(double s){
	  x=x*s;
	  y=y*s;
	}
	
	public Vertex add(Vertex v2){
		return new Vertex(x+v2.x,y+v2.y);
	}
	
	public Vertex sub(Vertex v2){
		return new Vertex(x-v2.x,y-v2.y);
	}
		
	public void addMod(Vertex v2){
		x=x+v2.x;
		y=y+v2.y;
	}
	
	public void subMod(Vertex v2){
		x=x-v2.x;
		y=y-v2.y;
	}
	
	public Vertex normalized(){
	  	return new Vertex(this.x/this.length(), this.y/this.length());
	 }
	
	public void normalizedMod(){
		double factor = 1/length();
		x = factor * x;
		y = factor * y;
	}
	
	public double distance(Vertex v2){
		double xx=v2.x-this.x;
		double yy=v2.y-this.x;
				
		return Math.sqrt(xx*xx+yy*yy);
	 }
	
	
	public boolean equals(Object thatObject){
		if(thatObject instanceof Vertex){
			Vertex that = (Vertex)thatObject;
			
			return this.x==that.x && this.y == that.y;
		 }
		return false;
		}
}