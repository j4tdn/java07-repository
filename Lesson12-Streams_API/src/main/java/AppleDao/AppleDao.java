package AppleDao;

import java.util.List;

import beans.Apple;

public interface AppleDao {
	public <T> List<T> getAll();
}
