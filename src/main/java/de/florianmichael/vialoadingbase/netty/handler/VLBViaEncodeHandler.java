package de.florianmichael.vialoadingbase.netty.handler;

import com.alan.clients.Client;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.type.types.VarIntType;
import com.viaversion.viaversion.exception.CancelCodecException;
import com.viaversion.viaversion.exception.CancelEncoderException;
import com.viaversion.viaversion.util.PipelineUtil;
import hackclient.rise.fj;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

@Sharable
public class VLBViaEncodeHandler extends MessageToMessageEncoder<ByteBuf> {
    private final UserConnection user;
    private int lastTick = -1;
    private boolean actionPerformedThisTick = false;

    public VLBViaEncodeHandler(UserConnection var1) {
        this.user = var1;
    }

    protected void encode(ChannelHandlerContext var1, ByteBuf var2, List<Object> var3) {
        if (!this.user.checkOutgoingPacket()) {
            throw CancelEncoderException.generate(null);
        }

        if (!this.user.shouldTransformPacket()) {
            var3.add(var2.retain());
        } else {
            int i = new VarIntType().readPrimitive(var2);
            ByteBuf bytebuf = var2.readerIndex(0);
            fj fj = new fj(bytebuf, i);
            Client.a.e().d(fj);
            if (!fj.isCancelled()) {
                ByteBuf bytebuf1 = var1.alloc().buffer().writeBytes(bytebuf);

                try {
                    this.user.transformOutgoing(bytebuf1, CancelEncoderException::generate);
                    var3.add(bytebuf1.retain());
                } finally {
                    bytebuf1.release();
                }
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception {
        if (!PipelineUtil.containsCause(var2, CancelCodecException.class)) {
            super.exceptionCaught(var1, var2);
        }
    }
}
