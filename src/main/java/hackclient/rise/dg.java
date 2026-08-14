package hackclient.rise;

import com.alan.clients.Client;
import com.alan.clients.util.interfaces.InstanceAccess;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;

public final class dg extends CreativeTabs implements InstanceAccess {
    public dg() {
        super(12, "rise");
    }

    @Override
    public void displayAllReleventItems(List<ItemStack> var1) {
        ItemStack itemstack = new ItemStack(Items.armor_stand);
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        NBTTagList nbttaglist = new NBTTagList();
        nbttaglist.appendTag(new NBTTagDouble(aEg.thePlayer.posX));
        nbttaglist.appendTag(new NBTTagDouble(aEg.thePlayer.posY));
        nbttaglist.appendTag(new NBTTagDouble(aEg.thePlayer.posZ));
        nbttagcompound.setBoolean("Invisible", true);
        nbttagcompound.setBoolean("NoGravity", true);
        nbttagcompound.setBoolean("CustomNameVisible", true);
        nbttagcompound.setString("CustomName", "Rise Client");
        nbttagcompound.setTag("Pos", nbttaglist);
        nbttagcompound.setTag("pose", nbttaglist);
        itemstack.setTagInfo("EntityTag", nbttagcompound);
        itemstack.setStackDisplayName("§rHologram");
        var1.add(itemstack);
        ItemStack itemstack1 = new ItemStack(Items.armor_stand);
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        NBTTagList nbttaglist1 = new NBTTagList();
        nbttaglist1.appendTag(new NBTTagDouble(aEg.thePlayer.posX));
        nbttaglist1.appendTag(new NBTTagDouble(aEg.thePlayer.posY));
        nbttaglist1.appendTag(new NBTTagDouble(aEg.thePlayer.posZ));
        nbttagcompound1.setBoolean("Invisible", true);
        nbttagcompound1.setBoolean("NoGravity", true);
        nbttagcompound1.setBoolean("CustomNameVisible", true);
        nbttagcompound1.setString("CustomName", "\"Rise Client\"");
        nbttagcompound1.setTag("Pos", nbttaglist1);
        itemstack1.setTagInfo("EntityTag", nbttagcompound1);
        itemstack1.setStackDisplayName("§rHologram (Via Version)");
        var1.add(itemstack1);
        var1.add(aie.F("Suspicious", "https://education.minecraft.net/wp-content/uploads/server.jpg"));
        var1.add(aie.F("Hentai", "https://education.minecraft.net/wp-content/uploads/cock.png"));
        ItemStack itemstack2 = aie.cf("anvil 1 100");
        itemstack2.setStackDisplayName("§rSpawn Imposter");
        var1.add(itemstack2);
        ItemStack itemstack3 = aie.cf("potion 1 16385 {CustomPotionEffects:[{Id:6,Amplifier:125,Duration:1000000}]}");
        itemstack3.setStackDisplayName("§rSplash Potion of Instant Death");
        var1.add(itemstack3);
        var1.add(aie.cf("dragon_egg"));
        var1.add(aie.cf("barrier"));
        var1.add(aie.cf("command_block"));
        var1.add(aie.cf("command_block_minecart"));
        ItemStack itemstack4 = aie.cf("stone_slab 1 2");
        itemstack4.setStackDisplayName("§rAlpha Slab");
        var1.add(itemstack4);
        ItemStack itemstack5 = aie.cf("leaves 1 4");
        itemstack5.setStackDisplayName("§rAlpha Leaves");
        var1.add(itemstack5);
        var1.add(aie.cf("tallgrass 1 0"));
        ItemStack itemstack6 = aie.cf(
            "potion 1 16385 {CustomPotionEffects:[{Id:15,Amplifier:2,Duration:1000000},{Id:2,Amplifier:2,Duration:1000000},{Id:9,Amplifier:2,Duration:1000000},{Id:19,Amplifier:2,Duration:1000000},{Id:20,Amplifier:2,Duration:1000000},{Id:18,Amplifier:2,Duration:1000000},{Id:17,Amplifier:2,Duration:1000000},{Id:14,Amplifier:2,Duration:1000000},{Id:4,Amplifier:2,Duration:1000000}]}"
        );
        itemstack6.setStackDisplayName("§rSplash Potion of Annoyance");
        var1.add(itemstack6);
        ItemStack itemstack7 = aie.cf("potion 1 16385 {CustomPotionEffects:[{Id:14,Duration:1000000,ShowParticles:0b}]}");
        itemstack7.setStackDisplayName("§rSplash Potion of Infinite Invisibility");
        var1.add(itemstack7);
        ItemStack itemstack8 = aie.cf(
            "diamond_sword 1 0 {ench:[{id:19,lvl:32767},{id:20,lvl:32767},{id:18,lvl:32767},{id:16,lvl:32767},{id:17,lvl:32767}],Unbreakable:1}"
        );
        itemstack8.setStackDisplayName("§r§b§lGod Sword");
        var1.add(itemstack8);
        ItemStack itemstack9 = aie.cf(
            "bow 1 0 {ench:[{id:48,lvl:32767},{id:49,lvl:32767},{id:50,lvl:32767},{id:51,lvl:32767},{id:19,lvl:32767}],Unbreakable:1}"
        );
        itemstack9.setStackDisplayName("§r§b§lGod Bow");
        var1.add(itemstack9);
        ItemStack itemstack10 = aie.cf(
            "diamond_helmet 1 0 {ench:[{id:0,lvl:32767},{id:6,lvl:32767},{id:3,lvl:32767},{id:1,lvl:32767},{id:7,lvl:32767},{id:4,lvl:32767}],Unbreakable:1}"
        );
        itemstack10.setStackDisplayName("§r§b§lGod Helmet");
        var1.add(itemstack10);
        ItemStack itemstack11 = aie.cf("diamond_chestplate 1 0  {ench:[{id:0,lvl:32767},{id:3,lvl:32767},{id:1,lvl:32767},{id:7,lvl:32767}],Unbreakable:1}");
        itemstack11.setStackDisplayName("§r§b§lGod Chestplate");
        var1.add(itemstack11);
        ItemStack itemstack12 = aie.cf("diamond_leggings 1 0  {ench:[{id:0,lvl:32767},{id:3,lvl:32767},{id:1,lvl:32767},{id:7,lvl:32767}],Unbreakable:1}");
        itemstack12.setStackDisplayName("§r§b§lGod Leggings");
        var1.add(itemstack12);
        ItemStack itemstack13 = aie.cf(
            "diamond_boots 1 0  {ench:[{id:0,lvl:32767},{id:8,lvl:32767},{id:3,lvl:32767},{id:1,lvl:32767},{id:7,lvl:32767}],Unbreakable:1}"
        );
        itemstack13.setStackDisplayName("§r§b§lGod Boots");
        var1.add(itemstack13);
        ItemStack itemstack14 = aie.cf(
            "sign 1 0 {BlockEntityTag:{Text1:\"{\\\"text\\\":\\\"Right click me for an easter egg!\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"run_command\\\",\\\"value\\\":\\\"/op "
                + aih.R()
                + "\\\"}}\"}}"
        );
        itemstack14.setStackDisplayName("§rOP Sign");
        var1.add(itemstack14);
        ItemStack itemstack15 = aie.cf(
            "written_book 1 0 {pages:[\"{\\\"text\\\":\\\"Click me for an Easter Egg!\\\",\\\"clickEvent\\\":{\\\"action\\\":\\\"run_command\\\",\\\"value\\\":\\\"/op "
                + aih.R()
                + "\\\"}}\"],title:\"Easter Egg\",author:"
                + aih.R()
                + "}"
        );
        var1.add(itemstack15);
    }

    @Override
    public String getTranslatedTabLabel() {
        return Client.b;
    }

    @Override
    public Item getTabIconItem() {
        return Items.diamond;
    }
}
