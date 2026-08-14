package de.florianmichael.vialoadingbase.netty.handler;

import com.alan.clients.component.impl.player.LastConnectionComponent;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.type.types.VarIntType;
import com.viaversion.viaversion.exception.CancelCodecException;
import com.viaversion.viaversion.exception.CancelDecoderException;
import com.viaversion.viaversion.exception.InformativeException;
import com.viaversion.viaversion.util.PipelineUtil;
import hackclient.rise.afi;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

@Sharable
public class VLBViaDecodeHandler extends MessageToMessageDecoder<ByteBuf> {
    private final UserConnection user;
    public static int stateId;

    public VLBViaDecodeHandler(UserConnection var1) {
        this.user = var1;
    }

    protected void decode(ChannelHandlerContext var1, ByteBuf var2, List<Object> var3) {
        if (!this.user.checkIncomingPacket()) {
            throw CancelDecoderException.generate(null);
        }

        if (!this.user.shouldTransformPacket()) {
            var3.add(var2.retain());
        } else {
            ByteBuf bytebuf = var1.alloc().buffer().writeBytes(var2);
            ByteBuf bytebuf1 = bytebuf.copy();

            try {
                bytebuf1.markReaderIndex();
                int i = new VarIntType().readPrimitive(bytebuf1);
                this.user.transformIncoming(bytebuf, CancelDecoderException::generate);
                var3.add(bytebuf.retain());
                if (i == 20 || i == 22) {
                    bytebuf1.readUnsignedByte();
                    stateId = new VarIntType().readPrimitive(bytebuf1);
                }
            } finally {
                bytebuf.release();
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) {
        if (!PipelineUtil.containsCause(var2, CancelCodecException.class)) {
            if (PipelineUtil.containsCause(var2, InformativeException.class)) {
                Throwable throwable = var2;

                while (throwable.getCause() != null) {
                    throwable = throwable.getCause();
                }

                if (throwable instanceof NullPointerException) {
                    String s = throwable.getMessage();
                    if (s != null
                        && (
                            s.contains("dimensions")
                                || s.contains("ConfigurationPacketStorage")
                                || s.contains("EntityTracker")
                                || s.contains("size()")
                                || s.contains("setEnabledFeatures")
                                || s.contains("setDimensions")
                        )) {
                        return;
                    }
                }

                if (this.user.getProtocolInfo().getServerState() != State.HANDSHAKE || Via.getManager().debugHandler().enabled()) {
                    var2.printStackTrace();
                    afi.c("exception");
                    if (LastConnectionComponent.ip != null && LastConnectionComponent.ip.contains("hypixel")) {
                        var1.close();
                    }
                }
            }
        }
    }
}
