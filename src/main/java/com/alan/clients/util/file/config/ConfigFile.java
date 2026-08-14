package com.alan.clients.util.file.config;

import com.alan.clients.Client;
import com.alan.clients.module.Module;
import com.alan.clients.module.impl.render.ClickGUI;
import com.alan.clients.util.file.File;
import com.alan.clients.util.file.FileType;
import com.alan.clients.value.Mode;
import com.alan.clients.value.Value;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.BoundsNumberValue;
import com.alan.clients.value.impl.ColorValue;
import com.alan.clients.value.impl.DragValue;
import com.alan.clients.value.impl.ListValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.StringValue;
import com.google.gson.JsonObject;
import hackclient.rise.ahc;
import hackclient.rise.ahd;
import hackclient.rise.cg;
import hackclient.rise.ev;
import hackclient.rise.p;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Generated;
import rip.vantage.commons.packet.impl.client.protection.e;
import rip.vantage.network.core.a;

public class ConfigFile extends File implements p {
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd.MM.yyyy");
    private boolean aHK;
    private String gK;
    private int keyCode;

    public ConfigFile(java.io.File var1, FileType var2, String var3) {
        super(var1, var2);
        this.gK = var3;
    }

    public ConfigFile(java.io.File var1, FileType var2) {
        super(var1, var2);
    }

    @Override
    public boolean te() {
        if (!this.sK().exists()) {
            return false;
        }

        try {
            FileReader filereader = new FileReader(this.sK());
            BufferedReader bufferedreader = new BufferedReader(filereader);
            JsonObject jsonobject = this.A().fromJson(bufferedreader, JsonObject.class);
            bufferedreader.close();
            filereader.close();
            if (jsonobject == null) {
                return false;
            }

            e(jsonobject);
            if (Client.a.p().mQ().T(1000L)) {
                a.aKB().aKK().sendMessage(new e(jsonobject.toString()).aJk());
                Client.a.p().mQ().aX();
            }
        } catch (IOException ioexception) {
            return false;
        }

        Client.a.e().d(new ev());
        if (this.gK != null) {
            cg.e("Config", "Loaded " + this.gK + " config");
        }

        return true;
    }

    private static void e(JsonObject var0) {
        if (var0 != null) {
            for (Module module : Client.a.g().ef()) {
                if (module != null && module.getModuleInfo() != null) {
                    String s = module.getModuleInfo().aliases()[0];
                    if (!var0.has(s)) {
                        String s1 = null;

                        for (ahc ahc : ahc.values()) {
                            String s2 = ahd.a(s, ahc);
                            if (s2 != null && !s2.equals(s) && var0.has(s2)) {
                                s1 = s2;
                                break;
                            }
                        }

                        if (s1 != null) {
                            var0.add(s, var0.get(s1));
                            var0.remove(s1);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean tf() {
        try {
            this.sK().createNewFile();
            JsonObject jsonobject = b(this.aHK, true);
            FileWriter filewriter = new FileWriter(this.sK());
            BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
            this.A().toJson(jsonobject, bufferedwriter);
            bufferedwriter.flush();
            bufferedwriter.close();
            return true;
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
            return false;
        }
    }

    public static JsonObject b(boolean var0, boolean var1) {
        JsonObject jsonobject = new JsonObject();
        if (var1) {
            JsonObject jsonobject1 = new JsonObject();
            jsonobject1.addProperty("version", "6");
            jsonobject1.addProperty("creationDate", DATE_FORMATTER.format(new Date()));
            jsonobject.add("Metadata", jsonobject1);
        }

        for (Module module : Client.a.g().ef()) {
            JsonObject jsonobject2 = new JsonObject();
            if (!(module instanceof ClickGUI)) {
                jsonobject2.addProperty("state", module.isEnabled());
            }

            if (var0) {
                jsonobject2.addProperty("keyCode", module.getKey());
            }

            for (Value value : module.getAllValues()) {
                JsonObject jsonobject3 = new JsonObject();
                if (value instanceof ModeValue modevalue) {
                    if (modevalue.wo() == null) {
                        continue;
                    }

                    jsonobject3.addProperty("value", modevalue.wo().getName());
                } else if (value instanceof BooleanValue booleanvalue) {
                    jsonobject3.addProperty("value", booleanvalue.wo());
                } else if (value instanceof NumberValue numbervalue) {
                    jsonobject3.addProperty("value", numbervalue.wo().doubleValue());
                } else if (value instanceof StringValue stringvalue) {
                    String s1 = stringvalue.wo();
                    String s2 = s1.replace("%", "<percentsign>");
                    jsonobject3.addProperty("value", s2);
                } else if (value instanceof BoundsNumberValue boundsnumbervalue) {
                    jsonobject3.addProperty("first", boundsnumbervalue.wo().doubleValue());
                    jsonobject3.addProperty("second", boundsnumbervalue.wA().doubleValue());
                } else if (value instanceof ColorValue colorvalue) {
                    jsonobject3.addProperty("red", colorvalue.wo().getRed());
                    jsonobject3.addProperty("green", colorvalue.wo().getGreen());
                    jsonobject3.addProperty("blue", colorvalue.wo().getBlue());
                    jsonobject3.addProperty("alpha", colorvalue.wo().getAlpha());
                } else if (value instanceof DragValue dragvalue) {
                    jsonobject3.addProperty("positionX", dragvalue.apP.x);
                    jsonobject3.addProperty("positionY", dragvalue.apP.y);
                    jsonobject3.addProperty("scaleX", dragvalue.aHe.x);
                    jsonobject3.addProperty("scaleY", dragvalue.aHe.y);
                } else if (value instanceof ListValue listvalue) {
                    if (listvalue.wo() == null) {
                        continue;
                    }

                    jsonobject3.addProperty("value", listvalue.wo().toString());
                }

                String s = value.wq() != null
                    ? (value.wq() instanceof Module ? ((Module)value.wq()).getModuleInfo().aliases()[0] + " Module" : ((Mode)value.wq()).getName() + " Mode")
                    : "Unknown";
                jsonobject2.add(value.getName() + " in " + s, jsonobject3);
            }

            jsonobject.add(module.getModuleInfo().aliases()[0], jsonobject2);
        }

        jsonobject.addProperty("theme", Client.a.k().rz().name());
        return jsonobject;
    }

    public static JsonObject d(java.io.File var0) {
        if (var0 != null && var0.exists()) {
            try (
                FileReader filereader = new FileReader(var0);
                BufferedReader bufferedreader = new BufferedReader(filereader);
            ) {
                return Client.a.A().fromJson(bufferedreader, JsonObject.class);
            } catch (Throwable throwable) {
                return null;
            }
        } else {
            return null;
        }
    }

    public void tm() {
        this.aHK = true;
    }

    @Override
    public int getKey() {
        return this.keyCode;
    }

    @Override
    public void onKey() {
        this.te();
    }

    @Override
    public String[] getAliases() {
        return new String[]{this.getName()};
    }

    @Override
    public String getName() {
        return this.gK;
    }

    @Generated
    @Override
    public void setKey(int var1) {
        this.keyCode = var1;
    }
}
