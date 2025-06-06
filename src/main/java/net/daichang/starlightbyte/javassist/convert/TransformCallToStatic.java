package net.daichang.starlightbyte.javassist.convert;

import net.daichang.starlightbyte.javassist.CtMethod;
import net.daichang.starlightbyte.javassist.bytecode.CodeIterator;
import net.daichang.starlightbyte.javassist.bytecode.ConstPool;
import net.daichang.starlightbyte.javassist.bytecode.Descriptor;
import net.daichang.starlightbyte.javassist.bytecode.Opcode;

public class TransformCallToStatic extends TransformCall {
    public TransformCallToStatic(Transformer next, CtMethod origMethod, CtMethod substMethod) {
        super(next, origMethod, substMethod);
        methodDescriptor = origMethod.getMethodInfo2().getDescriptor();
    }

    @Override
    protected int match(int c, int pos, CodeIterator iterator, int typedesc, ConstPool cp) {
        if (newIndex == 0) {
            String desc = Descriptor.insertParameter(classname, methodDescriptor);
            int nt = cp.addNameAndTypeInfo(newMethodname, desc);
            int ci = cp.addClassInfo(newClassname);
            newIndex = cp.addMethodrefInfo(ci, nt);
            constPool = cp;
        }
        iterator.writeByte(Opcode.INVOKESTATIC, pos);
        iterator.write16bit(newIndex, pos + 1);
        if (c == Opcode.INVOKEINTERFACE || c == Opcode.INVOKEDYNAMIC) {
            iterator.writeByte(0, pos + 3);
        }
        return pos;
    }
}
