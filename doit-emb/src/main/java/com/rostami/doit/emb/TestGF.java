/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rostami.doit.emb;

import java.io.File;
import org.glassfish.embeddable.BootstrapProperties;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import org.glassfish.embeddable.archive.ScatteredArchive;

/**
 *
 * @author dell
 */
public class TestGF {

    public static void main(String[] args) throws GlassFishException {
        File file = new File(".");
        System.out.println("===========================================");
        System.out.println(file.getAbsolutePath());
        BootstrapProperties bsProps = new BootstrapProperties();
        bsProps.setInstallRoot("E:\\labor\\glassfish4\\glassfish");
        GlassFishRuntime gfRuntime = GlassFishRuntime.bootstrap(bsProps);

        /**
         * Point GlassFish to domain1
         */
        GlassFishProperties gfProps = new GlassFishProperties();
        gfProps.setInstanceRoot("E:\\labor\\glassfish4\\glassfish" + "//domains//doit");
        GlassFish glassfish = gfRuntime.newGlassFish(gfProps);

        glassfish.start();
        ScatteredArchive archive = new ScatteredArchive("testapp", ScatteredArchive.Type.WAR);
    }

}
