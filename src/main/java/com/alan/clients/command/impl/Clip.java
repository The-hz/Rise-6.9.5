package com.alan.clients.command.impl;

import com.alan.clients.command.Command;
import hackclient.rise.afi;

public final class Clip extends Command {
    public Clip() {
        super("command.clip.description", "clip", "vclip", "hclip");
    }

    @Override
    public void execute(String[] var1) {
        if (var1.length > 1 && !var1[1].isEmpty()) {
            label149: {
                label118: {
                    String s = var1[0].toLowerCase();
                    byte b0 = -1;
                    switch (s.hashCode()) {
                        case 3056464:
                            if (s.equals("clip")) {
                                break label149;
                            }
                            break;
                        case 99102648:
                            if (s.equals("hclip")) {
                                break label118;
                            }
                            break;
                        case 112031942:
                            if (s.equals("vclip")) {
                                b0 = 0;
                            }
                    }

                    switch (b0) {
                        case 0:
                            double d0 = Double.parseDouble(var1[1]);
                            aEg.thePlayer.setPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + d0, aEg.thePlayer.posZ);
                            afi.b("Clipped you " + (d0 > 0.0 ? "up" : "down") + " " + Math.abs(d0) + " blocks.");
                            return;
                        case 1:
                            break;
                        case 2:
                            break label149;
                        default:
                            this.error();
                            return;
                    }
                }

                double d1 = Double.parseDouble(var1[1]);
                double d2 = Math.toRadians(aEg.thePlayer.pl);
                double d3 = Math.sin(d2) * d1;
                double d4 = Math.cos(d2) * d1;
                aEg.thePlayer.setPosition(aEg.thePlayer.posX - d3, aEg.thePlayer.posY, aEg.thePlayer.posZ + d4);
                afi.b("Clipped you " + (d1 > 0.0 ? "forward" : "back") + " " + Math.abs(d1) + " blocks.");
                return;
            }

            if (var1.length <= 2 || var1[2].isEmpty()) {
                this.error();
            } else {
                label150: {
                    label151: {
                        label152: {
                            label153: {
                                label154: {
                                    label97: {
                                        String s1 = var1[1];
                                        byte b2 = -1;
                                        switch (s1.hashCode()) {
                                            case -838280297:
                                                if (s1.equals("upward")) {
                                                    b2 = 0;
                                                }
                                                break;
                                            case -677145915:
                                                if (s1.equals("forward")) {
                                                    break label152;
                                                }
                                                break;
                                            case -216885316:
                                                if (s1.equals("upwards")) {
                                                    break label150;
                                                }
                                                break;
                                            case 3739:
                                                if (s1.equals("up")) {
                                                    break label150;
                                                }
                                                break;
                                            case 3015911:
                                                if (s1.equals("back")) {
                                                    break label153;
                                                }
                                                break;
                                            case 3089570:
                                                if (s1.equals("down")) {
                                                    break label151;
                                                }
                                                break;
                                            case 3317767:
                                                if (s1.equals("left")) {
                                                    break label154;
                                                }
                                                break;
                                            case 108511772:
                                                if (s1.equals("right")) {
                                                    break label97;
                                                }
                                                break;
                                            case 483313230:
                                                if (s1.equals("forwards")) {
                                                    break label152;
                                                }
                                                break;
                                            case 1322462741:
                                                if (s1.equals("downwards")) {
                                                    break label151;
                                                }
                                                break;
                                            case 1356771568:
                                                if (s1.equals("backwards")) {
                                                    break label153;
                                                }
                                                break;
                                            case 1428133406:
                                                if (s1.equals("downward")) {
                                                    break label151;
                                                }
                                                break;
                                            case 2121976803:
                                                if (s1.equals("backward")) {
                                                    break label153;
                                                }
                                        }

                                        switch (b2) {
                                            case 0:
                                            case 1:
                                            case 2:
                                                break label150;
                                            case 3:
                                            case 4:
                                            case 5:
                                                break label151;
                                            case 6:
                                            case 7:
                                                break label152;
                                            case 8:
                                            case 9:
                                            case 10:
                                                break label153;
                                            case 11:
                                                break label154;
                                            case 12:
                                                break;
                                            default:
                                                this.error();
                                                return;
                                        }
                                    }

                                    double d19 = Double.parseDouble(var1[2]);
                                    double d20 = Math.toRadians(aEg.thePlayer.pl + 90.0F);
                                    double d21 = Math.sin(d20) * d19;
                                    double d22 = Math.cos(d20) * d19;
                                    aEg.thePlayer.setPosition(aEg.thePlayer.posX - d21, aEg.thePlayer.posY, aEg.thePlayer.posZ + d22);
                                    afi.b("Clipped you right " + d19 + " blocks.");
                                    return;
                                }

                                double d15 = Double.parseDouble(var1[2]);
                                double d16 = Math.toRadians(aEg.thePlayer.pl - 90.0F);
                                double d17 = Math.sin(d16) * d15;
                                double d18 = Math.cos(d16) * d15;
                                aEg.thePlayer.setPosition(aEg.thePlayer.posX - d17, aEg.thePlayer.posY, aEg.thePlayer.posZ + d18);
                                afi.b("Clipped you left " + d15 + " blocks.");
                                return;
                            }

                            double d11 = Double.parseDouble(var1[2]);
                            double d12 = Math.toRadians(aEg.thePlayer.pl);
                            double d13 = Math.sin(d12) * d11;
                            double d14 = Math.cos(d12) * d11;
                            aEg.thePlayer.setPosition(aEg.thePlayer.posX + d13, aEg.thePlayer.posY, aEg.thePlayer.posZ - d14);
                            afi.b("Clipped you back " + d11 + " blocks.");
                            return;
                        }

                        double d7 = Double.parseDouble(var1[2]);
                        double d8 = Math.toRadians(aEg.thePlayer.pl);
                        double d9 = Math.sin(d8) * d7;
                        double d10 = Math.cos(d8) * d7;
                        aEg.thePlayer.setPosition(aEg.thePlayer.posX - d9, aEg.thePlayer.posY, aEg.thePlayer.posZ + d10);
                        afi.b("Clipped you forward " + d7 + " blocks.");
                        return;
                    }

                    double d6 = Double.parseDouble(var1[2]);
                    aEg.thePlayer.setPosition(aEg.thePlayer.posX, aEg.thePlayer.posY - d6, aEg.thePlayer.posZ);
                    afi.b("Clipped you down " + d6 + " blocks.");
                    return;
                }

                double d5 = Double.parseDouble(var1[2]);
                aEg.thePlayer.setPosition(aEg.thePlayer.posX, aEg.thePlayer.posY + d5, aEg.thePlayer.posZ);
                afi.b("Clipped you up " + d5 + " blocks.");
            }
        } else {
            this.error(".clip <up/down/forward/back/left/right> <amount>");
        }
    }
}
