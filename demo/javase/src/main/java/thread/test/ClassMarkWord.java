package thread.test;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class ClassMarkWord {
    public static void main(String[] args) {
        System.out.println(VM.current().details());

        ClassMarkWord classMarkWord = new ClassMarkWord();
        String s12 = ClassLayout.parseInstance(classMarkWord).toPrintable();
        System.out.println(s12);
        System.out.println(classMarkWord.hashCode());
        String s1 = ClassLayout.parseInstance(classMarkWord).toPrintable();
        System.out.println(s1);
    }

}
