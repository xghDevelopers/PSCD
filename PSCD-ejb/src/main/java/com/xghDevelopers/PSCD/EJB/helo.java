package com.xghDevelopers.PSCD.EJB;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.xghDevelopers.PSCD.EJB.Local.heloLocal;

@Local
@Stateless(mappedName="helo")
public class helo implements heloLocal{

}
