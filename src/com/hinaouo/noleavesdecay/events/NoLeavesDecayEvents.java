package com.hinaouo.noleavesdecay.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class NoLeavesDecayEvents implements Listener {

    private Boolean isNotDecay = true;
    private int proximityRange = 10;

    //remove the leaf decay if there are log_block nearby <proximityRange>
    @EventHandler
    public void onLeafDecay(LeavesDecayEvent event) {
        Block decayedLeaf = event.getBlock();
        if (decayedLeaf.getType() == Material.OAK_LEAVES
                || decayedLeaf.getType() == Material.MANGROVE_LEAVES
                || decayedLeaf.getType() == Material.BIRCH_LEAVES
                || decayedLeaf.getType() == Material.DARK_OAK_LEAVES
                || decayedLeaf.getType() == Material.JUNGLE_LEAVES
                || decayedLeaf.getType() == Material.SPRUCE_LEAVES
                || decayedLeaf.getType() == Material.ACACIA_LEAVES) {

            // Check if there are logs nearby within the specified proximity range
            for (int x = -proximityRange; x <= proximityRange; x++) {
                for (int y = -proximityRange; y <= proximityRange; y++) {
                    for (int z = -proximityRange; z <= proximityRange; z++) {
                        Location nearbyLocation = decayedLeaf.getLocation().add(x, y, z);
                        Block nearbyBlock = nearbyLocation.getBlock();

                        // Check if the nearby block is a log
                        if (nearbyBlock.getType() == Material.OAK_LOG
                                || nearbyBlock.getType() == Material.MANGROVE_LOG
                                || nearbyBlock.getType() == Material.BIRCH_LOG
                                || nearbyBlock.getType() == Material.DARK_OAK_LOG
                                || nearbyBlock.getType() == Material.JUNGLE_LOG
                                || nearbyBlock.getType() == Material.SPRUCE_LOG
                                || nearbyBlock.getType() == Material.ACACIA_LOG) {
                            // Cancel the leaf decay event
                            event.setCancelled(isNotDecay);
                            return;
                        }
                    }
                }
            }


        }
    }

    //getter and setter
    public Boolean getIsNotDecay() {
        return this.isNotDecay;
    }
    public void setIsNotDecay(Boolean IsNotDecay) {
         this.isNotDecay = isNotDecay;
    }
    public int getProximityRange() {
        return this.proximityRange;
    }
    public void setProximityRange(int proximityRange) {
        this.proximityRange = proximityRange;
    }

}
