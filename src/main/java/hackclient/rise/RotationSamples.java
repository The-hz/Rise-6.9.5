package hackclient.rise;

public class RotationSamples {
    public static IndexedEvictingList<RotationSample> ZI = new IndexedEvictingList<>(10);
    public static IndexedEvictingList<RotationSample> ZJ = new IndexedEvictingList<>(10);

    public RotationSamples() {
    }
}
