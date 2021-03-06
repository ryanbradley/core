/*
 * JBoss, by Red Hat.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.forge.shell.plugins.builtin;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import org.jboss.forge.resources.Resource;
import org.jboss.forge.shell.plugins.Alias;
import org.jboss.forge.shell.plugins.DefaultCommand;
import org.jboss.forge.shell.plugins.PipeIn;
import org.jboss.forge.shell.plugins.PipeOut;
import org.jboss.forge.shell.plugins.Plugin;
import org.jboss.forge.shell.plugins.Topic;

/**
 * An aliasing wrapper for {@link MorePlugin}
 *
 * @author Mike Brock .
 */
@Alias("less")
@Topic("Shell Environment")
public class LessPlugin implements Plugin
{
   private final MorePlugin morePlugin;

   @Inject
   public LessPlugin(@Alias("more") MorePlugin morePlugin)
   {
      this.morePlugin = morePlugin;
   }

   @DefaultCommand
   public void run(@PipeIn InputStream pipeIn,
                   final Resource<?> file,
                   final PipeOut pipeOut)
         throws IOException

   {
      morePlugin.run(pipeIn, file, true, pipeOut);
   }
}
