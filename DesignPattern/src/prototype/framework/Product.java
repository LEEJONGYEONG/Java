package prototype.framework;

public interface Product {

	public abstract void use();
	public abstract Object createClone() throws CloneNotSupportedException;
	
}
