/*
 * Decompiled with CFR 0.137.
 */
package org.springframework.boot.loader.jar;

import org.springframework.boot.loader.jar.AsciiBytes;

interface JarEntryFilter {
    public AsciiBytes apply(AsciiBytes var1);
}

