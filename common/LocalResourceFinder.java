/*******************************************************************************
 * Copyright (c) 2001-2013 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 *******************************************************************************/
package net.sf.robocode.loaders;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.security.PrivilegedAction;

import net.sf.robocode.io.FileUtil;
import net.sf.robocode.io.Logger;
import net.sf.robocode.io.URLJarCollector;


public class LocalResourceFinder implements PrivilegedAction<ByteBuffer> {
    private final String name;
    private RobotClassLoader loader;

    public LocalResourceFinder(RobotClassLoader loader, final String name) {
        this.loader = loader;
        this.name = name;
    }

    public ByteBuffer run() {
        // try to find it in robot's class path
        // this is URL, don't change to File.pathSeparator
        String path = name.replace('.', '/').concat(".class");

        final URL url = loader.findResource(path);
        ByteBuffer result = null;
        InputStream is = null;
        BufferedInputStream bis = null;

        if (url != null) {
            try {
                final URLConnection connection = URLJarCollector.openConnection(url);

                is = connection.getInputStream();
                bis = new BufferedInputStream(is);

                result = ByteBuffer.allocate(1024 * 8);
                boolean done = false;

                do {
                    do {
                        int res = bis.read(result.array(), result.position(), result.remaining());

                        if (res == -1) {
                            done = true;
                            break;
                        }
                        result.position(result.position() + res);
                    } while (result.remaining() != 0);
                    result.flip();
                    if (!done) {
                        result = ByteBuffer.allocate(result.capacity() * 2).put(result);
                    }
                } while (!done);

            } catch (IOException e) {
                Logger.logError(e);
                return null;
            } finally {
                FileUtil.cleanupStream(bis);
                FileUtil.cleanupStream(is);
            }
        }
        return result;
    }
}
