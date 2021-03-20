package com.gavin.plugin.lifecycle;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author gavin
 * @date 2019/2/18
 * lifecycle class visitor
 */
public class LifecycleClassVisitor extends ClassVisitor implements Opcodes {

    private String mClassName;
    private String mSuperName;
    private String[] mInterfaces;

    public LifecycleClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    //todo 通过本身类名、父类和接口来过滤插桩目标
    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        //System.out.println("LifecycleClassVisitor : visit -----> started ：" + name);
        System.out.println("######mClassName ----> " + name);
        System.out.println("######mSuperName ----> " + superName);
        for (String str : interfaces) {
            System.out.println("######interfaces ----> " + str);
        }


        mInterfaces = interfaces;
        this.mClassName = name;
        this.mSuperName=superName;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        //System.out.println("LifecycleClassVisitor : visitMethod : " + name);
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);


        //单独匹配FMainActivity
        if ("com/gavin/asmdemo/MainActivity".equals(this.mClassName)) {
            if ("onCreate".equals(name) ) {
                //处理onCreate
                System.out.println("LifecycleClassVisitor : change method ----> " + name);
                return new LifecycleOnCreateMethodVisitor(mv);
            } else if ("onDestroy".equals(name)) {
                //处理onDestroy
                System.out.println("LifecycleClassVisitor : change method ----> " + name);
                return new LifecycleOnDestroyMethodVisitor(mv);
            }
        }
        return mv;
    }

    @Override
    public void visitEnd() {
        //System.out.println("LifecycleClassVisitor : visit -----> end");
        super.visitEnd();
    }
}
