package cars;

public interface CarDAO {
    public Car[] getCars(); 
    public abstract void addCar(Car car);
}
