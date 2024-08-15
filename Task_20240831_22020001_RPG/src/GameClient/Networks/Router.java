package GameClient.Networks;

import java.lang.reflect.Method;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpServer;

import GameClient.Annotations.ApiRouter;
import GameClient.Annotations.HttpDelete;
import GameClient.Annotations.HttpGet;
import GameClient.Annotations.HttpPost;
import GameClient.Annotations.HttpPut;
import GameClient.Handlers.DeleteHandler;
import GameClient.Handlers.GetHandler;
import GameClient.Handlers.PostHandler;
import GameClient.Handlers.PutHandler;

public class Router {

    private ArrayList<GetHandler> getHandler;
    private ArrayList<PostHandler> postHandler;
    private ArrayList<PutHandler> putHandler;
    private ArrayList<DeleteHandler> deleteHandler;

    public Router(HttpServer server, String route, Object[] controllers, boolean asynchronous) {
        for (Object controller : controllers) {
            if (controller.getClass().isAnnotationPresent(ApiRouter.class)) {
                String routeName = controller.getClass().getAnnotation(ApiRouter.class).route();

                Method[] methods = controller.getClass().getMethods();

                for (Method method : methods) {
                    if (method.isAnnotationPresent(HttpGet.class)) {
                        String methodRoute = method.getAnnotation(HttpGet.class).method();
                        String finalRoute = route + routeName + methodRoute;

                        getHandler.add(new GetHandler(method));
                        server.createContext(finalRoute, getHandler.get(getHandler.size() - 1));
                    } else if (method.isAnnotationPresent(HttpPost.class)) {
                        String methodRoute = method.getAnnotation(HttpPost.class).method();
                        String finalRoute = route + routeName + methodRoute;

                        postHandler.add(new PostHandler(method));
                        server.createContext(finalRoute, postHandler.get(postHandler.size() - 1));
                    } else if (method.isAnnotationPresent(HttpPut.class)) {
                        String methodRoute = method.getAnnotation(HttpPut.class).method();
                        String finalRoute = route + routeName + methodRoute;

                        putHandler.add(new PutHandler(method));
                        server.createContext(finalRoute, putHandler.get(putHandler.size() - 1));
                    } else if (method.isAnnotationPresent(HttpDelete.class)) {
                        String methodRoute = method.getAnnotation(HttpDelete.class).method();
                        String finalRoute = route + routeName + methodRoute;

                        deleteHandler.add(new DeleteHandler(method));
                        server.createContext(finalRoute, deleteHandler.get(deleteHandler.size() - 1));
                    }
                }
            } else {
                throw new RuntimeException("Controller must have @ApiRouter annotation");
            }
        }
    }
}
