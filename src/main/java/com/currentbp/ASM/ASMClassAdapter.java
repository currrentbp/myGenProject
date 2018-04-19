package com.currentbp.ASM;

import net.sf.cglib.asm.ClassAdapter;
import net.sf.cglib.asm.ClassVisitor;

import java.util.HashMap;

/**
 * 字节码增强
 *
 * @author current_bp
 * @createTime 20180330
 */
public class ASMClassAdapter extends ClassAdapter {
    public ASMClassAdapter(ClassVisitor classVisitor) {
        super(classVisitor);
    }
    public void t1(){
    }
}
