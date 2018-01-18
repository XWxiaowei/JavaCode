/*
 * Copyright (c) 1998, 2001, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

 /**
 * The Helper for <tt>ServiceInformation</tt>.  For more information on
* Helper files, see <a href="doc-files/generatedfiles.html#helper">
* "Generated Files: Helper Files"</a>.<P>
*/

package org.omg.CORBA;


public abstract class ServiceInformationHelper {

    public static void write(org.omg.CORBA.portable.OutputStream out, ServiceInformation that)
    {
        out.write_long(that.service_options.length);
        out.write_ulong_array(that.service_options, 0, that.service_options.length);
        out.write_long(that.service_details.length);
        for (int i = 0 ; i < that.service_details.length ; i += 1) {
            ServiceDetailHelper.write(out, that.service_details[i]);
        }
    }

    public static ServiceInformation read(org.omg.CORBA.portable.InputStream in) {
        ServiceInformation that = new ServiceInformation();
        {
            int __length = in.read_long();
            that.service_options = new int[__length];
            in.read_ulong_array(that.service_options, 0, that.service_options.length);
        }
        {
            int __length = in.read_long();
            that.service_details = new ServiceDetail[__length];
            for (int __index = 0 ; __index < that.service_details.length ; __index += 1) {
                that.service_details[__index] = ServiceDetailHelper.read(in);
            }
        }
        return that;
    }
    public static ServiceInformation extract(Any a) {
        org.omg.CORBA.portable.InputStream in = a.create_input_stream();
        return read(in);
    }
    public static void insert(Any a, ServiceInformation that) {
        org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }
    private static TypeCode _tc;
    synchronized public static TypeCode type() {
        int _memberCount = 2;
        StructMember[] _members = null;
        if (_tc == null) {
            _members= new StructMember[2];
            _members[0] = new StructMember(
                                                         "service_options",
                                                         ORB.init().create_sequence_tc(0, ORB.init().get_primitive_tc(TCKind.tk_ulong)),
                                                         null);

            _members[1] = new StructMember(
                                                         "service_details",
                                                         ORB.init().create_sequence_tc(0, ServiceDetailHelper.type()),
                                                         null);
            _tc = ORB.init().create_struct_tc(id(), "ServiceInformation", _members);
        }
        return _tc;
    }
    public static String id() {
        return "IDL:omg.org/CORBA/ServiceInformation:1.0";
    }
}
