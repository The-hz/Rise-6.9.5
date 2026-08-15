package com.alan.clients.module.impl.other;

import com.alan.clients.module.Module;
import com.alan.clients.module.api.Category;
import com.alan.clients.module.api.ModuleInfo;
import com.alan.clients.newevent.Listener;
import com.alan.clients.newevent.annotations.EventLink;
import com.alan.clients.newevent.impl.input.ClickEvent;
import com.alan.clients.value.impl.ModeValue;
import com.alan.clients.value.impl.NumberValue;
import com.alan.clients.value.impl.SubMode;
import com.alan.clients.util.sound.SoundUtil;
import org.apache.commons.lang3.RandomUtils;

@ModuleInfo(aliases = "module.other.clicksounds.name", description = "module.other.clicksounds.description", category = Category.RENDER)
public final class ClickSounds extends Module {
    private final ModeValue sound = new ModeValue("Sound", this)
        .add(new SubMode("Standard"))
        .add(new SubMode("Double"))
        .add(new SubMode("Alan"))
        .setDefault("Standard");
    private final NumberValue volume = new NumberValue("Volume", this, 0.5, 0.1, 2, 0.1);
    private final NumberValue variation = new NumberValue("Variation", this, 5, 0, 100, 1);
    @EventLink
    public final Listener<ClickEvent> onClick = var1 -> {
        String s;
        label23: {
            label22: {
                s = "rise.click.standard";
                String s1 = this.sound.wo().getName();
                byte b0 = -1;
                switch (s1.hashCode()) {
                    case 2043320:
                        if (s1.equals("Alan")) {
                            boolean flag = true;
                            break label22;
                        }
                        break;
                    case 2052876273:
                        if (s1.equals("Double")) {
                            b0 = 0;
                        }
                }

                switch (b0) {
                    case 0:
                        s = "rise.click.double";
                        break label23;
                    case 1:
                        break;
                    default:
                        break label23;
                }
            }

            s = "rise.click.alan";
        }

        SoundUtil.playSound(s, this.volume.wo().floatValue(), RandomUtils.nextFloat(1.0F, 1.0F + this.variation.wo().floatValue() / 100.0F));
    };

    public ClickSounds() {
    }
}
