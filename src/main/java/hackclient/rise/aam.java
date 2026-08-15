package hackclient.rise;

import com.alan.clients.Client;
import java.lang.reflect.Method;

public final class aam extends aaj {
    private static final String[] CLASS_NAMES = new String[]{
        "sun.instrument.InstrumentationImpl",
        "java.lang.instrument.Instrumentation",
        "java.lang.instrument.ClassDefinition",
        "java.lang.instrument.ClassFileTransformer",
        "java.lang.instrument.IllegalClassFormatException",
        "java.lang.instrument.UnmodifiableClassException"
    };
    private final Method findLoadedClassMethod;

    public aam() throws NoSuchMethodException {
        super(aak.REPETITIVE, true);

        try {
            this.findLoadedClassMethod = ClassLoader.class.getDeclaredMethod("findLoadedClass0", String.class);
        } catch (Throwable throwable) {
            throw throwable;
        }
    }

    @Override
    public boolean check() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        ClassLoader classloader = ClassLoader.getSystemClassLoader();

        for (String s : CLASS_NAMES) {
            if (this.findLoadedClassMethod.invoke(classloader, s) != null) {
                Client.a.f().oc();
                return true;
            }
        }

        return false;
    }
}
