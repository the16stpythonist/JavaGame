package bin;

public class GeometricObject {
	public Vertex position;
	public double width;
	public double height;
	
	public GeometricObject(Vertex pos, double h, double w){
		position = pos;
		height = h;
		width = w;
		
		if (height<0){
			height = -height;
			pos.y = pos.y - height;
		}
		
		if (width<0){
			width = -width;
			pos.x = pos.x - width;
		}
	}
	
	public GeometricObject(double h, double w){
		this(new Vertex(0, 0), h, w);
	}
	
	public GeometricObject(double w){
		this(new Vertex(0, 0), w, w);
	}
	
	public String toString(){
		return "width="+width+" height="+height+" pos="+position.toString();
	}
	
	public double circumference(){
		return (2*(width*height));
	}
	
	public double area(){
		return height*width;
	}
	
	public boolean contains(Vertex v){
		boolean inwidth = v.x >= position.x && v.x <= position.x + width;
		boolean inheight = v.y >= position.x && v.y <= position.y + height;
		return inwidth && inheight;
	}
	
	public boolean isLargerThan(GeometricObject obj){
		return this.area() > obj.area();
	}
	
	public boolean isSmallerThan(GeometricObject obj){
		return this.area() < obj.area();
	}
	
	public void moveTo(Vertex v){
		position = v;
	}
	
	public void moveTo(double x, double y){
		position = new Vertex(x, y);
	}
	
	public void move(Vertex v){
		position.addMod(v);
	}
	
	public boolean equals(Object obj){
		if(obj instanceof GeometricObject){
			GeometricObject geo = (GeometricObject) obj;
			if((height == geo.height) && (width == geo.width)){
				if(position.equals(geo.position)){
					return true;
				} else {return false;}
			} else {return false;}
		} else {return false;}
	}
	
	
	
}
