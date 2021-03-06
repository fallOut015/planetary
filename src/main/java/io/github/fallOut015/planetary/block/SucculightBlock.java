package io.github.fallOut015.planetary.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;

import net.minecraft.block.AbstractBlock.Properties;

public class SucculightBlock extends FlowerBlock {
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);

    public SucculightBlock(Effect effect, int effectDuration, Properties properties) {
        super(effect, effectDuration, properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == Blocks.SMOOTH_SANDSTONE || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.RED_SAND || state.getBlock() == Blocks.TERRACOTTA || state.getBlock() == Blocks.WHITE_TERRACOTTA || state.getBlock() == Blocks.ORANGE_TERRACOTTA || state.getBlock() == Blocks.MAGENTA_TERRACOTTA || state.getBlock() == Blocks.LIGHT_BLUE_TERRACOTTA || state.getBlock() == Blocks.YELLOW_TERRACOTTA || state.getBlock() == Blocks.LIME_TERRACOTTA || state.getBlock() == Blocks.PINK_TERRACOTTA || state.getBlock() == Blocks.GRAY_TERRACOTTA || state.getBlock() == Blocks.LIGHT_GRAY_TERRACOTTA || state.getBlock() == Blocks.CYAN_TERRACOTTA || state.getBlock() == Blocks.PURPLE_TERRACOTTA || state.getBlock() == Blocks.BLUE_TERRACOTTA || state.getBlock() == Blocks.BROWN_TERRACOTTA || state.getBlock() == Blocks.GREEN_TERRACOTTA || state.getBlock() == Blocks.RED_TERRACOTTA || state.getBlock() == Blocks.BLACK_TERRACOTTA || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.COARSE_DIRT || state.getBlock() == Blocks.PODZOL;
    }
    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.DESERT;
    }
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Vector3d vec3d = state.getOffset(worldIn, pos);
        return SHAPE.move(vec3d.x, vec3d.y, vec3d.z);
    }
}