package GameClient.Handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import GameClient.Annotations.HttpDelete;

/**
 * The class of execute HttpDelete annotation method.
 *
 * This handler is accessed if the request method is Delete and the path matches
 * the path specified in the HttpDelete annotation.
 *
 *
 * <pre>
 * &#64;HttpDelete("/path")
 * public String delete() {
 *     return "Hello, World!";
 * }
 * </pre>
 *
 * @HttpDelete url
 *
 * @author FCA22020001
 */
public class DeleteHandler implements HttpHandler {
    private final Method controller;

    public DeleteHandler(Method controller) {
        this.controller = controller;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Get the method name from the request
        String method = exchange.getRequestMethod();

        // If the method is not GET, return a 405 Method Not Allowed response
        if (!method.equals("DELETE")) {
            exchange.sendResponseHeaders(405, -1);
            exchange.close();
            return;
        }

        String response = handleHttpGet(exchange);
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    // Handle GET annotation method
    private String handleHttpGet(HttpExchange exchange) {
        if (controller.isAnnotationPresent(HttpDelete.class)) {
            HttpDelete annotation = controller.getAnnotation(HttpDelete.class);
            String annotatedMethod = annotation.method();

            if (annotatedMethod.equals(exchange.getRequestURI().getPath())) {
                try {
                    return (String) controller.invoke(controller);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    return "500 Internal Server Error";
                }
            }
        }
        return "404 Not Found";
    }
}
