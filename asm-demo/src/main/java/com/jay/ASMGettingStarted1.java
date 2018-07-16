package com.jay;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Type;
import org.objectweb.asm.Opcodes;

/**
 *
 * Created by xiang.wei on 2018/7/16
 *
 * @author xiang.wei
 */
public class ASMGettingStarted1 {
    /**
     * 动态创建一个类，有一个无参数的构造函数
     */
    static ClassWriter createClassWriter(String className)
    {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //声明一个类，使用JDK1.8版本，public的类，父类是java.lang.Object，没有实现任何接口
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, className, null, Type.getInternalName(Object.class), null);

        //初始化一个无参的构造函数
        MethodVisitor constructor = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        //这里请看截图
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        //执行父类的init初始化
        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, Type.getInternalName(Object.class), "<init>", "()V", false);
        //从当前方法返回void
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();
        return cw;
    }

    /**
     * 创建一个返回Integer=10的函数
     * public Integer getIntVal()
     * {
     * 		return 10;
     * }
     * @return
     * @throws Exception
     */
    static byte[] createRetrurnMethod(String className, int returnValue) throws Exception
    {
        //注意，这里需要把classname里面的.改成/，如com.asm.Test改成com/asm/Test
        ClassWriter cw = createClassWriter(className.replace('.', '/'));

        //创建get方法
        //()Ljava/lang/Integer;表示函数，无参数，返回值为：java.lang.Integer，注意最后面的分号，没有就会报错
        MethodVisitor getMethod = cw.visitMethod(Opcodes.ACC_PUBLIC, "getIntVal", "()Ljava/lang/Integer;", null, null);
        //将单字节的常量值(-128~127)推送至栈顶(如果不是-128~127之间的数字，则不能用bipush指令)
        getMethod.visitIntInsn(Opcodes.BIPUSH, returnValue);
        //调用Integer的静态方法valueOf把10转换成Integer对象
        String methodDesc = Type.getMethodDescriptor(Integer.class.getMethod("valueOf", int.class));
        getMethod.visitMethodInsn(Opcodes.INVOKESTATIC, Type.getInternalName(Integer.class), "valueOf", methodDesc, false);
        //从当前方法返回对象引用
        getMethod.visitInsn(Opcodes.ARETURN);
        getMethod.visitMaxs(1, 1);
        getMethod.visitEnd();

        return cw.toByteArray();
    }

    public static void main(String[] args) throws Exception
    {
        String className = "com.jay.Tester1";
        /**
         * 因为上面方法用的是Opcodes.BIPUSH指令【将单字节的常量值(-128~127)推送至栈顶(如果不是-128~127之间的数字，则不能用bipush指令】
         * 所以，这里传入的int参数，只能是-127~128
         * 如果要传入其他的int值，则需要使用其他的jvm指令
         */
        byte[] classData = createRetrurnMethod(className, 10);
        Class<?> clazz = new MyClassLoader().defineClassForName(className, classData);
        Object value = clazz.getMethods()[0].invoke(clazz.newInstance());
        System.out.println(value);
    }
}

