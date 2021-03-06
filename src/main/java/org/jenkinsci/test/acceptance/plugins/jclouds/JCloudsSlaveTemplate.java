/*
 * The MIT License
 *
 * Copyright (c) 2015 Red Hat, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.test.acceptance.plugins.jclouds;

import org.jenkinsci.test.acceptance.po.PageAreaImpl;

/**
 * Single slave template of JClouds cloud.
 *
 * @author ogondza
 */
public class JCloudsSlaveTemplate extends PageAreaImpl {

    protected JCloudsSlaveTemplate(JCloudsCloud area, String relativePath) {
        super(area, relativePath);
    }

    public JCloudsSlaveTemplate hardwareId(String value) {
        control("useHardwareId[true]").check();
        elasticSleep(5000); // wait for select to populate
        control("hardwareId").select(value);
        return this;
    }

    public JCloudsSlaveTemplate checkHardwareId() {
        control("validate-button").click();
        return this;
    }

    public JCloudsSlaveTemplate imageId(String value) {
        control("imageSelectionOption[imageId]").check();
        elasticSleep(100);
        control("imageId").set(value);
        return this;
    }

    public JCloudsSlaveTemplate checkImageId() {
        control("validate-button[1]").click();
        return this;
    }

    public JCloudsSlaveTemplate imageNameRegex(String value) {
        control("imageSelectionOption[imageNameRegex]").check();
        elasticSleep(100);
        control("imageNameRegex").set(value);
        return this;
    }

    public JCloudsSlaveTemplate checkImageNameRegex() {
        control("validate-button[2]").click();
        return this;
    }
}
