package hackclient.rise;

public final class aan extends aaj {
    public aan() {
        super(aak.REPETITIVE, false);
    }

    @Override
    public boolean check() {
        System.setProperty("http.ProxyHost", "");
        System.setProperty("https.ProxyHost", "");
        System.setProperty("http.ProxyPort", "");
        System.setProperty("https.ProxyPort", "");
        return false;
    }
}
