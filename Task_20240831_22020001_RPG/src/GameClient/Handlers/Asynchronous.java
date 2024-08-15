package GameClient.Handlers;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Asynchronous {

    private static final ExecutorService executor = Executors.newFixedThreadPool(50);

    /**
     * Execute a method asynchronously
     *
     * @param method
     * @return Object
     */
    public static Object executeAsync(Method method) {
        // Get parameters
        Object[] parameters = new Object[method.getParameterCount()];
        for (int i = 0; i < method.getParameterCount(); i++) {
            parameters[i] = null;
        }

        // Get return type
        Class<?> returnType = method.getReturnType();

        // Execute method
        Future<?> future = executor.submit(() -> {
            if (returnType == Void.TYPE) {
                try {
                    method.invoke(parameters);
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } else {
                try {
                    return method.invoke(parameters);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });

        // Get result
        try {
            return future.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
