package net.yosa.uranium.lag;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TickEventHandler {

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;

        Level level = player.level();
        BlockPos center = player.blockPosition();
        int radius = 10;

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {

                    BlockPos pos = center.offset(x, y, z);
                    BlockState state = level.getBlockState(pos);

                    // non-air blocks → heavier math
                    if (!state.is(Blocks.AIR)) {
                        for (int i = 0; i < 30; i++) {
                            for (int j = 0; j < 20; j++) {
                                double waste = Math.sin(i) * Math.cos(j);
                            }
                        }
                    }
                    // air blocks → lighter math
                    else {
                        for (int i = 0; i < 24; i++) {
                            for (int j = 0; j < 20; j++) {
                                double waste = Math.sin(i) * Math.cos(j);
                            }
                        }
                    }
                }
            }
        }
    }

    // kept from your original, unused but valid
    private int inefficientFibonacci(int n) {
        return n <= 1 ? n : inefficientFibonacci(n - 1) + inefficientFibonacci(n - 2);
    }
}
