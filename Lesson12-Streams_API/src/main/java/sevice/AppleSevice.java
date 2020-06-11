package sevice;

import java.util.List;

import beans.Apple;

public interface AppleSevice {
	// interface access modifier default : public
	public <T> List<T> getAll();
	
	public <T> List<T> filter(List<Apple> inventory );
}
