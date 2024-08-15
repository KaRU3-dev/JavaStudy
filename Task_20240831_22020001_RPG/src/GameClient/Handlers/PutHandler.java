package GameClient.Handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import GameClient.Annotations.HttpPut;

/**
 * The class of execute HttpPut annotation method.
 *
 * This handler is accessed if the request method is PUT and the path matches
 * the path specified in the HttpPut annotation.
 *
 *
 * <pre>
 * &#64;HttpPut("/path")
 * public String put() {
 *     return "Hello, World!";
 * }
 * </pre>
 *
 * @HttpPut url
 *
 * @author FCA22020001
 */
public class PutHandler implements HttpHandler {
    private final Method controller;

    public PutHandler(Method controller) {
        this.controller = controller;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Get the method name from the request
        String method = exchange.getRequestMethod();

        // If the method is not GET, return a 405 Method Not Allowed response
        if (!method.equals("PUT")) {
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
        if (controller.isAnnotationPresent(HttpPut.class)) {
            HttpPut annotation = controller.getAnnotation(HttpPut.class);
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
