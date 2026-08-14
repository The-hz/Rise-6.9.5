package com.alan.clients.command.impl;

import com.alan.clients.Client;
import com.alan.clients.command.Command;
import com.alan.clients.compat.NetworkToggles;
import com.alan.clients.script.ScriptManager;
import com.alan.clients.util.file.FileType;
import com.alan.clients.util.file.config.ConfigFile;
import hackclient.rise.afi;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class Script extends Command {
    public Script() {
        super("command.script.description", "script", "scripts", "js");
    }

    @Override
    public void execute(String[] var1) {
        if (var1.length < 2) {
            this.error("Valid actions are load, reload, unload, disablesecurity, folder and enablesecurity");
        } else {
            String s = var1[1].toLowerCase(Locale.getDefault());
            ScriptManager scriptmanager = Client.a.l();
            com.alan.clients.script.Script script;
            if (var1.length > 3) {
                script = scriptmanager.getScript(var1[2]);
                if (script == null) {
                    afi.b("command.script.notfound", var1[2]);
                    return;
                }
            } else {
                script = null;
            }

            try {
                label108: {
                    label122: {
                        label125: {
                            label103: {
                                label102: {
                                    label101: {
                                        label100: {
                                            String s1 = s;
                                            byte b0 = -1;
                                            switch (s1.hashCode()) {
                                                case -1829555672:
                                                    if (s1.equals("disablesecurity")) {
                                                        break label108;
                                                    }
                                                    break;
                                                case -1268966290:
                                                    if (s1.equals("folder")) {
                                                        b0 = 7;
                                                    }
                                                    break;
                                                case -934641255:
                                                    if (s1.equals("reload")) {
                                                        break label102;
                                                    }
                                                    break;
                                                case -840442113:
                                                    if (s1.equals("unload")) {
                                                        break label101;
                                                    }
                                                    break;
                                                case 3327206:
                                                    if (s1.equals("load")) {
                                                        break label100;
                                                    }
                                                    break;
                                                case 1228368323:
                                                    if (s1.equals("enablesecurity")) {
                                                        break label122;
                                                    }
                                                    break;
                                                case 1427818632:
                                                    if (s1.equals("download")) {
                                                        break label125;
                                                    }
                                                    break;
                                                case 1957569947:
                                                    if (s1.equals("install")) {
                                                        break label125;
                                                    }
                                            }

                                            switch (b0) {
                                                case 0:
                                                    break;
                                                case 1:
                                                    break label102;
                                                case 2:
                                                    break label101;
                                                case 3:
                                                    break label108;
                                                case 4:
                                                    break label122;
                                                case 5:
                                                case 6:
                                                    break label125;
                                                case 7:
                                                    try {
                                                        Desktop desktop = Desktop.getDesktop();
                                                        File file1 = new File(String.valueOf(ScriptManager.SCRIPT_DIRECTORY));
                                                        desktop.open(file1);
                                                        afi.b("command.script.folder");
                                                    } catch (IllegalArgumentException | IOException illegalargumentexception) {
                                                        afi.b("command.script.notfoundfolder");
                                                    }

                                                    return;
                                                default:
                                                    afi.b(
                                                        "command.script.unknownaction",
                                                        "Valid actions are load, reload, unload, disablesecurity and enablesecurity"
                                                    );
                                                    return;
                                            }
                                        }

                                        if (script == null) {
                                            scriptmanager.loadScripts();
                                        } else {
                                            script.load();
                                        }
                                        break label103;
                                    }

                                    if (script == null) {
                                        scriptmanager.unloadScripts();
                                    } else {
                                        script.unload();
                                    }
                                    break label103;
                                }

                                Client.a.l().reloadScripts();
                                Client.a.v().moduleList = new ConcurrentLinkedQueue<>();
                            }

                            afi.b("Successfully " + s + "ed " + (script == null ? "all scripts" : "\"" + script.getName() + "\"") + ".");
                            return;
                        }

                        //add code
                        if (!NetworkToggles.remoteScripts()) {
                            afi.b("Remote script download is off (plain HTTP to a bare IP).");
                            afi.b("Start the client with -Drise.net.remotescripts=true to allow it.");
                            return;
                        }

                        new Thread(
                                () -> {
                                    try {
                                        HttpURLConnection httpurlconnection = (HttpURLConnection)new URL("http://165.22.2.247/getscript?id=" + var1[2])
                                            .openConnection();
                                        httpurlconnection.addRequestProperty(
                                            "User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0"
                                        );
                                        httpurlconnection.addRequestProperty("rise", ">astolfo");
                                        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
                                        ArrayList arraylist = new ArrayList();

                                        String s2;
                                        while ((s2 = bufferedreader.readLine()) != null) {
                                            arraylist.add(s2);
                                        }

                                        new ConfigFile(new File(ScriptManager.SCRIPT_DIRECTORY + File.separator + var1[2] + ".js"), FileType.CONFIG, var1[2])
                                            .a(ScriptManager.SCRIPT_DIRECTORY + File.separator + var1[2] + ".js", arraylist);
                                        afi.b("Installed the Script!");
                                        afi.b("Use .script reload, to reload scripts");
                                    } catch (Throwable throwable) {
                                        throwable.printStackTrace();
                                    }
                                }
                            )
                            .start();
                        return;
                    }

                    scriptmanager.setSecurityMeasures(true);
                    afi.b("command.script.enablesecurity");
                    return;
                }

                scriptmanager.setSecurityMeasures(false);
                afi.b("command.script.disablesecurity");
            } catch (Exception exception) {
                exception.printStackTrace();
                afi.b("Failed to " + s + " a script. Stacktrace printed.");
            }
        }
    }
}
