package ru.u26c2.vertx.book.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class HelloMicroservice extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.get("/").handler(rc -> rc.response().end("hello"));
        router.get("/:name").handler(rc -> rc.response().end("hello " + rc.pathParam("name")));

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(9090);
    }
}
