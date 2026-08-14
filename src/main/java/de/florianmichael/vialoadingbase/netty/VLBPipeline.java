package de.florianmichael.vialoadingbase.netty;

import com.viaversion.viaversion.api.connection.UserConnection;
import de.florianmichael.vialoadingbase.netty.event.CompressionReorderEvent;
import de.florianmichael.vialoadingbase.netty.handler.VLBViaDecodeHandler;
import de.florianmichael.vialoadingbase.netty.handler.VLBViaEncodeHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public abstract class VLBPipeline extends ChannelInboundHandlerAdapter {
    public static final String VIA_DECODER_HANDLER_NAME = "via-decoder";
    public static final String VIA_ENCODER_HANDLER_NAME = "via-encoder";
    private final UserConnection user;

    public VLBPipeline(UserConnection var1) {
        this.user = var1;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext var1) throws Exception {
        super.handlerAdded(var1);
        var1.pipeline().addBefore(this.getDecoderHandlerName(), "via-decoder", this.createVLBViaDecodeHandler());
        var1.pipeline().addBefore(this.getEncoderHandlerName(), "via-encoder", this.createVLBViaEncodeHandler());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext var1, Object var2) throws Exception {
        super.userEventTriggered(var1, var2);
        if (var2 instanceof CompressionReorderEvent) {
            int i = var1.pipeline().names().indexOf(this.getDecompressionHandlerName());
            if (i == -1) {
                return;
            }

            if (i > var1.pipeline().names().indexOf("via-decoder")) {
                ChannelHandler channelhandler = var1.pipeline().get("via-decoder");
                ChannelHandler channelhandler1 = var1.pipeline().get("via-encoder");
                var1.pipeline().remove(channelhandler);
                var1.pipeline().remove(channelhandler1);
                var1.pipeline().addAfter(this.getDecompressionHandlerName(), "via-decoder", channelhandler);
                var1.pipeline().addAfter(this.getCompressionHandlerName(), "via-encoder", channelhandler1);
            }
        }
    }

    public VLBViaDecodeHandler createVLBViaDecodeHandler() {
        return new VLBViaDecodeHandler(this.user);
    }

    public VLBViaEncodeHandler createVLBViaEncodeHandler() {
        return new VLBViaEncodeHandler(this.user);
    }

    public abstract String getDecoderHandlerName();

    public abstract String getEncoderHandlerName();

    public abstract String getDecompressionHandlerName();

    public abstract String getCompressionHandlerName();

    public UserConnection getUser() {
        return this.user;
    }
}
