
//============================================================================
//
//  Name        : ReverseClient.java
//  Author      : Sachin Vijaykumar Kunte
//  Copyright   : Copyright ©2019 by Sachin Kunte All rights reserved.
//  Description : A Java program for a Client implementation 
//  contact     : kuntesv@gmail.com
//
//============================================================================

import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;

class ReverseClient
{
    
    public static void main(String args[])
    {
        Reverse ReverseImpl=null;
        
        try
        {
            // initialize the ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            String name = "Reverse";
            ReverseImpl = ReverseHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Enter a number:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());

             // Calling the is_prime method
            boolean isPrime = ReverseImpl.is_prime(num);
            System.out.println(num + " is " + (isPrime ? "prime." : "not prime."));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
