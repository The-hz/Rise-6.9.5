package hackclient.rise;

import java.util.function.Supplier;
import net.minecraft.util.MathHelper;

public enum sw
{
    ID(() -> Double.valueOf(((su)st.ZI.jq()).getId())),
    PLAYER_X(() -> Double.valueOf(((su)st.ZI.jq()).ih())),
    PLAYER_Y(() -> Double.valueOf(((su)st.ZI.jq()).ii())),
    PLAYER_Z(() -> Double.valueOf(((su)st.ZI.jq()).ij())),
    PLAYER_YAW(() -> Double.valueOf(((su)st.ZI.jq()).ik())),
    PLAYER_PITCH(() -> Double.valueOf(((su)st.ZI.jq()).il())),
    TARGET_X(() -> Double.valueOf(((su)st.ZJ.jq()).ih())),
    TARGET_Y(() -> Double.valueOf(((su)st.ZJ.jq()).ii())),
    TARGET_Z(() -> Double.valueOf(((su)st.ZJ.jq()).ij())),
    TARGET_YAW(() -> Double.valueOf(((su)st.ZJ.jq()).ik())),
    TARGET_PITCH(() -> Double.valueOf(((su)st.ZJ.jq()).il())),
    DIFFERENCE_X(() -> Double.valueOf(sv.DIFFERENCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).ih()), Double.valueOf(((su)st.ZJ.jq()).ih()) }))),
    DIFFERENCE_Y(() -> Double.valueOf(sv.DIFFERENCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).ii()), Double.valueOf(((su)st.ZJ.jq()).ii()) }))),
    DIFFERENCE_Z(() -> Double.valueOf(sv.DIFFERENCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).ij()), Double.valueOf(((su)st.ZJ.jq()).ij()) }))),
    PLAYER_PERFECT_YAW(() -> Double.valueOf(aiu.c(new aka(((su)st.ZI.jq()).ih(), 0.0, ((su)st.ZI.jq()).ij()), new aka(((su)st.ZJ.jq()).ih(), 0.0, ((su)st.ZJ.jq()).ij())).getX())),
    PLAYER_PERFECT_PITCH(() -> Double.valueOf(aiu.c(new aka(((su)st.ZI.jq()).ih(), ((su)st.ZI.jq()).ii(), ((su)st.ZI.jq()).ij()), new aka(((su)st.ZJ.jq()).ih(), ((su)st.ZJ.jq()).ii(), ((su)st.ZJ.jq()).ij())).getY())),
    PLAYER_DELTA_X(() -> Double.valueOf(((su)st.ZI.jq()).ih() - ((su)st.ZI.get(1)).ih())),
    PLAYER_DELTA_Y(() -> Double.valueOf(((su)st.ZI.jq()).ii() - ((su)st.ZI.get(1)).ii())),
    PLAYER_DELTA_Z(() -> Double.valueOf(((su)st.ZI.jq()).ij() - ((su)st.ZI.get(1)).ij())),
    PLAYER_DELTA_YAW(() -> Double.valueOf(sv.WRAPPED_TO_180_DISTANCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).ik()), Double.valueOf(((su)st.ZI.get(1)).ik()) }))),
    PLAYER_DELTA_PITCH(() -> Double.valueOf(sv.DIFFERENCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).il()), Double.valueOf(((su)st.ZI.get(1)).il()) }))),
    PLAYER_YAW_DIFFERENCE_FROM_PERFECT_YAW(() -> Double.valueOf(sv.WRAPPED_TO_180_DISTANCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).ik()), sw.PLAYER_PERFECT_YAW.io() }))),
    ENEMY_YAW_DIFFERENCE_FROM_PERFECT_YAW(() -> sw.PLAYER_YAW_DIFFERENCE_FROM_PERFECT_YAW.t(true)),
    PLAYER_PITCH_DIFFERENCE_FROM_PERFECT_PITCH(() -> Double.valueOf(sv.DIFFERENCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).il()), sw.PLAYER_PERFECT_PITCH.io() }))),
    ENEMY_PITCH_DIFFERENCE_FROM_PERFECT_PITCH(() -> sw.PLAYER_PITCH_DIFFERENCE_FROM_PERFECT_PITCH.t(true)),
    HORIZONTAL_DISTANCE(() -> Double.valueOf(sv.EUCLIDEAN_DISTANCE.a(new Double[] { Double.valueOf(((su)st.ZJ.jq()).ih() - ((su)st.ZI.jq()).ih()), Double.valueOf(((su)st.ZJ.jq()).ij() - ((su)st.ZI.jq()).ij()) }))),
    VERTICAL_DISTANCE(() -> Double.valueOf(sv.DIFFERENCE.a(new Double[] { Double.valueOf(((su)st.ZJ.jq()).ii()), Double.valueOf(((su)st.ZI.jq()).ii()) }))),
    PLAYER_CONTRIBUTION_TO_DELTA_HORIZONTAL_DISTANCE(() -> Double.valueOf((double)sw.HORIZONTAL_DISTANCE.io() - sv.EUCLIDEAN_DISTANCE.a(new Double[] { Double.valueOf(((su)st.ZJ.jq()).ih() - ((su)st.ZI.get(1)).ih()), Double.valueOf(((su)st.ZJ.jq()).ij() - ((su)st.ZI.get(1)).ij()) }))),
    ENEMY_CONTRIBUTION_TO_DELTA_HORIZONTAL_DISTANCE(() -> sw.PLAYER_CONTRIBUTION_TO_DELTA_HORIZONTAL_DISTANCE.t(true)),
    PLAYER_CONTRIBUTION_TO_DELTA_VERTICAL_DISTANCE(() -> Double.valueOf(sv.DIFFERENCE.a(new Double[] { Double.valueOf(sv.DIFFERENCE.a(new Double[] { Double.valueOf(((su)st.ZJ.jq()).ii()), Double.valueOf(((su)st.ZI.get(1)).ii()) })), sw.VERTICAL_DISTANCE.io() }))),
    ENEMY_CONTRIBUTION_TO_DELTA_VERTICAL_DISTANCE(() -> sw.PLAYER_CONTRIBUTION_TO_DELTA_VERTICAL_DISTANCE.t(true)),
    ANGLE_OF_CROSS_HAIR_TO_ENEMY(() -> Double.valueOf(MathHelper.wrapAngleTo180_double(Math.toDegrees(Math.atan2((double)sw.PLAYER_YAW_DIFFERENCE_FROM_PERFECT_YAW.io(), (double)sw.PLAYER_PITCH_DIFFERENCE_FROM_PERFECT_PITCH.io()))))),
    DELTA_HORIZONTAL_ANGLE_TO_ENEMY(() -> Double.valueOf(sv.WRAPPED_TO_180_DISTANCE.a(new Double[] { sw.PLAYER_PERFECT_YAW.io(), sw.PLAYER_PERFECT_YAW.C(1) }))),
    DELTA_VERTICAL_ANGLE_TO_ENEMY(() -> Double.valueOf(sv.DIFFERENCE.a(new Double[] { sw.PLAYER_PERFECT_PITCH.io(), sw.PLAYER_PERFECT_PITCH.C(1) }))),
    PLAYER_HORIZONTAL_DELTA(() -> Double.valueOf(sv.EUCLIDEAN_DISTANCE.a(new Double[] { Double.valueOf(sv.DIFFERENCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).ih()), Double.valueOf(((su)st.ZI.get(1)).ih()) })), Double.valueOf(sv.DIFFERENCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).ij()), Double.valueOf(((su)st.ZI.get(1)).ij()) })) }))),
    PLAYER_HORIZONTAL_MOVEMENT_ANGLE(() -> Double.valueOf(MathHelper.wrapAngleTo180_float((float)(360.0 - Math.atan2(sw.PLAYER_DELTA_X.io(), sw.PLAYER_DELTA_Z.io()) * 57.29577951308232 - 180.0)) + 180.0f)),
    PLAYER_FORWARD_PERCENTAGE(() -> Double.valueOf(Math.min(Math.abs(sv.WRAPPED_TO_180_DISTANCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).ik()), Double.valueOf((double)sw.PLAYER_HORIZONTAL_MOVEMENT_ANGLE.io() - 90.0) })), Math.abs(sv.WRAPPED_TO_180_DISTANCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).ik()), Double.valueOf((double)sw.PLAYER_HORIZONTAL_MOVEMENT_ANGLE.io() + 90.0) }))) / 90.0 * 100.0)),
    PLAYER_FORWARD_DELTA(() -> Double.valueOf(sw.PLAYER_HORIZONTAL_DELTA.io() * sw.PLAYER_FORWARD_PERCENTAGE.io() / 100.0 * (double)((Math.abs(sv.WRAPPED_TO_180_DISTANCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).ik()), sw.PLAYER_HORIZONTAL_MOVEMENT_ANGLE.io() })) > 90.0) ? -1 : 1))),
    PLAYER_LATERAL_DELTA(() -> Double.valueOf(sw.PLAYER_HORIZONTAL_DELTA.io() * (1.0 - sw.PLAYER_FORWARD_PERCENTAGE.io() / 100.0) * (double)((Math.abs(sv.WRAPPED_TO_180_DISTANCE.a(new Double[] { Double.valueOf(((su)st.ZI.jq()).ik() + 90.0), sw.PLAYER_HORIZONTAL_MOVEMENT_ANGLE.io() })) > 90.0) ? -1 : 1))),
    ENEMY_FORWARD_DELTA(() -> sw.PLAYER_FORWARD_DELTA.t(true)),
    ENEMY_LATERAL_DELTA(() -> sw.PLAYER_LATERAL_DELTA.t(true)),
    PLAYER_CONTRIBUTION_TO_DELTA_HORIZONTAL_ANGLE_TO_ENEMY(() -> Double.valueOf(sv.WRAPPED_TO_180_DISTANCE.a(new Double[] { sw.PLAYER_PERFECT_YAW.io(), Double.valueOf(aiu.c(new aka(((su)st.ZI.get(1)).ih(), ((su)st.ZI.get(1)).ii(), ((su)st.ZI.get(1)).ij()), new aka(((su)st.ZJ.jq()).ih(), ((su)st.ZJ.jq()).ii(), ((su)st.ZJ.jq()).ij())).getX()) }))),
    ENEMY_CONTRIBUTION_TO_DELTA_HORIZONTAL_ANGLE_TO_PLAYER(() -> sw.PLAYER_CONTRIBUTION_TO_DELTA_HORIZONTAL_ANGLE_TO_ENEMY.t(true)),
    PLAYER_CONTRIBUTION_TO_DELTA_VERTICAL_ANGLE_TO_ENEMY(() -> Double.valueOf(sv.DIFFERENCE.a(new Double[] { sw.PLAYER_PERFECT_PITCH.io(), Double.valueOf(aiu.c(new aka(((su)st.ZI.get(1)).ih(), ((su)st.ZI.get(1)).ii(), ((su)st.ZI.get(1)).ij()), new aka(((su)st.ZJ.jq()).ih(), ((su)st.ZJ.jq()).ii(), ((su)st.ZJ.jq()).ij())).getY()) }))),
    ENEMY_CONTRIBUTION_TO_DELTA_VERTICAL_ANGLE_TO_PLAYER(() -> Double.valueOf((double)sw.PLAYER_CONTRIBUTION_TO_DELTA_VERTICAL_ANGLE_TO_ENEMY.t(true) * -1.0)),
    PLAYER_DELTA_ROTATION(() -> Double.valueOf(sv.EUCLIDEAN_DISTANCE.a(new Double[] { sw.PLAYER_DELTA_YAW.io(), sw.PLAYER_DELTA_PITCH.io() }))),
    PLAYER_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS(() -> Double.valueOf(sv.EUCLIDEAN_DISTANCE.a(new Double[] { sw.PLAYER_YAW_DIFFERENCE_FROM_PERFECT_YAW.io(), sw.PLAYER_PITCH_DIFFERENCE_FROM_PERFECT_PITCH.io() }))),
    PLAYER_DELTA_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS(() -> Double.valueOf(sv.DIFFERENCE.a(new Double[] { sw.PLAYER_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS.io(), sw.PLAYER_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS.C(1) }))),
    PLAYER_CONTRIBUTION_TO_DELTA_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS(() -> Double.valueOf(sv.DIFFERENCE.a(new Double[] { sw.PLAYER_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS.io(), Double.valueOf(sv.EUCLIDEAN_DISTANCE.a(new Double[] { Double.valueOf(sv.WRAPPED_TO_180_DISTANCE.a(new Double[] { Double.valueOf(((su)st.ZI.get(1)).ik()), Double.valueOf(aiu.c(new aka(((su)st.ZI.get(1)).ih(), 0.0, ((su)st.ZI.get(1)).ij()), new aka(((su)st.ZJ.jq()).ih(), 0.0, ((su)st.ZJ.jq()).ij())).getX()) })), Double.valueOf(sv.DIFFERENCE.a(new Double[] { Double.valueOf(((su)st.ZI.get(1)).il()), Double.valueOf(aiu.c(new aka(((su)st.ZI.get(1)).ih(), ((su)st.ZI.get(1)).ii(), ((su)st.ZI.get(1)).ij()), new aka(((su)st.ZJ.jq()).ih(), ((su)st.ZJ.jq()).ii(), ((su)st.ZJ.jq()).ij())).getY()) })) })) }))),
    ENEMY_CONTRIBUTION_TO_DELTA_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS(() -> Double.valueOf((double)sw.PLAYER_CONTRIBUTION_TO_DELTA_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS.t(true) * -1.0)),
    PLAYER_CLICKED(() -> Double.valueOf(((su)st.ZI.jq()).im() ? 1 : 0)),
    PLAYER_LAST_CLICK(() -> Double.valueOf(Integer.valueOf(st.ZI.stream().filter(su -> su.im()).findFirst().map(su2 -> Integer.valueOf(st.ZI.size() - st.ZI.indexOf((Object)su2) - 1)).orElse(Integer.valueOf(st.ZI.rS())))));

    private final Supplier<Double> aaQ;
    private static final sw[] $VALUES;

    private sw(final Supplier<Double> aaQ) {
        this.aaQ = aaQ;
    }

    public Double io() {
        return Double.valueOf(this.aaQ.get());
    }

    public Double C(final int n) {
        return this.d(n, false);
    }

    public Double t(final boolean b) {
        return this.d(0, b);
    }

    public Double d(final int n, final boolean b) {
        final sx jr = st.ZI.jr();
        final sx jr2 = st.ZJ.jr();
        if (b) {
            st.ZI = jr2;
            st.ZJ = jr;
        }
        for (int i = 0; i < n; ++i) {
            st.ZI.removeLast();
            st.ZJ.removeLast();
        }
        final Double n2 = Double.valueOf(this.aaQ.get());
        st.ZI = jr;
        st.ZJ = jr2;
        return n2;
    }

    private static sw[] jp() {
        return new sw[] { sw.ID, sw.PLAYER_X, sw.PLAYER_Y, sw.PLAYER_Z, sw.PLAYER_YAW, sw.PLAYER_PITCH, sw.TARGET_X, sw.TARGET_Y, sw.TARGET_Z, sw.TARGET_YAW, sw.TARGET_PITCH, sw.DIFFERENCE_X, sw.DIFFERENCE_Y, sw.DIFFERENCE_Z, sw.PLAYER_PERFECT_YAW, sw.PLAYER_PERFECT_PITCH, sw.PLAYER_DELTA_X, sw.PLAYER_DELTA_Y, sw.PLAYER_DELTA_Z, sw.PLAYER_DELTA_YAW, sw.PLAYER_DELTA_PITCH, sw.PLAYER_YAW_DIFFERENCE_FROM_PERFECT_YAW, sw.ENEMY_YAW_DIFFERENCE_FROM_PERFECT_YAW, sw.PLAYER_PITCH_DIFFERENCE_FROM_PERFECT_PITCH, sw.ENEMY_PITCH_DIFFERENCE_FROM_PERFECT_PITCH, sw.HORIZONTAL_DISTANCE, sw.VERTICAL_DISTANCE, sw.PLAYER_CONTRIBUTION_TO_DELTA_HORIZONTAL_DISTANCE, sw.ENEMY_CONTRIBUTION_TO_DELTA_HORIZONTAL_DISTANCE, sw.PLAYER_CONTRIBUTION_TO_DELTA_VERTICAL_DISTANCE, sw.ENEMY_CONTRIBUTION_TO_DELTA_VERTICAL_DISTANCE, sw.ANGLE_OF_CROSS_HAIR_TO_ENEMY, sw.DELTA_HORIZONTAL_ANGLE_TO_ENEMY, sw.DELTA_VERTICAL_ANGLE_TO_ENEMY, sw.PLAYER_HORIZONTAL_DELTA, sw.PLAYER_HORIZONTAL_MOVEMENT_ANGLE, sw.PLAYER_FORWARD_PERCENTAGE, sw.PLAYER_FORWARD_DELTA, sw.PLAYER_LATERAL_DELTA, sw.ENEMY_FORWARD_DELTA, sw.ENEMY_LATERAL_DELTA, sw.PLAYER_CONTRIBUTION_TO_DELTA_HORIZONTAL_ANGLE_TO_ENEMY, sw.ENEMY_CONTRIBUTION_TO_DELTA_HORIZONTAL_ANGLE_TO_PLAYER, sw.PLAYER_CONTRIBUTION_TO_DELTA_VERTICAL_ANGLE_TO_ENEMY, sw.ENEMY_CONTRIBUTION_TO_DELTA_VERTICAL_ANGLE_TO_PLAYER, sw.PLAYER_DELTA_ROTATION, sw.PLAYER_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS, sw.PLAYER_DELTA_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS, sw.PLAYER_CONTRIBUTION_TO_DELTA_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS, sw.ENEMY_CONTRIBUTION_TO_DELTA_ROTATION_DISTANCE_FROM_PERFECT_ROTATIONS, sw.PLAYER_CLICKED, sw.PLAYER_LAST_CLICK };
    }

    static {
        $VALUES = jp();
    }
}
