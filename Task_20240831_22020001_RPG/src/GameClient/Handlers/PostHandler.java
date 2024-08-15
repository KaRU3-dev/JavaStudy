package GameClient.Handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import GameClient.Annotations.HttpPost;

/**
 * The class of execute HttpPost annotation method.
 *
 * This handler is accessed if the request method is Post and the path matches
 * the path specified in the HttpPost annotation.
 *
 *
 * <pre>
 * &#64;HttpPost("/path")
 * public String post() {
 *     return "Hello, World!";
 * }
 * </pre>
 *
 * @HttpPost url
 *
 * @author FCA22020001
 */
public class PostHandler implements HttpHandler {
    private final Method controller;

    public PostHandler(Method controller) {
        this.controller = controller;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Get the method name from the request
        String method = exchange.getRequestMethod();

        // If the method is not GET, return a 405 Method Not Allowed response
        if (!method.equals("POST")) {
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
        if (controller.isAnnotationPresent(HttpPost.class)) {
            HttpPost annotation = controller.getAnnotation(HttpPost.class);
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
