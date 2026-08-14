package de.florianmichael.vialoadingbase.model;

import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;

@Deprecated
public class ProtocolRange {
    private final ProtocolVersion lowerBound;
    private final ProtocolVersion upperBound;

    public ProtocolRange(ProtocolVersion var1, ProtocolVersion var2) {
        if (var1 == null && var2 == null) {
            throw new RuntimeException("Invalid protocol range");
        }

        this.lowerBound = var1;
        this.upperBound = var2;
    }

    public static ProtocolRange andNewer(ProtocolVersion var0) {
        return new ProtocolRange(null, var0);
    }

    public static ProtocolRange singleton(ProtocolVersion var0) {
        return new ProtocolRange(var0, var0);
    }

    public static ProtocolRange andOlder(ProtocolVersion var0) {
        return new ProtocolRange(var0, null);
    }

    public boolean contains(ProtocolVersion var1) {
        return this.lowerBound != null && var1.olderThan(this.lowerBound) ? false : this.upperBound == null || var1.olderThanOrEqualTo(this.upperBound);
    }

    @Override
    public String toString() {
        if (this.lowerBound == null) {
            return this.upperBound.getName() + "+";
        }
        if (this.upperBound == null) {
            return this.lowerBound.getName() + "-";
        }
        return this.lowerBound == this.upperBound ? this.lowerBound.getName() : this.lowerBound.getName() + " - " + this.upperBound.getName();
    }
}
