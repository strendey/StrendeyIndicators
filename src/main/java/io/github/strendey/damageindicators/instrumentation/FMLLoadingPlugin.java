package io.github.strendey.damageindicators.instrumentation;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import io.github.strendey.damageindicators.StrendeyIndicators;
import io.github.strendey.damageindicators.instrumentation.transformer.EntityPlayerTransformer;

import java.util.Map;

public class FMLLoadingPlugin implements IFMLLoadingPlugin {

    public String[] getASMTransformerClass() {
        return new String[]{EntityPlayerTransformer.class.getName()};
    }

    public String getModContainerClass() {
        return StrendeyIndicators.class.getName();
    }

    public String getSetupClass() {
        return null;
    }

    public void injectData(Map<String, Object> data) {

    }

    public String getAccessTransformerClass() {
        return null;
    }

}
