package net.blay09.mods.cookingbook;

import cpw.mods.fml.common.network.IGuiHandler;
import net.blay09.mods.cookingbook.client.GuiRecipeBook;
import net.blay09.mods.cookingbook.container.ContainerRecipeBook;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_ID_RECIPEBOOK = 1;
    public static final int GUI_ID_RECIPEBOOK_WORLD = 2;
    public static final int GUI_ID_CRAFTBOOK = 3;
    public static final int GUI_ID_CRAFTBOOK_WORLD = 4;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID) {
            case GUI_ID_RECIPEBOOK:
                return new ContainerRecipeBook(player, player.inventory, false, false);
//            case GUI_ID_RECIPEBOOK_WORLD:
//                TileEntity tileEntity = world.getTileEntity(x, y, z);
//                if(tileEntity instanceof IInventory) {
//                    return new ContainerRecipeBook(player.inventory, (IInventory) tileEntity, false);
//                }
//                break;
            case GUI_ID_CRAFTBOOK:
                if(player.getHeldItem() != null && player.getHeldItem().getMetadata() == 1) {
                    return new ContainerRecipeBook(player, player.inventory, CookingBook.enableCraftingBook, false);
                }
                break;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID) {
            case GUI_ID_RECIPEBOOK:
                return new GuiRecipeBook(new ContainerRecipeBook(player, player.inventory, false, true));
//            case GUI_ID_RECIPEBOOK_WORLD:
//                TileEntity tileEntity = world.getTileEntity(x, y, z);
//                if(tileEntity instanceof IInventory) {
//                    return new GuiRecipeBook(new ContainerRecipeBook(player.inventory, (IInventory) tileEntity, false));
//                }
//                break;
            case GUI_ID_CRAFTBOOK:
                if(player.getHeldItem() != null && player.getHeldItem().getMetadata() == 1) {
                    return new GuiRecipeBook(new ContainerRecipeBook(player, player.inventory, CookingBook.enableCraftingBook, true));
                }
                break;
        }
        return null;
    }

}
