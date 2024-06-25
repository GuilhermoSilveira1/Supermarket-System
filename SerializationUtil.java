import java.util.ArrayList;
import java.util.List;

public class SerializationUtil {
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> castList(Object obj, Class<T> clazz) {
        ArrayList<T> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                if (clazz.isInstance(o)) {
                    result.add(clazz.cast(o));
                }
            }
        }
        return result;
    }
}
