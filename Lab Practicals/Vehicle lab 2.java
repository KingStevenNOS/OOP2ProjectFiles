public abstract class Vehicle{
	// attributes
	String fueltype;
	
	public void accelerate(int a){
		System.out.println("Vehicle accelerates by: "+a);
	};
	public abstract void stop();
	public abstract void gas();
	
	public static void main(String[] args){
		Sedan car = new Sedan();
		car.accelerate(5);//Overidden
		car.accelerate(5.0);//Overloaded
	}
}

interface Automobile{ // an interface cannot extend a class
	int NoOfWheels=4; // attributes in interfaces are public, static, final
	public boolean airconditioning();
}

class Sedan extends Vehicle implements Automobile{
	
	@Override
	public void accelerate(int a){//for overriding
		System.out.println("Sedan accelerates by: "+a);
	}
	
	public void accelerate(double a){//for overloading
		System.out.println("Sedan accelerates by: "+a+" but this time it's double.");
	}
	
	public void stop(){
	System.out.println("Sedan stop");
	}
	
	public void gas(){
		System.out.println("Sedan gas");
	}
	
	public boolean airconditioning(){
		return true;
	}
}

class SportsCar extends Vehicle implements Automobile{

	public void stop(){
	System.out.println("LuxuryCar stop");
	}
	
	public void gas(){
		System.out.println("LuxuryCar gas");
	}
	
	public boolean airconditioner(){
		return false;
	}
}

class Motorcycle extends Vehicle{
	public void stop(){
	System.out.println("Motorbike stop");
	}
	
	public void gas(){
		System.out.println("Motorbike gas");
	}
}
 
 class Bus extends Vehicle{
	public void stop(){
	System.out.println("Bus stop");
	}
	
	public void gas(){
		System.out.println("Bus gas");
	}
 }
 
 class SchoolBus extends Bus{
 }
 
 class MetroBus extends Bus{
 }