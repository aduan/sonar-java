/*
 * Sonar Java
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.java.checks;

import com.sonar.sslr.squid.checks.CheckMessagesVerifier;
import org.junit.Test;
import org.sonar.squid.api.SourceFile;

public class CallToFileDeleteOnExitMethodCheckTest {

  private CallToFileDeleteOnExitMethodCheck check = new CallToFileDeleteOnExitMethodCheck();

  @Test
  public void test() {
    SourceFile file = BytecodeFixture.scan("CallToFileDeleteOnExitMethod", check);
    CheckMessagesVerifier.verify(file.getCheckMessages())
        .next().atLine(27).withMessage("Do not use method 'File#deleteOnExit()'.")
        .noMore();
  }

}
