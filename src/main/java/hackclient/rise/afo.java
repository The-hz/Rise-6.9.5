package hackclient.rise;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

public class afo {
    @SerializedName("id")
    private final int aHn;
    @SerializedName("name")
    private final String aHo;
    @SerializedName("uuid")
    private final String aHp;
    @SerializedName("skins")
    private final afp[] aHq;
    @SerializedName("capes")
    private final afn[] aHr;

    public afo(int var1, String var2, String var3, afp[] var4, afn[] var5) {
        this.aHn = var1;
        this.aHo = var2;
        this.aHp = var3;
        this.aHq = var4;
        this.aHr = var5;
    }

    public int getId() {
        return this.aHn;
    }

    public String getName() {
        return this.aHo;
    }

    public String sh() {
        return this.aHp;
    }

    public afp[] tb() {
        return this.aHq;
    }

    public afn[] tc() {
        return this.aHr;
    }

    @Override
    public String toString() {
        return "DynamicAccountResult{id="
            + this.aHn
            + ", name='"
            + this.aHo
            + "', uuid='"
            + this.aHp
            + "', skins="
            + Arrays.toString(this.aHq)
            + ", capes="
            + Arrays.toString(this.aHr)
            + "}";
    }
}
