package hackclient.rise;

import java.util.HashMap;
import lombok.Generated;

public enum ahc {
    EN_US("en_US"),
    FR_FR("fr_FR"),
    ES_ES("es_ES"),
    SV_SE("sv_SE"),
    PL_PL("pl_PL"),
    RU_RU("ru_RU"),
    ZH_ZH("zh_ZH");

    private final String file;
    private final HashMap<String, String> strings = new HashMap<>();
    private static final ahc[] $VALUES = uG();

    @Generated
    public String getFile() {
        return this.file;
    }

    @Generated
    public HashMap<String, String> getStrings() {
        return this.strings;
    }

    @Generated
    ahc(String var3) {
        this.file = var3;
    }

    private static ahc[] uG() {
        return new ahc[]{EN_US, FR_FR, ES_ES, SV_SE, PL_PL, RU_RU, ZH_ZH};
    }
}
