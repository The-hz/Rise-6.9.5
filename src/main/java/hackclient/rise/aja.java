package hackclient.rise;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL20;

public class aja {
    public aja() {
    }

    public static void a(int var0, String var1, FloatBuffer var2) {
        GL20.glUniform1(b(var0, var1), var2);
    }

    public static void a(int var0, String var1, int var2) {
        GL20.glUniform1i(b(var0, var1), var2);
    }

    public static void a(int var0, String var1, int var2, int var3) {
        GL20.glUniform2i(b(var0, var1), var2, var3);
    }

    public static void a(int var0, String var1, float var2) {
        GL20.glUniform1f(b(var0, var1), var2);
    }

    public static void a(int var0, String var1, float var2, float var3) {
        GL20.glUniform2f(b(var0, var1), var2, var3);
    }

    public static void a(int var0, String var1, float var2, float var3, float var4) {
        GL20.glUniform3f(b(var0, var1), var2, var3, var4);
    }

    public static void a(int var0, String var1, float var2, float var3, float var4, float var5) {
        GL20.glUniform4f(b(var0, var1), var2, var3, var4, var5);
    }

    private static int b(int var0, String var1) {
        return GL20.glGetUniformLocation(var0, var1);
    }
}
