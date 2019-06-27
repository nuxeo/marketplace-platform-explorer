/*
 * (C) Copyright 2014 Nuxeo SA (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Nuxeo
 */
package org.nuxeo.functionaltests;

import org.junit.Test;
import org.nuxeo.functionaltests.JavaScriptErrorCollector.JavaScriptErrorIgnoreRule;
import org.nuxeo.functionaltests.pages.DocumentBasePage.UserNotConnectedException;
import org.nuxeo.functionaltests.pages.LoginPage;

/**
 * Simple login, logout test.
 */
public class ITLoginLogoutTest extends AbstractTest {

    @Test
    public void testLoginLogout() throws UserNotConnectedException {
        login();
        JavaScriptErrorIgnoreRule[] ignores = new JavaScriptErrorIgnoreRule[] {
                JavaScriptErrorIgnoreRule.startsWith("unreachable code after return statement"),
                JavaScriptErrorIgnoreRule.startsWith(
                        "calling a builtin typed array constructor without new is deprecated and will be forbidden in ES6") };
        open("/site/distribution", ignores);
        get(NUXEO_URL + "/logout", LoginPage.class, ignores);
    }

}
