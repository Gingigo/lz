package cn.lwjzt.designpattern.structural.proxy;

import javassist.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Leexiaobu
 * @date 2020-09-08 14:16:17
 */
public class ProxyFactory {
    //1.所有接口的所有方法代理
    //2.标准格式写代码
    public static void main(String[] args) throws Exception {
//        TestService proxy = createProxy();
//        proxy.sayHello("leexiaobu");
//
//        TestService proxy2 = createProxy2(TestService.class, "System.out.println(\"hello:\"+$1);\n");
//        proxy2.sayHello("lee");


        TestService proxy3 = createProxy3(TestService.class, new InvocationHandler() {
            @Override
            public Object invoke(String methodName, Object[] args) {
                if (methodName.equals("sayHello") && args.length == 1) {
                    System.out.println("hello" + args[0]);
                } else {
                    System.out.println("hello2");
                }
                return null;
            }
        });
        proxy3.sayHello();
        proxy3.sayHello("leexiaobu");
    }

    public static TestService createProxy() throws Exception {
        //1.创建一个类
        //javassist -->ASM -->编辑JVM指令码
        ClassPool classPool = new ClassPool();
        //classloader
        classPool.appendSystemPath();
        CtClass testServiceImpl = classPool.makeClass("TestServiceImpl");
        testServiceImpl.addInterface(classPool.get(TestService.class.getName()));
        //2.添加方法
        CtMethod sayHello = CtNewMethod.make(CtClass.voidType,
                "sayHello",
                new CtClass[]{classPool.getCtClass(String.class.getName())},
                new CtClass[0], "System.out.println(\"hello:\"+$1);", testServiceImpl);
        testServiceImpl.addMethod(sayHello);
        //3.实例化对象
        Class aClass = classPool.toClass(testServiceImpl);
        return (TestService) aClass.newInstance();
    }

    public static <T> T createProxy2(Class<T> t, String src) throws Exception {
        //1.创建一个类
        //javassist -->ASM -->编辑JVM指令码
        ClassPool classPool = new ClassPool();
        //classloader
        classPool.appendSystemPath();
        CtClass testServiceImpl = classPool.makeClass("TestServiceImpl2");
        testServiceImpl.addInterface(classPool.get(t.getName()));
        //2.添加方法
        CtMethod sayHello = CtNewMethod.make(CtClass.voidType,
                "sayHello",
                new CtClass[]{classPool.getCtClass(String.class.getName())},
                new CtClass[0], src, testServiceImpl);
        testServiceImpl.addMethod(sayHello);
        //3.实例化对象
//        Class aClass = classPool.toClass(testServiceImpl);
        Class aClass = testServiceImpl.toClass();
        return (T) aClass.newInstance();
    }

    static int count = 0;

    public static <T> T createProxy3(Class<T> clazz, InvocationHandler handler) throws Exception {
        //1.创建类
        ClassPool classPool = new ClassPool();
        classPool.appendSystemPath();
        CtClass proxy = classPool.makeClass("$proxy" + count);
        //2.添加一个属性 InvocationHandler
        String addFiled = " public cn.lwjzt.designpattern.structural.proxy.ProxyFactory.InvocationHandler handler = null;";
        proxy.addInterface(classPool.get(clazz.getName()));
        CtField ctField = CtField.make(addFiled, proxy);
//        CtField ctField = proxy.getField(handler.getClass().getName());
        proxy.addField(ctField);
        String voidSrc = "this.handler.invoke(\"%s\",$args);";
        String returnSrc = " return ($r)this.handler.invoke(\"%s\",$args);";
        //3.创建所有方法
        for (Method method : clazz.getMethods()) {
            String retSrc = "";
            Class<?> type = method.getReturnType();
            if (type.equals(Void.class)) {
                retSrc = voidSrc;
            } else {
                retSrc = returnSrc;
            }
            CtClass returnType = classPool.get(type.getName());
            CtClass[] param = toCtClass(classPool, method.getParameterTypes());
            CtClass[] exceptions = toCtClass(classPool, method.getExceptionTypes());
            CtMethod sayHello = CtNewMethod.make(returnType,
                    method.getName(),
                    param,
                    exceptions, String.format(retSrc, method.getName()), proxy);
            proxy.addMethod(sayHello);
        }
        //4.实例化
        Class aClass = classPool.toClass(proxy);
        T o = (T) aClass.newInstance();
        //4.1赋值
        aClass.getField("handler").set(o, handler);
        return o;
    }

    public interface TestService {
        void sayHello(String name);

        void sayHello();
    }


    public interface InvocationHandler {
        Object invoke(String methodName, Object[] args);
    }

    public class InvocationHandlerImplHello implements InvocationHandler {

        @Override
        public Object invoke(String methodName, Object[] args) {
            System.out.println("hello");
            return null;
        }
    }


    public static CtClass[] toCtClass(ClassPool classPool, Class[] classes) {
        return Arrays.stream(classes).map(c -> {
            try {
                return classPool.get(c.getName());
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList()).toArray(new CtClass[0]);
    }
}

