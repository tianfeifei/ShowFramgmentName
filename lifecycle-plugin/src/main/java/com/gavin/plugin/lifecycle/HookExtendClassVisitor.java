package com.gavin.plugin.lifecycle;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author gavin
 * @date 2019/2/18
 * lifecycle class visitor
 */
public class HookExtendClassVisitor extends ClassVisitor implements Opcodes {
    private static final String MONITOR_SUPER_CLASS_NAME = "com/example/showframent/base/FragmentBase";
    private static final String IMAGE_VIEW_CLASS_NAME = "androidx/fragment/app/Fragment";


    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        // 替换操作
        if (!name.equals(MONITOR_SUPER_CLASS_NAME) && superName.equals(IMAGE_VIEW_CLASS_NAME)) {
            superName = MONITOR_SUPER_CLASS_NAME;
            System.out.println("替换成功=="+name);

        }
        super.visit(version, access, name, signature, superName, interfaces);
    }


    public HookExtendClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

}
