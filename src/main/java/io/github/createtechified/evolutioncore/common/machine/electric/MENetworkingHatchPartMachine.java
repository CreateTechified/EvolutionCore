package io.github.createtechified.evolutioncore.common.machine.electric;

import appeng.api.networking.IManagedGridNode;
import appeng.api.networking.security.IActionSource;
import com.gregtechceu.gtceu.api.blockentity.BlockEntityCreationInfo;
import com.gregtechceu.gtceu.api.machine.multiblock.part.MultiblockPartMachine;
import com.gregtechceu.gtceu.api.sync_system.annotations.SaveField;
import com.gregtechceu.gtceu.api.sync_system.annotations.SyncToClient;
import com.gregtechceu.gtceu.integration.ae2.machine.feature.IGridConnectedMachine;
import com.gregtechceu.gtceu.integration.ae2.machine.trait.GridNodeHolder;

public class MENetworkingHatchPartMachine extends MultiblockPartMachine implements IGridConnectedMachine {
    @SaveField
    protected final GridNodeHolder nodeHolder;

    @SyncToClient
    protected boolean isOnline;

    protected final IActionSource actionSource;

    public MENetworkingHatchPartMachine(BlockEntityCreationInfo info) {
        super(info);
        this.nodeHolder = attachTrait(new GridNodeHolder(this));
        this.actionSource = IActionSource.ofMachine(nodeHolder.getMainNode()::getNode);
    }

    @Override
    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
        syncDataHolder.markClientSyncFieldDirty("isOnline");
    }

    @Override
    public IManagedGridNode getMainNode() {
        return nodeHolder.getMainNode();
    }
}
