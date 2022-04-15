package io.github.strendey.damageindicators.instrumentation.transformer;

import javassist.*;
import net.minecraft.launchwrapper.IClassTransformer;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EntityPlayerTransformer implements IClassTransformer {

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (name.equals("yz")) { // OBF = yz, Forge = net.minecraft.entity.player.EntityPlayer
            try {
                CtClass classFile = ClassPool.getDefault().makeClass(new ByteArrayInputStream(basicClass));
                CtMethod targetMethod = classFile.getDeclaredMethod("getDisplayName");
                targetMethod.insertBefore("this.displayname = null;");
                return classFile.toBytecode();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NotFoundException e) {
                e.printStackTrace();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        }

        return basicClass;
    }

}
