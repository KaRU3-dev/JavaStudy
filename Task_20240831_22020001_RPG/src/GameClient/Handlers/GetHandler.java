package GameClient.Handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import GameClient.Annotations.HttpGet;

/**
 * The class of execute HttpGet annotation method.
 *
 * This handler is accessed if the request method is GET and the path matches
 * the path specified in the HttpGet annotation.
 *
 *
 * <pre>
 * &#64;HttpGet("/path")
 * public String get() {
 *     return "Hello, World!";
 * }
 * </pre>
 *
 * @HttpGet url
 *
 * @author FCA22020001
 */
public class GetHandler implements HttpHandler {
    // Convert to Method
    private final Method controller;

    public GetHandler(Method controller) {
        this.controller = controller;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Get the method name from the request
        String method = exchange.getRequestMethod();

        // If the method is not GET, return a 405 Method Not Allowed response
        if (!method.equals("GET")) {
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
        if (controller.isAnnotationPresent(HttpGet.class)) {
            HttpGet annotation = controller.getAnnotation(HttpGet.class);
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
