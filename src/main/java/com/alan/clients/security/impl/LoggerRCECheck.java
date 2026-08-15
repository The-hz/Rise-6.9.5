package com.alan.clients.security.impl;

import com.alan.clients.security.a;
import java.util.regex.Pattern;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S29PacketSoundEffect;
import net.minecraft.network.play.server.c;
import net.minecraft.util.IChatComponent;

public final class LoggerRCECheck extends a {
    private static final Pattern PATTERN = Pattern.compile(".*\\$\\{[^}]*}.*");

    public LoggerRCECheck() {
        super("Log4J RCE Check", "Someone attempted to utilize the Log4J exploit");
    }

    @Override
    public boolean handle(Packet<?> var1) {
        if (var1 instanceof S29PacketSoundEffect) {
            String s = ((S29PacketSoundEffect)var1).getSoundName();
            return PATTERN.matcher(s).matches();
        }

        if (!(var1 instanceof c)) {
            return false;
        }

        IChatComponent ichatcomponent = ((c)var1).getChatComponent();
        return PATTERN.matcher(ichatcomponent.getUnformattedText()).matches() || PATTERN.matcher(ichatcomponent.getFormattedText()).matches();
    }
}
