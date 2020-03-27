package de.openaqua.ipsc.mail;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author pavan.solapure
 * 
 *         Stuff taken from https://github.com/pavansolapure/opencodez-samples
 *         https://www.opencodez.com/java/java-mail-framework-using-spring-boot.htm
 */
public class AppUtil {

	private AppUtil() {

	}

	public static String concatenate(List<String> listOfItems, String separator) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> stit = listOfItems.iterator();

		while (stit.hasNext()) {
			sb.append(stit.next());
			if (stit.hasNext()) {
				sb.append(separator);
			}
		}

		return sb.toString();
	}

	/**
	 * Checks if is collection empty.
	 *
	 * @param collection the collection
	 * @return true, if is collection empty
	 */
	private static boolean isCollectionEmpty(Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}

	/**
	 * Checks if is object empty.
	 *
	 * @param object the object
	 * @return true, if is object empty
	 */
	public static boolean isObjectEmpty(Object object) {
		if (object == null)
			return true;
		else if (object instanceof String) {
			if (((String) object).trim().length() == 0) {
				return true;
			}
		} else if (object instanceof Collection) {
			return isCollectionEmpty((Collection<?>) object);
		} else {
			return false;
		}
		return false;
	}
}
