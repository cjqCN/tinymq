package com.github.cjqcn.tinymq.starter;

import com.github.cjqcn.tinymq.core.TinymqBuiler;
import com.github.cjqcn.tinymq.core.TinymqStarter;

/**
 * @author: chenjinquan
 * @create: 2018-10-11
 **/
public class Bootstrap {
    public static void main(String[] args) throws Throwable {
        TinymqStarter starter = new TinymqBuiler().build();
        starter.start();
    }
}
