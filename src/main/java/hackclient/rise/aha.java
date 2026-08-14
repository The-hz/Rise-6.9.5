package hackclient.rise;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public interface aha {
    Executor aMR = Executors.newFixedThreadPool(Math.max(1, Math.min(2, Runtime.getRuntime().availableProcessors() - 1)));
}
