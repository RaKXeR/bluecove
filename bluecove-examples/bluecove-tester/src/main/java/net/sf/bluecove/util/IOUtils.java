/**
 *  BlueCove - Java library for Bluetooth
 *  Copyright (C) 2006-2007 Vlad Skarzhevskyy
 * 
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *  @version $Id$
 */ 
package net.sf.bluecove.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import javax.microedition.io.Connection;

import net.sf.bluecove.Configuration;
import net.sf.bluecove.Logger;

/**
 * General IO stream manipulation utilities.
 * Some functions are based on org.apache.commons.io
 * 
 * <p>
 * This class provides static utility methods for input/output operations.
 * <ul>
 * <li>closeQuietly - these methods close a stream ignoring nulls and all exceptions
 * </ul>
 * <p>
 */

public class IOUtils {

    /**
     * Unconditionally close an <code>InputStream</code>.
     * <p>
     * Equivalent to {@link InputStream#close()}, except any exceptions will be ignored.
     * This is typically used in finally blocks.
     *
     * @param input  the InputStream to close, may be null or already closed
     */
    public static void closeQuietly(InputStream input) {
        try {
            if (input != null) {
                input.close();
            }
        } catch (Throwable e) {
            if (Configuration.isBlueCove) {
            	Logger.error("InputStream.close()", e);
            }
        }
    }
    
    /**
     * Unconditionally close an <code>OutputStream</code>.
     * <p>
     * Equivalent to {@link OutputStream#close()}, except any exceptions will be ignored.
     * This is typically used in finally blocks.
     *
     * @param output  the OutputStream to close, may be null or already closed
     */
    public static void closeQuietly(OutputStream output) {
        try {
            if (output != null) {
                output.close();
            }
        } catch (Throwable e) {
        	if (Configuration.isBlueCove) {
            	Logger.error("OutputStream.close()", e);
            }
        }
    }
    
    /**
     * Unconditionally close a <code>Writer</code>.
     * <p>
     * Equivalent to {@link Writer#close()}, except any exceptions will be ignored.
     * This is typically used in finally blocks.
     *
     * @param output  the Writer to close, may be null or already closed
     */
    public static void closeQuietly(Writer output) {
        try {
            if (output != null) {
                output.close();
            }
        } catch (Throwable ioe) {
            // ignore
        }
    }
    
    public static void closeQuietly(Connection com) {
        try {
            if (com != null) {
            	com.close();
            }
        } catch (Throwable e) {
        	if (Configuration.isBlueCove) {
            	Logger.error("Connection.close()", e);
            }
        }
    }
    
	public static byte hiByte(int value) {
		return (byte)((value >> 8) & 0xFF);
	}
	
	public static byte loByte(int value) {
		return (byte)(0xFF & value);
	}

	public static int bytesToShort(byte valueHi, byte valueLo) {
		return ((((int)valueHi << 8) & 0xFF00) + (valueLo & 0xFF));
	}
    
}