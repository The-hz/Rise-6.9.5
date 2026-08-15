package com.alan.clients.module.impl.other;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.other.TickEvent;
import com.alan.clients.value.impl.BooleanValue;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import hackclient.rise.afi;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import org.lwjgl.input.Keyboard;

@ModuleInfo(aliases = "module.other.proximityvoicechat.name", description = "module.other.proximityvoicechat.description", category = Category.PLAYER)
public class ProximityVoiceChat extends Module {
    private final BooleanValue listenToYourself = new BooleanValue("Listen to yourself", this, false);
    private final NumberValue sampleRate = new NumberValue("Sample Rate", this, 16000, 8000, 192000, 4000);
    private final NumberValue sampleSizeInBits = new NumberValue("Sample Size in bits", this, 16, 8, 32, 1);
    public final ModeValue channelDont = new ModeValue("Channel (dont)", this)
        .add(new SubMode("Mono"))
        .add(new SubMode("Stereo"))
        .add(new SubMode("Quadraphonic"))
        .add(new SubMode("Surround Sound"))
        .setDefault("Mono");
    private Thread VD;
    private SourceDataLine VE;
    private TargetDataLine VF;
    private boolean talking = false;
    private int VH = 0;
    @EventLink
    public final Listener<TickEvent> onTick = var1 -> {
        if (Keyboard.isKeyDown(45)) {
            if (!this.talking) {
                this.talking = true;
                this.VH = 0;
                this.hK();
                afi.b("Start Talking");
            } else {
                afi.b("Talking");
                this.VH++;
            }
        } else if (this.talking) {
            afi.b("Stop talking");
            this.talking = false;
            this.disable();
        }
    };

    public ProximityVoiceChat() {
    }

    private void hK() {
        if (this.VD != null) {
            this.VD.interrupt();
            this.VF.stop();
            this.VF.close();
            this.VE.stop();
            this.VE.close();
        }

        this.VD = new Thread(() -> {
            try {
                AudioFormat audioformat = this.getAudioFormat();
                Info info = new Info(TargetDataLine.class, audioformat);
                this.VF = (TargetDataLine)AudioSystem.getLine(info);
                this.VF.open(audioformat);
                this.VF.start();
                Info info1 = new Info(SourceDataLine.class, audioformat);
                this.VE = (SourceDataLine)AudioSystem.getLine(info1);
                this.VE.open(audioformat);
                this.VE.start();
                byte[] abyte = new byte[4096];

                while (true) {
                    int i = this.VF.read(abyte, 0, abyte.length);
                    if (this.listenToYourself.wo()) {
                        this.VE.write(abyte, 0, i);
                    }
                }
            } catch (LineUnavailableException lineunavailableexception) {
                lineunavailableexception.printStackTrace();
            }
        });
        this.VD.start();
    }

    private void disable() {
        if (this.VD != null) {
            this.VD.interrupt();
        }

        if (this.VF != null) {
            this.VF.stop();
            this.VF.close();
        }

        if (this.VE != null) {
            this.VE.stop();
            this.VE.close();
        }
    }

    @Override
    public void onDisable() {
        this.disable();
    }

    private AudioFormat getAudioFormat() {
        label44: {
            {
                String s = this.channelDont.wo().getName();
                switch (s) {
                    case "Stereo":
                        byte b5 = 2;
                        return new AudioFormat(this.sampleRate.wo().floatValue(), this.sampleSizeInBits.wo().intValue(), b5, true, false);
                    case "Quadraphonic":
                        break label44;
                    case "Surround Sound":
                        break;
                    default:
                        byte b2 = 1;
                        return new AudioFormat(this.sampleRate.wo().floatValue(), this.sampleSizeInBits.wo().intValue(), b2, true, false);
                }
            }

            byte b3 = 6;
            return new AudioFormat(this.sampleRate.wo().floatValue(), this.sampleSizeInBits.wo().intValue(), b3, true, false);
        }

        byte b4 = 4;
        return new AudioFormat(this.sampleRate.wo().floatValue(), this.sampleSizeInBits.wo().intValue(), b4, true, false);
    }
}
