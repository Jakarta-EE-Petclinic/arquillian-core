/*
 * JBoss, Home of Professional Open Source
 * Copyright 2009 Red Hat Inc. and/or its affiliates and other contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.junit.container;

import org.jboss.arquillian.container.test.spi.TestRunner;
import org.jboss.arquillian.container.test.spi.client.deployment.CachedAuxilliaryArchiveAppender;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

/**
 * JUnitDeploymentAppender
 * 
 * Package up the JUnit / Arquillian JUnit related dependencies.
 *
 * @author <a href="mailto:aslak@conduct.no">Aslak Knutsen</a>
 * @version $Revision: $
 */
public class JUnitDeploymentAppender extends CachedAuxilliaryArchiveAppender
{
   @Override
   protected Archive<?> buildArchive()
   {
      JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "arquillian-junit.jar")
                        .addPackages(
                              true, 
                              "junit", 
                              "org.junit",
                              "org.hamcrest",
                              Arquillian.class.getPackage().getName())
                        .addAsServiceProvider(
                              TestRunner.class, 
                              JUnitTestRunner.class);
      return archive;
   }

}
