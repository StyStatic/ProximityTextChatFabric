package com.data_stream.proximitytextchat.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ProxTextConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> PROX_RANGE;
    public static final ForgeConfigSpec.ConfigValue<Integer> DIST_RANGE;

    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLEDISTORTION;
    public static final ForgeConfigSpec.ConfigValue<Boolean> UNDERSCOREMODE;

    public static final ForgeConfigSpec.ConfigValue<String> WORD_REPLACEMENT;

    static {
        BUILDER.push("Configs for Proximity Text Chat");

        PROX_RANGE = BUILDER.comment("How close you have to be to see other's messages")
                .define("Range", 50);

        TOGGLEDISTORTION = BUILDER.comment("Toggles distortion mode")
                .define("Distortion Mode Toggle", Boolean.FALSE);

        DIST_RANGE = BUILDER.comment("How close you have to be to see other's messages missing some words")
                .define("Distortion Range", 70);

        WORD_REPLACEMENT = BUILDER.comment("Word that missing words are replaced with in distortion mode")
                .define("Distortion Phrase", "*inaudible*");

        UNDERSCOREMODE = BUILDER.comment("Toggles Underscore mode, where letters of the word are replaced with underscores")
                .define("Underscore Mode", Boolean.FALSE);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
