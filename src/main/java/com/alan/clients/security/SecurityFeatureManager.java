package com.alan.clients.security;

import com.alan.clients.Client;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.ChatInputEvent;
import com.alan.clients.newevent.impl.motion.PreMotionEvent;
import com.alan.clients.newevent.impl.packet.PacketSendEvent;
import com.alan.clients.util.interfaces.InstanceAccess;
import hackclient.rise.aha;
import hackclient.rise.zh;
import hackclient.rise.zi;
import hackclient.rise.zj;
import hackclient.rise.zk;
import hackclient.rise.zl;
import hackclient.rise.zm;
import hackclient.rise.zn;
import hackclient.rise.zo;
import hackclient.rise.zp;
import hackclient.rise.zq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.network.play.client.C01PacketChatMessage;
import org.apache.commons.lang3.StringUtils;

public class SecurityFeatureManager implements InstanceAccess, aha {
    public rip.vantage.commons.util.time.a avt;
    @EventLink
    public Listener<ChatInputEvent> avy;
    public static long avp;
    public String avu;
    public List<SecurityFeature> avr;
    public long avv;
    public List<SecurityFeature> avq = new ArrayList<>();
    public static boolean avo;
    @EventLink
    public Listener<PreMotionEvent> avx;
    public boolean avw;
    @EventLink
    public Listener<PacketSendEvent> avz;
    public Set<String> avs;

    public void a(SecurityFeature var1) {
        this.avq.add(var1);
        Client.a.e().b(var1);
    }

    @Generated
    public List<SecurityFeature> nI() {
        return this.avq;
    }

    @Generated
    public List<SecurityFeature> nJ() {
        return this.avr;
    }

    public void b(SecurityFeature var1) {
        this.avr.add(var1);
        Client.a.e().b(var1);
    }

    @Generated
    public long nM() {
        return this.avv;
    }

    static {
    }

    @Generated
    public String nL() {
        return this.avu;
    }

    public void at(String var1) {
        this.c(var1, true);
    }

    public SecurityFeatureManager() {
        this.avr = new ArrayList<>();
        this.avs = ConcurrentHashMap.newKeySet();
        this.avt = new rip.vantage.commons.util.time.a();
        this.avu = "";
        this.avx = var1 -> {
            if (!this.nH()) {
                this.avw = false;
            } else {
                if (this.avt.T(10000L)) {
                    aMR.execute(() -> {
                        Object object = null;
                        long j = -7061893230367646527L;
                        long k = j ^ (0L ^ j) & -1L << 32;
                        Iterator iterator = this.avq.iterator();

                        while (iterator.hasNext()) {
                            SecurityFeature securityfeature = (SecurityFeature)iterator.next();
                            if (securityfeature.nG()) {
                                k ^= (4294967296L ^ k) & -1L << 32;
                                this.c(securityfeature.getReason(), false);
                                break;
                            }
                        }

                        Iterator iterator1 = this.avr.iterator();

                        while (iterator1.hasNext()) {
                            SecurityFeature securityfeature1 = (SecurityFeature)iterator1.next();
                            if (securityfeature1.nG()) {
                                this.c(securityfeature1.getReason(), true);
                            }
                        }

                        this.avw = ((int)(k >>> 143 - 111)) != 0;
                    });
                    this.avt.aX();
                }
            }
        };
        this.avy = var1 -> {
            if (this.nH()) {
                this.au(var1.getMessage());
            }
        };
        this.avz = var1 -> {
            Object object = null;
            if (this.nH()) {
                if (var1.dq() instanceof C01PacketChatMessage) {
                    C01PacketChatMessage c01packetchatmessage = (C01PacketChatMessage)var1.dq();
                    this.au(c01packetchatmessage.getMessage());
                }
            }
        };
    }

    @Generated
    public Listener<ChatInputEvent> nP() {
        return this.avy;
    }

    @Generated
    public Set<String> nK() {
        return this.avs;
    }

    public void c(String var1, boolean var2) {
        if (this.nH()) {
            if (!StringUtils.isBlank(var1) && this.avs.add(var1)) {
                this.as(var1);
            }
        }
    }

    @Generated
    public boolean nN() {
        return this.avw;
    }

    public void au(String var1) {
        String s = StringUtils.trimToEmpty(var1);
        if (!s.isEmpty()) {
            long j = System.currentTimeMillis();
            if (!s.equals(this.avu) || j - this.avv > 750L) {
                this.avu = s;
                this.avv = j;
                Iterator iterator = this.avr.iterator();

                while (iterator.hasNext()) {
                    SecurityFeature securityfeature = (SecurityFeature)iterator.next();
                    if (securityfeature instanceof zh) {
                        ((zh)securityfeature).ar(s);
                    }
                }
            }
        }
    }


    public void init() {
        Client.a.e().b(this);
        if (!this.nH()) {
            this.avw = false;
        } else {
            this.a(new zj());
            this.a(new zo());
            this.b(new zl());
            this.b(new zk());
            this.b(new zn());
            this.b(new zi());
            this.b(new zp());
            this.b(new zq());
            this.b(new zm());
        }
    }

    @Generated
    public Listener<PreMotionEvent> nO() {
        return this.avx;
    }

    @Generated
    public Listener<PacketSendEvent> nQ() {
        return this.avz;
    }

    public void as(String var1) {
        if (this.nH()) {
            String s = rip.vantage.util.a.kU(var1);
            if (s != null) {
                rip.vantage.util.a.aN(s, var1);
            }
        }
    }

    public boolean nH() {
        return true;
    }

    @Generated
    public rip.vantage.commons.util.time.a mQ() {
        return this.avt;
    }
}
