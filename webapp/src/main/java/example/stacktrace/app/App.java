package example.stacktrace.app;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(AppConfiguration configuration,
                    Environment environment) {
        final TestResource resource = new TestResource();
        environment.jersey().register(resource);
    }

}