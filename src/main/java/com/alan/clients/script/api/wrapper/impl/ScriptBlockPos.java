package com.alan.clients.script.api.wrapper.impl;

import com.alan.clients.Client;
import com.alan.clients.component.impl.player.SlotComponent;
import com.alan.clients.script.api.wrapper.ScriptWrapper;
import com.alan.clients.script.api.wrapper.impl.vector.ScriptVector3d;
import hackclient.rise.aih;
import hackclient.rise.aik;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.BlockPos;

public class ScriptBlockPos extends ScriptWrapper<BlockPos> {
    public ScriptBlockPos(BlockPos var1) {
        super(var1);
    }

    public ScriptVector3d getPosition() {
        return new ScriptVector3d(this.wrapped.getX(), this.wrapped.getY(), this.wrapped.getZ());
    }

    public float getHardness() {
        EntityPlayerSP entityplayersp = MC.thePlayer;
        WorldClient worldclient = MC.theWorld;
        BlockPos blockpos = this.wrapped;
        SlotComponent slotcomponent = Client.a.h().b(SlotComponent.class);
        return aik.a(entityplayersp, worldclient, blockpos, SlotComponent.bQ());
    }

    public float getHardness(int var1) {
        return aik.a(MC.thePlayer, MC.theWorld, this.wrapped, var1);
    }

    public ScriptBlock getBlock() {
        return new ScriptBlock(aih.q(this.wrapped));
    }
}
