package predivate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import beans.Apple;
@FunctionalInterface

public interface ApplePredivate {
	boolean test(Apple apple); 
	boolean check (Apple apple) {
		return true;
	}
}
