//written by Christian Wolff
public class Sheep implements Comparable<Sheep>{
	String name;
	int sheerTime;
	int arrivalTime;
	public Sheep(){
		this.name = "none";
		this.sheerTime = 1;
		this.arrivalTime = 0;
	}
	public Sheep(String aN, int sT, int aT) {
		setName(aN);
		setSheerTime(sT);
		setArrivalTime(aT);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null) {
			setName("none");
		}else
			this.name = name;
	}
	public int getSheerTime() {
		return sheerTime;
	}
	public void setSheerTime(int sheerTime) {
		if(sheerTime<1)
			sheerTime =1;
		this.sheerTime = sheerTime;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		if(arrivalTime<0)
			arrivalTime = 0;
		this.arrivalTime = arrivalTime;
	}
	public int compareTo(Sheep other) {
		if(this.getSheerTime() > other.getSheerTime())
			return 1;
		else if(this.getSheerTime() < other.getSheerTime())
			return -1;
		else
			return this.getName().compareTo(other.getName());//built in string compare to
	}
	public String toString() {
		return "Name: " + this.getName() + ", Shear Time: " + this.getSheerTime() + ", Arrival Time: " + this.getArrivalTime();
	}
}
